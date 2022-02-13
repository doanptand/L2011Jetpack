package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ddona.l2011jetpack.databinding.ActivityWorkBinding
import com.ddona.l2011jetpack.vm.WorkViewModel

class WorkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkBinding
    private val viewModel: WorkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDownload.setOnClickListener {
            viewModel.downloadContent()
        }

        binding.btnDownloadLoop.setOnClickListener {
            viewModel.downloadContentLoop()
        }

        binding.btnDownloadLink.setOnClickListener {
            val link = binding.edtLink.text.toString()
            viewModel.downloadLink(link)
        }
    }
}