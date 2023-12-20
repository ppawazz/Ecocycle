package com.paw.ecocycle.model.remote.dummy

import com.paw.ecocycle.model.remote.response.LoginResponse
import com.paw.ecocycle.model.remote.response.LoginResult

object dummyUser {
    fun dummyLoginResponse(): LoginResponse {
        val loginResult = LoginResult(
            name = "Dummy",
            userId = "12345",
            token = "67892"
        )
        return LoginResponse(
            loginResult = loginResult,
            error = false,
            message = "Succes"
        )
    }
}