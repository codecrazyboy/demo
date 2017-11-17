package com.example.administrator.mvpdemo.ui.activity.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.service.entity.Admin;
import com.example.administrator.mvpdemo.service.presenter.AdminPresenter;
import com.example.administrator.mvpdemo.service.view.AdminView;

public class AdminActivity extends AppCompatActivity {
    private TextView text;
    private Button button;
    private AdminPresenter mBookPresenter = new AdminPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        text = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBookPresenter.getSearchAdmins("西游记", null, 0, 1);
            }
        });
        mBookPresenter.onCreate();
        mBookPresenter.attachView(mAdminView);

    }
    private AdminView mAdminView = new AdminView() {
        @Override
        public void onSuccess(Admin mAdmin) {
            text.setText(mAdmin.toString());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(AdminActivity.this,result, Toast.LENGTH_SHORT).show();
        }
    };
}
