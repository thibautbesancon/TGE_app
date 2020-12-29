package com.example.tge_app.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tge_app.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String

){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null

}

fun User.toData() : UserLocal{
    return UserLocal(
        email = this.email,
        password = this.password
    )
}

fun UserLocal.toEntity() : User{
    return User(
        email = this.email,
        password = this.password
    )
}