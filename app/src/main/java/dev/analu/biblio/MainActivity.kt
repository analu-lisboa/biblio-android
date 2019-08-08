package dev.analu.biblio

import android.content.Intent
import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.analu.biblio.api.Repositories.LivrosComprados
import dev.analu.biblio.ui.Loja.LojaActivity
import dev.analu.biblio.utils.AppSharedPreferences
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv_saldo
import java.util.*

class MainActivity : AppCompatActivity(){

    var pt_br : Locale = Locale("pt", "BR")
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkFirstRun()
        iniciaBtnIrLoja()

    }
    override fun onResume(){
        super.onResume()
        var primeirosaldo = AppSharedPreferences.getSaldo(applicationContext)
        var saldoInicialEmReais = NumberFormat.getCurrencyInstance(pt_br).format(primeirosaldo)
        tv_saldo.setText(saldoInicialEmReais)
        showBiblio(LivrosComprados.Companion)

    }
    fun checkFirstRun(){

        if (!AppSharedPreferences.getState(applicationContext)) {
            AppSharedPreferences.setSaldo(applicationContext, 170.00f)
            AppSharedPreferences.setState(applicationContext, true)
            tv_bibliovazia.visibility = View.VISIBLE
            recyclerViewMain.visibility = View.GONE


        }else{

            var saldo = AppSharedPreferences.getSaldo(applicationContext)
            tv_saldo.setText(NumberFormat.getCurrencyInstance(pt_br).format(saldo))
            tv_bibliovazia.visibility = View.GONE
            showBiblio(LivrosComprados.Companion)

        }
    }
    fun iniciaBtnIrLoja(){

        btn_irLoja.setOnClickListener{

            var movetoStore = Intent(applicationContext, LojaActivity::class.java)

            startActivity(movetoStore) }
    }

    fun showBiblio(livros : LivrosComprados.Companion){
        recyclerViewMain.visibility = View.VISIBLE
        recyclerViewMain.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        this.adapter = MainAdapter(livros)
        recyclerViewMain.adapter = adapter
    }
}



