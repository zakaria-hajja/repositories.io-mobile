package com.zakaria.repositories.ui.repositories

import android.arch.lifecycle.ViewModel
import com.zakaria.repositories.data.model.Repository
import io.reactivex.Observable

/**
 * Created by Zakaria on 05/02/2018.
 */
class RepositoryViewModel : ViewModel() {

    fun getRepositories(page:Int)=Observable.fromCallable {listOf<Repository>(Repository(name = "hhh",description = "hhhh"))}

}