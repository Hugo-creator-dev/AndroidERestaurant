package fr.isen.musoles.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.isen.musoles.androiderestaurant.databinding.ActivityFoodBinding
import fr.isen.musoles.androiderestaurant.model.food
import fr.isen.musoles.androiderestaurant.model.shop
import java.io.File
import java.io.FileOutputStream

class FoodActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFoodBinding
    private lateinit var shop : shop
    private lateinit var food : food
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        food = intent.getSerializableExtra(FOODTRANSFER) as food
        binding.titlefood.text = food.name_fr
        var listOfIngredients : String = "Ingredients : "
        food.ingredients.forEach { listOfIngredients += "$it ," }
        binding.descfood.text = listOfIngredients
        shop = shop(food.id,0)
        pluss()
        binding.carouselView.pageCount = food.images.size
        binding.carouselView.setImageListener { position, imageView ->
            Picasso.with(imageView.context).load(food.images[position].ifEmpty { "https://th.bing.com/th/id/R.05eb1eff72a56a17dea26091dbb1fdd3?rik=zMv%2bXo9leg9laQ&pid=ImgRaw&r=0" }).placeholder(R.drawable.abc_vector_test).into(imageView)
        }
        binding.plus.setOnClickListener { pluss() }
        binding.less.setOnClickListener { less() }
        binding.pricefood.setOnClickListener { save() }
    }

    fun pluss()
    {
        shop.quantity+=1
        binding.pricefood.text = (shop.quantity * food.prices[0].price).toString() + "€"
        binding.totalfood.text = shop.quantity.toString()
    }

    fun less()
    {
        if(shop.quantity > 1) {
            shop.quantity-=1
            binding.pricefood.text = (shop.quantity * food.prices[0].price).toString() + "€"
            binding.totalfood.text = shop.quantity.toString()
        }
    }

    fun save()
    {
        var file : File = File(cacheDir,"data.json")
        var all : List<shop> = ArrayList<shop>()

        if(!file.exists())
        {
            file.createNewFile()
        }
        else
        {
            all = Gson().fromJson(file.readText(),List::class.java) as List<shop>
        }
        all + shop
        file.writeText(Gson().toJson(all))
        finish()
    }
}