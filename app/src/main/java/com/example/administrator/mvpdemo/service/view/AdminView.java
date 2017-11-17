package com.example.administrator.mvpdemo.service.view;


import com.example.administrator.mvpdemo.service.entity.Admin;
import com.example.administrator.mvpdemo.service.entity.Book;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface AdminView extends View {
    void onSuccess(Admin mAdmin);
    void onError(String result);
}
