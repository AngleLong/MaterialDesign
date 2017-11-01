package com.hejin.materialdesign;

import android.widget.ImageView;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/10/31 20:21
 * 类描述 : 条目的点击接口
 * 修改人 :
 * 修改内容 :
 * 修改时间 :
 * 类说明 :
 *  
 */
public interface OnClickListener {
    /**
     * author :  贺金龙
     * create time : 2017/10/31 20:22
     * description : 条目的点击事件
     * instructions :
     */
    void OnItemClickListener(int position, int width, int height, ImageView iv);
}
