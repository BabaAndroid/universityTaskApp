package com.university.app.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.university.app.data.model.UniversityItem

@Dao
interface UniversityDAO {

    @Insert
    suspend fun saveUniversityToLocalDb(universityItem: UniversityItem)

    @Delete
    suspend fun deleteUniversityFromLocalDb(universityItem: UniversityItem)

    @Update
    suspend fun updateUniversityInLocalDb(universityItem: UniversityItem)

    @Query("SELECT * FROM UniversityData")
    fun getUniversityListFromLocalDb(): LiveData<List<UniversityItem>>

}
