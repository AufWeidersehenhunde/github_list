package com.example.githabapi.InfoFragment


import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.ACTION_VIEW
import android.net.Uri
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
        private const val Model = "MODEL"
        fun getInstance(model: RepositoryRemoteItemEntity) = InfoFragment().apply {
            arguments = Bundle().apply {
                putSerializable(Model, model)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = arguments?.getSerializable(Model) as RepositoryRemoteItemEntity
        if (model != null) {
            with(viewBinding) {
                descriptionTxt.text = model.description
                fullnameTxt.text = "FullName: ${ model.fullName }"
                nameTxt.text = "Name: ${ model.name }"
                loginTxt.text = "Login: ${ model.owner.login }"
                Glide.with(imageViewSecond.context)
                    .load(model.owner.avatar_url)
                    .into(imageViewSecond)
            }
        }
        viewBinding.btnHtml.setOnClickListener {
                val intent = Intent(ACTION_VIEW)
                intent.data = Uri.parse(model.htmlUrl)
                startActivity(intent)
        }

        viewBinding.back.setOnClickListener {
            viewModelInfo.back()
        }

        viewBinding.share.setOnClickListener {
            val intent = Intent(ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT,"чекни норм статью: ${model.htmlUrl}")
            intent.setType ("text/plain")
            startActivity(Intent.createChooser(intent, "share"))
        }

    }
}

