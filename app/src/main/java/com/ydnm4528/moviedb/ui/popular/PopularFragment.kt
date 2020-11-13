package com.ydnm4528.moviedb.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ydnm4528.moviedb.R
import com.ydnm4528.moviedb.adapter.MovieAdapter
import com.ydnm4528.moviedb.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_popular.*

class PopularFragment : Fragment(), MovieAdapter.OnClickListener {

    private lateinit var popularViewModel: PopularViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        popularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_popular, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)

        var popularAdapter = MovieAdapter()

        popularRecycler.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = popularAdapter
        }
        popularAdapter.setOnClickListener(this)

        popularViewModel.getPopularArticles().observe(
                viewLifecycleOwner, Observer { movies ->
            popularAdapter.updateArticle(movies.results as List<ResultsItem>)

        }
        )

    }

    override fun onResume() {
        super.onResume()
        popularViewModel.loadPopularData()
    }

    override fun onClick(item: ResultsItem) {

        val directions = PopularFragmentDirections.actionNavPopularToNavDetailPopular(item)
        view?.findNavController()?.navigate(directions)




    }
}