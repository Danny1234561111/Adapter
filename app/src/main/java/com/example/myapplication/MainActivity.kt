package com.example.myapplication

import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//package ru.myitschool.peoplelistk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var people= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var name= resources.getStringArray(R.array.name).toMutableList()
        var surname= resources.getStringArray(R.array.name).toMutableList()
        name.toList().shuffled().toMutableList()
        surname.toList().shuffled().toMutableList()
        for (i in 0..name.size-1){
            people.add(name[i].toString()+" "+surname[i].toString())
        }
//        var people = mutableListOf("Petya", "Vasya", "Mary") // массив неизменяем
        val lvPeople = findViewById<ListView>(R.id.people)
        val adapter = ArrayAdapter<String>(this, R.layout.item, people)
        lvPeople.adapter = adapter


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

    }
    fun onAddPersonClick(view: View) {
        val edit = findViewById<EditText>(R.id.edit)
        val newPerson = edit.text.toString()
        people.add(newPerson)
        edit.text.clear() // Очищаем поле ввода
        (findViewById<ListView>(R.id.people).adapter as ArrayAdapter<String>).notifyDataSetChanged()

    }
}