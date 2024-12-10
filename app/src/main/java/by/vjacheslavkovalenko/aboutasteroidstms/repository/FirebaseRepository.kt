package by.vjacheslavkovalenko.aboutasteroidstms.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseRepository {

    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun getHtmlContent(callback: (String?) -> Unit) {
        database.child("discover").get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val htmlContent = snapshot.value as? String
                callback(htmlContent)
            } else {
                callback(null)
            }
        }.addOnFailureListener {
            callback(null)
        }
    }
}