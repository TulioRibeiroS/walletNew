package com.example.wallett.service

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.wallett.MainActivity
import com.example.wallett.R
import com.example.wallett.config.RetroConfig
import com.example.wallett.model.Card
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfirmCard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_card)

        findViewById<Button>(R.id.btPagemain).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        intent.getStringExtra(RegisterCard.KEY_CARD).toString()?.let {
            RetroConfig().cardController.findByid(it).enqueue(object: Callback<Card>{
                override fun onResponse(call: Call<Card>, response: Response<Card>) {
                    val card = response.body()
                    findViewById<TextView>(R.id.campoNomeTitular).text = card?.name
                    findViewById<TextView>(R.id.campoNumeroCartao).text = card?.number
                    findViewById<TextView>(R.id.vencimento).text = card?.expirationDate
                    findViewById<TextView>(R.id.campoCVV).text = card?.cvv
                    findViewById<TextView>(R.id.tvColorcard).text = card?.cardType
                }

                override fun onFailure(call: Call<Card>, t: Throwable) {
                    System.out.println("ERRO MEU PARCIERO")
                }
            })
        }
    }
}