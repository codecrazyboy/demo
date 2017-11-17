package com.example.administrator.mvpdemo.service.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.mvpdemo.service.api.BaseUrl;
import com.example.administrator.mvpdemo.service.api.HandleCord;
import com.example.administrator.mvpdemo.service.cache.NewsCallback;
import com.example.administrator.mvpdemo.service.entity.BaseResponse;
import com.example.administrator.mvpdemo.service.entity.okgobean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by jijia on 2017/11/17.
 */

public class OkGoPresenter {


    public static void getDataPresenter(final Handler handler_ ,final Context context, final JSONObject jsonObject){
        OkGo.<BaseResponse<List<okgobean>>>post(BaseUrl.BaseUrl)
                .tag(context)//
                .headers("header1", "headerValue1")//
//                .params("param1", "paramValue1")//  这里不要使用params，upJson 与 params 是互斥的，只有 upJson 的数据会被上传
                .upJson(jsonObject)//
                .execute(new NewsCallback<BaseResponse<List<okgobean>>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<List<okgobean>>> response) {
                       // List<okgobean> results = response.body().books;
                        BaseResponse results=response.body();
                        if (results != null) {
                            Message msg = handler_.obtainMessage(HandleCord.SUCESS);
                            msg.obj = results;
                            msg.sendToTarget();

                        }
                    }

                    @Override
                    public void onError(Response<BaseResponse<List<okgobean>>> response) {
                        //网络请求失败的回调,一般会弹个Toast
//                        showToast(response.getException().getMessage());
                    }

                });
    }

}
