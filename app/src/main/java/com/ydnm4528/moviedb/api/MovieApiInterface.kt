package com.ydnm4528.moviedb.api

import com.ydnm4528.moviedb.model.NowPlayingModel
import com.ydnm4528.moviedb.model.ResultsItem
import com.ydnm4528.moviedb.model.SearchModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("now_playing")
    fun getNowPlaying(
            @Query("api_key")api_key:String
    ):Call<NowPlayingModel>

//    fun getDetailMovie(
//            @Path("movie_id") movie_id : Int,
//            @Query("api_key") api_key : String
//    ) : Call<ResultsItem>


    @GET("upcoming")
    fun getUpcoming(
            @Query("api_key")api_key:String
    ):Call<NowPlayingModel>

    @GET("popular")
    fun getPopular(
            @Query("api_key")api_key:String
    ):Call<NowPlayingModel>

    @GET("top_rated")
    fun getTopRated(
            @Query("api_key")api_key:String
    ):Call<NowPlayingModel>

    @GET("movie")
    fun getSearchMovie(
            @Query("api_key")api_key:String,
            @Query("query")query:String
    ):Call<SearchModel>


}