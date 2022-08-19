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
@Table(name="products")
public class Products implements Serializable {

    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="Name", nullable=false, length=50)
    private String name;
    @Column(name="Image", nullable=false, length=50)
    private String image;
    @Column(name="Price", nullable=false, precision=22)
    private double price;
    @Column(name="CreateDate", nullable=false)
    private LocalDateTime createDate;
    @Column(name="Available", nullable=false, length=3)
    private boolean available;
    @OneToMany(mappedBy="products")
    @JsonIgnore
    private Set<Orderdetails> orderdetails;
    @ManyToOne(optional=false)
    @JoinColumn(name="CategoryId", nullable=false)
    @JsonIgnore
    private Categories categories;

}
