package com.zakaria.repositories.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.zakaria.repositories.R
import com.zakaria.repositories.ui.BaseActivity
import com.zakaria.repositories.ui.FragmentReplacer
import com.zakaria.repositories.ui.fragment.RepositoryFragment

/**
 * Created by Zakaria on 05/02/2018.
 */

 class RepositoryActivity() : BaseActivity(){

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