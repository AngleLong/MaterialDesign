package com.hejin.materialdesign;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * author :  贺金龙
     * create time : 2017/10/30 18:55
     * description : 跳转到toolBar的讲解界面
     */
    public void ToolBar(View view) {
        Intent intent = new Intent(this, ToolBarActivity.class);
        startActivity(intent);
    }


    public void JumpAnimation(View view) {
        Intent intent = new Intent(this, AnimationActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void RevealAnimator(View view) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2, view.getHeight() / 2, 0, view.getWidth());
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(1000);
            animator.start();
        } else {
            Toast.makeText(this, "5.0以下不支持", Toast.LENGTH_SHORT).show();
        }
    }
}
