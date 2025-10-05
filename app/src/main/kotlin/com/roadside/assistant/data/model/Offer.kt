package com.roadside.assistant.data.model

data class Offer(
    val id: String,
    val requestId: String,
    val helperId: String,
    val etaMinutes: Int,
    val createdAt: Long = System.currentTimeMillis()
)
