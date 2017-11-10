package com.hejin.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hejin.materialdesign.R;

public class BehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/8 12:45
     * description : 自定义简单联动的Behavior
     */
    public void easyBehavior(View view) {
        startActivity(new Intent(this, EasyBehaviorActivity.class));
    }
       /**
     * author :  贺金龙
     * create time : 2017/11/8 12:45
     * description : 仿照uc折叠的behavior
     */
    public void UCBehavior(View view) {
        startActivity(new Intent(this, UCBehaviorActivity.class));
    }
}
