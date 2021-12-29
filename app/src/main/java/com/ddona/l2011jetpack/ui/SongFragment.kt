package com.ddona.l2011jetpack.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ddona.l2011jetpack.databinding.FragmentSongBinding
import com.ddona.l2011jetpack.vm.MusicViewModel
import com.ddona.l2011jetpack.vm.MusicViewModelFactory

class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding

    private lateinit var viewModel: MusicViewModel
//    private val viewModel by viewModels<MusicViewModel>()
//    private val viewModel by activityViewModels<MusicViewModel>() {
//        MusicViewModelFactory(requireActivity().application, 10)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSongBinding.inflate(layoutInflater)
//        viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        viewModel =
            ViewModelProvider(
                requireActivity(),
                MusicViewModelFactory(requireActivity().application, 10)
            ).get(MusicViewModel::class.java)
        viewModel.number.observe(viewLifecycleOwner, {
            binding.tvNumber.text = it.toString()
        })
        //To Avoid memory leak when use observeForever, please call removeObserver
        viewModel.number.observeForever {
            Log.d("doanpt", "number in fragment: $it")
        }
        binding.btnUp.setOnClickListener {
            viewModel.increaseNumber()
        }
        return binding.root
    }


    override fun onDestroyView() {
        viewModel.number.removeObserver { }
        super.onDestroyView()
    }
}