package com.xpynx.assignment_a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var  btnProductList:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnProductList=findViewById(R.id.btnProductList)
        btnProductList.setOnClickListener{
            startActivity(Intent(this,ProductsListActivity::class.java))
        }

    }
}