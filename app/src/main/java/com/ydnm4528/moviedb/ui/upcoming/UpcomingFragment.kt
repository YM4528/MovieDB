package com.ydnm4528.moviedb.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ydnm4528.moviedb.R
import com.ydnm4528.moviedb.adapter.MovieAdapter
import com.ydnm4528.moviedb.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_upcoming.*

class UpcomingFragment : Fragment(), MovieAdapter.OnClickListener {

    private lateinit var upcomingViewModel: UpcomingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        upcomingViewModel = ViewModelProvider(this).get(UpcomingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_upcoming, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        upcomingViewModel=ViewModelProvider(this).get(UpcomingViewModel::class.java)

        var upcomingAdapter = MovieAdapter()

        upcomingRecycler.apply {
            layoutManager= GridLayoutManager(context,2)
            adapter=upcomingAdapter
        }
        upcomingAdapter.setOnClickListener(this)

        upcomingViewModel.getUpcomingArticles().observe(
            viewLifecycleOwner, Observer { movies->
                upcomingAdapter.updateArticle(movies.results as List<ResultsItem>)

            }
        )
    }

    override fun onClick(item: ResultsItem) {
        val directions=UpcomingFragmentDirections.actionNavUpcomingToNavDetailUpcoming(item)
        view?.findNavController()?.navigate(directions)
    }


    override fun onResume() {
        super.onResume()
        upcomingViewModel.loadUpcomingData()
    }


}