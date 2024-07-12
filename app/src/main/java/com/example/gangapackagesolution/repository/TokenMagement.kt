package com.example.gangapackagesolution.repository

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class TokenManagement(context: Context) {

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context, "secure_prefs",
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveToken(token: String) {
        sharedPreferences.edit().putString("jwtToken", token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("jwtToken", null)
    }

    fun deleteToken() {
        sharedPreferences.edit().remove("jwtToken")
    }
}