package com.paw.ecocycle.utils

import android.content.Context
import com.paw.ecocycle.model.MainRepository
import com.paw.ecocycle.model.local.datastore.UserPreference
import com.paw.ecocycle.model.local.datastore.dataStore
import com.paw.ecocycle.model.remote.service.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): MainRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token, context)
        return MainRepository.getInstance(pref, apiService)
    }
}