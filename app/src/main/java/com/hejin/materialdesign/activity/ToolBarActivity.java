package com.hejin.materialdesign.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hejin.materialdesign.R;

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private boolean isAssociatedActionBar;
    private Toolbar mZhiHuToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        mToolBar = (Toolbar) findViewById(R.id.toolBar);
         /*设置标题*/
        mToolBar.setTitle("标题栏");
        /*设置副标题*/
        mToolBar.setSubtitle("子标题");
        /*设置标题显示颜色*/
        mToolBar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        /*设置副标题的字体颜色*/
        mToolBar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
        /*设置Logo*/
        mToolBar.setLogo(R.mipmap.logo);
        /*设置导航按钮*/
        mToolBar.setNavigationIcon(R.mipmap.back_arrow);
        if (isAssociatedActionBar) {/*关联ActionBar的处理*/
            associatedActionBar();
        } else {/*不关联ActionBar的处理*/
            noAssociatedActionBar();
        }

        initZhiHuToolBar();
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/3 17:15
     * description : 初始化知乎的ToolBar
     * instructions : 实现ToolBar的ToolBar
     */
    private void initZhiHuToolBar() {
        mZhiHuToolBar = (Toolbar) findViewById(R.id.zhiHu);
        mZhiHuToolBar.inflateMenu(R.menu.menu_zhihu);
        mZhiHuToolBar.setNavigationIcon(R.mipmap.ic_zhbook_show_directory);
    }

    /**
     * author :  贺金龙
     * create time : 2017/10/30 17:03
     * description : 不关联ActionBar时toolBar的设置方法
     * instructions :
     * version :
     */
    private void noAssociatedActionBar() {
        /*添加一个子视图*/
        TextView subText = new TextView(this);
        subText.setText("添加的子控件");
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        params.setMargins(3, 3, 4, 4);
        subText.setLayoutParams(params);
        mToolBar.addView(subText);

        mToolBar.inflateMenu(R.menu.menu_main);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarActivity.this, "导航图标被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.setting) {
                    Toast.makeText(ToolBarActivity.this, "条目setting点击事件", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    /**
     * author :  贺金龙
     * create time : 2017/10/30 15:00
     * description : 关联ActionBar时toolBar的设置方法
     * instructions : 这里说明一点就是,如果这么设置的话,要实现menu的一些方法内容
     * 包括onCreateOptionsMenu(Menu menu);onOptionsItemSelected(MenuItem item);
     */
    private void associatedActionBar() {
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Toast.makeText(ToolBarActivity.this, "点击setting按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Tab3:/*组合*/
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
