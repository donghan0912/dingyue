package hpu.dingyue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import hpu.dingyue.refreshActivity.ListViewActivity;
import hpu.dingyue.refreshActivity.RecyclerViewActivity;
import hpu.dingyue.refreshActivity.ScrollViewActivity;

/**
 * Created by Administrator on 2016/8/17.
 */
public class RefreshTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        findViewById(R.id.recyclerview_tv).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent(RefreshTestActivity.this,
                                RecyclerViewActivity.class);
                        startActivity(intent);
                    }
                });
        findViewById(R.id.listview_tv).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RefreshTestActivity.this,
                                ListViewActivity.class);
                        startActivity(intent);
                    }
                });
        findViewById(R.id.scrollview_tv).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        Intent intent = new Intent(RefreshTestActivity.this,
                                ScrollViewActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
