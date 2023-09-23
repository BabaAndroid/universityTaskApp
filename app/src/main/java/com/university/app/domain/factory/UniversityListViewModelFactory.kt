package com.university.app.domain.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.university.app.data.db.UniversityDAO
import com.university.app.domain.viewmodel.UniversityListViewModel
import com.university.app.server.ApiService

class UniversityListViewModelFactory(
    private val apiService: ApiService,
    private val dao: UniversityDAO
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UniversityListViewModel::class.java)){
            return UniversityListViewModel(apiService,dao) as T
        }else{
            throw java.lang.IllegalArgumentException("Not a valid argument")
        }
    }
}
