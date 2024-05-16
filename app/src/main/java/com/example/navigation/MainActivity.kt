package com.example.navigation

import android.os.Bundle
import android.view.MenuItem
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
/*setContentView(R.layout.activity_main)*/



/*tabLayout = binding.tabLayout
viewPager = binding.viewpage

adapter = PageAdapter(supportFragmentManager, lifecycle)

viewPager.adapter = adapter

TabLayoutMediator(tabLayout, viewPager) { tab, position ->
    tab.text = when (position) {
        0 -> "Send"
        1 -> "Receive"
        else -> "Tab $position"
    }
}.attach()*/

/*private lateinit var tabLayout: TabLayout
private lateinit var viewPager: ViewPager2
private lateinit var adapter: PageAdapter*/


/*private lateinit var tabLayout: TabLayout
private lateinit var viewPager: ViewPager
private lateinit var adapter: PageAdapter
*/



