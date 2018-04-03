package com.zakaria.repositories.data.service

import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.service.retrofit.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Zakaria on 11/02/2018.
 */
class RepositoryWebService(val retrofitService:RetrofitService) : RepositoryService {


    override fun search(): Observable<List<Repository>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRepositories(): Observable<List<Repository>> {

        return retrofitService.getRepositories("created:>2018-01-01",1).map { e -> e.repositories }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}