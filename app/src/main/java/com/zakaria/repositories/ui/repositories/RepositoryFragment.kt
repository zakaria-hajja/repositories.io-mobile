package com.zakaria.repositories.ui.repositories

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakaria.repositories.R
import com.zakaria.repositories.databinding.FragmentRepositoryBinding
import com.zakaria.repositories.ui.adapter.RepositoryAdapter
import javax.inject.Inject

/**
 * Created by Zakaria on 05/02/2018.
 */
class RepositoryFragment: Fragment() {
    @Inject
    lateinit var viewModel: RepositoryViewModel
    lateinit var binding : FragmentRepositoryBinding
    lateinit var adapter : RepositoryAdapter
    lateinit var linearLayoutManager : LinearLayoutManager


    companion object{
        fun newInstance() : RepositoryFragment = RepositoryFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = DataBindingUtil.bind(view)

        (activity as RepositoryActivity).activityComponent.plusFragmentComponent().inject(this)
        intialLoad()
        linearLayoutManager = LinearLayoutManager(activity)
        binding.recycler.layoutManager =linearLayoutManager
        binding.executePendingBindings()
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater?.inflate(R.layout.fragment_repository,container,false)
    }
    fun intialLoad(){
        viewModel.getRepositories(1).subscribe({
            repositories ->
                if(repositories.isEmpty())
                    binding.emptyMessage.visibility=View.VISIBLE
            adapter= RepositoryAdapter(activity,repositories.toMutableList())
            binding.recycler.adapter=adapter

        },{e ->
            binding.emptyMessage.visibility=View.VISIBLE
        })
    }
    fun loadNext(page : Int){
        viewModel.getRepositories(page).subscribe({
            repositories ->
            adapter.repositories.addAll(repositories)
            adapter.notifyDataSetChanged()

        })
    }

}