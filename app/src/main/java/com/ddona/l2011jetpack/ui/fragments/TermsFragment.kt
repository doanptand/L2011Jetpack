package com.ddona.l2011jetpack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.l2011jetpack.databinding.FragmentLoginBinding
import com.ddona.l2011jetpack.databinding.FragmentTermsBinding
import com.ddona.l2011jetpack.databinding.FragmentWelcomeBinding

class TermsFragment : Fragment() {
    private lateinit var binding: FragmentTermsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTermsBinding.inflate(inflater, container, false)
        return binding.root
    }
}