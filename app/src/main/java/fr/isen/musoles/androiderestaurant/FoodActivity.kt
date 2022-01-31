package fr.isen.musoles.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import fr.isen.musoles.androiderestaurant.databinding.ActivityFoodBinding
import fr.isen.musoles.androiderestaurant.model.food

class FoodActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val food : food = intent.getSerializableExtra(FOODTRANSFER) as food
        binding.titlefood.text = food.name_fr
        var listOfIngredients : String = "Ingredients : "
        food.ingredients.forEach { listOfIngredients += "$it ," }
        binding.descfood.text = listOfIngredients
        binding.pricefood.text = food.prices[0].price.toString() + "€"
        if(food.images.isNotEmpty())
            Picasso.with(binding.root.context).load(food.images[0]).into(binding.imagefood)
    }
}