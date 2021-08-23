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

    var dataResultList: MutableLiveData<ModelClass> = MutableLiveData()
    private var repository: Repository = Repository()

    fun getDataList() = repository.generateDataList(context).also { dataResultList.value = it }

}