package com.ddona.l2011jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ddona.l2011jetpack.model.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    companion object {
        private var INSTANCE: StudentDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): StudentDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    ctx.applicationContext,
                    StudentDatabase::class.java,
                    "student.db",
                ).build()
            }
            return INSTANCE!!
        }
    }
}