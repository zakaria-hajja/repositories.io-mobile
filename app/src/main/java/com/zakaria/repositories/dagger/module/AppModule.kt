package com.zakaria.repositories.dagger.modules

import com.zakaria.repositories.RepositoriesApplication
import com.zakaria.repositories.navigator.Navigator
import dagger.Module
import dagger.Provides

/**
 * Created by Zakaria on 05/02/2018.
 */
@Module
class AppModule(val application: RepositoriesApplication) {


    @Provides
    fun provideApplicationContext() = application



}