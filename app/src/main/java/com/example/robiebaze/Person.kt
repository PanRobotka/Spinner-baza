package com.example.robiebaze

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "people_table")
data class Person  (var imie: String){

    @PrimaryKey(autoGenerate = true)
    var user_id: Int = 0
}