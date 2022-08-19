package com.store.rainydawn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Roles implements Serializable {

    protected static final String PK = "id";

    @Id

    @Column(name="Id", unique=true, nullable=false, length=10)
    private String id;
    @Column(name="Name", nullable=false, length=50)
    private String name;
    @ManyToMany(mappedBy="roles")
    @JsonIgnore
    private Set<Accounts> accounts;

}
