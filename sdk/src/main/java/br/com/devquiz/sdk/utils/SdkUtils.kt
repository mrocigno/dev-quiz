package br.com.devquiz.sdk.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

object SdkUtils {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    fun <T> async(func: suspend () -> T): LiveData<T> {
        val response = MutableLiveData<T>()
        scope.launch { response.value = func() }
        return response
    }

}