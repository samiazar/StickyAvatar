package com.saimazar.sample.model

data class ChatMessage (
    val id: Int,
    val body: String,
    val avatar: String,
    val isMyMessage: Boolean
)