package com.example.finalproject_c00274244

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntryListingAdapter(private val entryItemLayout: Int): RecyclerView.Adapter<EntryListingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntryListingAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(entryItemLayout, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return if(entryList == null) 0 else entryList!!.size
    }
    override fun onBindViewHolder(holder:
                                  EntryListingAdapter.ViewHolder, position: Int) {
        val item = holder.item
        entryList.let{
            item.text = it!![position].username + " gave " + it!![position].game + " a rating of " + it!![position].rating + " out of 100."
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.entry_row)
    }
    private var entryList: List<Entry>? = null
    fun setEntryList(entries: List<Entry>){
        entryList = entries
        notifyDataSetChanged()
    }
}