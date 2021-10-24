package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "myNotes.db", null, 1) {

    private var sqLiteDatabase: SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table notes (Note text )")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun savedat(s1: String): Long {

        val cv = ContentValues()
        cv.put("Note", s1)
        return sqLiteDatabase.insert("notes", null, cv)
    }
}