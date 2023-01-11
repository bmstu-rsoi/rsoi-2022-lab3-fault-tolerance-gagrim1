package com.romanov.privilege.repository;

import com.romanov.privilege.model.PrivilegeHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrivilegeHistoryRepository extends JpaRepository<PrivilegeHistoryEntity, Integer> {
    Optional<PrivilegeHistoryEntity> findByTicketUid(UUID ticketUid);
    List<PrivilegeHistoryEntity> findAllByPrivilegeId(Integer privilegeId);
}
