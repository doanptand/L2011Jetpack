package com.ddona.l2011jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddona.l2011jetpack.databinding.ItemStudentBinding
import com.ddona.l2011jetpack.model.Student

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    private val students = arrayListOf<Student>()

    fun submitList(temp: List<Student>) {
        students.clear()
        students.addAll(temp)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount() = students.size

    class ViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            binding.s = student
            binding.executePendingBindings()
        }
    }
}