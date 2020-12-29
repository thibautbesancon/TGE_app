package com.example.tge_app.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.tge_app.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess->{
                    MaterialAlertDialogBuilder(this)
                        .setMessage("Bonjour")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    val monIntent : Intent =  Intent(this, LogActivity::class.java)
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
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(),password_edit.text.toString().trim())
        }

        create_account_button.setOnClickListener{
            val monIntent : Intent =  Intent(this, CreateAccountActivity::class.java)
            startActivity(monIntent)
        }


    }
}