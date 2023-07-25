package com.example.mimb.counselerdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mimb.R

class SymptomsAdapter(val list: ArrayList<CounsellorListData>, val context: Context) : RecyclerView.Adapter<SymptomsAdapter.ViewHolder>() {

    var listOfId = ArrayList<Int>()

    var mListener: OnListChanges ? = null

    fun setOnListChangeListener(listener: OnListChanges?){
        mListener = listener
    }

    interface OnListChanges{
        fun listChanged(list : ArrayList<Int>)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater  = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_counsellors, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        holder.title.text = data.title

        holder.check.setOnClickListener {
            if (listOfId.contains(data.id)){
                listOfId.remove(data.id)
            } else {
                listOfId.add(data.id)
            }
            mListener?.listChanged(listOfId)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tvLayout)
        val check = itemView.findViewById<CheckBox>(R.id.checkbox)
    }
}