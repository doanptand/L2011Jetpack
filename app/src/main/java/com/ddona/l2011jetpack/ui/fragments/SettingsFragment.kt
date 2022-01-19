package com.ddona.l2011jetpack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ddona.l2011jetpack.databinding.FragmentLoginBinding
import com.ddona.l2011jetpack.databinding.FragmentSettingBinding
import com.ddona.l2011jetpack.databinding.FragmentWelcomeBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }
}