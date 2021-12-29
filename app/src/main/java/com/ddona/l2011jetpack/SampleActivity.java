package com.ddona.l2011jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.ddona.l2011jetpack.databinding.ActivitySampleBinding;
import com.ddona.l2011jetpack.vm.SampleViewModel;

public class SampleActivity extends AppCompatActivity {
    private ActivitySampleBinding binding;
    private SampleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        viewModel.getNumber().observe(this, integer -> {
            binding.tvNumber.setText(integer.toString());
        });
        binding.btnUp.setOnClickListener(v -> {
            viewModel.increaseNumber();
        });
    }
}