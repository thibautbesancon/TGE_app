package com.example.tge_app.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tge_app.R
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        create_button.setOnClickListener{
            this.finish()
        }
    }


}