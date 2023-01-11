package com.romanov.privilege.model.mapper;

import com.romanov.privilege.model.PrivilegeEntity;
import com.romanov.privilege.model.dto.PrivilegeOutput;
import org.springframework.stereotype.Component;

@Component
public class PrivilegeMapper {
    public PrivilegeOutput convert(PrivilegeEntity entity) {
        return PrivilegeOutput.builder()
                .balance(entity.getBalance())
                .status(entity.getStatus())
                .build();
    }
}
