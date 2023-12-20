package com.paw.ecocycle.model.remote.service

import com.paw.ecocycle.model.remote.response.LoginResponse
import com.paw.ecocycle.model.remote.response.ModelResponse
import com.paw.ecocycle.model.remote.response.RegisterResponse
import okhttp3.MultipartBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @Multipart
    @POST("img_classifier_model")
    suspend fun postImage(
        @Part file: MultipartBody.Part,
    ): ModelResponse
}