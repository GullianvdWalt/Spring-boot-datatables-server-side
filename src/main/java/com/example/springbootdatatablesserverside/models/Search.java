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
public class Search {
    private String value;
    private String regexp;
}
