package com.ydnm4528.moviedb.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ydnm4528.moviedb.R

class UpcomingFragment : Fragment() {

    private lateinit var upcomingViewModel: UpcomingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        upcomingViewModel =
                ViewModelProvider(this).get(UpcomingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_toprated, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        upcomingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}