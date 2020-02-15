package com.saimazar.sample.presentation.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.saimazar.sample.R
import com.saimazar.sample.datasource.ChatMessageState
import com.saimazar.sample.model.ChatMessage
import kotlinx.android.synthetic.main.item_incoming_message_in_chat.view.ivAvatar as incomingAvatar
import kotlinx.android.synthetic.main.item_incoming_message_in_chat.view.vBody as incomingBody
import kotlinx.android.synthetic.main.item_incoming_message_in_chat.view.vBody as incomingBody
import kotlinx.android.synthetic.main.item_outgoing_message_in_chat.view.ivAvatar as outgoingAvatar
import kotlinx.android.synthetic.main.item_outgoing_message_in_chat.view.vBody as outgoingBody
import kotlinx.android.synthetic.main.item_outgoing_message_in_chat.view.vBody as outgoingBody

abstract class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    abstract fun bind(message: ChatMessage, state: ChatMessageState)
}

class IncomingChatViewHolder(itemView: View): ChatViewHolder(itemView) {

    override fun bind(message: ChatMessage, state: ChatMessageState) {
        with(itemView) {
            incomingBody.text = message.body
            if (state == ChatMessageState.INCOMING_LAST) {
                incomingBody.setBackgroundResource(R.drawable.background_chat_incoming_last)
                incomingAvatar.visibility = View.VISIBLE
                Glide
                    .with(context)
                    .load(message.avatar)
                    .apply(RequestOptions.circleCropTransform())
                    .into(incomingAvatar)
            } else {
                incomingBody.setBackgroundResource(R.drawable.background_chat_incoming_normal)
                incomingAvatar.visibility = View.GONE
            }
        }
    }

}

class OutgoingChatViewHolder(itemView: View): ChatViewHolder(itemView) {

    override fun bind(message: ChatMessage, state: ChatMessageState) {
        with(itemView) {
            outgoingBody.text = message.body
            if (state == ChatMessageState.OUTGOING_LAST) {
                outgoingBody.setBackgroundResource(R.drawable.background_chat_outgoing_last)
                outgoingAvatar.visibility = View.VISIBLE
                Glide
                    .with(context)
                    .load(message.avatar)
                    .apply(RequestOptions.circleCropTransform())
                    .into(outgoingAvatar)
            } else {
                outgoingBody.setBackgroundResource(R.drawable.background_chat_outgoing_normal)
                outgoingAvatar.visibility = View.GONE
            }
        }
    }

}