package com.example.robiebaze

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val listOfPeople: List<Person>): RecyclerView.Adapter<Adapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.person_row,parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imieTextView.text = listOfPeople[position].imie



    }

    override fun getItemCount(): Int {
        return listOfPeople.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imieTextView: TextView = view.findViewById(R.id.imie)


    }
}