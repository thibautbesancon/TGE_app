package com.example.tge_app.injection

import com.example.tge_app.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}