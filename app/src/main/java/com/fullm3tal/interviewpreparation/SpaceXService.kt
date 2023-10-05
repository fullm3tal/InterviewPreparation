package com.fullm3tal.interviewpreparation

import com.fullm3tal.interviewpreparation.model.LaunchInfo
import retrofit2.Call
import retrofit2.http.GET

interface SpaceXService {
    @GET("/v3/launches")
    fun fetchLaunchList(): Call<ArrayList<LaunchInfo>>

    @GET("/v3/launches")
    suspend fun fetchLaunch(): ArrayList<LaunchInfo>

}