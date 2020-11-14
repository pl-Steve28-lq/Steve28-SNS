package com.steve28.steve28_sns.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.steve28.steve28_sns.R
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val ctx = intent

        val title = ctx.getStringExtra("title")
        val content = ctx.getStringExtra("content")
        val info = ctx.getStringExtra("info")

        qtitle.text = title
        qcontent.text = content
        qinfos.text = info
    }
}