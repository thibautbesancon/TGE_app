package com.example.tge_app.domain.usecase

import com.example.tge_app.data.repository.UserRepository
import com.example.tge_app.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
){
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}