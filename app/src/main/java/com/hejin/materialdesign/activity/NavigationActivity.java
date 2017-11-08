package com.hejin.materialdesign.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hejin.materialdesign.R;

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout mDL;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initDrawerLayout();
        initListener();
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 13:29
     * description : 初始化DrawerLayout的一些参数和关联ToolBar
     */
    private void initDrawerLayout() {
        mToolbar = (Toolbar) findViewById(R.id.tl);
        mToolbar.inflateMenu(R.menu.menu_zhihu);
        mDL = (DrawerLayout) findViewById(R.id.dl_main);

        /*关联ToolBar,这里主要是实现了一个左上角的动画*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDL, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        toggle.syncState();
        mDL.addDrawerListener(toggle);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 15:14
     * description :  设置监听
     */
    private void initListener() {
        //app:headerLayout="@layout/nav_header_navigation_view"
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = mNavigationView.inflateHeaderView(R.layout.nav_header_navigation_view);
        ImageView ivHead = headerView.findViewById(R.id.imageView);
        ivHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "头像被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_camera) {
                    // Handle the camera action
                    Toast.makeText(NavigationActivity.this, "nav_camera", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.nav_gallery) {
                    Toast.makeText(NavigationActivity.this, "nav_gallery", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.nav_slideshow) {
                    Toast.makeText(NavigationActivity.this, "nav_slideshow", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.nav_manage) {
                    Toast.makeText(NavigationActivity.this, "nav_manage", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.nav_share) {
                    Toast.makeText(NavigationActivity.this, "nav_share", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.nav_send) {
                    Toast.makeText(NavigationActivity.this, "nav_send", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        FloatingActionButton actionButton = (FloatingActionButton) findViewById(R.id.fab);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationActivity.this, "点击了FAB按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mDL.isDrawerOpen(Gravity.START)) {
            mDL.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }
    }
}
