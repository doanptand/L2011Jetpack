package com.ddona.l2011jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ddona.l2011jetpack.databinding.ItemPassengerBinding
import com.ddona.l2011jetpack.model.Passenger

private val passengerDiff = object : DiffUtil.ItemCallback<Passenger>() {
    override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
        return oldItem == newItem
    }

}

class PassengerAdapter :
    PagingDataAdapter<Passenger, PassengerAdapter.ViewHolder>(passengerDiff) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPassengerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class ViewHolder(private val binding: ItemPassengerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(passenger: Passenger) {
            binding.passenger = passenger
            binding.executePendingBindings()
        }
    }

}