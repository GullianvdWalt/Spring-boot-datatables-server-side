package com.example.springbootdatatablesserverside.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * @author Gullian Van Der Walt
 * Created at 08:25 on Sep, 2021
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private Double price;
    private Integer units;

    @OneToOne(mappedBy = "product")
    @JsonIgnore
    private DataTableState dataTableState;

    public Product() {
    }
}
