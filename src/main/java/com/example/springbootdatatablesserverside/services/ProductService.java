package com.example.springbootdatatablesserverside.services;

import com.example.springbootdatatablesserverside.models.Product;

import java.util.List;

/**
 * @author Gullian Van Der Walt
 * Created at 08:32 on Sep, 2021
 */
public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer id);
    void save(Product product);
}
