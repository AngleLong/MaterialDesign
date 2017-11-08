package com.hejin.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hejin.materialdesign.R;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/11/7 11:06
 * 类描述 :
 * 修改人 :
 * 修改内容 :
 * 修改时间 :
 * 类说明 :
 *  
 */
public class JianShuItemRVAdapter extends RecyclerView.Adapter <JianShuItemRVAdapter.ItemTab>{

    private Context mContext;
    private LayoutInflater mInflater;

    public JianShuItemRVAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemTab onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_jianshu,parent,false);
        return new ItemTab(itemView);
    }

    @Override
    public void onBindViewHolder(ItemTab holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class ItemTab extends RecyclerView.ViewHolder{
        public ItemTab(View itemView) {
            super(itemView);
        }
    }
}
