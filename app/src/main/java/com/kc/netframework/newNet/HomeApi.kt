package com.kc.netframework.newNet

import com.kc.net.provider.IServiceProvider
import retrofit2.http.GET
import com.alibaba.android.arouter.launcher.ARouter
import com.kc.net.operator.LiveDataOperator
import com.kc.netframework.response.HomeArticlesResp
import retrofit2.http.Path


/**
 * @data on 2021/7/14 6:30 下午
 * @auther
 * @describe
 */
interface HomeApi {
    @GET("article/list/{page}/json")
    fun getHomeArticles2(@Path("page") pageNo: Int): LiveDataOperator<HomeArticlesResp>

    companion object {
        private val instance = ARouter.getInstance().navigation(IServiceProvider::class.java)
            .createService(HomeApi::class.java)

        operator fun invoke(): HomeApi {
            return instance
        }
    }
}