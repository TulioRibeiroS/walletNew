package com.example.wallett.model

val cardList: List<Card> = emptyList()

data class Card(

    val id: String,
    val name: String,
    val cvv: String,
    val number: String,
    val expirationDate: String,
    val cardType: String
)
