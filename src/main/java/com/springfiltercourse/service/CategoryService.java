package com.springfiltercourse.service;

import com.springfiltercourse.domain.Category;
import com.springfiltercourse.model.FilterModel;
import com.springfiltercourse.model.PageModel;
import com.springfiltercourse.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements IListService<Category> {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @Override
    public PageModel<Category> list(FilterModel filter) {

        Page<Category> categoryPage = categoryRepository.findAll(filter.toSpringPageable());

        return new PageModel<>(categoryPage);
    }
}
