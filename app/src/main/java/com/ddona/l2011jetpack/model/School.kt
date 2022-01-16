package com.ddona.l2011jetpack.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School(
    @PrimaryKey
    val schoolName: String,
    val address: String
)