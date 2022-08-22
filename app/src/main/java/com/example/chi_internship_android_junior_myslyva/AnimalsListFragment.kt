package com.example.chi_internship_android_junior_myslyva

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AnimalsListFragment : Fragment() {

    companion object {
        fun newInstance() = AnimalsListFragment()
    }

    private lateinit var viewModel: AnimalsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.animals_list_fragment, container, false)
    }

}