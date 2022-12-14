package io.romanov.userservice.controller

import io.romanov.user_service_api.UserInfoResponse
import io.romanov.userservice.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {
    @GetMapping("/me")
    suspend fun getUserInfo(
        @RequestHeader(name = "X-User-Name", required = true) username: String
    ): ResponseEntity<UserInfoResponse> = ResponseEntity.ok(userService.getUserInfo(username))
}