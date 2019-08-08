package dev.analu.biblio.ui.Loja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.analu.biblio.R
import dev.analu.biblio.api.model.loja_response.LivroResponse
import kotlinx.android.synthetic.main.activity_loja.*


class LojaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loja)





    }

    fun showAllLivros(homeFeed: List<LivroResponse>){


        recyclerView.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        recyclerView.adapter = LojaAdapter(homeFeed)

    }




}























