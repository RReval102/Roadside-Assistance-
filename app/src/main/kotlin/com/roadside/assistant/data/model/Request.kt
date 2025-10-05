package com.roadside.assistant.data.model

enum class RequestCategory { TIRE, BATTERY, FUEL, TOW, OTHER }

enum class RequestStatus { OPEN, ASSIGNED, DONE, CANCELLED }

data class GeoPoint(val lat: Double, val lon: Double)

data class Request(
    val id: String,
    val authorId: String,
    val category: RequestCategory,
    val description: String,
    val location: GeoPoint,
    val status: RequestStatus = RequestStatus.OPEN,
    val createdAt: Long = System.currentTimeMillis()
)
