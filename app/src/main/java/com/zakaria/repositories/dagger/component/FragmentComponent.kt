package com.zakaria.repositories.dagger.component

import com.zakaria.repositories.dagger.module.FragmentModule
import com.zakaria.repositories.ui.fragment.RepositoryDetailsFragment
import com.zakaria.repositories.ui.fragment.RepositoryFragment
import dagger.Subcomponent

/**
 * Created by Zakaria on 05/02/2018.
 */
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(fragment : RepositoryFragment)
    fun inject(fragment : RepositoryDetailsFragment)

}