package com.example.tamar_sisvadzequiz4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataAccess = getDatabaseAccess()

        val noteParameter = intent.getStringExtra("data")

        val shouldBeEditable = noteParameter.isNullOrEmpty()
        titleText.isEnabled = shouldBeEditable
        noteText.isEnabled = shouldBeEditable
        saveButton.visibility = if (shouldBeEditable)
            View.VISIBLE
        else
            View.GONE


        titleText.setText(noteParameter)
        if (!shouldBeEditable){
            dataAccess.getNoteByTitle(noteParameter!!)
        }

        saveButton.setOnClickListener {
            val noteTitle = titleText.text.toString()
            val noteBody = noteText.text.toString()
            if (noteTitle.isNotEmpty() && noteBody.isNotEmpty()) {
                val noteModel = Notesmodel(noteTitle,noteBody)
                dataAccess.saveNote(noteModel)
                finish()

            } else{
                val warningMessage = "title or body is empty "
                Toast.makeText(this, warningMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun getDatabaseAccess():NotesDao{
        val database = Room.databaseBuilder(this,NotesDB::class.java, "notes_database")
            .allowMainThreadQueries()
            .build()
        return database.getNotesDao()
    }
}
