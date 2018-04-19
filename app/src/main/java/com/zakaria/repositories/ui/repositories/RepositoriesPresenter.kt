package com.zakaria.repositories.ui.repositories

import com.zakaria.repositories.data.DataManager
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.ui.MvpPresenter
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RepositoriesPresenter : MvpPresenter{
    lateinit var viewModel :RepositoryViewModel
    var dataManager: DataManager
    @Inject
    constructor(dataManager: DataManager){
        this.dataManager=dataManager
    }

    fun getRepositories(page:Int):Single<List<Repository>> {
            viewModel.dataManager = this.dataManager
        return viewModel.getRepositories(page)

    }



}