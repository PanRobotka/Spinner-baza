package com.example.robiebaze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PeopleViewMod
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewMod::class.java)

        insertBT.setOnClickListener{

            val imie = spinner.selectedItem.toString()

            val person = Person(imie)

            viewModel.insertPerson(person)
        }
        showListBT.setOnClickListener{
            val intent = Intent(this, activity_show::class.java)
            startActivity(intent)
        }
        clearDataBT.setOnClickListener{
            viewModel.deleteAllRows()
        }
    }
}