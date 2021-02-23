package com.SRB.conduit.data

import com.srb.ConduitClient
import com.srb.models.entities.LoginData
import com.srb.models.entities.SignupData
import com.srb.models.entities.User
import com.srb.models.entities.UserUpdateData
import com.srb.models.requsets.LoginRequest
import com.srb.models.requsets.SignupRequest
import com.srb.models.requsets.UserUpdateRequest


object UserRepo {
    val api = ConduitClient.publicApi
    val authAPI = ConduitClient.authApi

    suspend fun login(email: String, password: String): User? {
        val response = api.loginUser(LoginRequest(LoginData(email, password)))

        // TODO: Save it in SharedPreferences
        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user
    }

    suspend fun signup(username: String, email: String, password: String): User? {
        val response = api.signupUser(SignupRequest(SignupData(
                email, password, username
        )))

        // TODO: Save it in SharedPreferences
        ConduitClient.authToken = response.body()?.user?.token

        return response.body()?.user

    }

    suspend fun getCurrentUser(token: String): User? {
        ConduitClient.authToken = token
        return authAPI.getCurrentUser().body()?.user
    }

    suspend fun updateUser(
            bio: String?,
            username: String?,
            image: String?,
            email: String?,
            password: String?
    ): User? {
        val response = authAPI.updateCurrentUser(UserUpdateRequest(UserUpdateData(
                bio, email, image, username, password
        )))

        return response.body()?.user
    }

    suspend fun getUserProfile() = authAPI.getCurrentUser().body()?.user

}