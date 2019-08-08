package dev.analu.biblio.api

import dev.analu.biblio.api.model.loja_response.LivroResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LojaApi {

        private val api: ILojaApi

        init{
            val retrofit = Retrofit.Builder()
                .baseUrl(" https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            api = retrofit.create(ILojaApi::class.java)

        }

        fun getAllLivros(): Call<MutableList<LivroResponse>>{
            return api.getAllLivros()

        }
}