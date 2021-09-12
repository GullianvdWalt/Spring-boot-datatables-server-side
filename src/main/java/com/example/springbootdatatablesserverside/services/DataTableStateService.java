package com.example.springbootdatatablesserverside.services;

import com.example.springbootdatatablesserverside.models.DataTableState;

import java.util.List;

/**
 * @author Gullian Van Der Walt
 * Created at 08:32 on Sep, 2021
 */
public interface DataTableStateService {
    void saveState(DataTableState dataTablesState);
    DataTableState findDataTableState(Integer id);
    List<DataTableState> getDataTableStates();
    String getStateByProductId(int id);
}
