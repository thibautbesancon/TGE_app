package com.example.tge_app.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()
object LoginError : LoginStatus()
