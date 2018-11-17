package com.example.adambenyahia.currenconverterktl

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import kotlin.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val downloadData = Download()

        try {
            val url = ""
        } catch (e: Exception){
            e.printStackTrace()
        }
    }


    inner class Download : AsyncTask<String,Void,String>(){

        override fun doInBackground(vararg p0: String?): String {
            var result = ""
            var url : URL
            val httpURLConnection : HttpURLConnection

            try {
                url = URL(p0[0])
                httpURLConnection = url.openConnection() as HttpURLConnection
                val inputStream = httpURLConnection.inputStream
                val inputStreamReader = InputStreamReader(inputStream)

                var data = inputStream.read()

                while (data > 0) {
                    val character = data.toChar()
                    result += character

                    data = inputStreamReader.read()
                }
            } catch (e:Exception) {
                e.printStackTrace()
                return result
            }



            return result
        }


        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)


            try {
                val jsonObject = JSONObject(result)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

    }
}
