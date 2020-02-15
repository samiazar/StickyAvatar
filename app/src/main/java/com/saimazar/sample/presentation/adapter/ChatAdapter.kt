package com.saimazar.sample.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.saimazar.library.StickAvatarInterface
import com.saimazar.sample.R
import com.saimazar.sample.datasource.ChatMessageState
import com.saimazar.sample.datasource.getItemState
import com.saimazar.sample.model.ChatMessage
import com.saimazar.sample.presentation.adapter.viewholder.ChatViewHolder
import com.saimazar.sample.presentation.adapter.viewholder.IncomingChatViewHolder
import com.saimazar.sample.presentation.adapter.viewholder.OutgoingChatViewHolder
import kotlinx.android.synthetic.main.item_avatar_incoming_in_chat.view.*
import java.lang.IllegalArgumentException

class ChatAdapter: RecyclerView.Adapter<ChatViewHolder>(), StickAvatarInterface {

    val mItems: MutableList<ChatMessage> = ArrayList()
    private val MY_CHAT_SIDE = 0
    private val OPPOSED_CHAT_SIDE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return when (viewType) {
            MY_CHAT_SIDE -> {
                OutgoingChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_outgoing_message_in_chat, parent, false))
            }
            OPPOSED_CHAT_SIDE -> {
                IncomingChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_incoming_message_in_chat, parent, false))
            }
            else -> {
                throw IllegalArgumentException ("view type is not recognized")
            }
        }
    }

    override fun getItemCount(): Int = mItems.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) =
        holder.bind(mItems[holder.adapterPosition], mItems.getItemState(holder.adapterPosition))

    override fun getItemViewType(position: Int): Int {
        return if (mItems[position].isMyMessage) {
            MY_CHAT_SIDE
        } else {
            OPPOSED_CHAT_SIDE
        }
    }

    fun updateList(chatList: List<ChatMessage>) {
        mItems.clear()
        mItems.addAll(chatList)
        notifyDataSetChanged()
    }

    override fun getLastMessagePositionInSequenceForItem(itemPosition: Int): Int {
        when (mItems.getItemState(itemPosition)) {

            ChatMessageState.OUTGOING_LAST,
            ChatMessageState.INCOMING_LAST -> {
                return itemPosition
            }

            ChatMessageState.OUTGOING_NORMAL -> {
                var tempPosition = itemPosition - 1
                do {
                    val tempState = mItems.getItemState(tempPosition)
                    if (tempState == ChatMessageState.OUTGOING_LAST) return tempPosition
                    tempPosition--
                } while (tempPosition in mItems.indices)
                return RecyclerView.NO_POSITION
            }

            ChatMessageState.INCOMING_NORMAL -> {
                var tempPosition = itemPosition - 1
                do {
                    val tempState = mItems.getItemState(tempPosition)
                    if (tempState == ChatMessageState.INCOMING_LAST) return tempPosition
                    tempPosition--
                } while (tempPosition in mItems.indices)
                return RecyclerView.NO_POSITION
            }

            else -> {
                return RecyclerView.NO_POSITION
            }
        }
    }

    override fun getAvatarLayout(headerPosition: Int): Int {
        val headerState = mItems.getItemState(headerPosition)
        return if (headerState == ChatMessageState.OUTGOING_LAST || headerState == ChatMessageState.OUTGOING_NORMAL) {
            R.layout.item_avatar_outgoing_in_chat
        } else {
            R.layout.item_avatar_incoming_in_chat
        }
    }

    override fun bindAvatarData(header: View, headerPosition: Int) {
        with(header) {
            Glide
                .with(context)
                .load(mItems[headerPosition].avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(ivAvatar)
        }
    }

    override fun isSequenceBreaker(itemPosition: Int): Boolean {
        if (itemPosition !in mItems.indices || itemPosition == 0) return false
        val isSequenceBreaker = mItems[itemPosition].isMyMessage != mItems[itemPosition - 1].isMyMessage
        println("itemPosition: $itemPosition && isSequenceBreaker: $isSequenceBreaker")
        return isSequenceBreaker
    }
}