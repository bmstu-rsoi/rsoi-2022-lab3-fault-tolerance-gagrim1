package io.romanov.bonusservice.mapper

import io.romanov.bonus_service_api.common.BalanceHistory
import io.romanov.bonusservice.domain.PrivilegeHistoryEntity

fun PrivilegeHistoryEntity.toBalanceHistory() = BalanceHistory(
    date = dateTime,
    balanceDiff = balanceDiff,
    ticketUid = ticketUid,
    operationType = operationType
)