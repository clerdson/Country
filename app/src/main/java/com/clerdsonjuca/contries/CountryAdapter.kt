package com.clerdsonjuca.contries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class CountryAdapter @Inject constructor(
    private val items:ArrayList<Country>
    )
    :RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val countryName = view.findViewById<TextView>(R.id.countryName)
        fun bind(country: Country){
            countryName.text = country.name?.common
        }

    }
    fun update (country: List<Country>){
        items.clear()
        items.addAll(country)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


}