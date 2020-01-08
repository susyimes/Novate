package com.susyimes.funbox.novate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.susyimes.funbox.novate.base.BaseVM
import com.susyimes.funbox.novate.ext.Event
import com.susyimes.funbox.novate.model.Content

class DetailVM : BaseVM() {

    private val _clickEvent = MutableLiveData<Event<Content>>()
    val clickEvent: LiveData<Event<Content>> = _clickEvent
    private val _datas = MutableLiveData<List<Content>>()
    val datas: LiveData<List<Content>> = _datas
    private val arrayList = ArrayList<Content>()
    fun loadData() {
        val content1 = Content("123", 0)
        val content2 = Content(
            "https://www.baidu.com/img/bd_logo1.png?where=super",
            1
        )
        val content3 = Content("456", 0)

        arrayList.add(content1)
        arrayList.add(content2)
        arrayList.add(content3)
        _datas.value = arrayList
    }

    fun removeData(pos:Int){
        arrayList.removeAt(pos)
        _datas.value = arrayList
    }


}