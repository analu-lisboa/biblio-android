package dev.analu.biblio.api

import dev.analu.biblio.api.model.loja_response.LivroResponse
import retrofit2.http.GET
import retrofit2.Call

interface ILojaApi {


    @GET("/Felcks/desafio-mobile-lemobs/master/products.json")
    fun getAllLivros(): Call<List<LivroResponse>>
}