package com.example.springbootdatatablesserverside.repositories;

import com.example.springbootdatatablesserverside.models.DataTableState;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gullian Van Der Walt
 * Created at 08:30 on Sep, 2021
 */
public interface DataTableStateRepository  extends JpaRepository<DataTableState, Integer> {
}
