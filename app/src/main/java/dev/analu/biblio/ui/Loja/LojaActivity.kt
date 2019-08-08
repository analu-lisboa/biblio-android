package dev.analu.biblio.ui.Loja

import android.content.DialogInterface
import android.content.Intent
import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.analu.biblio.MainActivity
import dev.analu.biblio.R
import dev.analu.biblio.api.Repositories.LivrosComprados
import dev.analu.biblio.api.model.loja_response.LivroResponse
import dev.analu.biblio.utils.AppSharedPreferences
import kotlinx.android.synthetic.main.activity_loja.*
import kotlinx.android.synthetic.main.activity_loja.tv_saldo
import java.util.*

class LojaActivity : AppCompatActivity(), Mvp.View, Mvp.btnClickListener {

    var pt_br : Locale = Locale("pt", "BR")

    private val presenter: Mvp.Presenter by lazy<Mvp.Presenter>{
        LojaPresenter(this)
    }
    private lateinit var adapter: LojaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loja)

        this.presenter.LoadBooks(applicationContext)
        var saldo = AppSharedPreferences.getSaldo(applicationContext)
        tv_saldo.setText(NumberFormat.getCurrencyInstance(pt_br).format(saldo))

    }
    override fun showLista(livros : MutableList<LivroResponse>){
        recyclerView.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        this.adapter = LojaAdapter(livros, this)
        recyclerView.adapter = adapter
    }

    override fun showError (erro : String){
        Toast.makeText(LojaActivity(), "Muito ruim, hein",
            Toast.LENGTH_LONG).show();
    }
    override fun onBtnClick(position: Int) {

        var livro = adapter.homeFeed.get(position)
        var valorLivro = livro.price.toFloat()
        var saldo = AppSharedPreferences.getSaldo(applicationContext)

        if(valorLivro <= saldo && saldo != null){
            var novoSaldo = (saldo - valorLivro)
            AppSharedPreferences.setSaldo(applicationContext,novoSaldo)
            AppSharedPreferences.getSaldo(applicationContext)
            tv_saldo.setText(NumberFormat.getCurrencyInstance(pt_br).format(saldo))
            adapter.homeFeed.remove(livro)
            adapter.notifyDataSetChanged()
            LivrosComprados.livrosComprados.add(livro)

        }
        else{
            AlertDialog()
        }
        this.finish()

    }

    fun AlertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("SEM SALDO")
        builder.setMessage("Você não possui saldo para comprar outro livro")
        builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = { dialog: DialogInterface, which: Int ->
        } ))
        builder.show()
    }
}









