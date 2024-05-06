package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavigation.setupWithNavController(navController)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.drawerlayout, R.string.nav_open, R.string.nav_close)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.drawerNav.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.homeFragment->{
                    binding.drawerlayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.catagoryFragment->{
                    binding.drawerlayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.profielFragment->{
                    binding.drawerlayout.closeDrawers()
                    binding.drawerNav.setupWithNavController(navController)
                }
                R.id.Settings->{
                    binding.drawerlayout.closeDrawers()
                    Toast.makeText(this, "Enable Dark Theme", Toast.LENGTH_SHORT).show()
                }
                R.id.logout->{
                    binding.drawerlayout.closeDrawers()
                    Toast.makeText(this, "Enable Light Theme", Toast.LENGTH_SHORT).show()
                }
                R.id.logout->{
                    binding.drawerlayout.closeDrawers()
                    Toast.makeText(this, "you are logged out", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            true
        }else super.onOptionsItemSelected(item)
    }



}