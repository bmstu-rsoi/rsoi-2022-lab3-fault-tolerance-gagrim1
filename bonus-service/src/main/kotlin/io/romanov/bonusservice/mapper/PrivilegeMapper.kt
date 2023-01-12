package io.romanov.bonusservice.mapper

import io.romanov.bonus_service_api.PrivilegeInfoResponse
import io.romanov.bonus_service_api.common.BalanceHistory
import io.romanov.bonus_service_api.common.PrivilegeShortInfo
import io.romanov.bonusservice.domain.PrivilegeEntity

fun PrivilegeEntity.toPrivilegeInfoResponse(history: List<BalanceHistory>) = PrivilegeInfoResponse(
    balance = balance,
    status = status,
    history = history
)

fun PrivilegeEntity.toPrivilegeShortInfo() = PrivilegeShortInfo(
    balance = balance,
    status = status
)
