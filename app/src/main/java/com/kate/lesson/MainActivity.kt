package com.kate.lesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    navController = navHostFragment.navController
    navController.addOnDestinationChangedListener { _, destination, _ ->
      binding.bottomNavView.isVisible = destination.id == R.id.todayFragment ||
          destination.id == R.id.weeklyFragment ||
          destination.id == R.id.monthlyFragment ||
          destination.id == R.id.yesterdayFragment
    }

    binding.bottomNavView.setupWithNavController(navController)
    setupActionBarWithNavController(navController)
  }

  /**
   * Enables back button support. Simply navigates one element up on the stack.
   */
  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp() || super.onSupportNavigateUp()
  }

}