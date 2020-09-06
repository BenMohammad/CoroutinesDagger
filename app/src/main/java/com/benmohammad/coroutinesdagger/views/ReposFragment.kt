package com.benmohammad.coroutinesdagger.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.benmohammad.coroutinesdagger.CoroutinesDaggerApp
import com.benmohammad.coroutinesdagger.R
import kotlinx.android.synthetic.main.repos_fragment.*
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class ReposFragment : Fragment() {

    companion object {
        fun newInstance() = ReposFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ReposViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as CoroutinesDaggerApp)
            .appComponent
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.repos.observe(viewLifecycleOwner, Observer {
            reposRecyclerView.adapter = ReposAdapter(it)
        })

        viewModel.lookupRepos()
    }
}