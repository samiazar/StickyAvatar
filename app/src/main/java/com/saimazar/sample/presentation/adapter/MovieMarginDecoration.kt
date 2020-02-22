package com.saimazar.sample.presentation.adapter


import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.min

class MovieMarginDecoration(
    private val space: Int,
    private val movieNameHeight: Int,
    private val wholeMovieHeight: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            val diffFactor = abs(view.top).toFloat() / wholeMovieHeight.toFloat()
            val bottomSize = min(movieNameHeight * diffFactor, movieNameHeight.toFloat())
            left = space
            right = space
            bottom = - bottomSize.toInt()
        }

    }
}