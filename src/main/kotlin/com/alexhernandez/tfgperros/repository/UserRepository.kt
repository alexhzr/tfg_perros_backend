package com.alexhernandez.tfgperros.repository

import com.alexhernandez.tfgperros.model.User
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Repository

@Repository("userRepository")
class UserRepository() {
    val COLLECTION_NAME: String = "User"

    fun registerUser(user: User): Boolean {
        val firestoreDb: Firestore = FirestoreClient.getFirestore()
        val apiFuture: ApiFuture<WriteResult> = firestoreDb.collection(COLLECTION_NAME).document(user.dni).set(user)

        return (apiFuture.get().updateTime != null)
    }

    fun getUserByDNI(dni: String): User? {
        val docSnapshot: ApiFuture<DocumentSnapshot> = FirestoreClient.getFirestore().collection(COLLECTION_NAME).document(dni).get()

        return docSnapshot.get().toObject(User::class.java)
    }

    fun userExists(email: String, dni: String): Boolean {
        var user = this.getUserByDNI(dni)

        if (user == null) {
            val docSnapshot = FirestoreClient.getFirestore().collection(COLLECTION_NAME).whereEqualTo("email", email).get()

            if (!docSnapshot.get().documents.isEmpty())
                user = docSnapshot.get().documents.get(0)?.toObject(User::class.java)
        }

        return user != null
    }
}
