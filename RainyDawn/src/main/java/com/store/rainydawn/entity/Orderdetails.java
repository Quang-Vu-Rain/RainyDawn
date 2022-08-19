package com.store.rainydawn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orderdetails")
public class Orderdetails implements Serializable {

    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="Price", nullable=false, precision=22)
    private double price;
    @Column(name="Quantity", nullable=false, precision=10)
    private int quantity;
    @ManyToOne(optional=false)
    @JoinColumn(name="OrderId", nullable=false)
    @JsonIgnore
    private Orders orders;
    @ManyToOne(optional=false)
    @JoinColumn(name="ProductId", nullable=false)
    @JsonIgnore
    private Products products;

}
