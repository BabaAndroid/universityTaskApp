package com.university.app.data.repository

import androidx.lifecycle.LiveData
import com.university.app.data.db.UniversityDAO
import com.university.app.data.model.UniversityItem
import com.university.app.server.ApiService

class UniversityDataRepo(
    private val apiService: ApiService,
    private val universityDAO: UniversityDAO
) {

    //when network connectivity is available
    //getting university details retrofit
    suspend fun getUniversityDetailsFromServer(): List<UniversityItem> {
        return apiService.getUniversityListFromServer().body()?.universityList ?: emptyList()
    }

    //when no network is available
    //saving data to local db
    suspend fun insertUniversityInLocalDb(universityItem: UniversityItem){
        universityDAO.saveUniversityToLocalDb(universityItem)
    }

    //delete university data from local db
    suspend fun deleteUniversityDataFromLocalDb(universityItem: UniversityItem){
        universityDAO.deleteUniversityFromLocalDb(universityItem)
    }

    //update university value
    suspend fun updateUniversityToLocalDb(universityItem: UniversityItem){
        universityDAO.updateUniversityInLocalDb(universityItem)
    }

    //get all the university data list
    fun getUniversityListFromLocalDb(): LiveData<List<UniversityItem>> {
        return universityDAO.getUniversityListFromLocalDb()
    }

}
