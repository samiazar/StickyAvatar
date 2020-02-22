package com.saimazar.sample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saimazar.library.StickyAvatarItemDecoration
import com.saimazar.sample.R
import com.saimazar.sample.datasource.DataSource
import com.saimazar.sample.presentation.adapter.ChatAdapter
import com.saimazar.sample.presentation.adapter.MarginDecoration
import com.saimazar.sample.presentation.adapter.MovieAdapter
import com.saimazar.sample.presentation.adapter.MovieMarginDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupMovieList()

    }

    fun setupChatList() {
        val adapter = ChatAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(MarginDecoration(resources.getDimensionPixelOffset(R.dimen.item_space)))
        recyclerView.addItemDecoration(StickyAvatarItemDecoration(adapter, resources.getDimensionPixelOffset(R.dimen.item_space)))
        adapter.updateList(DataSource.mockChatList())
    }

    val movieDecoration:MovieMarginDecoration by lazy {
        MovieMarginDecoration(
            resources.getDimensionPixelOffset(R.dimen.item_space),
            resources.getDimensionPixelOffset(R.dimen.movie_name_height),
            resources.getDimensionPixelOffset(R.dimen.movie_name_height) + resources.getDimensionPixelOffset(
                R.dimen.movie_thumbnail_height
            )
        )
    }

    fun setupMovieList() {
        val adapter = MovieAdapter()
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(movieDecoration)
        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                recyclerView.removeItemDecoration(movieDecoration)
                recyclerView.addItemDecoration(movieDecoration)
            }
        })
        adapter.updateList(DataSource.mockMovieList())
    }
}
