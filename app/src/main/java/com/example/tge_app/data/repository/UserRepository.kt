package com.example.tge_app.data.repository

import com.example.tge_app.data.local.DatabaseDao
import com.example.tge_app.data.local.models.toData
import com.example.tge_app.data.local.models.toEntity
import com.example.tge_app.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {

    suspend fun createUser(user: User) {
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }

    fun getUserAndPwp(email: String, password : String) : User? {
        val userLocal = databaseDao.findByNameAndPassword(email,password)
        return userLocal?.toEntity()
    }
}