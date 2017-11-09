package com.hejin.materialdesign;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.hejin.materialdesign.activity.AnimationActivity;
import com.hejin.materialdesign.activity.AppBarLayoutActivity;
import com.hejin.materialdesign.activity.BehaviorActivity;
import com.hejin.materialdesign.activity.BottomSheetActivity;
import com.hejin.materialdesign.activity.FABAnimationActivity;
import com.hejin.materialdesign.activity.JianShuActivity;
import com.hejin.materialdesign.activity.NavigationActivity;
import com.hejin.materialdesign.activity.NestedScrollViewActivity;
import com.hejin.materialdesign.activity.SnackBarActivity;
import com.hejin.materialdesign.activity.TabLayoutActivity;
import com.hejin.materialdesign.activity.TextInputLayoutActivity;
import com.hejin.materialdesign.activity.ToolBarActivity;

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

    /**
     * author :  贺金龙
     * create time : 2017/11/6 14:15
     * description : 实现ActivityOptionsCompat动画页面
     */
    public void JumpAnimation(View view) {
        Intent intent = new Intent(this, AnimationActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/6 14:15
     * description : 展示TabLayout的使用
     */
    public void TabLayout(View view) {
        Intent intent = new Intent(this, TabLayoutActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/6 16:38
     * description :  展示AppBarLayout
     */
    public void AppBarLayout(View view) {
        Intent intent = new Intent(this, AppBarLayoutActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 9:23
     * description : 仿简书首页的实现
     */
    public void JianShuHome(View view) {
        Intent intent = new Intent(this, JianShuActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 13:03
     * description : DrawerLayout实现侧滑菜单
     */
    public void DrawerLayout(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 9:23
     * description : NestedScrollView的使用
     */
    public void NestedScrollView(View view) {
        Intent intent = new Intent(this, NestedScrollViewActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 9:23
     * description : TextInputLayout的使用
     */
    public void TextInputLayout(View view) {
        Intent intent = new Intent(this, TextInputLayoutActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 9:23
     * description : FAB的特殊玩法
     */
    public void FAB(View view) {
        Intent intent = new Intent(this, FABAnimationActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 9:23
     * description : FAB的特殊玩法
     */
    public void Behavior(View view) {
        Intent intent = new Intent(this, BehaviorActivity.class);
        startActivity(intent);
    }

    /**
     * author :  贺金龙
     * create time : 2017/11/7 9:23
     * description : SnackBar的使用
     */
    public void SnackBar(View view) {
        Intent intent = new Intent(this, SnackBarActivity.class);
        startActivity(intent);
    }
   /**
     * author :  贺金龙
     * create time : 2017/11/7 9:23
     * description : SnackBar的使用
     */
    public void BottomSheet(View view) {
        Intent intent = new Intent(this, BottomSheetActivity.class);
        startActivity(intent);
    }

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
