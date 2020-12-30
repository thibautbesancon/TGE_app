package com.example.projetandroid4a.domain.usecase

import com.example.tge_app.data.repository.UserRepository
import com.example.tge_app.domain.usecase.GetUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test


class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun invoke(){
        runBlocking {
            //Given
            val email = ""
            val pwd = ""
            coEvery{userRepository.getUserAndPwp(email,pwd)} returns null
            //When
            classUnderTest.invoke(email,pwd)
            //Then
            coVerify(exactly = 1) { userRepository.getUserAndPwp(email,pwd) }
        }
    }
}