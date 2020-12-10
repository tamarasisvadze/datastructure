package com.example.tamar_sisvadzequiz4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class ListAdapter(val clicListener:(title:String)-> Unit):RecyclerView.Adapter<NotesviewHolder>() {

    val noteList = mutableListOf<Notesmodel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent, false)
        return NotesviewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NotesviewHolder, position: Int) {
        val item = noteList[position]
        holder.itemView.noteText.text = item.title
        holder.itemView.setOnClickListener {
            clicListener.invoke(item.title)
        }
    }



}



class NotesviewHolder (view:View) : RecyclerView.ViewHolder{view}

