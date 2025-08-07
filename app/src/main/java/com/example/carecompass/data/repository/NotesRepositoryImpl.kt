package com.example.carecompass.data.repository

import com.example.carecompass.domain.model.Note
import com.example.carecompass.domain.repository.NotesRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class NotesRepositoryImpl : NotesRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val notesCollection = firestore.collection("notes")

    override fun getNotes(): Flow<List<Note>> = callbackFlow {
        val listener = notesCollection.addSnapshotListener { snapshot, _ ->
            val notes = snapshot?.documents?.mapNotNull { doc ->
                doc.toObject(Note::class.java)?.copy(id = doc.id)
            } ?: emptyList()
            trySend(notes)
        }
        awaitClose { listener.remove() }
    }

    override suspend fun addNote(title: String, content: String) {
        val newNote = hashMapOf("title" to title, "content" to content)
        notesCollection.add(newNote).await()
    }

    override suspend fun deleteNote(id: String) {
        notesCollection.document(id).delete().await()
    }
}
