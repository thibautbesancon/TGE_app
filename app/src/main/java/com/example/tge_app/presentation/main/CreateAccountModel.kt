package com.example.tge_app.presentation.main

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetandroid4a.domain.usecase.CreateUserUseCase
import com.example.tge_app.domain.entity.User
import com.example.tge_app.domain.usecase.ComputeHash
import com.example.tge_app.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val computeHash: ComputeHash
) : ViewModel(){
    val accountLiveData : MutableLiveData<AccountStatus> = MutableLiveData()

    init {
        //counter.value = 0

    }

    fun onClickedLogin(emailUser: String, password: String, passwordVerify : String) {
        viewModelScope.launch(Dispatchers.IO) {
            //createUserUseCase.invoke(User("admin@mail.com",computeHash.Crypto("admin")))
            val crypt = computeHash.Crypto(password)
            val crypt2 = computeHash.Crypto(passwordVerify)
            val user = getUserUseCase.invoke2(emailUser)
            val accountStatus = if(crypt != crypt2 || crypt == computeHash.Crypto("")) {
                PasswordError
            }else{
                if (user != null) {
                    AccountExist
                } else {
                    if (isValidEmail(emailUser)) {
                        createUserUseCase.invoke(User(emailUser,crypt))
                        AccountSuccess
                    }else{
                        AccountError
                    }
                }
            }

            withContext(Dispatchers.Main){
                accountLiveData.value = accountStatus
            }
        }
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}