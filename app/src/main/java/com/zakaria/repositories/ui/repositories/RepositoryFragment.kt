package com.zakaria.repositories.ui.repositories

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakaria.repositories.R
import com.zakaria.repositories.databinding.FragmentRepositoryBinding
import com.zakaria.repositories.ui.adapter.EndlessRecyclerViewScrolleListener
import com.zakaria.repositories.ui.adapter.RepositoryAdapter
import javax.inject.Inject

/**
 * Created by Zakaria on 05/02/2018.
 */
class RepositoryFragment: Fragment() {
    @Inject
    lateinit var presenter : RepositoriesPresenter
   // @Inject
   //lateinit var viewModel: RepositoryViewModel
    lateinit var binding : FragmentRepositoryBinding
    lateinit var adapter : RepositoryAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager


    companion object{
        fun newInstance() : RepositoryFragment = RepositoryFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = DataBindingUtil.bind(view)
        (activity as RepositoryActivity).activityComponent.plusFragmentComponent().inject(this)

        presenter.viewModel=ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
        adapter = RepositoryAdapter(activity,ArrayList())
        binding.recycler.adapter = adapter
        linearLayoutManager= LinearLayoutManager(activity)

        var listener = object : EndlessRecyclerViewScrolleListener(layoutManager = linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                loadNext(page+1)
            }
        }
        binding.recycler.addOnScrollListener(listener)
        binding.recycler.layoutManager =linearLayoutManager
        binding.executePendingBindings()
        loadNext()
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater?.inflate(R.layout.fragment_repository,container,false)
    }
    private fun loadNext(page : Int = 0){
        presenter.getRepositories(page).subscribe {
            if(it!=null) {
                adapter.repositories.addAll(it)
                adapter.notifyDataSetChanged()

                if(adapter.repositories.isEmpty())
                    print("")
                    //binding.emptyMessage.visibility = View.VISIBLE
        } }


    }

}