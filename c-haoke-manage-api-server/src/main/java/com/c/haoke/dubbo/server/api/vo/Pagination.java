package com.c.haoke.dubbo.server.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Pagination {

    private Integer current;
    private Integer pageSize;
    private Integer total;

    public Pagination(Integer current, Integer pageSize, Integer total) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Pagination() {
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "current=" + current +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }
}