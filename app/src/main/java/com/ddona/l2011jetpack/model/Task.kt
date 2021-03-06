package com.ddona.l2011jetpack.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "task_name")
    val name: String,
    @ColumnInfo(name = "task_description")
    val description: String,
    @ColumnInfo(name = "task_deadline")
    val deadline: Int
)
