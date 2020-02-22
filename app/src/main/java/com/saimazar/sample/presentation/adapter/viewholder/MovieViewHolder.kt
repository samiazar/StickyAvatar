package com.saimazar.sample.presentation.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saimazar.sample.R
import com.saimazar.sample.model.Movie
import kotlinx.android.synthetic.main.item_movie_in_grid.view.*

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie) {
        with(itemView) {
            Glide.with(context).load(movie.thumbnail).placeholder(R.color.colorAccent).into(ivThumbnail)
            tvMovieName.text = movie.name
        }
    }
}