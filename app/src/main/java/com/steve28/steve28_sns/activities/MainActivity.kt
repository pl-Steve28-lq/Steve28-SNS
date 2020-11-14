package com.steve28.steve28_sns.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.steve28.steve28_sns.R
import com.steve28.steve28_sns.adapter.CardviewAdapter
import kotlinx.android.synthetic.main.activity_main.*

import com.steve28.steve28_sns.post.PostData

class MainActivity : AppCompatActivity() {
    private val LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    private val cardview = CardviewAdapter()
    private val db = FirebaseDatabase.getInstance().getReference("Contents")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = cardview

        fab.setOnClickListener {
            val sendintent = Intent(this, SendActivity::class.java)
            startActivity(sendintent)
        }

        db.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val data = p0.getValue(PostData::class.java)!!
                cardview.add(data)
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {}
            override fun onChildRemoved(p0: DataSnapshot) {}
            override fun onChildMoved(p0: DataSnapshot, p1: String?) {}
            override fun onCancelled(p0: DatabaseError) {}
        })
    }
}