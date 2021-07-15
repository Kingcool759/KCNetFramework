package com.kc.net.interceptor

import com.alibaba.android.arouter.launcher.ARouter
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author : zhangqi
 * @time : 2020/5/18
 * desc :  参数拦截器
 */
class ParamsInterceptor : BaseParamsInterceptor() {
    override fun getAddHeaderParams(): MutableMap<String, String> {
        val headerParams = mutableMapOf<String, String>()
//        headerParams?.let {
//            if (ARouter.getInstance().navigation(UserService::class.java).getToken().isNotEmpty()) {
//                it["Cookie"] = ARouter.getInstance().navigation(UserService::class.java).getToken()
//            }
//        }
        return headerParams
    }

    override fun transformParams(old: MutableMap<String, String>): MutableMap<String, String> {
        return old
    }
}