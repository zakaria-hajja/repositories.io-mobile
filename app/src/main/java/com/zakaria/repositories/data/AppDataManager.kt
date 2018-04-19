package com.zakaria.repositories.data

import com.zakaria.repositories.data.api.ApiManager
import com.zakaria.repositories.data.db.DBManager
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.model.RepositoryDTO
import com.zakaria.repositories.data.prefs.PrefsManager
import io.reactivex.Observable
import io.reactivex.Single

class AppDataManager(var dbManager:DBManager, var prefsManager: PrefsManager, var apiManager:ApiManager) :DataManager{
    override fun getRepository(owner: String, repo: String): Single<RepositoryDTO> {
        return apiManager.getRepositoriy(owner,repo)
    }


    override fun getRepositories(page:Int): Single<List<Repository>> = apiManager.getRepositories(page)


}