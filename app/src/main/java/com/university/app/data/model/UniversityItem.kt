package com.university.app.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UniversityData")
data class UniversityItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "UniversityCode")
    val alpha_two_code: String,

    @ColumnInfo(name = "UniversityCountry")
    val country: String,

    @ColumnInfo(name = "UniversityName")
    val name: String,
)
