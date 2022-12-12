package com.example.githabapi.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.api.R
import com.example.api.databinding.FragmentHomeBinding
import com.example.githabapi.MyAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment(R.layout.fragment_home) {
    private var adapterHome: MyAdapter? = null
    private val viewBinding: FragmentHomeBinding by viewBinding()
    private val viewModelHome: HomeViewModel by viewModel()

    private fun initObservers(){
        observeElement()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
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
    }


    private fun observeElement() {
        viewModelHome.listRepositories.onEach {
            adapterHome?.set(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}

