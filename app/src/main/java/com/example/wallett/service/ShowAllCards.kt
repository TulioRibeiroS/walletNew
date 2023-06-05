package com.example.wallett.service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.wallett.R
import com.example.wallett.adapter.AdapterCards
import com.example.wallett.config.RetroConfig
import com.example.wallett.model.Card
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowAllCards : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_allcards)
           request()
    }

    private fun request(){

            RetroConfig().cardController.findAll().enqueue(object: Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                getList(response.body()!!)
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                Toast.makeText(this@ShowAllCards,"Falha na conexão!",Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun getList(listaCard:List<Card>){
        findViewById<RecyclerView>(R.id.listContent).adapter = AdapterCards(listaCard)
    }
}