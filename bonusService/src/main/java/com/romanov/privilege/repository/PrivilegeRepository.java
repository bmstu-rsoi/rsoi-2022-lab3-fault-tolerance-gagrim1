package com.romanov.privilege.repository;

import com.romanov.privilege.model.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, Integer> {
    Optional<PrivilegeEntity> findByUsername(String username);
    @Query("UPDATE PrivilegeEntity p SET p.balance = p.balance + :value WHERE p.id = :id")
    @Modifying(clearAutomatically = true)
    Integer deposit(@Param("id") Integer id, @Param("value") Integer value);
}
