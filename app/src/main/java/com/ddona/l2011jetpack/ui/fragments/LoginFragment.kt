package com.ddona.l2011jetpack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ddona.l2011jetpack.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text.toString()
            val pass = binding.edtPassword.text.toString()

            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(user, pass)
            findNavController().navigate(action)

        }
        return binding.root
    }
}