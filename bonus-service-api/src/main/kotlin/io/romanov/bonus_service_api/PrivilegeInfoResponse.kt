package io.romanov.bonus_service_api

import io.romanov.bonus_service_api.common.BalanceHistory
import io.romanov.bonus_service_api.common.PrivilegeStatus

data class PrivilegeInfoResponse(
        val balance: Int,
        val status: PrivilegeStatus,
        val history: List<BalanceHistory>
)
