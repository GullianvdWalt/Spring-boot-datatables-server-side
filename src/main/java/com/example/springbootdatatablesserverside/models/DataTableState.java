package com.example.springbootdatatablesserverside.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import javax.persistence.*;

/**
 * @author Gullian Van Der Walt
 * Created at 08:26 on Sep, 2021
 */
@AllArgsConstructor
@Entity
@Table(name = "data_table_state")
public class DataTableState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_table_state_id")
    private Integer id;

    @Lob
    @Column(name = "state_json")
    private String stateJson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "data_table_sate_products",
            joinColumns = { @JoinColumn(name = "data_table_state_id", referencedColumnName = "data_table_state_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
    @JsonIgnore
    private Product product;

    public DataTableState() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateJson() {
        return stateJson;
    }

    public void setStateJson(String stateJson) {
        this.stateJson = stateJson;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
