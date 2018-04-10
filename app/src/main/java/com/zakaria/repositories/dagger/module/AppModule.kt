package com.zakaria.repositories.dagger.modules

import com.zakaria.repositories.RepositoriesApplication
import com.zakaria.repositories.data.AppDataManager
import com.zakaria.repositories.data.DataManager
import com.zakaria.repositories.data.api.ApiManager
import com.zakaria.repositories.data.api.AppApiManager
import com.zakaria.repositories.data.api.retrofit.RetrofitService
import com.zakaria.repositories.data.db.AppDBManager
import com.zakaria.repositories.data.db.DBManager
import com.zakaria.repositories.data.prefs.AppPrefsManager
import com.zakaria.repositories.data.prefs.PrefsManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * Created by Zakaria on 05/02/2018.
 */
@Module
class AppModule(val application: RepositoriesApplication) {


    @Provides
    fun provideApplicationContext() = application

    @Provides
    @Singleton
    fun providesDataManager( dbManager: DBManager,prefsManager: PrefsManager,apiManager: ApiManager):DataManager{
        return AppDataManager(dbManager,prefsManager,apiManager)
    }

    @Provides
    @Singleton
    fun providesDBManager():DBManager{
        return AppDBManager()
    }
    @Provides
    @Singleton
    fun providesPrefsManager():PrefsManager{
        return AppPrefsManager()
    }
    @Provides
    @Singleton
    fun providesApiManager(retrofitService: RetrofitService):ApiManager{
        return AppApiManager(retrofitService)
    }

    @Singleton
    @Provides
    fun providesRetrofitService(retrofit: Retrofit): RetrofitService {
        return retrofit.create<RetrofitService>(RetrofitService::class.java!!)
    }


    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        return Retrofit.Builder()
                .baseUrl(RetrofitService.END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

}