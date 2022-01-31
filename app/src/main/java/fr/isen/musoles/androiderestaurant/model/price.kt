package fr.isen.musoles.androiderestaurant.model

import fr.isen.musoles.androiderestaurant.DEVISE
import java.io.Serializable

data class price(val number : Int, val devise : DEVISE) : Serializable {
    override fun toString(): String {
        return "$number " + when(devise) {
            DEVISE.EURO -> "€"
            DEVISE.DOLLAR -> "$"
        }
    }
}
