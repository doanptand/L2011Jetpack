package com.ddona.l2011jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ddona.l2011jetpack.databinding.FragmentAlbumBinding
import com.ddona.l2011jetpack.databinding.FragmentSongBinding
import com.ddona.l2011jetpack.vm.MusicViewModel

class AlbumFragment : Fragment() {
    private lateinit var binding: FragmentAlbumBinding

    //    private lateinit var viewModel: MusicViewModel
//    private val viewModel: MusicViewModel by viewModels()
    private val viewModel: MusicViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(layoutInflater)
//        viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
//        viewModel = ViewModelProvider(requireActivity()).get(MusicViewModel::class.java)
        binding.btnUp.setOnClickListener { viewModel.increaseNumber() }
        viewModel.number.observe(viewLifecycleOwner, {
            binding.tvNumber.text = it.toString()
        })
        return binding.root
    }
}