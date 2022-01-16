package com.ddona.l2011jetpack.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ddona.l2011jetpack.model.SchoolAndDirector
import com.ddona.l2011jetpack.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("DELETE FROM student WHERE _id = :id")
    suspend fun deleteStudentById(id: Int)

    @Query("SELECT * FROM student")
    suspend fun getAllStudents(): List<Student>

    @Query("SELECT * FROM student")
    fun getAllStudentsWithLiveData(): LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE _id = :id")
    suspend fun getStudentById(id: Int): Student

    @Query("SELECT * FROM school WHERE schoolName = :name")
    suspend fun getSchoolAndDirector(name: String): List<SchoolAndDirector>
}