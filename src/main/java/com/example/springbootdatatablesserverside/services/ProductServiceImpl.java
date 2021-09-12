package com.example.springbootdatatablesserverside.services;

import com.example.springbootdatatablesserverside.models.*;
import com.example.springbootdatatablesserverside.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Gullian Van Der Walt
 * Created at 08:32 on Sep, 2021
 */
@Slf4j
@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    private static final Comparator<Product> EMPTY_COMPARATOR = (e1, e2) -> 0;

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts(PageRequest pageRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Product> products = productRepository.findAll();

            return getPage(products, pageRequest);

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return new Page<>();
    }

    private Page<Product> getPage(List<Product> products, PageRequest pageRequest) {
        List<Product> fProducts = products.stream()
                .sorted(sortEmployees(pagingRequest))
                .filter(filterEmployees(pagingRequest))
                .skip(pagingRequest.getStart())
                .limit(pagingRequest.getLength())
                .collect(Collectors.toList());

        long count = employees.stream()
                .filter(filterEmployees(pagingRequest))
                .count();

        Page<Employee> page = new Page<>(filtered);
        page.setRecordsFiltered((int) count);
        page.setRecordsTotal((int) count);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }

    private Predicate<Product> filterEmployees(PageRequest pageRequest) {
        if (pageRequest.getSearch() == null || StringUtils.isEmpty(pageRequest.getSearch()
                .getValue())) {
            return product -> true;
        }

        String value = pageRequest.getSearch()
                .getValue();

        return product -> product.getName().toLowerCase().contains(value)
                || product.getDescription().toLowerCase().contains(value)
                || product.getBrand().toLowerCase().contains(value);
    }

    private Comparator<Product> sortEmployees(PageRequest pageRequest) {
        if (pageRequest.getOrder() == null) {
            return EMPTY_COMPARATOR;
        }

        try {
            Order order = pageRequest.getOrder()
                    .get(0);

            int columnIndex = order.getColumn();

            Column column = pageRequest.getColumns().get(columnIndex);

            Comparator<Product> comparator = ProductComparators.getComparator(column.getData(), order.getDir());
            if (comparator == null) {
                return EMPTY_COMPARATOR;
            }

            return comparator;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return EMPTY_COMPARATOR;
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.getById(id);
    }
}
