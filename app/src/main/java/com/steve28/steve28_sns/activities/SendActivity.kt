package com.steve28.steve28_sns.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase
import com.steve28.steve28_sns.R
import kotlinx.android.synthetic.main.activity_send.*

class SendActivity : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance().getReference("Contents")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)

        sendinput.setOnClickListener {
            if (titleinput.text.toString() == "" || contentinput.text.toString() == "")
                Snackbar.make(it, "내용이 비어있습니다.", Snackbar.LENGTH_SHORT)
            else {
                db.push().setValue(hashMapOf(
                    "title" to titleinput.text.toString(),
                    "info" to contentinput.text.toString(),
                    "desc" to "Written by Steve28")
                )
                finish()
            }
        }
    }
}