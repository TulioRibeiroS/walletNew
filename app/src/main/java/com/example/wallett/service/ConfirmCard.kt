package com.example.wallett.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
                    findViewById<TextView>(R.id.tvnameTitular).text = card?.name
                    findViewById<TextView>(R.id.tvnumberCard).text = card?.number
                    findViewById<TextView>(R.id.Vencimento).text = card?.expirationDate
                    findViewById<TextView>(R.id.cvv).text = card?.cvv
                    findViewById<TextView>(R.id.tvColorcard).text = card?.cardType
                }

                override fun onFailure(call: Call<Card>, t: Throwable) {
                }
            })
        }
    }
}