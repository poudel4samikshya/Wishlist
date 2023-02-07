package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class wishListAdapter (private val items: List<wish_item>) : RecyclerView.Adapter<wishListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set as you render a row.
        val wishItem: TextView
        val url: TextView
        val price: TextView
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            wishItem = itemView.findViewById(R.id.wish_item_textview)
            url = itemView.findViewById(R.id.url_textView)
            price = itemView.findViewById(R.id.price_textview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.wishItem.text = item.wishItem
        holder.url.text = item.url
        holder.price.text = item.price
    }


}