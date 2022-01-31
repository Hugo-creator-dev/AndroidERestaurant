package fr.isen.musoles.androiderestaurant.model

import java.io.Serializable

data class food(val id : Int,val name_fr : String,val name_en : String,val id_category : Int,val categ_name_fr : String,val categ_name_en : String,val images : List<String>, val ingredients : List<composant>, val prices : List<price>) : Serializable {

}
