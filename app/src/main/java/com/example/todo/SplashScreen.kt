package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// SplashScreen activity displaying a splash screen while initializing the app
class SplashScreen : AppCompatActivity() {
    private lateinit var database: myDatabase

    // Called when the activity is starting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Initialize the database
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()

        // Retrieve tasks from the database and update the listdata in DataObject
        GlobalScope.launch {
            DataObject.listdata = database.dao().getTasks() as MutableList<CardInfo>
        }

        // Delayed handler to navigate to MainActivity after 2000 milliseconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}
