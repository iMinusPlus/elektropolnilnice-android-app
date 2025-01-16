package com.example.elektropolnilnice_app.models

import com.google.gson.Gson

data class ChargingStation(
    val id: Int,
    val country: String?,
    val latitude: Double, // Latitude kot Double
    val longitude: Double, // Longitude kot Double
    val postcode: String?,
    val title: String?,
    val town: String? // Town bo null, če je v JSON-u "null"
) {
    // Dodamo metodo za pretvorbo koordinat v Double
    companion object {
        fun fromJson(json: String): ChargingStation {
            val gson = Gson()
            return gson.fromJson(json, ChargingStation::class.java)
        }
    }
}


