package hpu.dingyue;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

/**
 * Created by Administrator on 2016/4/22.
 */
public class TabLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.getTabAt(0).setText("第一个");
        tabLayout.getTabAt(0).setText("第二个");
        tabLayout.getTabAt(0).setText("第三个");
    }
}
