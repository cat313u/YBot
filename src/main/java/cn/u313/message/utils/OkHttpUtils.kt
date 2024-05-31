package cn.u313.message.utils

import com.alibaba.fastjson.JSONObject
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit


object OkHttpUtils {
    private val httpHeaderMediaType = "application/json;charset=utf-8"

    private val httpHeaderContentType = "Content-Type"

    /**
     * 设置默认30秒Http调用超时
     */
    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .callTimeout(30, TimeUnit.SECONDS)
        .build()

    fun postData(url:String,data:String): String? {
        println(data)
        //  构建Request对象
        val requestBody: RequestBody = RequestBody.create(httpHeaderMediaType.toMediaTypeOrNull(), data.replace("\n","\\n"))
        val request = Request.Builder()
            .addHeader(httpHeaderContentType, httpHeaderMediaType)
            .addHeader("Accept", httpHeaderMediaType)
            .post(requestBody)
            .url(url)
            .build()
        var signRsp: Response? = null
        try {
            signRsp = client.newCall(request).execute()
            val body: String = signRsp.body.string()
            if (signRsp.isSuccessful) {
                println(body)
                return body
            }else{
                println(body)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}