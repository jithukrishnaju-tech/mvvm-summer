package com.example.mvvmarchitecture.View

import android.os.Binder
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.databinding.ActivityMainBinding
import com.example.mvvmarchitecture.viewModel.ItemViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel : ItemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.additionResult.setOnClickListener {
            val firstNumber = binding.firstNumber.text.toString().toIntOrNull() ?: 0
            val secondNumber = binding.secondNumber.text.toString().toIntOrNull() ?:0
            viewModel.calculateSum(firstNumber, secondNumber)
//            binding.resultValue.text = result.Sum.toString()
        }

        viewModel.sumresult.observe(this) {result ->
            binding.resultValue.text = result.toString()
        }



    }
}