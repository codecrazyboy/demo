package com.example.administrator.mvpdemo.ui.activity.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.service.entity.Smart;
import com.example.administrator.mvpdemo.service.entity.okgobean;

/**
 * 文 件 名: PullToRefreshAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 19:55
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class okgoAdapter extends BaseQuickAdapter<okgobean, BaseViewHolder> {
    public okgoAdapter() {
        super( R.layout.listitem_movie_item, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, okgobean item) {
        //lmi_title
        ( (TextView)helper.getView(R.id.lmi_title)).setText(item.getAuthor()+"");
    }

}
