package com.krspace.krdemo.mvp.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.krspace.krdemo.R;

import java.util.List;


/**
 * Created by ethanhua on 2017/7/27.
 */

public class NewsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public NewsAdapter(@Nullable List<String> data) {
        super(R.layout.item_news, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, String url) {
        ImageView vimgView = helper.getView(R.id.img_news);
        Glide.with(mContext).load(url).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher).override(Target.SIZE_ORIGINAL))
                .into(vimgView);
        helper.addOnClickListener(R.id.img_news);
    }
}
