package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddona.l2011jetpack.adapter.PassengerAdapter
import com.ddona.l2011jetpack.databinding.ActivityPassengerBinding
import com.ddona.l2011jetpack.vm.PassengerViewModel
import kotlinx.coroutines.flow.collectLatest

class PassengerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPassengerBinding

    private val viewModels: PassengerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassengerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPassenger.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = PassengerAdapter()
        binding.rvPassenger.adapter = adapter
        lifecycleScope.launchWhenStarted {
            viewModels.passengers.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}