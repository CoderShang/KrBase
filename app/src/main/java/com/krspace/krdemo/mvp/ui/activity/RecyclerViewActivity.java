package com.krspace.krdemo.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.krspace.krbase.utils.BaseUtils;
import com.krspace.krbase.widget.GlideRoundTransform;
import com.krspace.krdemo.R;
import com.krspace.krdemo.app.widget.AVLoadingIndicatorView;
import com.krspace.krdemo.app.widget.shimmer.Skeleton;
import com.krspace.krdemo.app.widget.shimmer.SkeletonScreen;
import com.krspace.krdemo.mvp.ui.adapter.NewsAdapter;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethanhua on 2017/7/27.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    public static void start(Context context, String type) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        init();
    }

    static List<String> aList = new ArrayList<>();

    static {
        aList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548756837006&di=551df0dcf59d1d71673c3d46b33f0d93&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201308%2F04%2F20130804155912_wCRnE.thumb.700_0.jpeg");
        aList.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2279952540,2544282724&fm=26&gp=0.jpg");
        aList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=851052518,4050485518&fm=26&gp=0.jpg");
        aList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=174904559,2874238085&fm=26&gp=0.jpg");
        aList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548764579122&di=e3a46d9075ee49ecefb552a447974ddc&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201112%2F03%2F20111203233836_3wu5E.thumb.700_0.jpg");
        aList.add("https://user-gold-cdn.xitu.io/2019/1/25/168839e977414cc1?imageView2/2/w/800/q/100");
        aList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551692956639&di=8ee41e070c6a42addfc07522fda3b6c8&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160413%2F75659e9b05b04eb8adf5b52669394897.jpg");
        aList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548756837006&di=551df0dcf59d1d71673c3d46b33f0d93&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201308%2F04%2F20130804155912_wCRnE.thumb.700_0.jpeg");
        aList.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2279952540,2544282724&fm=26&gp=0.jpg");
        aList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=851052518,4050485518&fm=26&gp=0.jpg");
        aList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=174904559,2874238085&fm=26&gp=0.jpg");
        aList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548764579122&di=e3a46d9075ee49ecefb552a447974ddc&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201112%2F03%2F20111203233836_3wu5E.thumb.700_0.jpg");
        aList.add("https://user-gold-cdn.xitu.io/2019/1/25/168839e977414cc1?imageView2/2/w/800/q/100");
        aList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551692956639&di=8ee41e070c6a42addfc07522fda3b6c8&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160413%2F75659e9b05b04eb8adf5b52669394897.jpg");
    }

    private void init() {
        AVLoadingIndicatorView indicator = findViewById(R.id.indicator);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        NewsAdapter adapter = new NewsAdapter(aList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ViewActivity.start(RecyclerViewActivity.this, ViewActivity.TYPE_VIEW);
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.img_news) {
                    new XPopup.Builder(RecyclerViewActivity.this)
                            .asImageViewer((ImageView) view, aList.get(position), new ImageLoader())
                            .show();
//                    new XPopup.Builder(RecyclerViewActivity.this)
//                            .asImageViewer((ImageView) view, position, aList, true, -1, -1, -1, true, new OnSrcViewUpdateListener() {
//                                @Override
//                                public void onSrcViewUpdate(final ImageViewerPopupView popupView, final int position) {
//                                    //1.pager更新当前显示的图片
//                                    //当启用isInfinite时，position会无限增大，需要映射为当前ViewPager中的页
//                                    int realPosi = position % aList.size();
////                            Log.e("tag", "position: "+realPosi + " list size: "+list.size());
//                                    pager.setCurrentItem(realPosi, false);
//                                    //2.更新弹窗的srcView，注意这里的position是list中的position，上面ViewPager设置了pageLimit数量，
//                                    //保证能拿到child，如果不设置pageLimit，ViewPager默认最多维护3个page，会导致拿不到child
//                                    popupView.updateSrcView((ImageView) pager.getChildAt(realPosi));
//                                }
//                            }, new ImageLoader())
//                            .show();
                }
            }
        });
        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(adapter)
                .shimmer(true)
                .angle(20)
                .frozen(false)
                .duration(1200)
                .count(10)
                .load(R.layout.item_skeleton_news)
                .show(); //default count is 10
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonScreen.hide();
            }
        }, 3000);
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                indicator.hide();
            }
        }, 6000);
    }

    public static class ImageLoader implements XPopupImageLoader {
        @Override
        public void loadImage(int position, @NonNull Object url, @NonNull ImageView imageView) {
            //必须指定Target.SIZE_ORIGINAL，否则无法拿到原图，就无法享用天衣无缝的动画
            Glide.with(imageView).load(url).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher).override(Target.SIZE_ORIGINAL)).into(imageView);
        }

        @Override
        public File getImageFile(@NonNull Context context, @NonNull Object uri) {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

