package com.example.tamar_sisvadzequiz4

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Notesmodel::class], version = 1)
abstract class NotesDB :RoomDatabase(){

    abstract fun getNotesDao(): NotesDao


}