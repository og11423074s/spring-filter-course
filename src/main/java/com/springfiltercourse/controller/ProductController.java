package com.springfiltercourse.controller;

import com.springfiltercourse.domain.Product;
import com.springfiltercourse.model.FilterModel;
import com.springfiltercourse.model.PageModel;
import com.springfiltercourse.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<PageModel<Product>> list(@RequestParam Map<String, String> params ) {
        FilterModel filter = new FilterModel(params);
        PageModel<Product> productPageModel = productService.list(filter);
        return ResponseEntity.ok().body(productPageModel);
    }
}
