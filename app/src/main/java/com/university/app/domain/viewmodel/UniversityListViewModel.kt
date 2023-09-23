package com.university.app.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.university.app.data.db.UniversityDAO
import com.university.app.data.model.UniversityItem
import com.university.app.data.repository.UniversityDataRepo
import com.university.app.server.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UniversityListViewModel(
    private val apiService: ApiService,
    private val universityDAO: UniversityDAO
): ViewModel() {

    //init data repository in view model
    private val universityDataRepo = UniversityDataRepo(apiService, universityDAO)
    private val universityList = MutableLiveData<List<UniversityItem>>()

    //getting all the data from server
    fun getUniversityFromServer(){
        viewModelScope.launch(Dispatchers.IO){
            universityList.postValue(universityDataRepo.getUniversityDetailsFromServer())
        }
    }



}
