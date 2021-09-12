package com.example.springbootdatatablesserverside.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Gullian Van Der Walt
 * Created at 09:31 on Sep, 2021
 */
@Setter
@Getter
@NoArgsConstructor
public class PageRequest {
    private int start;
    private int length;
    private int draw;
    private List<Order> order;
    private List<Column> columns;
    private Search search;
}
