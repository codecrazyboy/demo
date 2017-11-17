package com.example.administrator.mvpdemo.ui.activity.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.service.entity.Admin;
import com.example.administrator.mvpdemo.service.presenter.AdminPresenter;
import com.example.administrator.mvpdemo.service.view.AdminView;
import com.example.administrator.mvpdemo.ui.activity.adapter.PullToRefreshAdapter;

public class PullActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private PullToRefreshAdapter mAdapter;
    private int mNextRequestPage = 1;
    private AdminPresenter mBookPresenter = new AdminPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBookPresenter.onCreate();
        mBookPresenter.attachView(mAdminView);

        initAdapter();
        //addHeadView();
        initRefreshLayout();
        refresh();
    }
    private void initRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }
    private void refresh() {
        mNextRequestPage = 1;
        mAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        mBookPresenter.getSearchAdmins("西游记", null, 0, 1);
    }
    private void loadMore() {
        mNextRequestPage++;
    }
    private AdminView mAdminView = new AdminView() {
        @Override
        public void onSuccess(Admin mAdmin) {
            //text.setText(mAdmin.toString());
            mAdapter.setEnableLoadMore(true);
            mSwipeRefreshLayout.setRefreshing(false);
            setData(true, mAdmin);

        }

        @Override
        public void onError(String result) {
            mAdapter.setEnableLoadMore(true);
            mSwipeRefreshLayout.setRefreshing(false);
        }
    };

    private void initAdapter() {
        mAdapter = new PullToRefreshAdapter();
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        });
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
//        mAdapter.setPreLoadNumber(3);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                Toast.makeText(PullActivity.this, Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setData(boolean isRefresh, Admin data) {
        mNextRequestPage++;

        mAdapter.setNewData(data.getBooks());
        mAdapter.notifyDataSetChanged();
    }
}
