package com.example.robiebaze

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class PeopleViewMod (application: Application):
    AndroidViewModel(application) {

    private var peopleRepositor: PeopleRepositor =
        PeopleRepositor(application)
    private var allPeople: Deferred<LiveData<List<Person>>> =
        peopleRepositor.getAllPeopleAsync()

    fun insertPerson(person: Person){

        peopleRepositor.insertPerson(person)
    }
    fun updatePerson(person: Person) {

        peopleRepositor.updatePerson(person)

    }

    fun deletePerson(person: Person) {

        peopleRepositor.deletePerson(person)
    }

    fun getAllPeople(): LiveData<List<Person>> = runBlocking {
        allPeople.await()
    }

    fun deleteAllRows(){
        peopleRepositor.deleteAllRows()
    }

}
