package com.example.tge_app.domain.retrofit

import com.example.tge_app.data.local.models.Membres
import retrofit2.http.GET
import java.util.*

interface IMemberList {
    @get:GET("TGE.json")
    val listMember:Observable<Membres>
}