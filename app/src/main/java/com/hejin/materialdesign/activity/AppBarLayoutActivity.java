package com.hejin.materialdesign.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.hejin.materialdesign.R;

public class AppBarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);

        initToolBar();
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/6 17:42
     * description : 初始化ToolBar
     */
    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.inflateMenu(R.menu.menu_appbarlayout);
        toolbar.setNavigationIcon(R.mipmap.back_arrow);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }
}
