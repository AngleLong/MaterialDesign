package com.hejin.materialdesign.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/11/8 14:41
 * 类描述 : 实现ToolBar和TextView联动的Behavior
 * 类说明 :
 */
public class ToolBarBehavior extends CoordinatorLayout.Behavior<TextView> {

    private int mStartY;

    public ToolBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        if (mStartY == 0) {/*这里获取的是点击处对控件顶部的距离*/
            mStartY = (int) dependency.getY();
        }

        /*计算ToolBar从开始引动到最后的百分比,也就是ToolBar的当前高度比上总高度*/
        float percent = dependency.getY() / mStartY;

        /*改变child的坐标(从消失到可见)*/
        child.setY(child.getHeight() * (1 - percent) - child.getHeight());
        return true;
    }
}
