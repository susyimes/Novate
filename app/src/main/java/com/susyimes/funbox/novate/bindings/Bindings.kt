package com.susyimes.funbox.novate.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.susyimes.funbox.novate.adapter.ContentAdapter
import com.susyimes.funbox.novate.adapter.NoteAdapter
import com.susyimes.funbox.novate.model.Content
import com.susyimes.funbox.novate.model.Note

@BindingAdapter("note_items")
fun setNoteItems(listView: RecyclerView, items: List<Note>?) {
    (listView.adapter as NoteAdapter).submitList(items)
}

@BindingAdapter("content_items")
fun setContentItems(listView: RecyclerView, items: List<Content>?) {
    (listView.adapter as ContentAdapter).setList(items)
}


