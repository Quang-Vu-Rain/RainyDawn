package com.store.rainydawn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Orders implements Serializable {

    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="CreateDate", nullable=false)
    private LocalDateTime createDate;
    @Column(name="Address", nullable=false, length=100)
    private String address;
    @OneToMany(mappedBy="orders")
    @JsonIgnore
    private Set<Orderdetails> orderdetails;
    @ManyToOne(optional=false)
    @JoinColumn(name="AccountId", nullable=false)
    @JsonIgnore
    private Accounts accounts;

}
