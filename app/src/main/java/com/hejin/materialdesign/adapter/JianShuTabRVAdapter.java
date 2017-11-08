package com.hejin.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hejin.materialdesign.R;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/11/7 10:53
 * 类描述 :
 * 修改人 :
 * 修改内容 :
 * 修改时间 :
 * 类说明 :
 *  
 */
public class JianShuTabRVAdapter extends RecyclerView.Adapter<JianShuTabRVAdapter.TabHolder> {

    private Context mContext;
    private LayoutInflater mInflater;

    public JianShuTabRVAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public TabHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_jianshu_tab, parent, false);
        return new TabHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TabHolder holder, int position) {
        switch (position) {
            case 0:
                holder.mTvBg.setBackgroundResource(R.drawable.label_shape);
                holder.mTvBg.setText("小说精选");
                break;
            case 1:
                holder.mTvBg.setBackgroundResource(R.drawable.label_shape2);
                holder.mTvBg.setText("摄影游记");
                break;
            case 2:
                holder.mTvBg.setBackgroundResource(R.drawable.label_shape3);
                holder.mTvBg.setText("漫画手绘");
                break;
            case 3:
                holder.mTvBg.setBackgroundResource(R.drawable.label_shape4);
                holder.mTvBg.setText("签约作者");
                break;
            default:
                holder.mTvBg.setBackgroundResource(R.drawable.label_shape);
                holder.mTvBg.setText("你猜我猜");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class TabHolder extends RecyclerView.ViewHolder {
        private TextView mTvBg;

        public TabHolder(View itemView) {
            super(itemView);
            mTvBg = itemView.findViewById(R.id.tv_bg);
        }
    }
}
