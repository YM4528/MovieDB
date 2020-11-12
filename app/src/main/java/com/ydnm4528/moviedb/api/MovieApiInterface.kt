package com.ydnm4528.moviedb.api

import com.ydnm4528.moviedb.model.NowPlayingModel
import com.ydnm4528.moviedb.model.ResultsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("now_playing")
    fun getNowPlaying(
            @Query("api_key")api_key:String
    ):Call<NowPlayingModel>

    fun getDetailMovie(
            @Path("movie_id") movie_id : Int,
            @Query("api_key") api_key : String
    ) : Call<ResultsItem>


}