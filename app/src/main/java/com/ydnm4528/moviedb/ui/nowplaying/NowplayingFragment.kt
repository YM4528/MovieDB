package com.ydnm4528.moviedb.ui.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ydnm4528.moviedb.R

class NowplayingFragment : Fragment() {

    private lateinit var nowplayingViewModel: NowplayingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        nowplayingViewModel =
                ViewModelProvider(this).get(NowplayingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_popular, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        nowplayingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}