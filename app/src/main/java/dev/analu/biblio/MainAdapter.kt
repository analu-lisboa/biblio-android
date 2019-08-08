package dev.analu.biblio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.analu.biblio.api.Repositories.LivrosComprados
import kotlinx.android.synthetic.main.main_card.view.*

class MainAdapter (val mainFeed: LivrosComprados.Companion): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_card, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val mainFeed = mainFeed.livrosComprados[position]

        with(holder.itemView){
            maintitle.text = mainFeed.title
            mainwriter.text = mainFeed.writer
            val cover = mainthumbnailHd
            Picasso.get().load(mainFeed.thumbnailHd).into(cover)
        }
    }
    override fun getItemCount(): Int {
        return mainFeed.livrosComprados.size
    }

    inner class MainViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    }
}


