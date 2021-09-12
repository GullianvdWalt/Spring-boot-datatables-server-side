package com.example.springbootdatatablesserverside.services;

import com.example.springbootdatatablesserverside.models.DataTableState;
import com.example.springbootdatatablesserverside.models.Product;
import com.example.springbootdatatablesserverside.repositories.DataTableStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gullian Van Der Walt
 * Created at 08:33 on Sep, 2021
 */
@Service("DataTablesStatesService")
public class DataTableStateServiceImpl implements DataTableStateService{

    private final DataTableStateRepository dataTableStateRepository;
    private final ProductService productService;

    @Autowired
    public DataTableStateServiceImpl(DataTableStateRepository dataTableStateRepository, ProductService productService) {
        this.dataTableStateRepository = dataTableStateRepository;
        this.productService = productService;
    }

    @Override
    public void saveState(DataTableState dataTableState) {
        dataTableStateRepository.save(dataTableState);
    }

    @Override
    public DataTableState findDataTableState(Integer id) {
        return dataTableStateRepository.getById(id);
    }

    @Override
    public List<DataTableState> getDataTableStates() {
        return dataTableStateRepository.findAll();
    }

    @Override
    public String getStateByProductId(int id) {
        Product product = productService.getProductById(id);
        return product.getDataTableState().getStateJson();
    }
}
