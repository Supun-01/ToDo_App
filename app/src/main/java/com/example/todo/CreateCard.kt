package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Activity for creating a new card
class CreateCard : AppCompatActivity() {
    private lateinit var database: myDatabase

    // Called when the activity is starting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        // Set click listener for the save button
        save_button.setOnClickListener {
            // Check if title and priority fields are not empty
            if (create_title.text.toString().trim { it <= ' ' }.isNotEmpty()
                && create_priority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                // Get title and priority values
                var title = create_title.getText().toString()
                var priority = create_priority.getText().toString()

                // Set data in DataObject (not clear from provided code)
                DataObject.setData(title, priority)

                // Insert task into the database
                GlobalScope.launch {
                    database.dao().insertTask(Entity(0, title, priority))
                }

                // Navigate to MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
