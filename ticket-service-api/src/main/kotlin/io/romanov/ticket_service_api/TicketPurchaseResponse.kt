package io.romanov.ticket_service_api

import io.romanov.bonus_service_api.common.PrivilegeShortInfo
import io.romanov.ticket_service_api.common.TicketStatus
import java.time.LocalDateTime
import java.util.*

data class TicketPurchaseResponse(
        val ticketUid: UUID,
        val flightNumber: String,
        val fromAirport: String,
        val toAirport: String,
        val date: LocalDateTime,
        val status: TicketStatus,
        val price: Int,
        val paidByMoney: Int,
        val paidByBonuses: Int,
        val privilege: PrivilegeShortInfo
)
