package com.example.mimb.plans

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mimb.R

class PlansAdapter(val list: List<PlusPlanData>, val context: Context) : RecyclerView.Adapter<PlansAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater  = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_plus_plans, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        holder.duration.text = "${data.duration} Days"
        holder.description.text = data.description
        holder.video_description.text = data.video_description
        holder.currency_code.text = data.currency_code

        holder.final_price.text = data.final_price.toString()
        holder.discounted_price.text = data.discounted_price.toString()
        holder.discounted_price_calculated.text = data.discounted_price_calculated.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val duration = itemView.findViewById<TextView>(R.id.duration)
        val description = itemView.findViewById<TextView>(R.id.description)
        val video_description = itemView.findViewById<TextView>(R.id.video_description)
        val currency_code = itemView.findViewById<TextView>(R.id.currency_code)
        val discounted_price_calculated = itemView.findViewById<TextView>(R.id.discounted_price_calculated)
        val final_price = itemView.findViewById<TextView>(R.id.final_price)
        val discounted_price = itemView.findViewById<TextView>(R.id.discounted_price)

    }
}