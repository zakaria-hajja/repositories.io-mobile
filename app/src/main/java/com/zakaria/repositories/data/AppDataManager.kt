package com.zakaria.repositories.data

import com.zakaria.repositories.data.api.ApiManager
import com.zakaria.repositories.data.db.DBManager
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.prefs.PrefsManager
import io.reactivex.Observable

class AppDataManager(var dbManager:DBManager, var prefsManager: PrefsManager, var apiManager:ApiManager) :DataManager{


    override fun getRepositories(page:Int): Observable<List<Repository>> = apiManager.getRepositories(page)


}