package com.saimazar.library

import android.view.View

interface StickAvatarInterface {
    /**
     * This method gets called by [StickAvatarInterface] to fetch the position of the message that has avatar
     * in sequence in the adapter
     * that is used for (represents) item at specified position.
     * IMPORTANT: If the item at specific position must not has sticky avatar you can return -1
     * @param itemPosition int. Adapter's position of the item for which to do the search of the position of the item that has avatar.
     * @return int. Position of the item that has avatar related to given position in the adapter.
     */
    fun getLastMessagePositionInSequenceForItem(itemPosition: Int): Int

    /**
     * This method gets called by [StickAvatarInterface] to get layout resource id for the avatar item at specified adapter's position.
     * @param avatarPosition int. Position of the last user message item in sequence in the adapter.
     * @return int. Layout resource id.
     */
    fun getAvatarLayout(avatarPosition: Int): Int

    /**
     * This method gets called by [StickAvatarInterface] to setup the avatar View.
     * @param avatarView View. Avatar view to set the data on.
     * @param avatarPosition int. Position of the avatar item in the adapter.
     */
    fun bindAvatarData(avatarView: View, avatarPosition: Int)

    /**
     * This method gets called by [StickAvatarInterface] to verify whether the item represents a first message of user in sequence.
     * @param itemPosition int.
     * @return true, if item at the specified adapter's position represents a header.
     */
    fun isSequenceBreaker(itemPosition: Int): Boolean
}