package cn.u313.bot.controller

import cn.u313.bot.model.NTMessage
import cn.u313.bot.service.TestService
import cn.u313.message.processor.MessageBeanPostProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@RequestMapping
@Controller
@ResponseBody
class InMessageController {
    @Autowired
    var messageBeanPostProcessor: MessageBeanPostProcessor? = null
    @Autowired
    var testService: TestService? = null
    /**
     * {"self_id":2036085374,"user_id":1054980699,"time":1716654742,"message_id":-2147483416,"real_id":-2147483416,"message_seq":-2147483416,"message_type":"group","sender":{"user_id":1054980699,"nickname":"柳苏言.","card":"群主欠我一顿饭","role":"owner"},"raw_message":"复读机[CQ:face,id=120]","font":14,"sub_type":"normal","message":"复读机[CQ:face,id=120]","message_format":"string","post_type":"message","group_id":733860730}
     */
    @RequestMapping("/test")
    fun a(@RequestBody messageBody: NTMessage): String {
        println(testService)
        println(messageBody)
        messageBeanPostProcessor?.onMsg(messageBody)
        return "success"
    }
}

