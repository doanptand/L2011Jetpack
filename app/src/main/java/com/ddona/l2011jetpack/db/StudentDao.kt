package com.ddona.l2011jetpack.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ddona.l2011jetpack.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM student")
    fun getAllStudentsWithLiveData(): LiveData<List<Student>>
}