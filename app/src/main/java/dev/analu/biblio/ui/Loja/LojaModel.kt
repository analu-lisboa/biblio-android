package dev.analu.biblio.ui.Loja

import android.util.Log
import dev.analu.biblio.api.LojaApi
import dev.analu.biblio.api.model.loja_response.LivroResponse
import io.reactivex.Observable
import io.reactivex.Observable.create
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LojaModel(val presenter: Mvp.Presenter) : Mvp.Model {

    val lojaapi : LojaApi = LojaApi()

    override fun getAllBooks(): Observable<MutableList<LivroResponse>> {
        return create { subscriber ->

            val callResponse = lojaapi.getAllLivros()
            val response = callResponse.execute()


            if(response.isSuccessful){

                val livros : MutableList<LivroResponse> = response.body()!!

                subscriber.onNext(livros)
                subscriber.onComplete()
            }else{
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    override fun getAllLivros() {

        lojaapi.getAllLivros().enqueue(object : Callback<MutableList<LivroResponse>> {
            override fun onFailure(call: Call<MutableList<LivroResponse>>, t: Throwable) {
                Log.d("ana", "onFailure")
            }

            override fun onResponse(call: Call<MutableList<LivroResponse>>, response: Response<MutableList<LivroResponse>>) {
                (response.body()!!)
            }

        })

    }

}