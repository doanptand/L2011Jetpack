package com.ddona.l2011jetpack.model

data class Passenger(
    val __v: Int,
    val _id: String,
    val airline: List<Airline>,
    val name: String,
    val trips: Int
)