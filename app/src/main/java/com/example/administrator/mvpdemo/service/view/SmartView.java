package com.example.administrator.mvpdemo.service.view;


import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.entity.Smart;

import java.util.List;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface SmartView extends View {
    void onSuccess(Smart mSmart);
    void onError(String result);
}
