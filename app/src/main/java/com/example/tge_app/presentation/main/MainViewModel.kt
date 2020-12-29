package com.example.tge_app.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetandroid4a.domain.usecase.CreateUserUseCase
import com.example.tge_app.domain.usecase.ComputeHash
import com.example.tge_app.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val computeHash: ComputeHash
) : ViewModel(){
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    init {
        //counter.value = 0

    }

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            //createUserUseCase.invoke(User("admin@mail.com",computeHash.Crypto("admin")))
            val crypt = computeHash.Crypto(password)
            val user = getUserUseCase.invoke(
                emailUser,
                crypt)
            val loginStatus = if(user != null) {
                LoginSuccess(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }



}