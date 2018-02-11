package com.zakaria.repositories

import android.app.Application
import com.zakaria.repositories.dagger.component.AppComponent
import com.zakaria.repositories.dagger.modules.AppModule

/**
 * Created by Zakaria on 05/02/2018.
 */
class RepositoriesApplication: Application(){
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
         appComponent = AppComponent.Initializer.init(AppModule(this))

    }
}