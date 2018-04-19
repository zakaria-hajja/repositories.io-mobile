package com.zakaria.repositories.data

import com.zakaria.repositories.data.model.Owner
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.model.RepositoryDTO
import io.reactivex.Observable
import io.reactivex.Single

interface DataManager {
    fun getRepositories(page:Int): Single<List<Repository>>
    fun getRepository(owner: String,repo:String): Single<RepositoryDTO>

}