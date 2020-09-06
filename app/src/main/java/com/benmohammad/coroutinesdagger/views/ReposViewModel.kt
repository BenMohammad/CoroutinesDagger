package com.benmohammad.coroutinesdagger.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benmohammad.coroutinesdagger.domain.GithubRepo
import com.benmohammad.coroutinesdagger.repository.GithubApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ReposViewModel @Inject constructor(private val githubApi: GithubApi): ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _repos = MutableLiveData<List<GithubRepo>>()

    val repos: LiveData<List<GithubRepo>>
    get() = _repos

    fun lookupRepos() {
        val disposable = githubApi.getRepos("BenMohammad")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("repos: $it")
                _repos.value = it
            },
                {
                    Timber.e(it)
                }
                )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}