package com.zakaria.repositories.ui.repositorydetails;

import android.arch.lifecycle.ViewModel
import com.zakaria.repositories.data.DataManager
import com.zakaria.repositories.data.model.RepositoryDTO
import io.reactivex.Single


public class RepositoryDetailsViewModel :ViewModel(){

    lateinit var dataManager : DataManager

    fun getRepository(owner: String,repo:String): Single<RepositoryDTO> {

        return dataManager.getRepository(owner,repo)
    }

}
