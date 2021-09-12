package com.example.springbootdatatablesserverside.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Gullian Van Der Walt
 * Created at 09:34 on Sep, 2021
 */
@Getter
@Setter
@NoArgsConstructor
public class Page<T> {

    public Page(List<T> data) {
        this.data = data;
    }

    private List<T> data;
    private int recordsFiltered;
    private int recordsTotal;
    private int draw;
}
