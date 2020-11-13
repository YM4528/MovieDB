package com.ydnm4528.moviedb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ydnm4528.moviedb.R
import com.ydnm4528.moviedb.model.ResultsItem
import kotlinx.android.synthetic.main.item_nowplaying.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.NowplayingViewHolder> () {

    private var articlesItems:List<ResultsItem> = ArrayList()
    var clickListener: OnClickListener?=null

    inner class NowplayingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
            ,View.OnClickListener {

        init {
            itemView.setOnClickListener(this);
        }

        lateinit var item: ResultsItem
        fun bind(articlesItem: ResultsItem){
            this.item=articlesItem
            itemView.nowplayingTitle.text=articlesItem.originalTitle
            itemView.nowplayingDate.text=articlesItem.originalTitle
            Picasso.get()
                    .load("http://image.tmdb.org/t/p/w500"+articlesItem.posterPath)
                    .into(itemView.nowplayingImage)

        }
        override fun onClick(view: View?) {
            clickListener?.onClick(item)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowplayingViewHolder {
        var view=LayoutInflater.from(parent.context)
                .inflate(R.layout.item_nowplaying,parent,false)
        return NowplayingViewHolder(view)
    }
    override fun getItemCount(): Int = articlesItems.size

    override fun onBindViewHolder(holder: NowplayingViewHolder, position: Int) {
        holder.bind(articlesItems[position])
    }
    fun updateArticle(playingList: List<ResultsItem>){
        this.articlesItems=playingList
        notifyDataSetChanged()
    }
    interface OnClickListener{
        fun onClick(item:ResultsItem)
    }
    fun setOnClickListener(clickListener: OnClickListener){
        this.clickListener=clickListener
    }
}
