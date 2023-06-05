package com.example.wallett.config

import com.example.wallett.controller.CardController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroConfig {
    val cardController: CardController = Retrofit.Builder().baseUrl("http://192.168.50.4:3000").addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CardController::class.java)
}