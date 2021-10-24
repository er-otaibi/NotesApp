package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rvMain: RecyclerView
    lateinit var etnote: EditText
    lateinit var addBtn: Button
    var notesList = arrayListOf<String>()
    var s1 =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)
        rvMain.adapter = NoteAdapter(notesList)
        rvMain.layoutManager = LinearLayoutManager(this)
        etnote = findViewById(R.id.etnote)
        addBtn = findViewById(R.id.addBtn)

        addBtn.setOnClickListener {
            s1 = etnote.text.toString()

            var helper = DBHelper(applicationContext)
            var status = helper.savedat(s1)
//            notesList.add(s1)
//            rvMain.adapter!!.notifyDataSetChanged()
            Toast.makeText(this , "Your note is added successfully $status" , Toast.LENGTH_LONG).show()
        }


    }
}