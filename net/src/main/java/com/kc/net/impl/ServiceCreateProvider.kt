package com.kc.net.impl

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.kc.net.interceptor.LogIntercepter
import com.kc.net.interceptor.ParamsInterceptor
import com.kc.net.operator.LiveDataCallAdapterFactory
import com.kc.net.params.IGlobalParams
import com.kc.net.provider.IServiceProvider
import com.kc.net.service.ServiceBuilder
import com.kc.net.service.ServiceController
import okhttp3.logging.HttpLoggingInterceptor

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2019/7/22 0022
 */
@Route(path = "/network/IServiceProvider", name = "Service创建模块入口")
class ServiceCreateProvider : IServiceProvider {

    private val serviceController by lazy {
        val baseUrl =  ARouter.getInstance().navigation(IGlobalParams::class.java).getBaseUrl()
        createServiceController(baseUrl)
    }

    override fun init(context: Context?) {
    }

    override fun <T> createService(cla: Class<T>): T {
        return serviceController.createService(cla)
    }

    override fun <T> createService(cla: Class<T>, baseUrl: String): T {
        return createServiceController(baseUrl).createService(cla)
    }

    private fun createServiceController(baseUrl: String): ServiceController {
        return ServiceBuilder()
            .setBaseUrl(baseUrl)
            .isIgnoreSSL(true)
            .setOkHttpBuilder {
                //添加参数拦截器拦截器
                it.addInterceptor(ParamsInterceptor())
                //添加打印拦截器
                it.addInterceptor(
                    HttpLoggingInterceptor(LogIntercepter())
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
//                it.addInterceptor(ResponseHeaderInterceptor())

                //失败重联
                it.retryOnConnectionFailure(true)
            }
            .setRetrofitBuilder {
                it.addCallAdapterFactory(LiveDataCallAdapterFactory())
            }
            .builder()
    }
}