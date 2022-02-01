package fr.isen.musoles.androiderestaurant

import android.content.Intent
import android.os.Bundle
import fr.isen.musoles.androiderestaurant.databinding.ActivityHomeBinding
import fr.isen.musoles.androiderestaurant.databinding.ActivityMenuBinding

const val TYPEOFETAPE :String = "typeofetape"

class HomeActivity : ToolsBar() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.myToolbar
        super.onCreate(savedInstanceState)

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