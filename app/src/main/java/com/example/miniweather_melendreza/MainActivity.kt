package com.example.miniweather_melendreza

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.miniweather_melendreza.utilities.WeatherService

class MainActivity : AppCompatActivity() {
    private lateinit var tvGreeting: TextView
    private lateinit var tvCity: TextView
    private lateinit var ivWeather: ImageView
    private lateinit var tvTemperature: TextView
    private lateinit var tvWeather: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvGreeting = findViewById(R.id.tvGreeting)
        tvCity = findViewById(R.id.tvCity)
        ivWeather = findViewById(R.id.ivWeather)
        tvTemperature = findViewById(R.id.tvTemperature)
        tvWeather = findViewById(R.id.tvWeather)

        val selectedCity = intent.getStringExtra("SELECTED_CITY") ?: "Ciudad de México"
        tvCity.text = selectedCity

        val weatherService = WeatherService(this)
        val weatherData = weatherService.generateWeather()

        tvTemperature.text = "${weatherData.temperatura}°C"
        tvWeather.text = weatherData.weather

        val iconRes = when (weatherData.weather) {
            getString(R.string.snowy) -> R.drawable.ic_snowy
            getString(R.string.windy) -> R.drawable.ic_windy
            getString(R.string.stormy) -> R.drawable.ic_stormy
            getString(R.string.rainy) -> R.drawable.ic_rainy
            getString(R.string.cloudy) -> R.drawable.ic_cloudy
            else -> R.drawable.ic_sunny
        }
        ivWeather.setImageResource(iconRes)
    }
}