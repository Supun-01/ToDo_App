package com.example.todo

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

// Adapter class for the RecyclerView
class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {

    // ViewHolder class to hold the views for each item in the RecyclerView
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title // Title TextView
        var priority = itemView.priority // Priority TextView
        var layout = itemView.mylayout // Layout of the item view
    }

    // Called when RecyclerView needs a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        // Inflate the item layout and create a new ViewHolder
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return viewHolder(itemView)
    }

    // Called by RecyclerView to display the data at the specified position
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        // Set background color based on priority level
        when (data[position].priority.toLowerCase()) {
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#00917C"))
        }

        // Set title and priority text
        holder.title.text = data[position].title
        holder.priority.text = data[position].priority

        // Set click listener to open UpdateCard activity with extra "id"
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,UpdateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }

    }

    // Return the size of the dataset
    override fun getItemCount(): Int {
        return data.size
    }
}
