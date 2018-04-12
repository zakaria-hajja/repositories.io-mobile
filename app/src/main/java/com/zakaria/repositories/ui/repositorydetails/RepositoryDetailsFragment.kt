package com.zakaria.repositories.ui.repositorydetails

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakaria.repositories.R
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.databinding.FragmentRepositoryDetailsBinding
import com.zakaria.repositories.ui.repositories.RepositoryActivity
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
        presenter.repository=repository
        binding.presenter=presenter

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_repository_details,container,false)
    }
}