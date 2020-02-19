package com.saimazar.library

import android.graphics.Canvas
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @param
 * @param mSequenceBreakerMargin: the margin between two message from two different user
 * */
class StickyAvatarItemDecoration(
    private val stickHeaderInterface: StickAvatarInterface,
    private val mSequenceBreakerMargin: Int
) : RecyclerView.ItemDecoration(){

    private var mStickyAvatarHeight: Int = 0
    private var mParentHeight: Int = 0


    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        //because our list direction is reverse so the 0's item is the bottom child
        val bottomChild = parent.getChildAt(0) ?: return

        val bottomChildPosition = parent.getChildAdapterPosition(bottomChild)

        if (bottomChildPosition == RecyclerView.NO_POSITION) {
            return
        }

        val avatarPos = stickHeaderInterface.getLastMessagePositionInSequenceForItem(bottomChildPosition)
        //NOTE: the second condition (bottomChild.bottom < par...) is for skip bottom padding of list
        // and also the value of chat_item_margin_min used because of avatar margin from bottom
        if (avatarPos == RecyclerView.NO_POSITION || bottomChild.bottom < parent.height) {
            return
        }
        val currentAvatar = getAvatarViewForItem(avatarPos, parent)
        fixLayoutSize(parent, currentAvatar)
        val contactPoint = currentAvatar.top - mSequenceBreakerMargin
        val childInContact = getChildInContact(parent, contactPoint, avatarPos)

        if (childInContact != null) {
            val sequenceBreakerPos = parent.getChildAdapterPosition(childInContact)
            if (sequenceBreakerPos != avatarPos && stickHeaderInterface.isSequenceBreaker(sequenceBreakerPos)) {
                moveAvatar(c, currentAvatar, childInContact)
                return
            }
        }

        drawAvatar(c, currentAvatar)
    }

    private fun getAvatarViewForItem(avatarPosition: Int, parent: RecyclerView): View {
        val layoutResId = stickHeaderInterface.getAvatarLayout(avatarPosition)
        val header = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        stickHeaderInterface.bindAvatarData(header, avatarPosition)
        return header
    }

    private fun drawAvatar(c: Canvas, avatar: View) {
        c.save()
        c.translate(0f, (mParentHeight - mStickyAvatarHeight).toFloat())
        avatar.draw(c)
        c.restore()
    }

    private fun moveAvatar(c: Canvas, currentAvatar: View, sequenceBreaker: View) {
        c.save()
        c.translate(0f, (sequenceBreaker.bottom + mSequenceBreakerMargin).toFloat())
        currentAvatar.draw(c)
        c.restore()
    }

    private fun getChildInContact(
        parent: RecyclerView,
        contactPoint: Int,
        currentAvatarPos: Int
    ): View? {
        var childInContact: View? = null
        for (i in 0 until parent.childCount) {
            var heightTolerance = 0
            val child = parent.getChildAt(i)

            //measure height tolerance with child if child is another header
            if (currentAvatarPos != i) {
                val position = parent.getChildAdapterPosition(child)
                if(position != RecyclerView.NO_POSITION) {
                    val isChildNotInSequence =
                        stickHeaderInterface.isSequenceBreaker(parent.getChildAdapterPosition(child))
                    if (isChildNotInSequence) {
                        heightTolerance = mStickyAvatarHeight - child.height - mSequenceBreakerMargin
                    }
                }
            }

            //add heightTolerance if child top be in display area
            val childTopPosition = if (child.bottom < mParentHeight) {
                child.top + heightTolerance
            } else {
                child.top
            }

            if (childTopPosition < contactPoint) {
                if (child.bottom >= contactPoint) {
                    // This child overlaps the contactPoint
                    childInContact = child
                    break
                }
            }
        }
        return childInContact
    }


    /**
     * Properly measures and layouts the bottom sticky avatar.
     * @param parent ViewGroup: RecyclerView in this case.
     */
    private fun fixLayoutSize(parent: ViewGroup, view: View) {

        // Specs for parent (RecyclerView)
        val widthSpec = View.MeasureSpec.makeMeasureSpec(parent.width, View.MeasureSpec.EXACTLY)
        val heightSpec =
            View.MeasureSpec.makeMeasureSpec(parent.height, View.MeasureSpec.UNSPECIFIED)

        // Specs for children (headers)
        val childWidthSpec = ViewGroup.getChildMeasureSpec(
            widthSpec,
            parent.paddingLeft + parent.paddingRight,
            view.layoutParams.width
        )
        val childHeightSpec = ViewGroup.getChildMeasureSpec(
            heightSpec,
            parent.paddingTop + parent.paddingBottom,
            view.layoutParams.height
        )

        view.measure(childWidthSpec, childHeightSpec)

        mStickyAvatarHeight = view.measuredHeight
        mParentHeight = heightSpec
        view.layout(0, heightSpec - view.measuredHeight, view.measuredWidth, heightSpec)
    }

}