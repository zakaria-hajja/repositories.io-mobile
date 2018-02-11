package com.zakaria.repositories.navigator

import android.support.v7.app.AppCompatActivity
import com.zakaria.repositories.ui.BaseActivity
import com.zakaria.repositories.ui.activity.RepositoryDetailsActivity
import com.zakaria.repositories.ui.fragment.RepositoryDetailsFragment

/**
 * Created by Zakaria on 10/02/2018.
 */
class Navigator(val activity: AppCompatActivity) {



    fun goToRepositoriesDetails(){
        this.activity.startActivity(RepositoryDetailsActivity.getIntent(this.activity))
    }
}