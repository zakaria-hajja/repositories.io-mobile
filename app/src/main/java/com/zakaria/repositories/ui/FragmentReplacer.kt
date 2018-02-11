package com.zakaria.repositories.ui

import android.support.v4.app.Fragment


/**
 * Created by Zakaria on 10/02/2018.
 */
interface FragmentReplacer {

    enum class BackStackStrategy{
        DO_NOT_ADD,
        ADD
    }

    fun replaceFragment(newFragment: android.support.v4.app.Fragment, backStackStrategy: BackStackStrategy, animate: Boolean)
    fun replaceFragment(newFragment: android.support.v4.app.Fragment, backStackStrategy: BackStackStrategy)
    fun getCurrentFragment():Fragment
    fun popBackStack()
}