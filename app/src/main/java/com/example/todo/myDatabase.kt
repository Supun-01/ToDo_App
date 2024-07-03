package com.example.todo

import androidx.room.Database
import androidx.room.RoomDatabase

// Database class for the application
@Database(entities = [Entity::class], version = 1)
abstract class myDatabase : RoomDatabase() {

    // Abstract method to retrieve the Data Access Object (DAO)
    abstract fun dao(): DAO
}
