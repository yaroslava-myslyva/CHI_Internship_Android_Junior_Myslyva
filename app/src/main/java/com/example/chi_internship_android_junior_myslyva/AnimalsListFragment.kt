package com.example.chi_internship_android_junior_myslyva

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chi_internship_android_junior_myslyva.databinding.AnimalsListFragmentBinding
import androidx.recyclerview.widget.DividerItemDecoration

class AnimalsListFragment : Fragment() {
    private lateinit var binding: AnimalsListFragmentBinding
    private lateinit var viewModel: AnimalsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AnimalsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalsListViewModel::class.java)
        viewModel.networkResponse.observe(viewLifecycleOwner, {
            setupRecyclerView(it)
        })
    }

    private fun setupRecyclerView(animalsList: List<Animal>) {
        binding.rvUsersList.run {
            adapter = AnimalAdapter(animalsList)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager(context).orientation
                )
            )
        }
    }
}
