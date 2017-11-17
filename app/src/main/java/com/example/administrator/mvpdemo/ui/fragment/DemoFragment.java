package com.example.administrator.mvpdemo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.ui.activity.demo.SmartPullActivity;
import com.example.administrator.mvpdemo.ui.activity.demo.okgoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DemoFragment extends Fragment {

    @BindView(R.id.okgo)
    TextView okgo;
    @BindView(R.id.smart)
    TextView smart;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.okgo, R.id.smart})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.okgo:
               intent = new Intent(getActivity(),okgoActivity.class);
                startActivity(intent);
                break;
            case R.id.smart:
                 intent = new Intent(getActivity(),SmartPullActivity.class);
                startActivity(intent);
                break;
        }
    }
}
