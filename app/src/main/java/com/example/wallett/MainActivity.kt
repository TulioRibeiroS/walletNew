package com.example.wallett

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.wallett.service.RegisterCard
import com.example.wallett.service.ShowAllCards

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btCadcard).setOnClickListener {
            startActivity( Intent(this, RegisterCard::class.java))
        }
        findViewById<Button>(R.id.myCards).setOnClickListener {
            startActivity(Intent(this, ShowAllCards::class.java))
        }


    }
}