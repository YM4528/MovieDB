package com.ydnm4528.moviedb.api

import com.ydnm4528.moviedb.model.NowPlayingModel
import com.ydnm4528.moviedb.model.ResultsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

   // private val BASE_URL= "https://api.themoviedb.org/3/
   // movie/"

    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    private val apiInterface:MovieApiInterface

    init {
        val retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiInterface=retrofit.create(MovieApiInterface::class.java)
    }

    fun getNowPlaying(): Call<NowPlayingModel> {
        return apiInterface.getNowPlaying("ad687434515bde81fca65c5a02adcb39")

    }

    fun getUpcoming():Call<NowPlayingModel>{
        return apiInterface.getUpcoming("ad687434515bde81fca65c5a02adcb39")
    }

    fun getPopular():Call<NowPlayingModel>{
        return apiInterface.getPopular("ad687434515bde81fca65c5a02adcb39")
    }

    fun getTopRated():Call<NowPlayingModel>{
        return apiInterface.getTopRated("ad687434515bde81fca65c5a02adcb39")
    }

//    fun getDetailMovie(id : Int) : Call<ResultsItem>{
//        return apiInterface.getDetailMovie(id,"ad687434515bde81fca65c5a02adcb39")
//    }

}