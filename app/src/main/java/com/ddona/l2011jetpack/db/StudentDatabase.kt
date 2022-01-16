package com.ddona.l2011jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ddona.l2011jetpack.model.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Student::class], version = 2, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    companion object {
        private var INSTANCE: StudentDatabase? = null

        @Synchronized
        fun getInstance(
            ctx: Context,
            scope: CoroutineScope
        ): StudentDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    ctx.applicationContext,
                    StudentDatabase::class.java,
                    "student.db",
                ).fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            //insert data here
                            scope.launch(Dispatchers.IO) {
                                insertFakeData()
                            }
                        }

                        private suspend fun insertFakeData() {
                            val studentDao = INSTANCE!!.getStudentDao()
                            for (i in 1..100) {
                                studentDao.insertStudent(
                                    Student(
                                        name = "Doan $i",
                                        address = "Nam Dinh $i"
                                    )
                                )
                            }
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                        }

                        override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                            super.onDestructiveMigration(db)
                        }
                    })
                    .build()
            }
            return INSTANCE!!
        }
    }
}