package br.com.devquiz.commons.di.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    fun launchData(
        applyLoading: Boolean = true,
        doOnError: (t: Throwable) -> Unit = {},
        action: suspend () -> Unit
    ) : Job = viewModelScope.launch {
        _loading.value = applyLoading
        action.runCatching {
            this.invoke()
        }.onFailure(doOnError)
        _loading.value = false
    }

}