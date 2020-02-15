package com.saimazar.sample.presentation.adapter


import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginDecoration(
    private val space: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            top = space

            val itemPosition = parent.getChildAdapterPosition(view)
            if (itemPosition == 0) {
                bottom = space
            }
        }

    }
}