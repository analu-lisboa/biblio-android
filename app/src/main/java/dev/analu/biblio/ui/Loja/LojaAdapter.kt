package dev.analu.biblio.ui.Loja

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.analu.biblio.R
import dev.analu.biblio.api.model.loja_response.LivroResponse
import kotlinx.android.synthetic.main.item_card.view.*

class LojaAdapter  (val homeFeed: List<LivroResponse>) : RecyclerView.Adapter<LojaAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LojaAdapter.CustomViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)



        return CustomViewHolder(view)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val homeFeed = homeFeed[position]

        with(holder.itemView){
            title.text = homeFeed.title
            writer.text = homeFeed.writer
            price.text = ("R$ " + homeFeed.price.toString())
            val cover = thumbnailHd
            Picasso.get().load(homeFeed.thumbnailHd).into(cover)
        }
    }

    override fun getItemCount(): Int {

        return homeFeed.size

    }

    inner class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    }

}







