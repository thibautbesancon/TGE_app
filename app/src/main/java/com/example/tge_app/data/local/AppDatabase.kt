package com.example.tge_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tge_app.data.local.models.UserLocal

@Database(entities = arrayOf(UserLocal::class), version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}