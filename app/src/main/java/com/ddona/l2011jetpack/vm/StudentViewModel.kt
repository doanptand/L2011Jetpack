package com.ddona.l2011jetpack.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.ddona.l2011jetpack.db.StudentDatabase
import com.ddona.l2011jetpack.model.Student
import com.ddona.l2011jetpack.repository.StudentRepository
import kotlinx.coroutines.*

class StudentViewModel(private val app: Application) : ViewModel() {
    private val studentRepository = StudentRepository(
        StudentDatabase
            .getInstance(app.applicationContext, viewModelScope)
            .getStudentDao()
    )

    val students = studentRepository.getAllStudentWithLiveData()

    fun insertStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.insertStudent(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.updateStudent(student)
        }
    }

    fun deleteStudentById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            studentRepository.deleteStudentById(id)
        }
    }

    suspend fun getStudentById(id: Int): Student {
        val student = viewModelScope.async (Dispatchers.IO){
            studentRepository.getStudentById(id)
        }
        return student.await()
    }

}