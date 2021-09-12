package com.example.springbootdatatablesserverside.models;

import lombok.*;

/**
 * @author Gullian Van Der Walt
 * Created at 09:32 on Sep, 2021
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    private Integer column;
    private Direction dir;
}
