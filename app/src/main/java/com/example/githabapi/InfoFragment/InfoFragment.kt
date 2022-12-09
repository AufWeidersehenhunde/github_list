package com.example.githabapi.InfoFragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.api.databinding.FragmentInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class InfoFragment : Fragment() {
    private val viewModelInfo: InfoViewModel by viewModel()
    private val viewBinding: FragmentInfoBinding by viewBinding()

    companion object {
        private const val DATA = "UUID"
        fun getInstance(data: Int) = InfoFragment().apply {
            arguments = Bundle().apply {
                putInt(DATA, data)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uuidForInfo = arguments?.getInt(DATA)
        if (uuidForInfo != null) {
            viewModelInfo.getInfoFragment(uuidForInfo.toInt())
        }

    }
}