package com.zakaria.repositories.ui.adapter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakaria.repositories.databinding.RepositoryListItemBinding
import com.zakaria.repositories.data.model.Repository
import com.zakaria.repositories.navigator.Navigator

/**
 * Created by Zakaria on 05/02/2018.
 */
class RepositoryAdapter(val context: Context, val repositories:MutableList<Repository>):RecyclerView.Adapter<RepositoryAdapter.RepoViewHolder>() {

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(repositories.get(position))
        holder.itemView.setOnClickListener(View.OnClickListener {
            val navigator =Navigator(context as AppCompatActivity)
            navigator.goToRepositoriesDetails()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoViewHolder {
        return RepoViewHolder(RepositoryListItemBinding.inflate(LayoutInflater.from(context),parent,false));
    }

    override fun getItemCount(): Int {
       return repositories.size
    }

    class RepoViewHolder(val binding:RepositoryListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(repository:Repository){
            binding.repository = repository
        }
    }


}