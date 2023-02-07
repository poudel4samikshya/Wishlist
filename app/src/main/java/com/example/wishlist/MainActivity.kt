package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<wish_item> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishListRv = findViewById<RecyclerView>(R.id.itemsRv)
        // Create adapter passing in the list of emails
        val adapter = wishListAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        wishListRv.adapter = adapter
        // Set layout manager to position the items
        wishListRv.layoutManager = LinearLayoutManager(this)


        // Submit button
        val button = findViewById<Button>(R.id.button)

        // declarations for edit texts

        val wish_item = findViewById<EditText>(R.id.wish_item)
        val price = findViewById<EditText>(R.id.price)
        val url = findViewById<EditText>(R.id.website_url)


        button.setOnClickListener {
            items.add(wish_item(wish_item.text.toString(),url.text.toString(),"$"+ price.text.toString()))
            wish_item.onEditorAction(EditorInfo.IME_ACTION_DONE)
            //price.onEditorAction(EditorInfo.IME_ACTION_DONE)
           // url.onEditorAction(EditorInfo.IME_ACTION_DONE)
            wish_item.text = null
            price.text = null
            url.text = null
            Toast.makeText(getApplicationContext(), "Item Added!", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
        }







    }
}