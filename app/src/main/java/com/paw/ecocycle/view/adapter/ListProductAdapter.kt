package com.paw.ecocycle.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.paw.ecocycle.databinding.ItemProductBinding
import com.paw.ecocycle.model.remote.response.Data

class ListProductAdapter: ListAdapter<Data, ListProductAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                tvItemRust.text = data.createdAt
                tvItemNoRust.text = data.updatedAt
//                Glide.with(itemView.context)
//                    .load(market.image)
//                    .centerCrop()
//                    .apply(
//                        RequestOptions
//                            .placeholderOf(R.drawable.ic_image_loading)
//                            .error(R.drawable.ic_broken_image)
//                    )
//                    .into(ivPhoto)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}