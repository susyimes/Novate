package com.susyimes.funbox.novate.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by susyimes on 2019/5/17 0017.
 */
open class BaseVM : ViewModel(){
    val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}


