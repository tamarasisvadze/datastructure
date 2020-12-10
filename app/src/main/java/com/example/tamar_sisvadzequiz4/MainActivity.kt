package com.example.tamar_sisvadzequiz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapter: com.example.tamar_sisvadzequiz4.ListAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ListAdapter{
            goToDetails(it)

        }
        createNote.setOnClickListener{
           goToDetails(null)
        }

        noteList.adapter = adapter
        noteList.layoutManager = LinearLayoutManager (this)
    }
    override fun onStart() {
        super.onStart()
        val dataAccess =getDatabaseAccess()
        val noteList = dataAccess.getAllNotes()
        adapter?.noteList?.clear()
        adapter?.noteList?.addAll(noteList)
        adapter?.notifyDataSetChanged()
    }

     fun getDatabaseAccess():NotesDao{
         val database = Room.databaseBuilder(this,NotesDB::class.java, "notes_database")
             .allowMainThreadQueries()
             .build()
         return database.getNotesDao()
     }

    fun goToDetails(noteTitle:String?){
        val detailsIntents = Intent(this, DetailActivity:: class.java)
        detailsIntents.putExtra("data", noteTitle)
        startActivity(detailsIntents)
    }
}