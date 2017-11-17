package com.example.administrator.mvpdemo.ui.activity.adapter;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.service.entity.Admin;
import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.ui.utils.SpannableStringUtils;
import com.example.administrator.mvpdemo.ui.utils.ToastUtils;
import com.example.administrator.mvpdemo.ui.utils.Utils;

/**
 * 文 件 名: PullToRefreshAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 19:55
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class PullToRefreshAdapter extends BaseQuickAdapter<Admin.BooksBean, BaseViewHolder> {
    public PullToRefreshAdapter() {
        super( R.layout.layout_animation, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, Admin.BooksBean item) {

        helper.setText(R.id.tweetName,"Hoteis in Rio de Janeiro");
        ( (TextView)helper.getView(R.id.tweetText)).setText(item.getAuthor_intro());
        ( (TextView)helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }

}
