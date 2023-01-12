package io.romanov.user_service_api

import io.romanov.bonus_service_api.common.PrivilegeShortInfo
import io.romanov.ticket_service_api.TicketResponse

data class UserInfoResponse(
        val tickets: List<TicketResponse>,
        val privilege: PrivilegeShortInfo?
)
