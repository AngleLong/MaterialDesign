package com.hejin.materialdesign.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hejin.materialdesign.R;
import com.hejin.materialdesign.adapter.JianShuItemRVAdapter;

public class BottomSheetActivity extends AppCompatActivity {

    private BottomSheetBehavior<View> mEasySheet;
    private BottomSheetBehavior<View> mRecyclerSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        initRecycleView();
        initSheet();
    }


    private void initRecycleView() {
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new JianShuItemRVAdapter(this));
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/9 10:31
     * description : 初始化BottomSheetBehavior
     */
    private void initSheet() {
        /*根据控件获取简单的Sheet*/
        mEasySheet = BottomSheetBehavior.from(findViewById(R.id.easySheet));
        /*根据控件获取RecyclerView的sheet*/
        mRecyclerSheet = BottomSheetBehavior.from(findViewById(R.id.rv));
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/9 10:22
     * description : 简单的sheet显示与隐藏
     */
    public void Sheet1(View view) {
        /*当为折叠状态或者是打开状态的话就隐藏视图*/
        if (mEasySheet.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            mEasySheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (mEasySheet.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mEasySheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        }

        mEasySheet.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                /*状态改变的监听*/
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                /*当底部的BottomSheet被拖动的时候回调*/
            }
        });
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/9 10:23
     * description : RecycleView 展示的Sheet
     */
    public void Sheet2(View view) {
        if (mRecyclerSheet.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            mRecyclerSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (mRecyclerSheet.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mRecyclerSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/9 12:02
     * description : 展示BottomSheetDialog
     */
    public void Sheet3(View view) {
        BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
        sheetDialog.setContentView(R.layout.sheet_dialog);
        sheetDialog.show();
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/9 13:49
     * description : 展示BottomSheetDialogFragment
     */
    public void Sheet4(View view) {

    }
}
