package com.dicoding.picodiploma.fundamentalsub1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.fundamentalsub1.databinding.ItemRowUserBinding

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(private val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {

        internal fun bind(user: User) {
            with(binding) {

            tvItemName.text = user.username
            tvItemFollowers.text = user.followers
            tvItemFollowing.text = user.following
            tvCompany.text = user.company
            Glide.with(imgItemAvatar.context)
                    .load(user.avatar)
                    .apply(RequestOptions().override(85, 85))
                    .into(imgItemAvatar)
            cardView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[adapterPosition]) }
            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListUserAdapter.ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListUserAdapter.ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}