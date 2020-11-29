package com.example.robiebaze

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*

class PeopleRepositor (application: Application){

    private var peopleDao: PeopleDao
    init {
        val database = PeopleDatabase
            .getInstance(application.applicationContext)

        peopleDao = database!!.peopleDao()
    }

    fun insertPerson (person: Person): Job =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.insert(person)
        }

    fun updatePerson(person: Person):Job =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.update(person)
        }

    fun deletePerson(person: Person):Job =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.delete(person)
        }

    fun getAllPeopleAsync(): Deferred<LiveData<List<Person>>> =
        CoroutineScope(Dispatchers.IO).async {
            peopleDao.getALLPeople()
        }


    fun deleteAllRows():Job =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.deleteALLRows()
        }

}