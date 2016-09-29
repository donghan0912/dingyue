package hpu.dingyue;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Administrator on 2016/9/26.
 */

public class ConstraintLayoutActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private String url = "file:///android_asset/help.html";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);
        SwipeRefreshLayout mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mRefreshLayout.setColorSchemeResources(R.color.black, R.color.black,
                R.color.black, R.color.black);
        mRefreshLayout.setOnRefreshListener(this);
        WebView webView = (WebView) findViewById(R.id.webview);

        webView.loadUrl(url);
    }

    @Override
    public void onRefresh() {

    }
}
