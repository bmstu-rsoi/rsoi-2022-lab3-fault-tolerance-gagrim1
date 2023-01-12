package io.romanov.bonus_service_api

import io.romanov.bonus_service_api.common.PrivilegeShortInfo

data class FillBonusesResponse(
    val filledBonuses: Int,
    val privilege: PrivilegeShortInfo
)
