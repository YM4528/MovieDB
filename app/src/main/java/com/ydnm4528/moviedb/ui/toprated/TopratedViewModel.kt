package com.ydnm4528.moviedb.ui.toprated

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydnm4528.moviedb.api.ApiClient
import com.ydnm4528.moviedb.model.NowPlayingModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopratedViewModel : ViewModel() {
    private var movieLists:MutableLiveData<NowPlayingModel> = MutableLiveData()

    fun getTopRatedArticle():MutableLiveData<NowPlayingModel> = movieLists

    fun loadTopRatedData(){
        var apiClient= ApiClient()

        var apiCall=apiClient.getTopRated()

        apiCall.enqueue(object : Callback<NowPlayingModel> {
            override fun onFailure(call: Call<NowPlayingModel>, t: Throwable) {
                Log.d("Error>>>",t.toString())
            }

            override fun onResponse(
                call: Call<NowPlayingModel>,
                response: Response<NowPlayingModel>
            ) {
                movieLists.value=response.body()
            }

        })
    }
}