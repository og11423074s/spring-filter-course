package com.springfiltercourse.controller;

import com.springfiltercourse.domain.Supplier;
import com.springfiltercourse.model.FilterModel;
import com.springfiltercourse.model.PageModel;
import com.springfiltercourse.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<PageModel<Supplier> > list(@RequestParam Map<String, String> params){
        FilterModel filter = new FilterModel(params);
        PageModel<Supplier> supplierPageModel = supplierService.list(filter);
        return ResponseEntity.ok().body(supplierPageModel);
    }
}
