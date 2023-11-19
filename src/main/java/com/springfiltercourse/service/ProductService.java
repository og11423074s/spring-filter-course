package com.springfiltercourse.service;

import com.springfiltercourse.domain.Category;
import com.springfiltercourse.domain.Product;
import com.springfiltercourse.model.FilterModel;
import com.springfiltercourse.model.PageModel;
import com.springfiltercourse.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IListService<Product> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public PageModel<Product> list(FilterModel filter) {

        Page<Product> productPage = productRepository.findAll(filter.toSpringPageable());

        return new PageModel<>(productPage);
    }
}
