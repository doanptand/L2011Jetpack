package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.ddona.l2011jetpack.adapter.MusicPagerAdapter
import com.ddona.l2011jetpack.databinding.ActivityMusicBinding
import com.ddona.l2011jetpack.vm.MusicViewModel
import com.google.android.material.tabs.TabLayoutMediator

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicBinding
    private val viewModel by viewModels<MusicViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.number.observe(this, {
            Log.d("doanpt", "new data ${it.toString()}")
        })

        val tabs = arrayOf("Song", "Album")
        binding.vpMusic.adapter = MusicPagerAdapter(this)
        TabLayoutMediator(binding.tabMusic, binding.vpMusic) { tab, index ->
            tab.text = tabs[index]
        }.attach()
    }
}