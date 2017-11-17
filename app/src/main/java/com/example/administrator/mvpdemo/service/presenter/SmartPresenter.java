package com.example.administrator.mvpdemo.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.entity.Smart;
import com.example.administrator.mvpdemo.service.manager.DataManager;
import com.example.administrator.mvpdemo.service.view.SmartView;
import com.example.administrator.mvpdemo.service.view.View;

import java.util.List;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by jijia on 2017/11/13.
 */

public class SmartPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private SmartView mSmartView;
    private Smart mSmart;
    public SmartPresenter(Context mContext){
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
        mSmartView = (SmartView)view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void getSearchSmarts(String since,int pageSize,int per_page){
        mCompositeSubscription.add(manager.getSearchSmarts(since,pageSize,per_page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Smart>() {
                    @Override
                    public void onCompleted() {
                        if (mSmart != null){
                            mSmartView.onSuccess(mSmart);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mSmartView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(Smart smart) {
                        mSmart = smart;
                    }
                })

        );
    }
}
