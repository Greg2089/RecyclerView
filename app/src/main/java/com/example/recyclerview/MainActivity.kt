package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview.adapter.PlantAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Plant

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = PlantAdapter()
    private val imageIdList =
        listOf(
            R.drawable.arhideja,
            R.drawable.clever,
            R.drawable.romaska,
            R.drawable.rose,
            R.drawable.kalendula
        )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAd.setOnClickListener {
                if (index > 4) index = 0
                val plant = Plant(imageIdList[index], "Растение $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }
}