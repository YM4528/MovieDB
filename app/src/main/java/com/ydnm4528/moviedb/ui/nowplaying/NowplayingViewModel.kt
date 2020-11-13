package com.ydnm4528.moviedb.ui.nowplaying

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydnm4528.moviedb.api.ApiClient
import com.ydnm4528.moviedb.model.NowPlayingModel
import com.ydnm4528.moviedb.model.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowplayingViewModel : ViewModel() {

   // private var details : MutableLiveData<ResultsItem> = MutableLiveData()
  //  fun getDetail() : LiveData<ResultsItem> = details

    private var movies: MutableLiveData<NowPlayingModel> = MutableLiveData()
    fun getArticle(): MutableLiveData<NowPlayingModel> = movies


    fun loadData() {
        var apiClient = ApiClient()
        var apiCall = apiClient.getNowPlaying()
        apiCall.enqueue(object : Callback<NowPlayingModel> {
            override fun onFailure(call: Call<NowPlayingModel>, t: Throwable) {
                Log.d("Error>>>", t.toString())
            }

            override fun onResponse(
                    call: Call<NowPlayingModel>,
                    response: Response<NowPlayingModel>
            ) {
                movies.value = response.body()
            }

        })

    }

//    fun loadDetail(id : Int){
//        var apiClient = ApiClient()
//        var apiCall = apiClient.getDetailMovie(id)
//
//        apiCall.enqueue(
//            object : Callback<ResultsItem>{
//                override fun onFailure(call: Call<ResultsItem>, t: Throwable) {
//
//                }
//
//                override fun onResponse(call: Call<ResultsItem>, response: Response<ResultsItem>) {
//                    details.value = response.body()
//                }
//
//            }
//        )
//    }


}