package com.hejin.materialdesign.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作者 : 贺金龙
 * 创建时间 :  2017/11/8 11:33
 * 类描述 : 这个是第一个简单的自定义EasyBehavior
 * 类说明 : 这里的泛型应给是被观察者,也就是child
 */
public class EasyBehavior extends CoordinatorLayout.Behavior<TextView> {

    public EasyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        /*这里主要是说明观察者是什么类型的,如果返回true说明是观察者观察的View否则返回false也就不会产生联动了*/
        return dependency instanceof Button;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        /*这里主要是观察者位置改变的时候,被观察者的位置在观察者位置的基础上响应的增加了200*/
        child.setX(dependency.getX() + 200);
        child.setY(dependency.getY() + 200);
        child.setText(dependency.getX() + "," + dependency.getY());
        return true;
    }
}
