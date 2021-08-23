package com.example.exercisetwo.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.exercisetwo.model.ModelClass
import com.google.gson.Gson
import java.io.IOException

class Repository {

    fun generateDataList(context: Context): MutableLiveData<ModelClass> {

        val dataResultList: MutableLiveData<ModelClass> = MutableLiveData()
        val jsonString: String? = loadJSONFromAsset(context)
        val gson = Gson()
        val modelClass: ModelClass = gson.fromJson(jsonString, ModelClass::class.java)
        dataResultList.postValue(modelClass)
        return dataResultList
    }

    private fun loadJSONFromAsset(context: Context): String? {

        return try {
            val `is` = context.assets.open("jsonObject.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
    }

}