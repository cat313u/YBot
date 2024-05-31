package cn.u313.message.processor

import cn.u313.bot.model.NTMessage
import cn.u313.message.annotation.BotListener
import cn.u313.message.annotation.Filter
import cn.u313.message.annotation.OnGroup
import cn.u313.message.annotation.OnPrivate
import cn.u313.message.bean.BaseMsg
import cn.u313.message.bean.GroupMessage
import cn.u313.message.bean.PrivateMessage
import cn.u313.message.utils.messageEvent
import cn.u313.message.utils.sendMsg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.context.ApplicationContext
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Component
import java.lang.reflect.Method
@Component
class MessageBeanPostProcessor : BeanPostProcessor {
    @Autowired
    var applicationContext:ApplicationContext? =null
    var executor: ThreadPoolTaskExecutor = ThreadPoolTaskExecutor().apply {
       corePoolSize = 3
       maxPoolSize = 10
       queueCapacity = 100
       setThreadNamePrefix("MyThread-")
       initialize()
    }
    private val methodMap = mutableMapOf<String,MutableList<Method>>()
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        parseAnnotation(bean)
        return super.postProcessAfterInitialization(bean, beanName)
    }
    private fun parseAnnotation(bean:Any){
        if (bean.javaClass.isAnnotationPresent(BotListener::class.java)){
            val methods: Array<Method> = bean.javaClass.declaredMethods
            for (method in methods) {
                if (method.isAnnotationPresent(OnGroup::class.java)) {
                    val annotation = method.getAnnotation(OnGroup::class.java)
                    val value: String = annotation.toString()
                    println(("Invoking method: " + method.name) + " (" + value + ")")
                    if (methodMap.contains("OnGroup").not()){
                        methodMap["OnGroup"] = mutableListOf(method)
                    }else{
                        methodMap["OnGroup"]?.add(method)
                    }
                }else if(method.isAnnotationPresent(OnPrivate::class.java)){
                    val annotation = method.getAnnotation(OnPrivate::class.java)
                    val value: String = annotation.toString()
                    println(("Invoking method: " + method.name) + " (" + value + ")")
                    if (methodMap.contains("OnPrivate").not()){
                        methodMap["OnPrivate"] = mutableListOf(method)
                    }else{
                        methodMap["OnPrivate"]?.add(method)
                    }
                }
            }
        }
    }

    fun onMsg(messageBody: NTMessage) {
        if(messageBody.messageType == "private"){
            executor.execute {
                val privateMessage = PrivateMessage().also {
                    it.msg = messageBody.rawMessage
                    it.userId = messageBody.userId
                }
                invokeAnnotatedMethods(privateMessage,OnPrivate::class.java)
            }
        }else if(messageBody.messageType == "group"){
            executor.execute {
                val groupMessage = GroupMessage().also {
                    it.msg = messageBody.rawMessage
                    it.userId = messageBody.userId
                    it.groupId = messageBody.groupId
                }
                invokeAnnotatedMethods(groupMessage,OnGroup::class.java)
            }
        }
    }

    private fun invokeAnnotatedMethods(any: Any,onClazz: Class<out Annotation>){
        methodMap[onClazz.simpleName]?.forEach {method ->
            if (method.isAnnotationPresent(onClazz)) {
                val annotation = method.getAnnotation(onClazz)
                val value: String = annotation.toString()
                println(("Invoking method: " + method.name).toString() + " (" + value + ") ${any.javaClass.simpleName},${method.declaringClass.simpleName}")
                if (method.isAnnotationPresent(Filter::class.java)) {
                    val filter = method.getAnnotation(Filter::class.java)
                    val toRegex = filter.value.toRegex()
                    val msg = any as BaseMsg
                    val matches = toRegex.matches(msg.msg)
                    if (matches) invoke(method, any)
                }else{
                    invoke(method, any)
                }
            }
        }
    }
    private fun invoke(method:Method,any:Any){
        try {
            method.invoke(applicationContext!!.getBean(method.declaringClass),any)
        } catch (e: Exception) {
            e.printStackTrace()
            if (any is GroupMessage)
                messageEvent.sendMsg(any,"捕获异常：${e.message}")
            if (any is PrivateMessage)
                messageEvent.sendMsg(any,"捕获异常：${e.message}")
        }
    }
}