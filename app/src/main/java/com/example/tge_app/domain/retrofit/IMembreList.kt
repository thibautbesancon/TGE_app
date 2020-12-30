package com.example.tge_app.domain.retrofit

import com.example.tge_app.data.remote.Membres
import retrofit2.http.GET
import java.util.*

interface IMembreList {
    @get:GET("TGE.json")
    val listMember:Observable<Membres>
}