package com.example.tge_app.domain.usecase

import java.security.MessageDigest

class computeHash (
    val password: String
){
    suspend fun sha256(password: String): String {
        return hashString(password, "SHA-256")
    }

    private fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }
}
