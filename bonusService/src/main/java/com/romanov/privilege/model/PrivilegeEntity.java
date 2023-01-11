package com.romanov.privilege.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "privilege")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "status", nullable = false, columnDefinition = "BRONZE")
    private String status;
    @Column(name = "balance")
    private Integer balance;
}
