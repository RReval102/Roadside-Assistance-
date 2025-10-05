package com.roadside.assistant.data.model

enum class MessageKind { TEXT, SYSTEM }

data class ChatMessage(
    val id: String,
    val requestId: String,
    val authorId: String,
    val kind: MessageKind,
    val text: String,
    val createdAt: Long = System.currentTimeMillis()
)
