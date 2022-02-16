package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.l2011jetpack.adapter.TaskAdapter
import com.ddona.l2011jetpack.databinding.ActivityPagingBinding
import com.ddona.l2011jetpack.vm.TaskViewModel
import kotlinx.coroutines.flow.collectLatest

class PagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagingBinding
    private val viewModel by viewModels<TaskViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = TaskAdapter()
        binding.rvTask.adapter = adapter
        binding.rvTask.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launchWhenStarted {
            viewModel.taskPaging.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}