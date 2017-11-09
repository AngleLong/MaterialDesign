package com.hejin.materialdesign.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hejin.materialdesign.R;

public class SnackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/8 16:07
     * description : SnackBar的简单使用
     */
    public void use1(View view) {
        Snackbar snackbar = Snackbar.make(view, "It is SnackBar", Snackbar.LENGTH_INDEFINITE);
        snackbar.getView().setBackgroundResource(R.color.colorAccent);
        snackbar.setActionTextColor(Color.parseColor("#332244"));
        snackbar.setAction("点击", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarActivity.this, "点击了这个按钮", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.addCallback(new Snackbar.Callback() {
            @Override
            public void onShown(Snackbar sb) {/*这个是开始出来的时候调用的方法*/
                super.onShown(sb);
                Toast.makeText(SnackBarActivity.this, "Snackbar show", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {/*这个是退出页面时候调用的方法*/
                super.onDismissed(transientBottomBar, event);
                Toast.makeText(SnackBarActivity.this, "Snackbar dismiss", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }
}
