package com.example.wallett.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallett.R
import com.example.wallett.model.Card
import com.example.wallett.view.ViewHolderCards

class AdapterCards(var listaDeCards: List<Card>): RecyclerView.Adapter<ViewHolderCards>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCards {
        return ViewHolderCards( LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false))
    }

    override fun getItemCount(): Int {
        return listaDeCards.size
    }

    override fun onBindViewHolder(holder: ViewHolderCards, position: Int) {
        holder.configItens(listaDeCards[position])
    }
}