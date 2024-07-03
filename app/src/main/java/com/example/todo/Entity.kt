package com.example.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity class representing a task in the To_Do table of the database
@Entity(tableName = "To_Do")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id:Int, // Primary key for the task
    var title:String, // Title of the task
    var priority:String // Priority level of the task
)
