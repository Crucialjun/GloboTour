package com.sriyank.globotour.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sriyank.globotour.R


class CityListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_city_list, container, false)

        setupRecyclerView(view)

        return view
    }

    private fun setupRecyclerView(view: View) {
        val context = requireContext()

        val cityAdapter : CityAdapter = CityAdapter(context,VacationSpots.cityList!!)

        val recyclerView : RecyclerView = view.findViewById<RecyclerView>(R.id.city_recycler_view)

        recyclerView.adapter = cityAdapter

        recyclerView.setHasFixedSize(true)

        val layoutManager  = StaggeredGridLayoutManager(3,RecyclerView.VERTICAL)

        layoutManager.orientation = RecyclerView.VERTICAL

        recyclerView.layoutManager = layoutManager


    }
}