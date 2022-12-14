package io.romanov.ticketservice.feign

import io.romanov.bonus_service_api.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

@ReactiveFeignClient(name = "\${app.service.bonusService.name}", url = "\${app.service.gateway.baseUrl}/api/v1/privilege")
interface BonusServiceApi {
    @GetMapping
    fun getPrivilegeInfo(
        @RequestHeader(name = "X-User-Name") username: String
    ): Mono<ResponseEntity<Mono<PrivilegeInfoResponse>>>

    @PostMapping("/pay")
    fun payWithBonuses(
        @RequestHeader(name = "X-User-Name") username: String,
        @RequestBody request: PayWithBonusesRequest
    ): Mono<ResponseEntity<Mono<PayWithBonusesResponse>>>

    @PostMapping("/fill")
    fun fillBonuses(
        @RequestHeader(name = "X-User-Name") username: String,
        @RequestBody request: FillBonusesRequest
    ): Mono<ResponseEntity<Mono<FillBonusesResponse>>>

    @PostMapping("/cancel")
    fun cancelBonusOperation(
        @RequestHeader(name = "X-User-Name") username: String,
        @RequestBody request: CancelBonusesRequest
    ): Mono<ResponseEntity<Mono<Unit>>>
}