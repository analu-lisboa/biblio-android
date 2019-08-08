package dev.analu.biblio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import dev.analu.biblio.ui.Loja.LojaActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var comprarLivros = findViewById<MaterialButton>(R.id.comprarLivros)

        comprarLivros.setOnClickListener{

            var movetoStore = Intent(applicationContext, LojaActivity::class.java)

            startActivity(movetoStore) }



    }





}


