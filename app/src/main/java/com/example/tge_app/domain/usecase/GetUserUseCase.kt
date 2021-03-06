package com.example.tge_app.domain.usecase

import com.example.tge_app.data.repository.UserRepository
import com.example.tge_app.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
){
    suspend fun invoke(email: String, password: String) : User?{
        return userRepository.getUserAndPwp(email, password)
    }

    suspend fun invoke2(email: String) : User?{
        return userRepository.getUser(email)
    }

}