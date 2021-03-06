package com.example.tge_app.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tge_app.R
import kotlinx.android.synthetic.main.activity_main.*

class Main_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Login -> {
                    // Handle Login icon press
                    val IntentLog =  Intent(this, LogActivity::class.java)
                    startActivity(IntentLog)
                    true
                }
                R.id.Member -> {
                    // Handle Login icon press
                    val IntentLog =  Intent(this, Member_Activity::class.java)
                    startActivity(IntentLog)
                    true
                }
                else -> false
            }
        }



    }

}