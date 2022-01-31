package fr.isen.musoles.androiderestaurant

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.musoles.androiderestaurant.databinding.ActivityFoodFragmentBinding
import fr.isen.musoles.androiderestaurant.model.food

class FoodAdaptater(private val dishes: List<food>, private val onFoodClick : (food) -> Unit) : RecyclerView.Adapter<FoodAdaptater.FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = ActivityFoodFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(view)
    }
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = dishes[position]
        if(food.images[0].isNotEmpty()) {
            Picasso.with(holder.itemView.context).load(food.images[0]).into(holder.imageView)
        }
        holder.textView.text = food.name_fr
        holder.priceView.text = food.prices[0].price.toString() + "€"
        holder.itemView.setOnClickListener {
            onFoodClick(food)
        }
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    class FoodViewHolder(ItemView: ActivityFoodFragmentBinding) : RecyclerView.ViewHolder(ItemView.root) {
        val imageView: ImageView = ItemView.fragImg
        val textView: TextView = ItemView.fragTitle
        val priceView: TextView = ItemView.fragPrice
    }
}