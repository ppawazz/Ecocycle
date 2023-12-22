package com.paw.ecocycle.model.remote.service

import com.paw.ecocycle.model.remote.request.LoginRequest
import com.paw.ecocycle.model.remote.request.RegisterRequest
import com.paw.ecocycle.model.remote.response.LoginResponse
import com.paw.ecocycle.model.remote.response.RegisterResponse
import com.paw.ecocycle.model.remote.response.UploadResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @POST("register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @Multipart
    @POST("postimage")
    suspend fun postImage(
        @Part file: MultipartBody.Part,
    ): UploadResponse
}