package com.springfiltercourse.service;

import com.springfiltercourse.model.FilterModel;
import com.springfiltercourse.model.PageModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Locale;

public interface IListService<T> {

    List<T> list();
    PageModel<T> list(FilterModel filter);
}
