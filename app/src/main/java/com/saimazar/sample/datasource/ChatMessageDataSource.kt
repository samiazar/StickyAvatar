package com.saimazar.sample.datasource

import com.saimazar.sample.model.ChatMessage
import kotlin.random.Random

object ChatMessageDataSource {

    fun mockChatList(): List<ChatMessage> {
        val list: MutableList<ChatMessage> = ArrayList()
        val myAvatar = "https://api.adorable.io/avatars/100/myAvatar.png"
        val opposedAvatar = "https://api.adorable.io/avatars/100/opposedAvatar.png"
        val sampleBody = arrayListOf(
            "Hey, How you doing?",
            "Hello man.",
            "Are you there?",
            "It's my pleasure to talk with someone like you that so care about me?",
            "Oh my goodness!!!!",
            "I'm here without you",
            "He was 100% into fasting with her until he understood that meant he couldn't eat.",
            "Now I need to ponder my existence and ask myself if I'm truly real",
            "He wondered if she would appreciate his toenail collection.",
            "The thunderous roar of the jet overhead confirmed her worst fears.",
            "The skeleton had skeletons of his own in the closet.",
            "The ants enjoyed the barbecue more than the family.",
            "Getting up at dawn is for the birds.\n" +
                    "That was how he came to win \$1 million.",
            "The Tsunami wave crashed against the raised houses and broke the pilings as if they were toothpicks.",
            "He found a leprechaun in his walnut shell.",
            "The fact that there's a stairway to heaven and a highway to hell explains life well.",
            "I am out of paper for the printer.",
            "I'm a great listener, really good with empathy vs sympathy and all that, but I hate people.",
            "The random sentence generator generated a random sentence about a random sentence.",
            "She can live her life however she wants as long as she listens to what I have to say.",
            "Plans for this weekend include turning wine into water.",
            "He had a hidden stash underneath the floorboards in the back room of the house.",
            "Oh, how I'd love to go!",
            "We have never been to Asia, nor have we visited Africa."
        )

        list.add(ChatMessage(1, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(2, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(3, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(4, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(5, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(6, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(7, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(8, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(9, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(10, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(11, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(12, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(13, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(14, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(15, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(16, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(17, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(18, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(19, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(20, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(21, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(22, sampleBody[Random.nextInt(0, sampleBody.size)], myAvatar, true))
        list.add(ChatMessage(23, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(24, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))
        list.add(ChatMessage(25, sampleBody[Random.nextInt(0, sampleBody.size)], opposedAvatar, false))

        return list
    }
}

fun List<ChatMessage>.getItemState(position: Int):ChatMessageState {
    if (position !in indices) return ChatMessageState.NONE
    return if (position == 0) {
        if (get(position).isMyMessage) {
            ChatMessageState.OUTGOING_LAST
        } else {
            ChatMessageState.INCOMING_LAST
        }
    } else {
        if (get(position).isMyMessage) {
            if (get(position - 1).isMyMessage) {
                ChatMessageState.OUTGOING_NORMAL
            } else {
                ChatMessageState.OUTGOING_LAST
            }
        } else {
            if (get(position - 1).isMyMessage) {
                ChatMessageState.INCOMING_LAST
            } else {
                ChatMessageState.INCOMING_NORMAL
            }
        }
    }
}

enum class ChatMessageState {
    OUTGOING_NORMAL, OUTGOING_LAST, INCOMING_NORMAL, INCOMING_LAST, NONE
}