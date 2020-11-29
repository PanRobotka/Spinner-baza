package com.example.robiebaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class activity_show : AppCompatActivity() {
    private lateinit var viewModel: PeopleViewMod
    private lateinit var daoAdapter: Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listOfPeople: LiveData<List<Person>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewMod::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        listOfPeople = viewModel.getAllPeople()
        listOfPeople.observe(this, Observer {
            if (it.isNotEmpty()){

                daoAdapter = Adapter(it)
                recyclerView.adapter = daoAdapter
            }
        })
    }
}