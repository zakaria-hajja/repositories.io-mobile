package com.zakaria.repositories.ui.repositories

import android.arch.lifecycle.*
import com.zakaria.repositories.data.DataManager
import com.zakaria.repositories.data.model.Repository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Zakaria on 05/02/2018.
 */

class RepositoryViewModel : ViewModel() {
    lateinit var dataManager :DataManager

    fun getRepositories(page:Int):Observable<List<Repository>>{

        return dataManager.getRepositories()
    }


}