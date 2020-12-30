package com.example.tge_app.domain.retrofit

import com.example.tge_app.data.remote.Membres
import io.reactivex.Observable
import retrofit2.http.GET


interface iMembreList {
    @get:GET("tge.json")
    val listMember:Observable<Membres>
}