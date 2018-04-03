package com.zakaria.repositories.ui.repositories

import android.arch.lifecycle.ViewModelProvider
import com.zakaria.repositories.ui.MvpPresenter

class RepositoriesPresenter : MvpPresenter{
    var viewModel :RepositoryViewModel

    init {
        viewModel = RepositoryViewModel()
    }

    fun setViewmodel( viewModel: RepositoryViewModel){
        this.viewModel =viewModel
    }

    fun getViewmodel():RepositoryViewModel{
        return this.viewModel
    }
}