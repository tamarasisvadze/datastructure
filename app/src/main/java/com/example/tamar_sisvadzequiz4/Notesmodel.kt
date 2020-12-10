package com.example.tamar_sisvadzequiz4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Notesmodel {
    @PrimaryKey
    val title:String,
    val note:String
}