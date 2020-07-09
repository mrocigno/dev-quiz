package br.com.devquiz.commons.di.extensions

import android.app.Activity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (T) -> Unit) {
    liveData.observe(this, Observer {
        action.invoke(it)
    })
}