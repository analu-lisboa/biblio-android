package dev.analu.biblio.utils

import android.content.Context
import android.content.SharedPreferences
import dev.analu.biblio.BuildConfig

class AppSharedPreferences {

    companion object{
        private val SALDO = "${BuildConfig.APPLICATION_ID}.saldo"
        private val APPSTATE = "${BuildConfig.APPLICATION_ID}.app_state"
        private val LIVROSCOMPRADOS = "${BuildConfig.APPLICATION_ID}.livros_comprados"

        fun setSaldo(context: Context, saldo : Float){
            val prefs : SharedPreferences = context.getSharedPreferences(SALDO, Context.MODE_PRIVATE)

            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putFloat(SALDO, saldo)
            editor.apply()
        }

        fun getSaldo(context: Context): Float {
            val prefs  : SharedPreferences = context.getSharedPreferences(SALDO, Context.MODE_PRIVATE)
            return prefs.getFloat(SALDO, 0f)
        }

        fun setState(context: Context, value : Boolean){
            val prefs : SharedPreferences = context.getSharedPreferences(APPSTATE, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putBoolean(APPSTATE, value)
            editor.apply()
        }

        fun getState(context: Context): Boolean {
            val prefs  : SharedPreferences = context.getSharedPreferences(APPSTATE, Context.MODE_PRIVATE)
            return prefs.getBoolean(APPSTATE, false)
        }
    }
}