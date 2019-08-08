package dev.analu.biblio.ui.Loja

import android.util.Log
import dev.analu.biblio.api.LojaApi
import dev.analu.biblio.api.model.loja_response.LivroResponse
import io.reactivex.Observable
import io.reactivex.Observable.create
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LivroRepository {

    val lojaapi : LojaApi = LojaApi()

    fun getAllBooks(): Observable<List<LivroResponse>> {
        return create { subscriber ->

            val callResponse = lojaapi.getAllBooks()

            val livros = mutableListOf<LivroResponse>()
            // api call...

            subscriber.onNext(news)
            subscriber.onCompleted()
        }
    }












    fun getAllLivros() {

        lojaapi.getAllLivros().enqueue(object : Callback<List<LivroResponse>> {
            override fun onFailure(call: Call<List<LivroResponse>>, t: Throwable) {
                Log.d("ana", "onFailure")
            }

            override fun onResponse(call: Call<List<LivroResponse>>, response: Response<List<LivroResponse>>) {
                (response.body()!!)
            }

        })

    }

}