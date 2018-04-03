package com.zakaria.repositories.ui.repositories

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.zakaria.repositories.R
import com.zakaria.repositories.ui.BaseActivity
import com.zakaria.repositories.ui.FragmentReplacer
import javax.inject.Inject

/**
 * Created by Zakaria on 05/02/2018.
 */

 class RepositoryActivity() : BaseActivity(){

    @Inject
    lateinit var presenter : RepositoriesPresenter
    companion object{
        fun getIntent(context: Context):Intent {
            return Intent(context, RepositoryActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_repository);
        activityComponent.inject(this)

        if(savedInstanceState == null){
            replaceFragment(RepositoryFragment.newInstance(),FragmentReplacer.BackStackStrategy.ADD)
        }
    }
}