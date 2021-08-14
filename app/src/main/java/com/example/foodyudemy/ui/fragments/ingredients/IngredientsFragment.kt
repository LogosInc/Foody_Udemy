package com.example.foodyudemy.ui.fragments.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodyudemy.util.Constants.Companion.RECIPE_RESULT_KEY
import com.example.foodyudemy.adapters.IngredientsAdapter
import com.example.foodyudemy.databinding.FragmentIngredientsBinding
import com.example.foodyudemy.models.Result

class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private val binding get() = _binding!!

    private val mAdapter: IngredientsAdapter by lazy { IngredientsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        setupRecyclerView()
        myBundle?.extendedIngredients?.let { mAdapter.setData(it) }

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.ingredientRecyclerview.adapter = mAdapter
        binding.ingredientRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}