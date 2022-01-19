package com.ddona.l2011jetpack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ddona.l2011jetpack.databinding.FragmentLoginBinding
import com.ddona.l2011jetpack.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    private val args: WelcomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val text = "${args.username} - ${args.password}"
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.tvWelcome.text = text
        return binding.root
    }
}