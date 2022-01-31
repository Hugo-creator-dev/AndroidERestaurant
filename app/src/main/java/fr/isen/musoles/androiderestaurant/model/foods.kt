package fr.isen.musoles.androiderestaurant.model

import java.io.Serializable

data class foods(val name_fr: String, val name_en : String, val items : List<food>) : Serializable
{

}
