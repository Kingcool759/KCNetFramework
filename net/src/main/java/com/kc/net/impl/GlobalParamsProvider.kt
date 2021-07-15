package com.kc.net.impl

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.kc.net.params.IGlobalParams

/**
 * @data on 2021/7/15 10:59 上午
 * @auther
 * @describe
 */
@Route(path = "/service/params_provider", name = "全局请求链接的参数")
class GlobalParamsProvider : IGlobalParams {
    override fun getBaseUrl(): String {
        return Url.BEAT_URL
    }

    override fun init(context: Context?) {
    }

    object Url{
        //正式环境
        const val RELEASE_URL = "https://wanandroid.com/"

        //测试环境
        const val BEAT_URL = "https://wanandroid.com/"
    }
}