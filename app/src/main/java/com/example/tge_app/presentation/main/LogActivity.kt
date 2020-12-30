package com.example.tge_app.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.tge_app.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_log.*
import org.koin.android.ext.android.inject

class LogActivity : AppCompatActivity() {

    private val logViewModel: LogViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        logViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess->{
                    val monIntent =  Intent(this, Main_Activity::class.java)
                    startActivity(monIntent)
                }
                LoginError->{
                    MaterialAlertDialogBuilder(this)
                        .setMessage("Login ou password incorrect")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_button.setOnClickListener {
            logViewModel.onClickedLogin(login_edit.text.toString().trim(),password_edit.text.toString().trim())
        }

        create_account_button.setOnClickListener{
            val monIntent =  Intent(this, CreateAccountActivity::class.java)
            startActivity(monIntent)
        }


    }
}