package com.alexhernandez.tfgperros.service

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.stereotype.Service
import java.io.FileInputStream
import javax.annotation.PostConstruct


@Service
class FirebaseInitializer {
    @PostConstruct
    fun initialize() {
        try {
            val serviceAccount = FileInputStream("src/main/kotlin/com/alexhernandez/tfgperros/config/firebase-service-account.json")
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tfg-perros.firebaseio.com/")
                .build()

            FirebaseApp.initializeApp(options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}