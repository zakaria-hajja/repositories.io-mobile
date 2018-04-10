package com.zakaria.repositories.data

import com.zakaria.repositories.data.model.Repository
import io.reactivex.Observable

interface DataManager {
    fun getRepositories(page:Int): Observable<List<Repository>>
}