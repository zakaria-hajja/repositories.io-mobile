package com.zakaria.repositories.viewmodel

import com.zakaria.repositories.model.Repository
import io.reactivex.Observable

/**
 * Created by Zakaria on 05/02/2018.
 */
class RepositoryViewModel {

    fun getRepositories(page:Int)=Observable.fromCallable {listOf<Repository>(Repository(name = "hhh",description = "hhhh"))}

}