package com.example.tge_app.presentation.main

sealed class AccountStatus


object AccountSuccess : AccountStatus()
object AccountExist : AccountStatus()
object PasswordError : AccountStatus()
object AccountError : AccountStatus()