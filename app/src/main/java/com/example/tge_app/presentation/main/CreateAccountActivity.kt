package com.example.tge_app.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.tge_app.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_create_account.*
import org.koin.android.ext.android.inject

class CreateAccountActivity : AppCompatActivity()  {

    private val createAccountModel: CreateAccountModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        createAccountModel.accountLiveData.observe(this, Observer {
            when (it) {
                is AccountSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Success")
                        .setMessage("Success")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    this.finish()

                }
                is AccountExist -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Oups !")
                        .setMessage("Email déjà existant")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                is AccountError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Oups !")
                        .setMessage("Login incorrect")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                PasswordError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Oups !")
                        .setMessage("Password et Verify Password non identique")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        create_button.setOnClickListener {
            createAccountModel.onClickedLogin(
                login_edit.text.toString().trim(),
                password_edit.text.toString().trim(),
                password_verify_edit.text.toString().trim()
            )
        }
    }
}