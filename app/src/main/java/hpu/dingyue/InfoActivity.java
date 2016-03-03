package hpu.dingyue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * Created by Administrator on 2016/3/3.
 */
public class InfoActivity extends Activity {
    private static final String LINK = "LINK";

    public static Intent getIntent(Context context, String link) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(LINK, link);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String link = getIntent().getStringExtra(LINK);

        WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
//        settings.setUseWideViewPort(true);
        webView.loadUrl(link);
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                view.loadUrl(url);
//                return true;
//            }
//        });
    }
}
