package com.zakaria.repositories.ui.repositories

import com.zakaria.repositories.data.DataManager
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.ui.MvpPresenter
import io.reactivex.Observable
import javax.inject.Inject

class RepositoriesPresenter : MvpPresenter{
    lateinit var viewModel :RepositoryViewModel
    lateinit var dataManager: DataManager
    @Inject
    constructor(dataManager: DataManager){
        this.dataManager=dataManager
    }

    fun getRepositories(page:Int):Observable<List<Repository>> {
            viewModel.dataManager = this.dataManager
        return viewModel.getRepositories(page)

    }



}