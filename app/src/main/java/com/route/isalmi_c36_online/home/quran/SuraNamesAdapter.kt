package com.route.isalmi_c36_online.home.quran

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.isalmi_c36_online.R
class SuraNamesAdapter(val items:List<String>) : RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>(){

    var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.suraNameTextView.text = items.get(position)
        holder.suraNameTextView.setOnClickListener {
            ///todo: call method in your fragment or activity
             Log.e("AdapterOnItemClick","clicked an item")
            onItemClickListener?.onItemClickListener(items.get(position), position)
        }
    }


    interface OnItemClickListener{
        fun onItemClickListener(item: String, index: Int)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val suraNameTextView = itemView.findViewById<TextView>(R.id.item_sura_name_title)
    }
}