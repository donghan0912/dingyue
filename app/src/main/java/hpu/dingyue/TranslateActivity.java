package hpu.dingyue;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.R.attr.bitmap;

/**
 * Created by Administrator on 2016/10/21.
 */

public class TranslateActivity extends AppCompatActivity {

    public static Intent getIntent(Context context, Bitmap bitmap) {
        Intent intent = new Intent(context, TranslateActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("bitmap", bitmap);
//        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_back);
//        Bundle bundle = getIntent().getExtras();
//        Bitmap bitmap = bundle.getParcelable("bitmap");
//        findViewById(R.id.root).setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
//        getWindow().getDecorView().setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));

    }


}
