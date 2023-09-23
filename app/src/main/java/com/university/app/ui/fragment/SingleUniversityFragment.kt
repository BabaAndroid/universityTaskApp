package com.university.app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.university.app.R
import com.university.app.data.db.AppDatabase
import com.university.app.data.db.UniversityDAO
import com.university.app.databinding.SingleUniversityDetailsBinding

class SingleUniversityFragment: Fragment() {

    private lateinit var binding : SingleUniversityDetailsBinding
    private lateinit var universityDAO: UniversityDAO

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.single_university_details, container, false)

        //init local variables
        universityDAO = AppDatabase.getAppDatabase(requireContext()).getUniversityDao()

        return binding.root
    }

}
