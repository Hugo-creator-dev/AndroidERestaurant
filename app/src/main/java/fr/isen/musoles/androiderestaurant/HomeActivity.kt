package fr.isen.musoles.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.musoles.androiderestaurant.databinding.ActivityHomeBinding

const val TYPEOFETAPE :String = "typeofetape"

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.starter.setOnClickListener {
            getMenu(ETAPE.STARTER)
        }
        binding.main.setOnClickListener {
            getMenu(ETAPE.MAIN)
        }
        binding.dessert.setOnClickListener {
            getMenu(ETAPE.DESSERT)
        }
    }

    private fun getMenu(type : ETAPE)
    {
        val intent = Intent(this, MenuActivity::class.java).apply {
            putExtra(TYPEOFETAPE, type)
        }
        startActivity(intent)
    }
}