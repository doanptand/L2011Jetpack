package com.ddona.l2011jetpack.network

import com.ddona.l2011jetpack.model.Passenger

data class PassengerResponse(
    val totalPassengers: Int,
    val totalPages: Int,
    val data: List<Passenger>
)
