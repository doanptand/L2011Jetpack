package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.work.WorkInfo
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
//            viewModel.downloadContentLoop()
//            viewModel.runChain()
            viewModel.runWorkContinuation()
        }

        binding.btnDownloadLink.setOnClickListener {
            val link = binding.edtLink.text.toString()
            viewModel.downloadLink(link)
        }
        viewModel.sampleWorkInfo.observe(this, { it ->
            it.filter { it.state == WorkInfo.State.SUCCEEDED }
                .map {
                    Log.d("doanpt", "Result is: ${it.outputData.getBoolean("is_success", false)}")
                }
        })
    }
}