package com.example.springbootdatatablesserverside.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import javax.persistence.*;

/**
 * @author Gullian Van Der Walt
 * Created at 08:25 on Sep, 2021
 */
@AllArgsConstructor
@Entity
@Table(name = "product")
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

    public Product() {
    }

    @OneToOne(mappedBy = "products")
    @JsonIgnore
    private DataTableState dataTableState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public DataTableState getDataTableState() {
        return dataTableState;
    }

    public void setDataTableState(DataTableState dataTableStates) {
        this.dataTableState = dataTableStates;
    }
}
