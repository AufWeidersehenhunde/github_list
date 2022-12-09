package com.example.githabapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.RecyclerviewItemBinding
import com.example.githabapi.DBandprovider.GithubDb


class MyAdapter(
    private val info: (GithubDb) -> Unit
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var item: List<GithubDb> = listOf()
    fun set(items: List<GithubDb>) {
        this.item = items
        notifyDataSetChanged()
    }

    class MyViewHolder(itemBinding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        private val binding = itemBinding
        fun bind(
            repositoryItems: GithubDb,
            info: (GithubDb) -> Unit
        ) {
            binding.apply {
                nameText.text = repositoryItems.name
                descriptionText.text = repositoryItems.description

                recitem.setOnClickListener {
                    info(repositoryItems)
                }
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
        holder.bind(item[position], info)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}