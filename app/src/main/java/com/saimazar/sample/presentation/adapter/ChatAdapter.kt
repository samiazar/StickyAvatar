package com.saimazar.sample.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saimazar.sample.R
import com.saimazar.sample.datasource.getItemState
import com.saimazar.sample.model.ChatMessage
import com.saimazar.sample.presentation.adapter.viewholder.ChatViewHolder
import com.saimazar.sample.presentation.adapter.viewholder.IncomingChatViewHolder
import com.saimazar.sample.presentation.adapter.viewholder.OutgoingChatViewHolder
import java.lang.IllegalArgumentException

class ChatAdapter: RecyclerView.Adapter<ChatViewHolder>() {

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
}