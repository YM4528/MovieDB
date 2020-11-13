package com.ydnm4528.moviedb.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.ydnm4528.moviedb.R
import com.ydnm4528.moviedb.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_detail_nowplaying.*
import kotlinx.android.synthetic.main.fragment_upcoming_detail.*
import kotlinx.android.synthetic.main.fragment_upcoming_detail.movieDetailDate
import kotlinx.android.synthetic.main.fragment_upcoming_detail.movieDetailImage
import kotlinx.android.synthetic.main.fragment_upcoming_detail.movieDetailOverview
import kotlinx.android.synthetic.main.fragment_upcoming_detail.movieDetailTitle
import kotlinx.android.synthetic.main.fragment_upcoming_detail.voteCount


class UpcomingDetailFragment : Fragment() {

    private val args: UpcomingDetailFragmentArgs by navArgs()
    private lateinit var item: ResultsItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item = args.upcomeitem

        movieDetailTitle.text = item.title
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/" + item.posterPath )
            .placeholder(R.drawable.ic_launcher_background)
            .into(movieDetailImage)
        voteCount.text  = item.voteCount.toString()
        movieDetailOverview.text = item.overview
        movieDetailDate.text = item.releaseDate
    }
}