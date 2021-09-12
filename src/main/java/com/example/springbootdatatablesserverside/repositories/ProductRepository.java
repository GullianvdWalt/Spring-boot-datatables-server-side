package com.example.springbootdatatablesserverside.repositories;

import com.example.springbootdatatablesserverside.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Gullian Van Der Walt
 * Created at 08:30 on Sep, 2021
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
