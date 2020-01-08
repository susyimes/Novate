package com.susyimes.funbox.novate.model

data class Note (val title:String,val contents:List<Content>)
data class Content(val content:String,val type:Int)
