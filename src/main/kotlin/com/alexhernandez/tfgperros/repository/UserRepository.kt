package com.alexhernandez.tfgperros.repository

import com.alexhernandez.tfgperros.model.User
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Repository

@Repository("userRepository")
class UserRepository {
    
    fun registerUser(user: User): String {
        val firestoreDb: Firestore = FirestoreClient.getFirestore()
        val apiFuture: ApiFuture<WriteResult> = firestoreDb.collection("User").document(user.name.firstName).set(user)

        return apiFuture.get().updateTime.toString()
    }
}