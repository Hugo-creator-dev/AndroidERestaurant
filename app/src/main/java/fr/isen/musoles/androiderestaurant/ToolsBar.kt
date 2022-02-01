package fr.isen.musoles.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


abstract class ToolsBar : AppCompatActivity() {
    open protected lateinit var toolBar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolBar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        menu.findItem(R.id.nbr)?.title = getSharedPreferences("info", 0).getInt("nbr",0).toString()
        return super.onCreateOptionsMenu(menu)
    }
    override fun onResume() {
        toolBar.menu.findItem(R.id.nbr)?.title = getSharedPreferences("info", 0).getInt("nbr",0).toString()
        super.onResume()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.store -> {
                val intent = Intent(this, FoodActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}