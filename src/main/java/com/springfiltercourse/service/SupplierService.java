package com.springfiltercourse.service;

import com.springfiltercourse.domain.Product;
import com.springfiltercourse.domain.Supplier;
import com.springfiltercourse.model.FilterModel;
import com.springfiltercourse.model.PageModel;
import com.springfiltercourse.repository.SupplierRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements IListService<Supplier> {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> list() {
        return supplierRepository.findAll();
    }

    @Override
    public PageModel<Supplier> list(FilterModel filter) {

        Page<Supplier> supplierPage = supplierRepository.findAll(filter.toSpringPageable());

        return new PageModel<>(supplierPage);
    }
}
