package com.example.administrator.mvpdemo.service.manager;

import android.content.Context;


import com.example.administrator.mvpdemo.service.RetrofitService;
import com.example.administrator.mvpdemo.service.RetrofitHelper;
import com.example.administrator.mvpdemo.service.entity.Admin;
import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.entity.Smart;

import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    public  Observable<Book> getSearchBooks(String name,String tag,int start,int count){
        return mRetrofitService.getSearchBooks(name,tag,start,count);

    }
    public  Observable<Admin> getSearchAdmins(String name, String tag, int start, int count){
        return mRetrofitService.getSearchAdmins(name,tag,start,count);

    }
    public  Observable<Smart> getSearchSmarts(String type,int pageSize,int pageNumber){
        return mRetrofitService.getSearchSmarts(type,pageSize,pageNumber);
    }
}
