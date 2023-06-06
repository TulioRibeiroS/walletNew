package com.example.wallett.config

import com.example.wallett.controller.CardController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroConfig {
    val cardController: CardController = Retrofit.Builder().baseUrl("https://wallet-backend-nu.vercel.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CardController::class.java)
}