package com.saimazar.sample.datasource

import com.saimazar.sample.model.ChatMessage
import com.saimazar.sample.model.Movie
import kotlin.random.Random

object DataSource {

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

    fun mockMovieList(): List<Movie> {
        val list: MutableList<Movie> = ArrayList()
        val baseThumbnailUrl = "https://api.adorable.io/avatars/200/"

        list.add(Movie(1, "${baseThumbnailUrl}Samurai.png", "The Seven Samurai"))
        list.add(Movie(2, "${baseThumbnailUrl}Clydepng", "Bonnie and Clyde"))
        list.add(Movie(3, "${baseThumbnailUrl}Reservoir.png", "Reservoir Dogs"))
        list.add(Movie(4, "${baseThumbnailUrl}Airplane.png", "Airplane!"))
        list.add(Movie(5, "${baseThumbnailUrl}Labyrinth.png", "Pan's Labyrinth"))
        list.add(Movie(6, "${baseThumbnailUrl}Zhivago.png", "Doctor Zhivago"))
        list.add(Movie(7, "${baseThumbnailUrl}Hunter.png", "The Deer Hunter"))
        list.add(Movie(8, "${baseThumbnailUrl}Encounters.png", "Close Encounters"))
        list.add(Movie(9, "${baseThumbnailUrl}Up.png", "Up"))
        list.add(Movie(10, "${baseThumbnailUrl}Rocky.png", "Rocky"))
        list.add(Movie(11, "${baseThumbnailUrl}Memento.png", "Memento"))
        list.add(Movie(12, "${baseThumbnailUrl}Braveheart.png", "Braveheart"))
        list.add(Movie(13, "${baseThumbnailUrl}Slumdog.png", "Slumdog Millionaire"))
        list.add(Movie(14, "${baseThumbnailUrl}the Rings.png", "The Lord of the Rings"))
        list.add(Movie(15, "${baseThumbnailUrl}Beauty.png", "Beauty and the Beast"))
        list.add(Movie(16, "${baseThumbnailUrl}Seven.png", "Seven"))
        list.add(Movie(17, "${baseThumbnailUrl}Inception.png", "Inception"))
        list.add(Movie(18, "${baseThumbnailUrl}Hard.png", "Die Hard"))
        list.add(Movie(19, "${baseThumbnailUrl}Amadeus.png", "Amadeus"))
        list.add(Movie(20, "${baseThumbnailUrl}Waterfront.png", "On the Waterfront"))
        list.add(Movie(21, "${baseThumbnailUrl}Wall.png", "Wall-E"))
        list.add(Movie(22, "${baseThumbnailUrl}Angry.png", "12 Angry Men"))

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