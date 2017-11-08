package com.hejin.materialdesign.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.hejin.materialdesign.adapter.AnimationRVAdapter;
import com.hejin.materialdesign.OnClickListener;
import com.hejin.materialdesign.R;

public class AnimationActivity extends AppCompatActivity implements OnClickListener {

    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initRecycleView();
    }

    /**
     * author :  贺金龙
     * create time : 2017/10/31 20:13
     * description : 初始化RecycleView
     * instructions : 这里为了展示动画效果,所以这里创建了一个RecycleView
     */
    private void initRecycleView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new GridLayoutManager(this, 2));
        AnimationRVAdapter animationRVAdapter = new AnimationRVAdapter(this);
        mRv.setAdapter(animationRVAdapter);

        animationRVAdapter.setOnClickListener(this);
    }

    @Override
    public void OnItemClickListener(int position, int width, int height, ImageView iv) {
        ActivityOptionsCompat optionsCompat;
        Intent intent;
        switch (position) {
            case 0:/*演示ActivityOptionsCompat实现类似overridePendingTransition()的动画*/
                optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.slide_bottom_in, R.anim.slide_bottom_out);
                intent = new Intent(this, AnimationResultActivity.class);
                ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
                break;
            case 1:
                /*演示这里主要是使用ActivityOptionsCompat.makeScaleUpAnimation(source, startX, startY, startWidth, startHeight)
                  * 这个是在4.x上使用的,可实现新的Activity从某个固定的坐标以某个大小扩大至全屏*/
                optionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(iv, width, height, 480, 960);
                intent = new Intent(this, AnimationResultActivity.class);
                ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
                break;
            default:/*实现共享动画*/
                if (Build.VERSION.SDK_INT > 20) {
                    intent = new Intent(this, AnimationResultActivity.class);
                    optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(AnimationActivity.this, iv, "transitionImg");
                    ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
                } else {
                    startActivity(new Intent(AnimationActivity.this, AnimationResultActivity.class));
                }
                break;
        }
    }
}
