package com.ydnm4528.moviedb.ui.toprated

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
import kotlinx.android.synthetic.main.fragment_toprated.*

class TopratedFragment : Fragment(), MovieAdapter.OnClickListener  {

   // private lateinit var topratedViewModel: TopratedViewModel

    private lateinit var topratedViewModel: TopratedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        topratedViewModel = ViewModelProvider(this).get(TopratedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_toprated, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topratedViewModel=ViewModelProvider(this).get(TopratedViewModel::class.java)

        var topRatedAdapter = MovieAdapter()

        topRatedRecycler.apply {
            layoutManager= GridLayoutManager(context,2)
            adapter=topRatedAdapter
        }
        topRatedAdapter.setOnClickListener(this)

        topratedViewModel.getTopRatedArticle().observe(
            viewLifecycleOwner, Observer { movies ->
                topRatedAdapter.updateArticle(movies.results as List<ResultsItem>)

            }
        )

    }

    override fun onResume() {
        super.onResume()
        topratedViewModel.loadTopRatedData()
    }

    override fun onClick(item: ResultsItem) {
        val directions= TopratedFragmentDirections.actionNavTopratedToNavDetailToprated(item)
        view?.findNavController()?.navigate(directions)
    }

}