package fr.isen.musoles.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.musoles.androiderestaurant.databinding.ActivityMenuBinding
import fr.isen.musoles.androiderestaurant.model.food
import fr.isen.musoles.androiderestaurant.model.price

class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    private lateinit var typeOfEtape : ETAPE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        typeOfEtape = intent.getSerializableExtra(TYPEOFETAPE) as ETAPE
        binding.titleMenu.setText( when(typeOfEtape) {
            ETAPE.MAIN -> R.string.main
            ETAPE.STARTER -> R.string.starter
            ETAPE.DESSERT -> R.string.dessert
        })
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val food = ArrayList<food>()
        food.add(food(R.drawable.abc_vector_test,"miam","oui", price(5,DEVISE.EURO)))
        food.add(food(R.drawable.abc_vector_test,"ouf","oui", price(5,DEVISE.EURO)))
        binding.recyclerView.adapter = FoodAdaptater(food) {
            val intent = Intent(this, FoodActivity::class.java).apply {
                putExtra("title", it)
            }
            startActivity(intent)
        }
    }
}