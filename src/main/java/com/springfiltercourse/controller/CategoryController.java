package com.springfiltercourse.controller;

import com.springfiltercourse.domain.Category;
import com.springfiltercourse.model.FilterModel;
import com.springfiltercourse.model.PageModel;
import com.springfiltercourse.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<PageModel<Category>> list(@RequestParam Map<String, String> params ) {
        FilterModel filter = new FilterModel(params);
        PageModel<Category> categoriesPageModel = categoryService.list(filter);
        return ResponseEntity.ok().body(categoriesPageModel);
    }
}
