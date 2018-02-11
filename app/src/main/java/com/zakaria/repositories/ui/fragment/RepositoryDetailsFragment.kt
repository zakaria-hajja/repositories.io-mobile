package com.zakaria.repositories.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakaria.repositories.R

/**
 * Created by Zakaria on 10/02/2018.
 */
class RepositoryDetailsFragment : Fragment() {



    companion object {
        fun newInstance():RepositoryDetailsFragment=RepositoryDetailsFragment()

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_repository_details,container,false)
    }
}