package com.example.githabapi.InfoFragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.api.R
import com.example.api.databinding.FragmentInfoBinding
import com.example.githabapi.RepositoryRemoteItemEntity
import org.koin.androidx.viewmodel.ext.android.viewModel


class InfoFragment : Fragment(R.layout.fragment_info) {
    private val viewModelInfo: InfoViewModel by viewModel()
    private val viewBinding: FragmentInfoBinding by viewBinding()

    companion object {
        private const val DATA = "UUID"
        private const val NAME = "NAME"
        private const val FULLNAME = "FULLNAME"
        private const val IMAGE = "IMAGE"
        private const val DESCRIPTION = "DESCRIPTION"
        private const val LOGIN  = "LOGIN"
        fun getInstance(model: RepositoryRemoteItemEntity) = InfoFragment().apply {
            arguments = Bundle().apply {
                model.id?.let { putInt(DATA, it) }
                putString(NAME, model.name)
                putString(FULLNAME, model.fullName)
                putString(IMAGE, model.owner.avatar_url)
                putString(DESCRIPTION, model.description)
                putString(LOGIN, model.owner.login)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val uuidForInfo = arguments?.getInt(DATA)
        if (uuidForInfo != null) {
            with(viewBinding) {
                descriptionTxt.text = arguments?.getString(DESCRIPTION)
                fullnameTxt.text = arguments?.getString(FULLNAME)
                nameTxt.text = arguments?.getString(NAME)
                loginTxt.text = arguments?.getString(LOGIN)
                Glide.with(imageViewSecond.context)
                    .load(arguments?.getString(IMAGE))
                    .into(imageViewSecond)
            }
        }
        viewBinding.back.setOnClickListener {
            viewModelInfo.back()
        }

    }
}