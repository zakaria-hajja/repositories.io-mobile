package com.zakaria.repositories.dagger.component

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.zakaria.repositories.dagger.module.ActivityModule
import com.zakaria.repositories.dagger.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Zakaria on 05/02/2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun plusActivityComponent(activityModule:ActivityModule) : ActivityComponent
    fun inject(application: Application)

    class Initializer(){
        companion object {
            fun init(module: AppModule):AppComponent{
                return DaggerAppComponent.builder()
                        .appModule(module)
                        .build();
            }
        }
    }

}