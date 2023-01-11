package com.romanov.privilege.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class PrivilegeOutput {
    private String status;
    private Integer balance;
}
