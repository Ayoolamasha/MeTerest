package com.ayoolamasha.meterest.data.extensionsPackage

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.ayoolamasha.meterest.data.execptionPackage.Failure

fun <T : Any, L : LiveData<T>> LifecycleOwner.success(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure?) -> Unit) =
    liveData.observe(this, Observer(body))