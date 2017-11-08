package com.hejin.materialdesign.activity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hejin.materialdesign.R;

public class FABAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton mMain;/*主FAB*/
    private AnimatorSet mAnimatorSet;
    private AnimatorSet mAnimatorSet2;
    private AnimatorSet mAnimatorSet3;
    private AnimatorSet mAnimatorSet4;
    private LinearLayout mLl01;
    private LinearLayout mLl02;
    private LinearLayout mLl03;
    private LinearLayout mLl04;
    private RelativeLayout mRlFABAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabanimation);

        initView();

        mAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.item_animation);
        mAnimatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.item_animation);
        mAnimatorSet3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.item_animation);
        mAnimatorSet4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.item_animation);

        mRlFABAll = (RelativeLayout) findViewById(R.id.rlFABAll);
    }

    private void initView() {
        mMain = (FloatingActionButton) findViewById(R.id.fabMain);
        mMain.setOnClickListener(this);

        mLl01 = (LinearLayout) findViewById(R.id.ll01);
        mLl02 = (LinearLayout) findViewById(R.id.ll02);
        mLl03 = (LinearLayout) findViewById(R.id.ll03);
        mLl04 = (LinearLayout) findViewById(R.id.ll04);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabMain:
                mRlFABAll.setVisibility(View.VISIBLE);

                mAnimatorSet.setTarget(mLl01);
                mAnimatorSet.start();

                mAnimatorSet2.setTarget(mLl02);
                mAnimatorSet2.setStartDelay(150);
                mAnimatorSet2.start();


                mAnimatorSet3.setTarget(mLl03);
                mAnimatorSet3.setStartDelay(300);
                mAnimatorSet3.start();

                mAnimatorSet4.setTarget(mLl04);
                mAnimatorSet4.setStartDelay(450);
                mAnimatorSet4.start();
                break;
            default:
                Toast.makeText(this, "其他条目被点击了", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
