package com.example.administrator.mvpdemo.service.entity;

import java.io.Serializable;

/**
 * Created by jijia on 2017/11/17.
 */

public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -686453405647539973L;
    private int count;
    private int start;
    private int total;
    public T books;

    @Override
    public String toString() {
        return "BaseResponse{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", books=" + books +
                '}';
    }
}
