package fr.isen.musoles.androiderestaurant

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.musoles.androiderestaurant.databinding.ActivityMenuBinding
import fr.isen.musoles.androiderestaurant.model.data
import org.json.JSONObject




const val FOODTRANSFER :String = "myFood"
class MenuActivity : ToolsBar() {
    private lateinit var typeOfEtape : ETAPE
    private lateinit var binding : ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.myToolbar
        super.onCreate(savedInstanceState)
        typeOfEtape = intent.getSerializableExtra(TYPEOFETAPE) as ETAPE
        binding.titleMenu.setText( when(typeOfEtape) {
            ETAPE.MAIN -> R.string.main
            ETAPE.STARTER -> R.string.starter
            ETAPE.DESSERT -> R.string.dessert
        })
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST,
            "http://test.api.catering.bluecodegames.com/menu",
            JSONObject("{\"id_shop\":\"1\"}"),
            { response ->
                val responseObj = Gson().fromJson(response.toString(), data::class.java)
                binding.recyclerView.adapter = responseObj.data.find {
                    it.name_fr == when(typeOfEtape) {
                        ETAPE.MAIN -> "Plats"
                        ETAPE.STARTER -> "Entrées"
                        ETAPE.DESSERT -> "Desserts"
                    }
                }?.let {
                    FoodAdaptater(
                        it.items
                    ) {
                        val intent = Intent(this, FoodActivity::class.java).apply {
                            putExtra(FOODTRANSFER, it)
                        }
                        startActivity(intent)
                    }
                }
            },
            { error ->
                error.printStackTrace()
            }
        )
        Volley.newRequestQueue(this).add(jsonObjectRequest)

    }
}