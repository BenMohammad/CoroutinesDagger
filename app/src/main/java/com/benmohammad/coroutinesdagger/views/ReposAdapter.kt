package com.benmohammad.coroutinesdagger.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benmohammad.coroutinesdagger.R
import com.benmohammad.coroutinesdagger.domain.GithubRepo

class ReposAdapter(private val repos: List<GithubRepo>): RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val repoName = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false) as TextView
        return ReposViewHolder(repoName)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.repoName.text = repos[position].name

    }

    override fun getItemCount(): Int {
        return repos.size
    }

    class ReposViewHolder(val repoName: TextView) : RecyclerView.ViewHolder(repoName)
}