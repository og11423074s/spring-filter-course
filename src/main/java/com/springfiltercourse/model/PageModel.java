package com.springfiltercourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class PageModel<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long totalElements;
    private Integer pageSize;
    private Integer totalPages;
    private Integer currentPage;
    private List<T> elements;

    public PageModel(Page<T> page) {
        this.totalElements = page.getTotalElements();
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();
        this.elements = page.getContent();
    }
}
