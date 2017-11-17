package com.example.administrator.mvpdemo.ui.activity.demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.service.api.HandleCord;
import com.example.administrator.mvpdemo.service.cache.DialogCallback;
import com.example.administrator.mvpdemo.service.cache.NewsCallback;
import com.example.administrator.mvpdemo.service.entity.BaseResponse;
import com.example.administrator.mvpdemo.service.entity.LzyResponse;
import com.example.administrator.mvpdemo.service.entity.Smart;
import com.example.administrator.mvpdemo.service.entity.okgobean;
import com.example.administrator.mvpdemo.service.presenter.OkGoPresenter;
import com.example.administrator.mvpdemo.service.presenter.SmartPresenter;
import com.example.administrator.mvpdemo.ui.activity.adapter.SmartAdapter;
import com.example.administrator.mvpdemo.ui.activity.adapter.okgoAdapter;
import com.example.administrator.mvpdemo.ui.activity.base.BaseActivity;
import com.example.administrator.mvpdemo.ui.utils.StatusBarUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class okgoActivity extends BaseActivity {
    private okgoAdapter mAdapter;
    private SmartPresenter mSmartPresenter = new SmartPresenter(this);
    RefreshLayout refreshLayout;
    RecyclerView recyclerView;
    Toolbar toolbar;
    List<Smart.ResultsBean> sr = new ArrayList<Smart.ResultsBean>();
    private boolean isInitCache = false;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okgo);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);

        mAdapter = new okgoAdapter();
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        refreshLayout.autoRefresh();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //getData();
                        getDataPre();
                        refreshLayout.finishRefresh();
                    }
                }, 2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                //getData();
                getDataPre();
                refreshlayout.finishLoadmore();

            }
        });

        //状态栏透明和间距处理
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        StatusBarUtil.setPaddingSmart(this, recyclerView);
        StatusBarUtil.setMargin(this, findViewById(R.id.header));
        StatusBarUtil.setPaddingSmart(this, findViewById(R.id.blurview));


    }

    private void refresh() {
        url = "https://api.douban.com/v2/book/search?q=西游记&start=0&count=1";
        OkGo.<BaseResponse<List<okgobean>>>get(url + "1")//
                .cacheKey("TabFragment_" + "1")       //由于该fragment会被复用,必须保证key唯一,否则数据会发生覆盖
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)  //缓存模式先使用缓存,然后使用网络数据
                .execute(new NewsCallback<BaseResponse<List<okgobean>>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<List<okgobean>>> response) {
                        List<okgobean> results = response.body().books;
                        if (results != null) {
                            //currentPage = 2;
                            mAdapter.setNewData(results);
                        }
                    }

                    @Override
                    public void onCacheSuccess(Response<BaseResponse<List<okgobean>>> response) {
                        //一般来说,只需呀第一次初始化界面的时候需要使用缓存刷新界面,以后不需要,所以用一个变量标识
                        if (!isInitCache) {
                            //一般来说,缓存回调成功和网络回调成功做的事情是一样的,所以这里直接回调onSuccess
                            onSuccess(response);
                            isInitCache = true;
                        }
                    }

                    @Override
                    public void onError(Response<BaseResponse<List<okgobean>>> response) {
                        //网络请求失败的回调,一般会弹个Toast
                        //showToast(response.getException().getMessage());
                    }

                    @Override
                    public void onFinish() {
                        //可能需要移除之前添加的布局
                        mAdapter.removeAllFooterView();
                        //最后调用结束刷新的方法
                        // setRefreshing(false);
                    }
                });
    }

    private void getData() {
        // url = "https://api.douban.com/v2/book/search?q=西游记&start=0&count=1";
        HashMap<String, String> params = new HashMap<>();
        params.put("q", "西游记");
        params.put("start", "0");
        params.put("count", "1");
        JSONObject jsonObject = new JSONObject(params);

        OkGo.<BaseResponse<List<okgobean>>>post("https://api.douban.com/v2/book/search")//
                .tag(this)//
                .headers("header1", "headerValue1")//
//                .params("param1", "paramValue1")//  这里不要使用params，upJson 与 params 是互斥的，只有 upJson 的数据会被上传
                .upJson(jsonObject)//
                .execute(new NewsCallback<BaseResponse<List<okgobean>>>() {
                    @Override
                    public void onSuccess(Response<BaseResponse<List<okgobean>>> response) {
                        List<okgobean> results = response.body().books;
                        if (results != null) {
                            //currentPage = 2;
                            mAdapter.setNewData(results);
                        }
                    }

                    @Override
                    public void onError(Response<BaseResponse<List<okgobean>>> response) {
                        //网络请求失败的回调,一般会弹个Toast
                        showToast(response.getException().getMessage());
                    }

                });
    }

    private void getDataPre() {
        HashMap<String, String> params = new HashMap<>();
        params.put("q", "西游记");
        params.put("start", "0");
        params.put("count", "1");
        JSONObject jsonObject = new JSONObject(params);

        OkGoPresenter.getDataPresenter(handler_, this, jsonObject);
    }




    public void handleMessage(Message msg) {
        switch (msg.what) {
            case HandleCord.SUCESS:
                BaseResponse response= (BaseResponse) msg.obj;
                List<okgobean> results = (List<okgobean>) response.books;
                if (results!=null){
                    mAdapter.setNewData(results);
                }


                break;

            case HandleCord.FAIL:

                break;
        }

    }
}
