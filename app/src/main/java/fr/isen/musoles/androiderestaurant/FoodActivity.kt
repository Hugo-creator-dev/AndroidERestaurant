package fr.isen.musoles.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.musoles.androiderestaurant.databinding.ActivityFoodBinding
import fr.isen.musoles.androiderestaurant.model.food

class FoodActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val food : food = intent.getSerializableExtra(FOODTRANSFER) as food
        binding.titlefood.text = food.title
        binding.descfood.text = food.description
        binding.pricefood.text = food.price.toString()
        binding.imagefood.setImageResource(food.image)
    }
}