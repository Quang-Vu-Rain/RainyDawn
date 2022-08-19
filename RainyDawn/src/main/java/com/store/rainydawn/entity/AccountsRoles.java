package com.store.rainydawn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts_roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"accounts_id", "roles_id"})})
public class AccountsRoles implements Serializable {

    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false, precision = 10)
    private int id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "accounts_id", nullable = false)
    private Accounts accounts;
    @ManyToOne(optional = false)
    @JoinColumn(name = "roles_id", nullable = false)
    private Roles roles;

}
