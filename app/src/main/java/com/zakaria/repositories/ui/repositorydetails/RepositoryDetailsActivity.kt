package com.zakaria.repositories.ui.repositorydetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.zakaria.repositories.R
import com.zakaria.repositories.ui.BaseActivity
import com.zakaria.repositories.ui.FragmentReplacer

class RepositoryDetailsActivity : BaseActivity() {

    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, RepositoryDetailsActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_details)
        replaceFragment(RepositoryDetailsFragment.newInstance(),FragmentReplacer.BackStackStrategy.DO_NOT_ADD)
    }
}
