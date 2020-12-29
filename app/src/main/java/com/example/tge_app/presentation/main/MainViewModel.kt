package com.example.tge_app.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tge_app.domain.usecase.CreateUserUseCase
import com.example.tge_app.domain.usecase.GetUserUseCase
import com.example.tge_app.domain.usecase.computeHash
import kotlinx.coroutines.*

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    init {
        //counter.value = 0

    }

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(
                emailUser,
                computeHash.sha256(password))
            val loginStatus = if(user != null) {
                LoginSuccess(user.email)
            }else{
                LoginError
            }
            /*createUserUseCase.invoke(User(emailUser,password))*/
            //val user = getUserUseCase.invoke(emailUser,password)
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

}