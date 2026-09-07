package com.example.miniweather_melendreza

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.miniweather_melendreza.utilities.WeatherService

class CityActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var btnSaveCity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false

        spinner = findViewById(R.id.spinner)
        btnSaveCity = findViewById(R.id.btn_save_city)

        val weatherService = WeatherService(this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, weatherService.getCities())
        spinner.adapter = adapter

        btnSaveCity.setOnClickListener {
            val selectedCity = spinner.selectedItem.toString()
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("city", selectedCity)
            }
            startActivity(intent)
        }
    }
}