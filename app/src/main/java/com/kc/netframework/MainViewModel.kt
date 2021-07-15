package com.kc.netframework

import android.app.Application
import android.util.Log
import com.kc.netframework.base.BasePageViewModel
import com.kc.netframework.newNet.HomeApi
import com.kc.netframework.response.DataX

/**
 * @data on 2021/7/15 11:33 上午
 * @auther
 * @describe
 */
class MainViewModel(application: Application): BasePageViewModel<DataX>(application) {

    init {
        refresh()
    }

    override fun getStartPageNum(): Int = 1

    override fun requestData(page: Int) {
        HomeApi()
            .getHomeArticles2(page)
            .setLiveData(baseLiveData)
            .bindStateLayout()
            .bindSmartRefresh()
            .doOnResponseSuccess { _, body ->
                handleItemData(page,body.data.datas)
                Log.d("ddd","请求成功！")
                Log.d("ddd",body.data.datas.toString())
            }
            .doOnAnyFail {
                Log.d("ddd","请求失败！")
            }
    }

    override fun getItemLayoutId(): Int {
        return R.layout.item_home_article_layout
    }
}