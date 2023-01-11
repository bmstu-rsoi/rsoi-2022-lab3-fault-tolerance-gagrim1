package com.romanov.privilege.model.dto;

import lombok.Data;

@Data
public class BonusOutput {
    private Integer paidByMoney;
    private Integer paidByBonuses;
    private PrivilegeOutput privilege;
}
