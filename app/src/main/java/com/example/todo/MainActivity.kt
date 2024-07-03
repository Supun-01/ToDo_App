package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

// Main activity displaying the list of tasks
class MainActivity : AppCompatActivity() {
    private lateinit var database: myDatabase

    // Called when the activity is starting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        // Set click listener for the add button to navigate to CreateCard activity
        add.setOnClickListener {
            val intent = Intent(this, CreateCard::class.java)
            startActivity(intent)
        }

        // Set up the RecyclerView
        setRecycler()
    }

    // Set up the RecyclerView with adapter and layout manager
    fun setRecycler() {
        recycler_view.adapter = Adapter(DataObject.getAllData())
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}
