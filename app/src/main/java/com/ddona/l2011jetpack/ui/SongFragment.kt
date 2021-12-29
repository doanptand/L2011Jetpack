package com.ddona.l2011jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ddona.l2011jetpack.databinding.FragmentSongBinding
import com.ddona.l2011jetpack.vm.MusicViewModel

class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding
    private lateinit var viewModel: MusicViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSongBinding.inflate(layoutInflater)
//        viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        viewModel = ViewModelProvider(requireActivity()).get(MusicViewModel::class.java)
        viewModel.number.observe(viewLifecycleOwner, {
            binding.tvNumber.text = it.toString()
        })
        binding.btnUp.setOnClickListener {
            viewModel.increaseNumber()
        }
        return binding.root
    }
}