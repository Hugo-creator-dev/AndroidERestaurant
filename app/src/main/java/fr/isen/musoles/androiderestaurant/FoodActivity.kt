package fr.isen.musoles.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.musoles.androiderestaurant.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*val dish : DishModel = intent.getSerializableExtra(TITLE_DISH) as DishModel
        binding.dishTitle.text = dish.title
        binding.dishDescription.text = dish.description
        binding.dishPrice.text = dish.price
        binding.dishImage.setImageResource(dish.image)*/

    }
}