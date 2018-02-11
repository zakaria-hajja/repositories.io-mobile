package com.zakaria.repositories.dagger.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.zakaria.repositories.navigator.Navigator
import dagger.Module
import dagger.Provides

/**
 * Created by Zakaria on 05/02/2018.
 */
@Module
class ActivityModule(val activity :AppCompatActivity) {

    @Provides
    fun provideNavigator():Navigator{
        return Navigator(activity)
    }

}