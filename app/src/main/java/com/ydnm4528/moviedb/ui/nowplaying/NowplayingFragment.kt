package com.ydnm4528.moviedb.ui.nowplaying

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ydnm4528.moviedb.R
import com.ydnm4528.moviedb.adapter.MovieAdapter
import com.ydnm4528.moviedb.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_nowplaying.*

class NowplayingFragment : Fragment(), MovieAdapter.OnClickListener {
    private lateinit var nowplayingViewModel: NowplayingViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        nowplayingViewModel = ViewModelProvider(this).get(NowplayingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_nowplaying, container, false)
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nowplayingViewModel= ViewModelProvider(this).get(nowplayingViewModel::class.java)

        var nowplayingAdapter = MovieAdapter()

        nowplayingRecycler.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = nowplayingAdapter
        }
        nowplayingAdapter.setOnClickListener(this)
        nowplayingViewModel.getArticle().observe(
            viewLifecycleOwner, Observer { movies ->
                nowplayingAdapter.updateArticle(movies.results as List<ResultsItem>)
            }
        )
        btnClick.setOnClickListener{
            findNavController().navigate(R.id.action_nav_nowplaying_to_searchFragment)
        }
    }
    override fun onClick(item: ResultsItem) {
        val directions = NowplayingFragmentDirections.actionNavNowplayingToNavDetailNowplaying(item)
        view?.findNavController()?.navigate(directions)
    }

    override fun onResume() {
        super.onResume()
        nowplayingViewModel.loadData()
    }


}