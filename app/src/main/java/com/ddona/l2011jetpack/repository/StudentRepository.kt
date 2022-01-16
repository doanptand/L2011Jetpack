package com.ddona.l2011jetpack.repository

import androidx.lifecycle.LiveData
import com.ddona.l2011jetpack.db.StudentDao
import com.ddona.l2011jetpack.model.Student

class StudentRepository(
    private val studentDao: StudentDao,
) {

    suspend fun insertStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }

    suspend fun deleteStudentById(id: Int) {
        studentDao.deleteStudentById(id)
    }

    suspend fun getAllStudents(): List<Student> {
        return studentDao.getAllStudents()
    }

    fun getAllStudentWithLiveData(): LiveData<List<Student>> {
        return studentDao.getAllStudentsWithLiveData()
    }

    suspend fun getStudentById(id: Int): Student {
        return studentDao.getStudentById(id)
    }
}