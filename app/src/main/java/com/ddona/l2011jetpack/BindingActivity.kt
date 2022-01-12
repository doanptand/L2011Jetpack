package com.ddona.l2011jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.ddona.l2011jetpack.base.BaseActivity
import com.ddona.l2011jetpack.databinding.ActivityBindingBinding
import com.ddona.l2011jetpack.vm.BindingViewModel

class BindingActivity : BaseActivity() {

    private lateinit var binding: ActivityBindingBinding
    private val viewModel: BindingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.vm = viewModel
        binding.lifecycleOwner = this

//        binding.btnLoad.setOnClickListener {
//            Glide.with(this)
//                .load(binding.edtLink.text.toString())
//                .into(binding.imgAvatar)
//        }
//        viewModel.link.observe(this, {
//            Log.d("doanpt", it)
//        })
    }
}