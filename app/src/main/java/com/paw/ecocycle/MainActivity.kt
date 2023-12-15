package com.paw.ecocycle

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.isVisible
import com.paw.ecocycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Dashboard"
        //setupView()
        setupFab()
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

    private fun setupFab() {
        binding.fabMenu.shrink()
        binding.fabMenu.setOnClickListener(this)
        binding.fabCamera.setOnClickListener(this)
        binding.fabGallery.setOnClickListener(this)
    }

    private fun expandOrCollapse() {
        if (binding.fabMenu.isExtended) {
            binding.fabMenu.shrink()
            binding.fabCamera.hide()
            binding.fabCameraText.visibility = View.GONE
            binding.fabGallery.hide()
            binding.fabGalleryText.visibility = View.GONE
        } else {
            binding.fabMenu.extend()
            binding.fabCamera.show()
            binding.fabCameraText.visibility = View.VISIBLE
            binding.fabGallery.show()
            binding.fabGalleryText.visibility = View.VISIBLE

        }
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

            }
        }
        return true
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.fab_menu -> {
                expandOrCollapse()
            }
            R.id.fab_camera -> {
                Toast.makeText(this, "it is add from camera", Toast.LENGTH_SHORT).show()
            }
            R.id.fab_gallery -> {
                Toast.makeText(this, "it is add from gallery", Toast.LENGTH_SHORT).show()
            }
        }
    }
}