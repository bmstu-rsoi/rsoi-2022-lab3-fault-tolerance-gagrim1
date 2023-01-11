package com.romanov.privilege.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "privilege_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PrivilegeHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privilege_id")
    private PrivilegeEntity privilege;
    @Column(name = "ticket_uid", nullable = false)
    private UUID ticketUid;
    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "balance_diff", nullable = false)
    private Integer balanceDiff;
    @Column(name = "operation_type", nullable = false)
    private String operationType;
}
