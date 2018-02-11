package com.zakaria.repositories.service

import com.zakaria.repositories.model.Repository
import io.reactivex.Observable

/**
 * Created by Zakaria on 11/02/2018.
 */
interface RepositoryService {


    fun search():Observable<List<Repository>>
    fun getRepositories():Observable<List<Repository>>
}