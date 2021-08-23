package com.example.exercisetwo.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.exercisetwo.model.ModelClass
import com.example.exercisetwo.repository.Repository

class DataViewModel(application: Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    fun getDataList(): MutableLiveData<ModelClass> {
        val myRepo = Repository()
        return myRepo.generateDataList(context)
    }
}