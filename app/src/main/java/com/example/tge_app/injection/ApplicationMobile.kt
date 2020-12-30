package com.example.tge_app.injection

import android.content.Context
import androidx.room.Room
import com.example.projetandroid4a.domain.usecase.CreateUserUseCase
import com.example.tge_app.data.local.AppDatabase
import com.example.tge_app.data.local.DatabaseDao
import com.example.tge_app.data.repository.UserRepository
import com.example.tge_app.domain.usecase.ComputeHash
import com.example.tge_app.domain.usecase.GetUserUseCase
import com.example.tge_app.presentation.main.CreateAccountModel
import com.example.tge_app.presentation.main.LogViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule = module {
    factory { LogViewModel(get(),get(),get()) }
    factory { CreateAccountModel(get(),get(),get()) }
}

val domainModule : Module = module{
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
    single { ComputeHash() }
}

val dataModule : Module = module{
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }

}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    appDatabase.databaseDao()
    return appDatabase.databaseDao()
}
