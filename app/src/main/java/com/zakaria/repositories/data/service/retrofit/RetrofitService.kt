package com.zakaria.repositories.data.service.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Zakaria on 11/02/2018.
 */

interface RetrofitService {
    companion object {
        val END_POINT:String = "https://api.github.com"
    }

    @GET("/search/repositories?sort=stars&order=desc")
    fun getRepositories(@Query("q") created:String,@Query("page")page:Int):Observable<Response>
}

