package com.susyimes.funbox.novate.ext

import com.susyimes.funbox.novate.common.WeakRef
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


fun Disposable.addTo(c: CompositeDisposable){
    c.add(this)
}
fun <T:Any> T.weakReference() = WeakRef(this)