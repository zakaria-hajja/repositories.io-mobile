package com.zakaria.repositories.data.api.retrofit

import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.model.RepositoryDTO
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Zakaria on 11/02/2018.
 */

interface RetrofitService {
    companion object {
        val END_POINT:String = "https://api.github.com"
    }

    @GET("/search/repositories?sort=stars&order=desc&q=created")
    fun getRepositories(@Query("page")page:Int):Single<Response>

    @GET("repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner: String, @Path("repo") repo: String): Single<RepositoryDTO>
}

