package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.l2011jetpack.adapter.StudentAdapter
import com.ddona.l2011jetpack.databinding.ActivityStudentRoomBinding
import com.ddona.l2011jetpack.model.Student
import com.ddona.l2011jetpack.vm.StudentViewModel
import com.ddona.l2011jetpack.vm.StudentViewModelFactory

class StudentRoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentRoomBinding
    private val viewModel: StudentViewModel by viewModels() {
        StudentViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            viewModel.insertStudent(Student(name = name, address = address))
        }
        binding.btnDelete.setOnClickListener {
            val id = binding.edtId.text.toString().toInt()
            viewModel.deleteStudentById(id)
        }
        binding.btnUpdate.setOnClickListener {
            val id = binding.edtId.text.toString().toInt()
            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            viewModel.updateStudent(Student(id = id, name = name, address = address))
        }
        binding.btnFind.setOnClickListener {

        }

        val studentAdapter = StudentAdapter()
        viewModel.students.observe(this, {
            studentAdapter.submitList(it)
        })

        binding.rvStudent.adapter = studentAdapter
        binding.rvStudent.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}