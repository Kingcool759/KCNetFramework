package com.kc.net.interceptor

import android.util.Log
import com.orhanobut.logger.Logger
import okhttp3.logging.HttpLoggingInterceptor

/**
 * @data on 2021/7/15 5:17 下午
 * @auther
 * @describe
 */
class LogIntercepter : HttpLoggingInterceptor.Logger {

    private val mMessage = StringBuilder()

    override fun log(message: String) {
        Log.e("http",message)
        // 请求或者响应开始
        var message = message
        if (message.startsWith("--> POST")) {
            mMessage.setLength(0)
        }
        // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
        if (message.startsWith("{") && message.endsWith("}")
            || message.startsWith("[") && message.endsWith("]")
        ) {
            message = JsonUtil.formatJson(
                JsonUtil.decodeUnicode(message)
            )
        }
        mMessage.append(
            """
                $message
                
                """.trimIndent()
        )
        // 响应结束，打印整条日志
        if (message.startsWith("<-- END HTTP")) {
            Logger.d(mMessage.toString())
        }
    }
}