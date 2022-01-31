package fr.isen.musoles.androiderestaurant.model

import java.io.Serializable

data class price(val id : Int, val id_pizza: Int, val price : Double, val create_date : String,val update_date : String,val size: String) : Serializable {

}
