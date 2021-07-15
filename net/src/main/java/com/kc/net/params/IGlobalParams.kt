package com.kc.net.params

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @data on 2021/7/15 10:58 上午
 * @auther
 * @describe
 */
interface IGlobalParams : IProvider {
    /**
     * 提供对外获取baseUrl的方法
     */
    fun getBaseUrl(): String
}