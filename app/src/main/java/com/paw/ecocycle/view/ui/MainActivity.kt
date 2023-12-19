package com.paw.ecocycle.view.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.paw.ecocycle.R
import com.paw.ecocycle.databinding.ActivityMainBinding
import com.paw.ecocycle.view.viewmodel.MainViewModel
import com.paw.ecocycle.view.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var factory: ViewModelFactory
//    private val viewModel: MainViewModel by viewModels { factory }
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private var isExpanded = false
    private val fromBottomfabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom_fab)
    }
    private val toBottomfabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom_fab)
    }
    private val rotateClockWiseAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_clock_wise)
    }
    private val rotateAntiClockWiseAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_anti_clock_wise)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "My Store"
        //setupView()
//        viewModel.getSession().observe(this) { user ->
//            binding.tvHello.text = "Hello, ${user.name}"
//        }
        binding.fabMenu.setOnClickListener {
            if (isExpanded) {
                shrinkFab()
            } else {
                expandFab()
            }
        }
        binding.btnStartRecycle.setOnClickListener {
            binding.fabMenu.performClick()
        }
    }

    private fun shrinkFab() {
        binding.fabMenu.startAnimation(rotateAntiClockWiseAnim)
        binding.fabCamera.startAnimation(toBottomfabAnim)
        binding.fabGallery.startAnimation(toBottomfabAnim)
        isExpanded = !isExpanded
    }

    private fun expandFab() {
        binding.fabMenu.startAnimation(rotateClockWiseAnim)
        binding.fabCamera.startAnimation(fromBottomfabAnim)
        binding.fabGallery.startAnimation(fromBottomfabAnim)
        isExpanded = !isExpanded
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_1 -> {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
            }

            R.id.menu_2 -> {
                viewModel.logout()
            }
        }
        return true
    }
}