package com.zakaria.repositories.navigator

import android.support.v7.app.AppCompatActivity
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.ui.repositorydetails.RepositoryDetailsActivity

/**
 * Created by Zakaria on 10/02/2018.
 */
class Navigator(val activity: AppCompatActivity) {



    fun goToRepositoriesDetails(repository: Repository){
        var intent = RepositoryDetailsActivity.getIntent(this.activity)
        intent.putExtra("repository",repository)
        this.activity.startActivity(intent)
    }
}