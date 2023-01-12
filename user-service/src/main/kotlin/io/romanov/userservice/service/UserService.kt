package io.romanov.userservice.service

import io.romanov.user_service_api.UserInfoResponse

interface UserService {
    suspend fun getUserInfo(username: String): UserInfoResponse
}