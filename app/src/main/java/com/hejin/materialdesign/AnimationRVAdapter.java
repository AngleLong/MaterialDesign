package com.hejin.materialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/10/31 20:15
 * 类描述 :
 * 修改人 :
 * 修改内容 :
 * 修改时间 :
 * 类说明 :
 *  
 */
class AnimationRVAdapter extends RecyclerView.Adapter<AnimationRVAdapter.ItemHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private OnClickListener mOnClickListener;

    public AnimationRVAdapter(Context context) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_animation, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null) {
                    /*获取该View在屏幕中的位置*/
                    int[] location = new int[2];
                    holder.mIv.getLocationOnScreen(location);
                    int width = location[0];
                    int height = location[1];
                    Log.e("done", "onClick: " + width + "----" + height);
                    mOnClickListener.OnItemClickListener(position, width, height, holder.mIv);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 16;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        public ImageView mIv;

        public ItemHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_item);
        }
    }
}
