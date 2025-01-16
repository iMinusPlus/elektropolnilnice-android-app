package com.example.elektropolnilnice_app

import android.app.Application
//import android.widget.Toast
//import io.realm.Realm
//import io.realm.RealmConfiguration
//import io.realm.mongodb.App
//import io.realm.mongodb.AppConfiguration
//import io.realm.mongodb.mongo.MongoCollection
//import io.realm.mongodb.mongo.iterable.MongoCursor
//import org.bson.Document

class MyApplication : Application() {

//    private lateinit var mongoApp: App
//    private lateinit var collection: MongoCollection<Document>

    override fun onCreate() {
        super.onCreate()

//        Realm.init(this)
//
//        val appID = "your-app-id" // Zamenjaj z MongoDB App ID
//        mongoApp = App(AppConfiguration.Builder(appID).build())
//
//        // Prijavi se v MongoDB Realm (anonimno)
//        mongoApp.loginAsync(AppCredentials.anonymous()) { result ->
//            if (result.isSuccess) {
//                Toast.makeText(this, "Prijava uspešna!", Toast.LENGTH_SHORT).show()
//                setupMongoDB()
//            } else {
//                Toast.makeText(this, "Napaka pri prijavi: ${result.error.message}", Toast.LENGTH_LONG).show()
//            }
//        }

    }

//    private fun setupMongoDB() {
//        // Pridobi MongoDB klienta in zbirko
//        val mongoClient = mongoApp.currentUser()?.getMongoClient("mongodb-atlas")
//        val database = mongoClient?.getDatabase("your-database-name") // Zamenjaj z imenom baze podatkov
//        collection = database?.getCollection("your-collection-name")!! // Zamenjaj z imenom zbirke
//
//        // Pridobi podatke iz zbirke
//        fetchData()
//    }
//
//    private fun fetchData() {
//        val query = Document() // Prazen dokument pomeni, da pridobimo vse
//        collection.find(query).iterator().getAsync { result ->
//            if (result.isSuccess) {
//                val cursor: MongoCursor<Document>? = result.get()
//                while (cursor?.hasNext() == true) {
//                    val document = cursor.next()
//                    // Naredi nekaj s pridobljenim dokumentom
//                    Toast.makeText(this, "Podatek: ${document.toJson()}", Toast.LENGTH_LONG).show()
//                }
//            } else {
//                Toast.makeText(this, "Napaka pri pridobivanju podatkov: ${result.error.message}", Toast.LENGTH_LONG).show()
//            }
//        }
//    }

}