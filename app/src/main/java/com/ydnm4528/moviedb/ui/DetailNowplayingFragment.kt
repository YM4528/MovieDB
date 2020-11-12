package com.ydnm4528.moviedb.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.ydnm4528.moviedb.R
import com.ydnm4528.moviedb.model.ResultsItem
import com.ydnm4528.moviedb.ui.nowplaying.NowplayingViewModel
import kotlinx.android.synthetic.main.fragment_detail_nowplaying.*

class DetailNowplayingFragment : Fragment() {

    private val args: DetailNowplayingFragmentArgs by navArgs()
    private lateinit var item : ResultsItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_nowplaying, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item = args.item

       // var viewmodel : NowplayingViewModel = ViewModelProvider(this).get(NowplayingViewModel::class.java)

      //  viewmodel.loadDetail(id)

     //   viewmodel.getDetail().observe(
         //   viewLifecycleOwner, Observer {
                movieDetailTitle.text = item.title
                Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500/" + item.posterPath )
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(movieDetailImage)
                voteCount.text  = item.voteCount.toString()
                movieDetailOverview.text = item.overview
                movieDetailDate.text = item.releaseDate
            }
       // )
  //  }


}