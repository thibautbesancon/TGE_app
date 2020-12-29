package com.example.tge_app.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tge_app.domain.entity.User
import com.example.tge_app.domain.usecase.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel(){
    val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0

    }

    fun onClickedIncrement(emailUser: String) {
        viewModelScope.launch {
            createUserUseCase.invoke(User("test"))
        }
        //counter.value = (counter.value ?: 0) +1
    }

}