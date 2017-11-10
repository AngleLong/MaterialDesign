package com.hejin.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.hejin.materialdesign.R;
import com.hejin.materialdesign.utils.BottomNavigationViewHelper;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        final BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.bnv);

//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.news:
//                        Snackbar.make(navigationView, "新闻", Snackbar.LENGTH_SHORT).show();
//                        break;
//                    case R.id.sports:
//                        Snackbar.make(navigationView, "运动", Snackbar.LENGTH_SHORT).show();
//                        break;
//                    case R.id.my:
//                        Snackbar.make(navigationView, "我的", Snackbar.LENGTH_SHORT).show();
//                        break;
//                    case R.id.music:
//                        Snackbar.make(navigationView, "音乐", Snackbar.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//        });


        navigationView.setSelectedItemId(R.id.sports);

        BottomNavigationViewHelper.disableShiftMode(navigationView);
    }
}
