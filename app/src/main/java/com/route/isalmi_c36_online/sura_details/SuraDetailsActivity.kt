package com.route.isalmi_c36_online.sura_details

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.route.isalmi_c36_online.Constants
import com.route.isalmi_c36_online.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
    var suraContent: MutableList<String> = mutableListOf()
    lateinit var nameTextView: TextView
    lateinit var contentTextView: TextView
    lateinit var backButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val suraName = intent.getStringExtra(Constants.SURA_NAME)
        val fileName = intent.getStringExtra(Constants.FILE_NAME)
        nameTextView = findViewById(R.id.sura_details_sura_name)
        contentTextView = findViewById(R.id.sura_content)
        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            finish()
        }
        nameTextView.text = suraName
        readSuraContent(fileName?:"")
        var content = ""
        for(i in 0 .. suraContent.size-1){
          content += suraContent.get(i) + "(${i+1}) "
        }
        Log.e("SuraDetails","$content")
        contentTextView.text = content
    }
   fun readSuraContent(fileName: String){
       val reader: BufferedReader
       try {
           val file: InputStream = assets.open(fileName)
           reader = BufferedReader(InputStreamReader(file))
             suraContent= reader.readLines().toMutableList()
       } catch (ioe: IOException) {
           ioe.printStackTrace()
       }
    }
}