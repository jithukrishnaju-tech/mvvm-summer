package com.example.mvvmarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.SumData

class ItemViewModel: ViewModel() {
    private val _sumresult = MutableLiveData<Int>()
    val sumresult: LiveData<Int> = _sumresult
    fun calculateSum(firtNumber:Int, secondNumber: Int):SumData{
        val sum = firtNumber + secondNumber
        var resultValue: Int = SumData(firtNumber, secondNumber, sum).Sum;
        _sumresult.value = resultValue
        return SumData(firtNumber, secondNumber, sum)
    }
}