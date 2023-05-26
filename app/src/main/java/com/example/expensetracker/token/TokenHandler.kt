package com.example.expensetracker.token

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.lang.Exception
import java.security.Key
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.GCMParameterSpec

//TODO finish with decrypt
object TokenHandler {
    private lateinit var iv: ByteArray
    private lateinit var key: Key

    fun setFirebaseToken(token: String, context: Context) {
        val sharedPref = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        sharedPref.edit().putString("encryptedData", encryptString(token)).apply()
    }

    fun getFirebaseToken(context: Context): String {
        val sharedPref = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val encryptedString = sharedPref.getString("encryptedData", null)
        return encryptedString?.let { decryptString(it) } ?: "Error getting token"
    }

    private fun encryptString(token: String): String {
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        key = getKeyStore()
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptData = cipher.doFinal(token.toByteArray())
        iv = cipher.iv
        return String(encryptData, Charsets.UTF_8)
    }

    private fun decryptString(encryptedString: String): String {
        try {
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val spec = GCMParameterSpec(128, iv)
            cipher.init(Cipher.DECRYPT_MODE, key, spec)
            val decryptedData = cipher.doFinal(encryptedString.toByteArray())
            return String(decryptedData, Charsets.UTF_8)
        } catch (e: Exception) {
            return e.toString()
        }
    }

    private fun getKeyStore(): Key {
        val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        val alias = "alias2"
        val key = keyStore.getKey(alias, null)
        if (key == null) {
            val keyGenerator = KeyGenerator.getInstance(
                KeyProperties.KEY_ALGORITHM_AES,
                "AndroidKeyStore"
            )
            val keyGenParam = KeyGenParameterSpec.Builder(
                alias,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            ).setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build()
            keyGenerator.init(keyGenParam)
            keyGenerator.generateKey()
        }
        return keyStore.getKey(alias, null)
    }
}