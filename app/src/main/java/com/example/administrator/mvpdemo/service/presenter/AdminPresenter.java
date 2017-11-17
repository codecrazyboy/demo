package com.example.administrator.mvpdemo.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.administrator.mvpdemo.service.entity.Admin;
import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.manager.DataManager;
import com.example.administrator.mvpdemo.service.view.AdminView;
import com.example.administrator.mvpdemo.service.view.BookView;
import com.example.administrator.mvpdemo.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by jijia on 2017/11/13.
 */

public class AdminPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private AdminView mAdminView;
    private Admin mAdmin;
    public AdminPresenter (Context mContext){
        this.mContext = mContext;
    }
    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        mAdminView = (AdminView)view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void getSearchAdmins(String name,String tag,int start,int count){
        mCompositeSubscription.add(manager.getSearchAdmins(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Admin>() {
                    @Override
                    public void onCompleted() {
                        if (mAdmin != null){
                            mAdminView.onSuccess(mAdmin);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mAdminView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(Admin admin) {
                        mAdmin = admin;
                    }
                })
        );
    }
}
