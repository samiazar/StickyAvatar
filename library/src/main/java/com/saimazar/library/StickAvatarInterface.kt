package com.saimazar.library

import android.view.View

interface StickAvatarInterface {
    /**
     * This method gets called by [StickAvatarInterface] to fetch the position of the last user message in sequence in the adapter
     * that is used for (represents) item at specified position.
     * IMPORTANT: first check if item position is not in user sequence messages, return -1
     * @param itemPosition int. Adapter's position of the item for which to do the search of the position of the header item.
     * @return int. Position of the header item in the adapter.
     */
    fun getLastMessagePositionInSequenceForItem(itemPosition: Int): Int

    /**
     * This method gets called by [StickAvatarInterface] to get layout resource id for the avatar item at specified adapter's position.
     * @param headerPosition int. Position of the last user messasge item in sequence in the adapter.
     * @return int. Layout resource id.
     */
    fun getAvatarLayout(headerPosition: Int): Int

    /**
     * This method gets called by [StickAvatarInterface] to setup the avatar View.
     * @param header View. Header to set the data on.
     * @param headerPosition int. Position of the header item in the adapter.
     */
    fun bindAvatarData(header: View, headerPosition: Int)

    /**
     * This method gets called by [StickAvatarInterface] to verify whether the item represents a first message of user in sequence.
     * @param itemPosition int.
     * @return true, if item at the specified adapter's position represents a header.
     */
    fun isSequenceBreaker(itemPosition: Int): Boolean
}