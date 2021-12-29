package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddona.l2011jetpack.adapter.MusicPagerAdapter
import com.ddona.l2011jetpack.databinding.ActivityMusicBinding
import com.google.android.material.tabs.TabLayoutMediator

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabs = arrayOf("Song", "Album")
        binding.vpMusic.adapter = MusicPagerAdapter(this)
        TabLayoutMediator(binding.tabMusic, binding.vpMusic) { tab, index ->
            tab.text = tabs[index]
        }.attach()
    }
}