package com.example.githabapi.HomeFragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.api.R
import com.example.api.databinding.FragmentHomeBinding
import com.example.githabapi.PaginationScrollListener
import com.example.githabapi.RepositoryRemoteItemEntity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment(R.layout.fragment_home) {
    private var isLoading: Boolean = false
    private var isLastPage: Boolean = false
    private var totalPages: Int = 1
    private var adapterHome: MyAdapter? = null
    private val viewBinding: FragmentHomeBinding by viewBinding()
    private val viewModelHome: HomeViewModel by viewModel()

    private fun initObservers(){
        observeElement()
    }
    private fun stopRefresh() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewBinding.swipe.isRefreshing = false
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewBinding.swipe.isRefreshing = true
        initObservers()
    }

    private fun initView() {
        this.adapterHome =
            MyAdapter({viewModelHome.routeToInfo(it)})

        with(viewBinding.recyclerView) {
            layoutManager = LinearLayoutManager(
                context
            )
            adapter = adapterHome
        }
        viewBinding.swipe.setOnRefreshListener {
                observeElement()
                stopRefresh()
        }
        viewBinding.recyclerView.addOnScrollListener(object : PaginationScrollListener(viewBinding.recyclerView.layoutManager as LinearLayoutManager) {
            override fun loadMoreItems() {
                isLoading = true

                Handler(Looper.myLooper()!!).postDelayed({
                    addElements()
                    viewBinding.swipe.isRefreshing = true
                }, 500)
            }

            override fun getTotalPageCount(): Int {
                return totalPages
            }

            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }
        })
    }


    private fun loadNextPage(){
        viewLifecycleOwner.lifecycleScope.launch {
            val lastId = viewModelHome.listRepositories.value.last()?.id
            lastId?.let { viewModelHome.observeRepositories(it) }
        }
        isLoading = false
        viewBinding.swipe.isRefreshing = false
    }

    private fun addElements(){
        loadNextPage()
        viewModelHome.listRepositories.onEach {
            adapterHome?.add(it as ArrayList<RepositoryRemoteItemEntity?>)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeElement() {
        viewModelHome.listRepositories.onEach {
            adapterHome?.set(it as ArrayList<RepositoryRemoteItemEntity?>)
            viewBinding.swipe.isRefreshing = false
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}

