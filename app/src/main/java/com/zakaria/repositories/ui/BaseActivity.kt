package com.zakaria.repositories.ui


import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.zakaria.repositories.R
import com.zakaria.repositories.RepositoriesApplication
import com.zakaria.repositories.dagger.component.ActivityComponent
import com.zakaria.repositories.dagger.module.ActivityModule
import com.zakaria.repositories.navigator.Navigator
import javax.inject.Inject

/**
 * Created by Zakaria on 10/02/2018.
 */
open abstract class BaseActivity : AppCompatActivity(),FragmentReplacer{
    lateinit var activityComponent:ActivityComponent

    @Inject
    lateinit var navigator:Navigator



    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = (application as RepositoriesApplication).appComponent.plusActivityComponent(ActivityModule(this))
        activityComponent.inject(this)

    }

    override fun replaceFragment(newFragment: Fragment, backStackStrategy: FragmentReplacer.BackStackStrategy, animate: Boolean) {
        replaceFragment(newFragment,backStackStrategy)
    }
    override fun replaceFragment(newFragment: Fragment, backStackStrategy: FragmentReplacer.BackStackStrategy) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment, newFragment)

      //  Timber.d("added fragment %s with backstack %s", newFragment.javaClass.simpleName, backStackStrategy)
        if (backStackStrategy.equals(FragmentReplacer.BackStackStrategy.ADD)) {
            ft.addToBackStack(newFragment.javaClass.simpleName)
        }

        ft.commit()
    }

    override fun getCurrentFragment(): Fragment {
        return supportFragmentManager.findFragmentById(R.id.fragment);
    }

    override fun popBackStack() {
        supportFragmentManager.popBackStack()
    }
}