package com.example.tamar_sisvadzequiz4

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {
    @Query( "select * from  notes")
    fun getAllNotes():List<Notesmodel>

    @Insert
    fun saveNote(notesmodel:Notesmodel )

    @Query("select * drom notes where title = :noteparameter")
    fun getNoteByTitle(titleParameter:String): Notesmodel
}
