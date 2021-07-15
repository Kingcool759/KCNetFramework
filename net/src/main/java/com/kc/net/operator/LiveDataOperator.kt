package com.kc.net.operator

import com.kc.net.livedata.BaseLiveData
import com.kc.net.livedata.IResponse
import com.kc.net.livedata.LiveDataCallback

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/7/28
 */
class LiveDataOperator<T : IResponse> {
    internal val liveDataCallback = LiveDataCallback<T>()
    fun setLiveData(value: BaseLiveData): LiveDataCallback<T> {
        liveDataCallback.setLiveData(value)
        return liveDataCallback
    }

}