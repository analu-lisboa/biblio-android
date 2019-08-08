package dev.analu.biblio.ui.Loja

import dev.analu.biblio.domain.Livro


interface Mvp {
    interface View{

    }


    interface  presenter {
        fun getAllLivros(livro: Livro)

    }


    interface model{
        fun getAllBooks()

    }

}