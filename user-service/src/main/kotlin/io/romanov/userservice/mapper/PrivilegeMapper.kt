package io.romanov.userservice.mapper

import io.romanov.bonus_service_api.PrivilegeInfoResponse
import io.romanov.bonus_service_api.common.PrivilegeShortInfo

fun PrivilegeInfoResponse.toPrivilegeShortInfo() = PrivilegeShortInfo(
    balance = balance,
    status = status
)