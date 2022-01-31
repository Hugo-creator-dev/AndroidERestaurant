package fr.isen.musoles.androiderestaurant.model

import java.io.Serializable

data class composant(val id : Int,val id_shop: Int, val name_fr : String,val name_en : String,val create_date : String,val update_date : String,val id_pizza : Int) : Serializable
{
    override fun toString(): String {
        return name_fr
    }
}
