package com.ddona.l2011jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.l2011jetpack.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    private lateinit var binging: FragmentSongBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binging = FragmentSongBinding.inflate(layoutInflater)
        return binging.root
    }
}