package com.zakaria.repositories.data.api

import com.zakaria.repositories.data.model.Repository
import io.reactivex.Observable

/**
 * Created by Zakaria on 11/02/2018.
 */
interface ApiManager {


    fun search():Observable<List<Repository>>
    fun getRepositories(page:Int):Observable<List<Repository>>
}