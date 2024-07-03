package com.example.todo

// Singleton object to manage data for the application
object DataObject {
    // Mutable list to store card information
    var listdata = mutableListOf<CardInfo>()

    // Add new data to the list
    fun setData(title: String, priority: String) {
        listdata.add(CardInfo(title, priority))
    }

    // Retrieve all data from the list
    fun getAllData(): List<CardInfo> {
        return listdata
    }

    // Clear all data from the list
    fun deleteAll(){
        listdata.clear()
    }

    // Retrieve data at a specific position in the list
    fun getData(pos:Int): CardInfo {
        return listdata[pos]
    }

    // Remove data at a specific position from the list
    fun deleteData(pos:Int){
        listdata.removeAt(pos)
    }

    // Update data at a specific position in the list
    fun updateData(pos:Int,title:String,priority:String)
    {
        listdata[pos].title=title
        listdata[pos].priority=priority
    }
}
