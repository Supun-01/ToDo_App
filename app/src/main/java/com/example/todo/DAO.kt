package com.example.todo

import androidx.room.*

// Data Access Object (DAO) interface for interacting with the database
@Dao
interface DAO {

    // Insert a task entity into the database
    @Insert
    suspend fun insertTask(entity: Entity)

    // Update a task entity in the database
    @Update
    suspend fun updateTask(entity: Entity)

    // Delete a task entity from the database
    @Delete
    suspend fun deleteTask(entity: Entity)

    // Delete all tasks from the database
    @Query("Delete from to_do")
    suspend fun deleteAll()

    // Retrieve all tasks from the database and return as a list of CardInfo objects
    @Query("Select * from to_do")
    suspend fun getTasks():List<CardInfo>
}
