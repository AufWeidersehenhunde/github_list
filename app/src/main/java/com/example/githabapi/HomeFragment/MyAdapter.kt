package com.example.githabapi.HomeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api.databinding.RecyclerviewItemBinding
import com.example.githabapi.RepositoryRemoteItemEntity


class MyAdapter(
    private val info: (RepositoryRemoteItemEntity) -> Unit
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
     var item: List<RepositoryRemoteItemEntity?> = mutableListOf()

    fun set(items: List<RepositoryRemoteItemEntity?>) {
        this.item = items
        notifyDataSetChanged()
    }

    fun add(model: List<RepositoryRemoteItemEntity?>){
        val mutableItem = item.toMutableList()
        mutableItem.addAll(model)
        item = mutableItem
    }
    class MyViewHolder(itemBinding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        private val binding = itemBinding
        fun bind(
            repositoryItems: RepositoryRemoteItemEntity,
            info: (RepositoryRemoteItemEntity) -> Unit
        ) {
            binding.apply {
                nameText.text = "name${repositoryItems.name}"
                descriptionText.text = repositoryItems.description

                recitem.setOnClickListener {
                    info(repositoryItems)
                }
                Glide.with(imageView.context)
                    .load(repositoryItems.owner.avatar_url)
                    .into(imageView)
            }
            return
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        item[position]?.let { holder.bind(it, info) }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}