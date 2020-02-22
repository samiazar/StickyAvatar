package com.saimazar.sample.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saimazar.sample.R
import com.saimazar.sample.model.Movie
import com.saimazar.sample.presentation.adapter.viewholder.MovieViewHolder

class MovieAdapter(): RecyclerView.Adapter<MovieViewHolder>() {

    private val mItems: MutableList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_in_grid, parent, false))

    override fun getItemCount(): Int =
        mItems.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(mItems[holder.adapterPosition])

    fun updateList(movieList: List<Movie>) {
        mItems.clear()
        mItems.addAll(movieList)
        notifyDataSetChanged()
    }

}