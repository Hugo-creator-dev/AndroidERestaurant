package fr.isen.musoles.androiderestaurant.model

import java.io.Serializable

data class food(val image : Int, val title : String, val description : String, val price : price) : Serializable {

}
