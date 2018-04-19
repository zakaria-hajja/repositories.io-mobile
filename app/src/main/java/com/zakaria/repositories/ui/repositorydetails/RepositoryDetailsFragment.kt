package com.zakaria.repositories.ui.repositorydetails

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakaria.repositories.R
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.data.model.RepositoryDTO
import com.zakaria.repositories.databinding.FragmentRepositoryDetailsBinding
import com.zakaria.repositories.utils.JoinDate
import javax.inject.Inject

/**
 * Created by Zakaria on 10/02/2018.
 */
class RepositoryDetailsFragment : Fragment() {


    @Inject
    lateinit var presenter: RepositoryDetailsPresenter
    lateinit var binding : FragmentRepositoryDetailsBinding


    companion object {
        fun newInstance(): RepositoryDetailsFragment = RepositoryDetailsFragment()

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = DataBindingUtil.bind(view)
        (activity as RepositoryDetailsActivity).activityComponent.plusFragmentComponent().inject(this)
        val repository=activity.intent.getParcelableExtra<Repository>("repository")
        presenter.viewModel=ViewModelProviders.of(this).get(RepositoryDetailsViewModel::class.java)

        presenter.getRepository(repository.owner.name,repository.name).subscribe { t1: RepositoryDTO?, t2: Throwable? ->

            if(t2!=null){
                Log.e("MAKHADAMACH",t2.message)
            }
             else if(t1!=null)
            {
                presenter.toRepository(t1)
            }
        }
        presenter.repository=repository
        binding.presenter=presenter

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_repository_details,container,false)
    }
}