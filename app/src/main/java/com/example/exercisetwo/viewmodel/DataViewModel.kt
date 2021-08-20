package com.example.exercisetwo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.exercisetwo.model.ModelClass
import com.example.exercisetwo.model.Row
import com.google.gson.Gson
import java.io.IOException

class DataViewModel(application: Application) : AndroidViewModel(application){

    private val context = getApplication<Application>().applicationContext

  //  var dataResultList: List<Row> = generateDataList()
    fun generateDataList() : List<Row>{
        val jsonString: String? = loadJSONFromAsset()
        val gson = Gson()
        val modelClass: ModelClass = gson.fromJson(jsonString, ModelClass::class.java)
        val rows: List<Row> = modelClass.rows
        return rows
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
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
        return json
    }


}