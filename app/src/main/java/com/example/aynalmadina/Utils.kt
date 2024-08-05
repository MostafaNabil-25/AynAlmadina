package com.example.aynalmadina

import android.content.Context
import java.io.IOException
import java.io.BufferedReader
import java.io.InputStreamReader

fun loadJSONFromAsset(context: Context, fileName: String): String? {
    val stringBuilder = StringBuilder()
    try {
        context.assets.open(fileName).use { inputStream ->
            BufferedReader(InputStreamReader(inputStream, Charsets.UTF_8)).use { reader ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    stringBuilder.append(line)
                }
            }
        }
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
    return stringBuilder.toString()
}

