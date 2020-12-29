package com.example.tge_app.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserLocal(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "email") val email: String?
)