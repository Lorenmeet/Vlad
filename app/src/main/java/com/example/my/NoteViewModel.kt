package com.example.my

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.my.ui.theme.Note

class NoteViewModel: ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note>
        get() = _notes
    fun addNote(title: String, text:String){
        _notes.add(Note(title, text))
    }
    fun removeNote(note: Note){
        _notes.remove(note)
    }
}