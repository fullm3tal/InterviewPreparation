package com.fullm3tal.interviewpreparation

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fullm3tal.interviewpreparation.model.LaunchInfo
import com.fullm3tal.interviewpreparation.model.LaunchListResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val spaceXService = RetrofitInstance().service
    init {
        suspendRetrofitOnly()
    }

    private val launchListResponseMutableLiveData = MutableLiveData<LaunchListResponse>()
    val launchListResponseLiveData: LiveData<LaunchListResponse>
        get() = launchListResponseMutableLiveData

    private fun fetchResponseEnqueue() {
        spaceXService.fetchLaunchList().enqueue(object : Callback<ArrayList<LaunchInfo>> {
            override fun onResponse(
                call: Call<ArrayList<LaunchInfo>>, response: Response<ArrayList<LaunchInfo>>
            ) {
                Log.v(TAG, "OnSuccess: " + Thread.currentThread().name)
                if (response.isSuccessful && response.body() != null) {
                    if (response.body()?.isNotEmpty() == true) {
                        val launchListResponse = LaunchListResponse()
                        launchListResponse.loading = false
                        response.body()?.let {
                            launchListResponse.list = it
                        }
                        launchListResponseMutableLiveData.postValue(launchListResponse)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<LaunchInfo>>, t: Throwable) {
                Log.v(TAG, "OnFailure: " + Thread.currentThread().name + t)
                val launchListResponse = LaunchListResponse()
                launchListResponse.loading = false
                launchListResponse.error = "Something went wrong"
                launchListResponseMutableLiveData.postValue(launchListResponse)
            }
        })
    }

    private fun suspendResponse() {
        viewModelScope.launch {
            Log.v(TAG, "ViewModel Scope: " + Thread.currentThread().name)
            spaceXService.fetchLaunch().runCatching {
                Log.v(TAG, "OnSuccess: " + Thread.currentThread().name)
                if (isNotEmpty()) {
                    val launchListResponse = LaunchListResponse()
                    launchListResponse.loading = false
                    launchListResponse.list = this
                    launchListResponseMutableLiveData.value = launchListResponse
                }
            }.onFailure {
                Log.v(TAG, "OnFailure: " + Thread.currentThread().name + it)
                val launchListResponse = LaunchListResponse()
                launchListResponse.loading = false
                launchListResponse.error = "Something went wrong"
                launchListResponseMutableLiveData.value = launchListResponse
            }
        }
    }

    private fun suspendResponseDispatcherIO() {
        viewModelScope.launch {
            Log.v(TAG, "ViewModel Scope: " + Thread.currentThread().name)
            withContext(Dispatchers.IO) {
                Log.v(TAG, "Dispatchers.IO: " + Thread.currentThread().name)
                spaceXService.fetchLaunch().runCatching {
                    Log.v(TAG, "OnSuccess: " + Thread.currentThread().name)
                    if (isNotEmpty()) {
                        val launchListResponse = LaunchListResponse()
                        launchListResponse.loading = false
                        launchListResponse.list = this
                        launchListResponseMutableLiveData.postValue(launchListResponse)
                    }
                }.onFailure {
                    Log.v(TAG, "OnFailure: " + Thread.currentThread().name + it)
                    val launchListResponse = LaunchListResponse()
                    launchListResponse.loading = false
                    launchListResponse.error = "Something went wrong"
                    launchListResponseMutableLiveData.postValue(launchListResponse)
                }
            }
        }
    }

    private fun suspendResponseViewModelScope() {
        viewModelScope.launch {
            Log.v(TAG, "ViewModel Scope: " + Thread.currentThread().name)
            spaceXService.fetchLaunch().runCatching {
                Log.v(TAG, "OnSuccess: " + Thread.currentThread().name)
                if (isNotEmpty()) {
                    val launchListResponse = LaunchListResponse()
                    launchListResponse.loading = false
                    launchListResponse.list = this
                    launchListResponseMutableLiveData.value = launchListResponse
                }
            }.onFailure {
                Log.v(TAG, "OnFailure: " + Thread.currentThread().name + it)
                val launchListResponse = LaunchListResponse()
                launchListResponse.loading = false
                launchListResponse.error = "Something went wrong"
                launchListResponseMutableLiveData.value = launchListResponse
            }
        }
    }

    private fun suspendRetrofitOnly() {
        viewModelScope.launch {
            Log.v(TAG, "ViewModel Scope: " + Thread.currentThread().name)
            spaceXService.fetchLaunch().runCatching {
                Log.v(TAG, "runCatching: " + Thread.currentThread().name)
                if (isNotEmpty()) {
                    val launchListResponse = LaunchListResponse()
                    launchListResponse.loading = false
                    launchListResponse.list = this
                    launchListResponseMutableLiveData.value = launchListResponse
                }
            }.onFailure {
                Log.v(TAG, "OnFailure: " + Thread.currentThread().name + it)
                val launchListResponse = LaunchListResponse()
                launchListResponse.loading = false
                launchListResponse.error = "Something went wrong"
                launchListResponseMutableLiveData.value = launchListResponse
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun suspendRxRetrofitOnly() {
        Single.fromCallable {
            var list: ArrayList<LaunchInfo> = ArrayList()
            viewModelScope.launch {
                Log.v(TAG, "viewModelScope: " + Thread.currentThread().name)
                list = spaceXService.fetchLaunch()
            }
            return@fromCallable list
        }.map {
            Log.v(TAG, "map: " + Thread.currentThread().name)
            return@map it
        }.observeOn(AndroidSchedulers.mainThread()).subscribe(Consumer {
            Log.v(TAG, "subscribe Consumer: " + Thread.currentThread().name)
        })
    }

}
