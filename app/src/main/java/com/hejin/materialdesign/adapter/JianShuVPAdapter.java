package com.hejin.materialdesign.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hejin.materialdesign.R;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/11/7 10:42
 * 类描述 : 简述顶部Banner的适配器
 */
public class JianShuVPAdapter extends PagerAdapter {

    private Context mContext;

    public JianShuVPAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mIv = new ImageView(mContext);
        if (position % 2 == 0) {
            mIv.setImageResource(R.mipmap.meizhi);
        } else {
            mIv.setImageResource(R.mipmap.photo);
        }
        mIv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(mIv);
        return mIv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
