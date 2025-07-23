package com.example.bloggingproject.filter;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public class UserFilter {
    private Integer size;
    private Integer page;
    private String searchKey;


    @JsonIgnore
    public Pageable getPageable() {
        return PageRequest.of(this.getPage(), this.getSize());
    }

    @JsonIgnore
    public String getSearchForQuery() {
        return StringUtils.isNotEmpty(searchKey) ? "%" + searchKey.trim().toLowerCase() + "%" : searchKey;
    }

}
