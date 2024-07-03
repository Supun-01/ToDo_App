package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Activity for updating a card
class UpdateCard : AppCompatActivity() {
    private lateinit var database: myDatabase

    // Called when the activity is starting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        // Get the position of the card to be updated from the intent
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            // Retrieve title and priority of the card at the given position
            val title = DataObject.getData(pos).title
            val priority = DataObject.getData(pos).priority

            // Set title and priority in EditText fields
            create_title.setText(title)
            create_priority.setText(priority)

            // Set click listener for the delete button
            delete_button.setOnClickListener {
                // Delete the card from the list and database
                DataObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteTask(
                        Entity(
                            pos + 1,
                            create_title.text.toString(),
                            create_priority.text.toString()
                        )
                    )
                }
                myIntent()
            }

            // Set click listener for the update button
            update_button.setOnClickListener {
                // Update the card in the list and database
                DataObject.updateData(
                    pos,
                    create_title.text.toString(),
                    create_priority.text.toString()
                )
                GlobalScope.launch {
                    database.dao().updateTask(
                        Entity(
                            pos + 1, create_title.text.toString(),
                            create_priority.text.toString()
                        )
                    )
                }
                myIntent()
            }

        }
    }

    // Method to navigate to MainActivity
    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
