package com.kc.net.provider

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @data on 2021/7/14 6:21 下午
 * @auther
 * @describe
 */
interface IServiceProvider : IProvider {

    fun <T> createService(cla: Class<T>): T

    fun <T> createService(cla: Class<T>, baseUrl: String): T
}
