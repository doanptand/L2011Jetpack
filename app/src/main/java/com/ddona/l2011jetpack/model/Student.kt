package com.ddona.l2011jetpack.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Int,
    @ColumnInfo(name = "_name")
    val name: String,
    @ColumnInfo(name = "_address")
    val address: String,
)
