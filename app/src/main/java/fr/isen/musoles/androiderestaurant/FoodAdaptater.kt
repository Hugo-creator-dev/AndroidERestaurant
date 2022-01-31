package fr.isen.musoles.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.musoles.androiderestaurant.model.food

class FoodAdaptater(private val dishes: List<food>, private val onDishClick : (food) -> Unit) : RecyclerView.Adapter<FoodAdaptater.FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_cell, parent, false)

        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val dish = dishes[position]
        holder.imageView.setImageResource(dish.image)
        holder.textView.text = dish.title
        holder.itemView.setOnClickListener {
            onDishClick(dish)
        }
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    class FoodViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.listImage)
        val textView: TextView = itemView.findViewById(R.id.listTitle)
    }
}