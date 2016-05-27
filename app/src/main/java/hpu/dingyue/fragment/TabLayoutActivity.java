package hpu.dingyue.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import hpu.dingyue.R;

/**
 * Created by Administrator on 2016/4/22.
 */
public class TabLayoutActivity extends FragmentActivity {
    private TabFragment2 fragment2;
    private TabFragment1 fragment1;

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
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction transaction = fm.beginTransaction();

                switch (tab.getPosition()) {
                    case 0:
                        if (fragment1 == null) {
                            fragment1 = TabFragment1.newInstance();
                        }
//                        transaction.replace(R.id.id_content, fragment1);
//                        switchContent(fragment2, fragment1, 1);
                        switchContent(fragment1);
                        break;
                    case 1:
                        if (fragment2 == null) {
                            fragment2 = TabFragment2.newInstance();
                        }
//                        transaction.replace(R.id.id_content, fragment2);
//                        switchContent(fragment1, fragment2, 2);
                        switchContent(fragment2);
                        break;
                    case 2:
                        break;
                }
//                transaction.commit();

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

        initView();
    }

    private void initView() {
            fragment1 = TabFragment1.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.id_content, fragment1);
            mFragment = fragment1;
            transaction.commit();
    }



    private Fragment mFragment;// 当前正在显示的fragment

    /** fragment切换不会重复new fragment对象，replace方法会导致fragment每次都走oncreatView()方法
     *  如果fragment在oncreat()方法中从网络抓取数据，会导致用户流量损失以及体验也不好
     * @param to
     */
    public void switchContent(Fragment to) {
        if (mFragment != to) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(mFragment).add(R.id.id_content, to).commit(); // 隐藏当前的fragment，add下一个fragment到Activity中
            } else {
                transaction.hide(mFragment).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            mFragment = to;
        }  
    }

}
