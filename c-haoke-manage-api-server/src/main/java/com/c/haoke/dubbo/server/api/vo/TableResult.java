package com.c.haoke.dubbo.server.api.vo;

import lombok.*;

import java.util.List;


public class TableResult<T> {

    private List<T> list;
    private Pagination pagination;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public TableResult() {
    }

    public TableResult(List<T> list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "TableResult{" +
                "list=" + list +
                ", pagination=" + pagination +
                '}';
    }
}