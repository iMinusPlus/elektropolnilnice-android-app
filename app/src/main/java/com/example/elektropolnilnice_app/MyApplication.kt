package com.example.elektropolnilnice_app

import android.app.Application
import android.util.Log
import com.example.elektropolnilnice_app.models.ChargingStation
import com.google.gson.Gson
import com.mapbox.maps.extension.style.expressions.dsl.generated.all
import okhttp3.*
import java.io.IOException

class MyApplication : Application() {

    private lateinit var allStations: MutableList<ChargingStation>

    override fun onCreate() {
        super.onCreate()

        allStations = mutableListOf()

        getChargingStations()

    }

    fun getChargingStations() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://elektropolnilnice.eu:3000/address")
            .get()
            .build()

        // poslji zahtevo
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    parseChargingStationsData(body)
                } else {
                    handleError(response)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Log.d("MyApplication", "Error: ${e.message}")
            }
        })
    }

    fun parseChargingStationsData(data: String?) {
        if (data != null) {
            val gson = Gson()
            try {
                val chargingStations = gson.fromJson(data, Array<ChargingStation>::class.java)

                allStations.clear()
                allStations.addAll(chargingStations)

                 displayChargingStations(allStations)

            } catch (e: Exception) {
                Log.e("MyApplication", "Napaka pri parsiranju podatkov: ${e.message}")
            }
        }
    }


    fun handleError(response: Response) {
        println("Error: ${response.message}")
    }

    fun displayChargingStations(chargingStations: List<ChargingStation>) {
        for (station in chargingStations) {
            Log.d("MyApplication", "Polnilnica: ${station.title}, ${station.country}")
        }
    }

}