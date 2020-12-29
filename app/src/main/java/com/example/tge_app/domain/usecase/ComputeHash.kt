package com.example.tge_app.domain.usecase

import java.security.MessageDigest

class ComputeHash {
    public fun Crypto(password: String): String {
        return hashString(password, "SHA-256")
    }

    private fun hashString(input: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
    }
}