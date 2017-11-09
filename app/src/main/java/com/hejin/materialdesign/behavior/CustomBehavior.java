package com.hejin.materialdesign.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/11/8 15:19
 * 类描述 : 头像跟随移动到中间的Behavior
 */
public class CustomBehavior extends CoordinatorLayout.Behavior<ImageView> {

    private float mStartAvatarY;
    private float mStartAvatarX;
    private int mAvatarMaxHeight;

    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {

        int i = dependency.getHeight() / 2;/*ToolBar高度的一半*/

        if (mStartAvatarY == 0) {/*头像开始的Y轴坐标*/
            mStartAvatarY = dependency.getY();
        }

        if (mStartAvatarX == 0) {/*头像开始的X轴坐标*/
            mStartAvatarX = child.getX();
        }

        if(mAvatarMaxHeight == 0){/*头像的最大高度*/
            mAvatarMaxHeight = child.getHeight();
        }

        float percent = dependency.getY() / mStartAvatarY;/*Y轴方向的比例*/


        return true;
    }

}
