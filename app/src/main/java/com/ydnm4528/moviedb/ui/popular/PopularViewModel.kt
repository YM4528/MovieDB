package com.ydnm4528.moviedb.ui.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydnm4528.moviedb.api.ApiClient
import com.ydnm4528.moviedb.model.NowPlayingModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel : ViewModel() {
    private var movieLists:MutableLiveData<NowPlayingModel> = MutableLiveData()

    fun getPopularArticles():MutableLiveData<NowPlayingModel> = movieLists

    fun loadPopularData(){
        var apiClient= ApiClient()

        var apiCall=apiClient.getPopular()

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