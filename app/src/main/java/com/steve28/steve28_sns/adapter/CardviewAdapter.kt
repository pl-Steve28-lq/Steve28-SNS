package com.steve28.steve28_sns.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.steve28.steve28_sns.R
import com.steve28.steve28_sns.activities.ContentActivity
import com.steve28.steve28_sns.post.PostData
import kotlinx.android.synthetic.main.cardview_item.view.*
import kotlin.math.min

class CardviewAdapter: RecyclerView.Adapter<CardviewAdapter.ViewHolder>() {

    private val postList: ArrayList<PostData> = ArrayList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.mTitle
        var desc: TextView = itemView.mDesc
        var info: TextView = itemView.mInfo
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(p0.context).inflate(R.layout.cardview_item, p0, false))

    override fun onBindViewHolder(p0: ViewHolder, pos: Int) {
        val post = postList[pos]
        p0.title.text = post.title  // 글 제목
        p0.desc.text = post.desc  // 글 설명
        p0.info.text = post.info.substring(0..min(97, post.info.length-1)) + "..."  // 글 내용

        p0.itemView.setOnClickListener {
            val content = Intent(it.context, ContentActivity::class.java)
            content.putExtra("title", p0.title.text)
            content.putExtra("content", post.info)
            content.putExtra("info", p0.desc.text)
            it.context.startActivity(content)
        }
    }

    override fun getItemCount(): Int = postList.size

    fun add(data: PostData) {
        this.postList.add(data)
        notifyDataSetChanged()
    }

    private fun clear() {
        this.postList.clear()
        notifyDataSetChanged()
    }

    fun addAll(datas: ArrayList<PostData>) {
        this.clear()
        this.postList.addAll(datas)
        notifyDataSetChanged()
    }
}