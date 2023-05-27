package com.example.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapp.databinding.ContactViewBinding

class FirstAdapter(private val contacts: List<Contact>) : RecyclerView.Adapter<FirstAdapter.MyViewHolder>() {
    inner class MyViewHolder(binding: ContactViewBinding) : ViewHolder(binding.root) {
        val nameTv = binding.nameTv
        val numberTv = binding.numberTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val contactViewBinding = ContactViewBinding.inflate(inflater, parent, false)
    return MyViewHolder(contactViewBinding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTv.text = contacts[position].name
        holder.numberTv.text = contacts[position].number
    }
}