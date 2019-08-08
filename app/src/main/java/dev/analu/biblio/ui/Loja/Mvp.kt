package dev.analu.biblio.ui.Loja

import android.content.Context
import dev.analu.biblio.api.model.loja_response.LivroResponse
import io.reactivex.Observable


interface Mvp {

    interface View{
        fun showError (erro : String)
        fun showLista(livros : MutableList<LivroResponse>)
    }
    interface  Presenter {
        fun LoadBooks(context: Context)
    }

    interface Model{
        fun getAllBooks() : Observable<MutableList<LivroResponse>>
        fun getAllLivros()
    }

    interface btnClickListener {
        fun onBtnClick(position: Int)

    }
}