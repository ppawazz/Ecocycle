package com.paw.ecocycle.model.local.datastore

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)