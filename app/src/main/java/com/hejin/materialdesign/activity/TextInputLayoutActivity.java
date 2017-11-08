package com.hejin.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hejin.materialdesign.R;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout mLayoutTop;
    private TextInputEditText mInputEditTextTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);

        initView();
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 17:25
     * description : 初始化一些View
     */
    private void initView() {
        mLayoutTop = (TextInputLayout) findViewById(R.id.til_top);
        mInputEditTextTop = (TextInputEditText) findViewById(R.id.tiet_top);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 17:18
     * description : 登陆的按钮
     * instructions : 这里主要是为了验证错误信息的显示
     * version :
     */
    public void login(View view) {
        if (!mLayoutTop.getEditText().getText().toString().equals("123456")) {
            mLayoutTop.setError("账号信息填写错误");
            mInputEditTextTop.setError("只是展示下错误的显示样式");
        }
    }
}
