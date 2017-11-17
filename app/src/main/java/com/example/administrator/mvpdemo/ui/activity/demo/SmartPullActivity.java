package com.example.administrator.mvpdemo.ui.activity.demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.service.entity.Smart;
import com.example.administrator.mvpdemo.service.presenter.SmartPresenter;
import com.example.administrator.mvpdemo.service.view.SmartView;
import com.example.administrator.mvpdemo.ui.activity.adapter.SmartAdapter;
import com.example.administrator.mvpdemo.ui.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class SmartPullActivity extends AppCompatActivity {
    private SmartAdapter mAdapter;
    private SmartPresenter mSmartPresenter = new SmartPresenter(this);
    RefreshLayout refreshLayout;
    RecyclerView recyclerView;
    Toolbar toolbar;
    List<Smart.ResultsBean> sr=new ArrayList<Smart.ResultsBean>();

    public static List<BannerActivity.BannerItem> BANNER_ITEMS = new ArrayList<BannerActivity.BannerItem>(){{
        add(new BannerActivity.BannerItem("最后的骑士", R.mipmap.image_movie_header_48621499931969370));
        add(new BannerActivity.BannerItem("三生三世十里桃花", R.mipmap.image_movie_header_12981501221820220));
        add(new BannerActivity.BannerItem("豆福传", R.mipmap.image_movie_header_12231501221682438));
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_pull);
         toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);

        mAdapter = new SmartAdapter();
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        mSmartPresenter.onCreate();
        mSmartPresenter.attachView(mSmartView);
        refreshLayout.autoRefresh();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                        refreshLayout.finishRefresh();
                    }
                },2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh();
                refreshlayout.finishLoadmore();

            }
        });


        //添加Header
        android.view.View header = LayoutInflater.from(this).inflate(R.layout.listitemsmartheader, recyclerView, false);
        Banner banner = (Banner) header;
        banner.setImageLoader(new SmartPullActivity.GlideImageLoader());
        banner.setImages(BANNER_ITEMS);
        banner.start();
        mAdapter.addHeaderView(banner);
        mAdapter.openLoadAnimation();

        //状态栏透明和间距处理
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        StatusBarUtil.setPaddingSmart(this, recyclerView);
        StatusBarUtil.setMargin(this, findViewById(R.id.header));
        StatusBarUtil.setPaddingSmart(this, findViewById(R.id.blurview));
    }
    private void refresh() {

        mSmartPresenter.getSearchSmarts("Android",1,10);
    }
    private SmartView mSmartView = new SmartView() {
        @Override
        public void onSuccess(Smart mSmart) {
            //text.setText(mAdmin.toString());
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadmore();
            sr.clear();
            sr=mSmart.getResults();
            mAdapter.setNewData(sr);
            mAdapter.notifyDataSetChanged();

        }

        @Override
        public void onError(String result) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadmore();


        }
    };
//    private void setData(boolean isRefresh, Smart data) {
////        mNextRequestPage++;
//
//        mAdapter.setNewData(data.getResults());
//        mAdapter.notifyDataSetChanged();
//    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setImageResource(((BannerActivity.BannerItem) path).pic);
        }
    }

}
