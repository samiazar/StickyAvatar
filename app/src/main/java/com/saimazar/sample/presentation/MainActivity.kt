package com.saimazar.sample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.saimazar.library.StickyAvatarItemDecoration
import com.saimazar.sample.R
import com.saimazar.sample.datasource.ChatMessageDataSource
import com.saimazar.sample.presentation.adapter.ChatAdapter
import com.saimazar.sample.presentation.adapter.MarginDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ChatAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(MarginDecoration(resources.getDimensionPixelOffset(R.dimen.item_space)))
        recyclerView.addItemDecoration(StickyAvatarItemDecoration(adapter, resources.getDimensionPixelOffset(R.dimen.item_space)))
        adapter.updateList(ChatMessageDataSource.mockChatList())
    }
}
