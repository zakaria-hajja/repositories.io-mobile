package com.zakaria.repositories.dagger.module

import com.zakaria.repositories.data.DataManager
import com.zakaria.repositories.ui.repositories.RepositoriesPresenter
import com.zakaria.repositories.ui.repositories.RepositoryViewModel
import com.zakaria.repositories.ui.repositorydetails.RepositoryDetailsPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Zakaria on 05/02/2018.
 */

@Module
class FragmentModule{

    @Provides
    fun providesRepositoriesPresenter(dataManager: DataManager): RepositoriesPresenter {
        return RepositoriesPresenter(dataManager)
    }
    @Provides
    fun providesRepositoryDetailsPresenter(): RepositoryDetailsPresenter {
        return RepositoryDetailsPresenter()
    }

}