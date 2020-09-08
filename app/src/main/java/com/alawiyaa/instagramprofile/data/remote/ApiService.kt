package com.alawiyaa.instagramprofile.data.remote


import com.alawiyaa.instagramprofile.data.remote.response.Responsew
import com.alawiyaa.instagramprofile.data.remote.response.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/{username}/")
    fun getUsername(
        @Path("username") username:String,
        @Query("__a") param:Int
    ):Call<Responsew>
}