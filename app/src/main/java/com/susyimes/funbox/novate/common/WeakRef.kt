package com.susyimes.funbox.novate.common

import kotlinx.coroutines.suspendCancellableCoroutine
import java.lang.ref.WeakReference

class WeakRef <T> internal  constructor(any:T){
    private val weakRef = WeakReference(any)
    suspend operator fun invoke() :T{
        return suspendCancellableCoroutine{
            weakRef.get()
        }
    }
}