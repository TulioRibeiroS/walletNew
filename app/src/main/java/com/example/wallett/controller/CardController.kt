package com.example.wallett.controller
import com.example.wallett.model.Card
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CardController {

    @GET("/cards")
    fun findAll(): Call<List<Card>>

    @GET("/cards/{id}")
    fun findByid(@Path("id") cardId: String):Call<Card>

    @POST("/cards/")
    fun createCard(@Body card: Card) : Call<Card>

}