package com.springfiltercourse.model;

import com.springfiltercourse.constants.ApiConstants;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;

@Getter
public class FilterModel {
    private final Integer limit;
    private final Integer page;

    public FilterModel(Map<String, String> params) {
        this.limit = params.containsKey(ApiConstants.LIMIT_KEY)
                ? Integer.parseInt(params.get(ApiConstants.LIMIT_KEY))
                : ApiConstants.DEFAULT_LIMIT;
        this.page = params.containsKey(ApiConstants.PAGE_KEY)
                ? Integer.parseInt(params.get(ApiConstants.PAGE_KEY))
                : ApiConstants.DEFAULT_PAGE;
    }

    public Pageable toSpringPageable() {
        return PageRequest.of(page, limit);
    }
}
