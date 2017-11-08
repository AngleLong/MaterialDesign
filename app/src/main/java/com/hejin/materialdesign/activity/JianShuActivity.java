package com.hejin.materialdesign.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hejin.materialdesign.R;
import com.hejin.materialdesign.adapter.JianShuItemRVAdapter;
import com.hejin.materialdesign.adapter.JianShuTabRVAdapter;
import com.hejin.materialdesign.adapter.JianShuVPAdapter;

/**
 * author :  贺金龙
 * create time : 2017/11/7 9:24
 * description : 仿简书首页的实现
 * http://www.jianshu.com/p/ac56f11e7ce1
 */
public class JianShuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jian_shu);
        initViewPager();
        initRecycleView();
    }


    /**
     * author :  贺金龙
     * create time : 2017/11/7 10:40
     * description : 初始化ViewPager
     */
    private void initViewPager() {
        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new JianShuVPAdapter(this));
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 10:49
     * description : 初始化顶部和底部的RecycleView
     */
    private void initRecycleView() {
        RecyclerView rvTab = (RecyclerView) findViewById(R.id.rv_tab);
        RecyclerView rvItem = (RecyclerView) findViewById(R.id.rv_bottom);

        rvTab.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvTab.setAdapter(new JianShuTabRVAdapter(this));

        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setAdapter(new JianShuItemRVAdapter(this));
    }
}
