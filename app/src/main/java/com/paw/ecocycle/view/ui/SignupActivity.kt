package com.paw.ecocycle.view.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.view.isVisible
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.api.ApiException
//import com.google.firebase.Firebase
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.GoogleAuthProvider
//import com.google.firebase.auth.auth
import com.paw.ecocycle.databinding.ActivitySignupBinding
import com.paw.ecocycle.utils.ResultState
import com.paw.ecocycle.utils.showToast
import com.paw.ecocycle.view.viewmodel.SignupViewModel
import com.paw.ecocycle.view.viewmodel.ViewModelFactory

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var factory: ViewModelFactory
    private val viewmodel: SignupViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //setupView()
        playAnimation()
        setupAction()
        setupViewModel()
    }

    private fun setupViewModel() {
        factory = ViewModelFactory.getInstance(this)
    }

    private fun setupAction() {
        binding.btnSignup.setOnClickListener {
            with(binding) {
                val name = edSignupName.text.toString()
                val email = edSignupEmail.text.toString()
                val password = edSignupPassword.text.toString()

                viewmodel.register(name, email, password).observe(this@SignupActivity) { response ->
                    when (response) {
                        ResultState.Loading -> {
                            pbSignup.isVisible = true
                        }

                        is ResultState.Error -> {
                            pbSignup.isVisible = false
                            showToast(response.error)
                        }

                        is ResultState.Success -> {
                            pbSignup.isVisible = false
                            showToast("Anda Berhasil Membuat Akun, Silahkan Login")
                            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
//                            val toLogin =
//                                Intent(this@SignupActivity, LoginActivity::class.java)
//                            startActivity(toLogin)
                        }

                        else -> {}
                    }
                }
            }
        }
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

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imgSignup, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val username = ObjectAnimator.ofFloat(binding.tlSignupName, View.ALPHA, 1f).setDuration(100)
        val email =
            ObjectAnimator.ofFloat(binding.tlSignupEmail, View.ALPHA, 1f).setDuration(100)
        val password =
            ObjectAnimator.ofFloat(binding.tlSignupPassword, View.ALPHA, 1f).setDuration(100)
        val signup = ObjectAnimator.ofFloat(binding.btnSignup, View.ALPHA, 1f).setDuration(100)


        AnimatorSet().apply {
            playSequentially(
                username,
                email,
                password,
                signup
            )
            startDelay = 100
        }.start()
    }
}
