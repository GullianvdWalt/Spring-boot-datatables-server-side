package com.example.springbootdatatablesserverside.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gullian Van Der Walt
 * Created at 09:55 on Sep, 2021
 */
public class ProductComparators {

    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }

    static Map<Key, Comparator<Product>> map = new HashMap<>();

    static {
        map.put(new Key("name", Direction.ASC), Comparator.comparing(Product::getName));
        map.put(new Key("name", Direction.DESC), Comparator.comparing(Product::getName).reversed());

        map.put(new Key("description", Direction.ASC), Comparator.comparing(Product::getDescription));
        map.put(new Key("description", Direction.DESC), Comparator.comparing(Product::getDescription).reversed());

        map.put(new Key("brand", Direction.ASC), Comparator.comparing(Product::getBrand));
        map.put(new Key("brand", Direction.DESC), Comparator.comparing(Product::getBrand).reversed());


        map.put(new Key("price", Direction.ASC), Comparator.comparing(Product::getPrice));
        map.put(new Key("price", Direction.DESC), Comparator.comparing(Product::getPrice).reversed());

        map.put(new Key("units", Direction.ASC), Comparator.comparing(Product::getUnits));
        map.put(new Key("units", Direction.DESC), Comparator.comparing(Product::getUnits).reversed());
    }

    public static Comparator<Product> getComparator(String name, Direction dir) {
        return map.get(new Key(name, dir));
    }


    public ProductComparators() {
    }
}
