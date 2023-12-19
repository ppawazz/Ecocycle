package com.paw.ecocycle.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.paw.ecocycle.R
import com.paw.ecocycle.view.viewmodel.SplashViewModel
import com.paw.ecocycle.view.viewmodel.ViewModelFactory

class Splash_Activity : AppCompatActivity() {

//    private lateinit var factory: ViewModelFactory
//    private val viewModel: SplashViewModel by viewModels { factory }
    private val viewModel by viewModels<SplashViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({

            viewModel.getSession().observe(this) { user ->
                if (!user.isLogin) {
                    startActivity(Intent(this, StartActivity::class.java))
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            finish()
        }, SPLASH_TIME)

        //setupViewModel()

    }

//    private fun setupViewModel() {
//        factory = ViewModelFactory.getInstance(this)
//    }

    companion object {
        const val SPLASH_TIME = 3000L
    }
}