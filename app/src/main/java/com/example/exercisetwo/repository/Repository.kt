package com.example.exercisetwo.repository

import android.content.Context
import com.example.exercisetwo.model.ModelClass
import com.google.gson.Gson
import java.io.IOException

class Repository {

    fun generateDataList(context: Context): ModelClass {
        val jsonString: String? = loadJSONFromAsset(context)
        val gson = Gson()
        return gson.fromJson(jsonString, ModelClass::class.java)
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