package hpu.dingyue.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/4/22.
 */
public class TabLayoutActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("第一个"));
        tabLayout.addTab(tabLayout.newTab().setText("第二个"));
        tabLayout.addTab(tabLayout.newTab().setText("第三个"));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        TabFragment1 tabFragment1 = new TabFragment1();
                        transaction.replace(R.id.id_content, tabFragment1);
                        break;
                    case 1:
                        TabFragment2 tabFragment2 = new TabFragment2();
                        transaction.replace(R.id.id_content, tabFragment2);
                        break;
                    case 2:
                        break;
                }
                transaction.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                Toast.makeText(getApplicationContext(), "第二个", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                Toast.makeText(getApplicationContext(), "第三个", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
