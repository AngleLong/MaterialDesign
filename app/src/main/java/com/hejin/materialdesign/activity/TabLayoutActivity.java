package com.hejin.materialdesign.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hejin.materialdesign.R;

public class TabLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);


        initJianShu();
        initJingDong();
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/6 16:03
     * description : 仿照简述的TabLayout的使用
     */
    private void initJianShu() {
        TabLayout tl = (TabLayout) findViewById(R.id.tl_jianshu);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/6 16:04
     * description : 仿照京东的商品详情页的TabLayout
     */
    private void initJingDong() {
        TabLayout tl = (TabLayout) findViewById(R.id.tl_jingDong);
    }
}
