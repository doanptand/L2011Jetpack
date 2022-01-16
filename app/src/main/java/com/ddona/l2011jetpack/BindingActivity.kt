package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ddona.l2011jetpack.adapter.StudentAdapter
import com.ddona.l2011jetpack.base.BaseActivity
import com.ddona.l2011jetpack.databinding.ActivityBindingBinding
import com.ddona.l2011jetpack.model.Student
import com.ddona.l2011jetpack.vm.BindingViewModel

class BindingActivity : BaseActivity() {

    private lateinit var binding: ActivityBindingBinding
    private val viewModel: BindingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.vm = viewModel
        binding.lifecycleOwner = this

//        binding.btnLoad.setOnClickListener {
//            Glide.with(this)
//                .load(binding.edtLink.text.toString())
//                .into(binding.imgAvatar)
//        }
//        viewModel.link.observe(this, {
//            Log.d("doanpt", it)
//        })
        val students = arrayListOf(
            Student(1, "Doan", "ND"),
            Student(2, "Doan2", "ND"),
            Student(3, "Doan3", "ND"),
            Student(4, "Doan4", "ND"),
        )
        val adapter = StudentAdapter()
        adapter.submitList(students)
        binding.rvData.adapter = adapter
        binding.rvData.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}