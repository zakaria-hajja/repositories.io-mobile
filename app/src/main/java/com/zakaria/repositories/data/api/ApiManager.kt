package com.zakaria.repositories.data.api

import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.model.RepositoryDTO
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Zakaria on 11/02/2018.
 */
interface ApiManager {


    fun search():Observable<List<Repository>>
    fun getRepositories(page:Int):Single<List<Repository>>
    fun getRepositoriy(owner:String,repo:String):Single<RepositoryDTO>

}