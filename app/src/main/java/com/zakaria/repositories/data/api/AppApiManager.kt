package com.zakaria.repositories.data.api

import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.api.retrofit.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Zakaria on 11/02/2018.
 */
class AppApiManager(val retrofitService:RetrofitService) : ApiManager {


    override fun search(): Observable<List<Repository>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRepositories(): Observable<List<Repository>> {

        return retrofitService.getRepositories("created:>2018-01-01",1).map { e -> e.repositories }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}