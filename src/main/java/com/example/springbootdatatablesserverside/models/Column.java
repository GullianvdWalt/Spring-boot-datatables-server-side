package com.example.springbootdatatablesserverside.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gullian Van Der Walt
 * Created at 09:32 on Sep, 2021
 */
@Setter
@Getter
@NoArgsConstructor
public class Column {
    private String data;
    private String name;
    private Boolean searchable;
    private Boolean orderable;
    private Search search;

    public Column(String data) {
        this.data = data;
    }
}
