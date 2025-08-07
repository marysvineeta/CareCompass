package com.example.carecompass.domain.repository

import com.example.carecompass.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun addNote(title: String, content: String)
    suspend fun deleteNote(id: String)
}
