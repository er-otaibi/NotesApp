package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.MyList.notesList

object MyList{

     var notesList = arrayListOf<String>()
}

class MainActivity : AppCompatActivity() {
    lateinit var rvMain: RecyclerView
    lateinit var etnote: EditText
    lateinit var addBtn: Button
    var note =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)
        etnote = findViewById(R.id.etnote)
        addBtn = findViewById(R.id.addBtn)

        var helper = DBHelper(applicationContext)
        helper.readData()

        rvMain.adapter = NoteAdapter(notesList)
        rvMain.layoutManager = LinearLayoutManager(this)


        addBtn.setOnClickListener {
            note = etnote.text.toString()

            var status = helper.saveNote(note)
            Toast.makeText(this , "Your note is added successfully $status" , Toast.LENGTH_LONG).show()

            var r = helper.getNote(note)
            etnote.setText("")
            notesList.add(r)
            rvMain.adapter!!.notifyDataSetChanged()
        }
    }
}