package com.zakaria.repositories.dagger.component

import com.zakaria.repositories.dagger.module.ActivityModule
import com.zakaria.repositories.ui.BaseActivity
import com.zakaria.repositories.ui.repositories.RepositoryActivity
import com.zakaria.repositories.ui.repositorydetails.RepositoryDetailsActivity
import dagger.Subcomponent

/**
 * Created by Zakaria on 05/02/2018.
 */
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun plusFragmentComponent() : FragmentComponent

    fun inject(activity: BaseActivity)

    fun inject(activity: RepositoryActivity)

    fun inject(activity: RepositoryDetailsActivity)

}