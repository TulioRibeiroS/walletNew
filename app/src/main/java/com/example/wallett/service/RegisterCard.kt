package com.example.wallett.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.wallett.R
import com.example.wallett.config.RetroConfig
import com.example.wallett.controller.CardController
import com.example.wallett.model.Card
import kotlinx.coroutines.MainScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.UUID

class RegisterCard : AppCompatActivity() {

    private var service: CardController? = null

    companion object {
        const val KEY_CARD = "KEY_CARD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registercard)

        service = RetroConfig().cardController

        findViewById<Button>(R.id.btAvancar).setOnClickListener {
            executarRequest(Card(
                id = UUID.randomUUID().toString(),
                name = findViewById<EditText>(R.id.campoNomeTitular).text.toString(),
                cvv = findViewById<EditText>(R.id.campoCVV).text.toString(),
                expirationDate = findViewById<EditText>(R.id.campoVencimento).text.toString(),
                cardType = "GREEN",
                number = findViewById<EditText>(R.id.campoNumeroCartao).text.toString()
            ))
        }
        findViewById<Button>(R.id.btVoltar).setOnClickListener {
            startActivity(Intent(this, MainScope()::class.java))
        }

    }

    private fun executarRequest(newCard: Card){
        service?.createCard(newCard)?.enqueue(object: Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                Toast.makeText(
                    this@RegisterCard,
                    "Cadastro Realizado com sucesso",
                    Toast.LENGTH_LONG
                ).show()
                Intent(this@RegisterCard, ConfirmCard::class.java).also {
                    it.putExtra(KEY_CARD,newCard.id)
                    startActivity(it)
                }
            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Toast.makeText(this@RegisterCard, "Erro, Falha na comunicação", Toast.LENGTH_LONG)
                    .show()
            }
        })
        }
    }

