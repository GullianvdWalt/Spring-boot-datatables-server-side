package com.example.springbootdatatablesserverside.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Gullian Van Der Walt
 * Created at 09:35 on Sep, 2021
 */
@Getter
@Setter
@NoArgsConstructor
public class PageArray {
    private List<List<String>> data;
    private int recordsFiltered;
    private int recordsTotal;
    private int draw;
}
