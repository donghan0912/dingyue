package hpu.dingyue;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.message.PushAgent;

import java.util.List;

import hpu.dingyue.dao.User;
import hpu.dingyue.dao.greendao.UserDao;
import hpu.dingyue.rxbus.RxBus;
import hpu.dingyue.rxbus.RxBusActivity;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/5/3.
 */
public class LoginActivity extends FragmentActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private CompositeSubscription subscription;
    private Button btn5;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        setContentView(R.layout.activity_login);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        getRxBus();
        initClick();
        subject();
    }

    private void subject() {
        subscription = new CompositeSubscription();
        subscription.add(rxBus.toObserverable().subscribe(new Action1<Object>() {
            @Override
            public void call(Object event) {
                if (event instanceof String) {
                    if (!TextUtils.isEmpty((String) event)) {
                        Toast.makeText(LoginActivity.this, (String) event, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }));
    }

    private void initClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(MainActivity.getIntent(this));
                break;
            case R.id.btn2:
//                startActivity(RxBusActivity.getIntent(this));
//                overridePendingTransition(R.anim.put, R.anim.out);
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.put, R.anim.out);

                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeScaleUpAnimation(imageView, //The View that the new activity is animating from
                                (int) imageView.getWidth() / 2, (int) imageView.getHeight() / 2, //拉伸开始的坐标
                                0, 0);//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
                startNewAcitivity(options);
                break;
            case R.id.btn3:
                showDg();
                break;
            case R.id.btn4:
//                FeedbackAPI.openFeedbackActivity(this);
//                startActivity(new Intent(this, ConstraintLayoutActivity.class));
//                checkPermission();
                test();
                break;
            case R.id.btn5:
                startActivity(new Intent(this, RefreshTestActivity.class));
                break;
            case R.id.image:
                ActivityOptionsCompat options1;
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    options1 =
                            ActivityOptionsCompat.makeScaleUpAnimation(v, //The View that the new activity is animating from
                                    (int) v.getWidth() / 2, (int) v.getHeight() / 2, //拉伸开始的坐标
                                    0, 0);//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
                } else {
                    options1 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "image");
                }

                startNewAcitivity(options1);
                break;
        }
    }

    RxBus rxBus = null;

    public RxBus getRxBus() {
        if (rxBus == null) {
            rxBus = new RxBus();
        }
        return rxBus;
    }

    private void showDg() {

//        MyDialogFragment dialog = MyDialogFragment.newInstance(R.layout.dialogfragment_my);
//        dialog.show(getSupportFragmentManager(), "dd");

//        AlertDialog dialog = new AlertDialog.Builder(this).create();
//        View view = View.inflate(this, R.layout.dialogfragment_my, null);
//        dialog.setView(view, 0, 0, 0, 0);
//        dialog.show();
//        int width = getWindowManager().getDefaultDisplay().getWidth();
//        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.gravity = Gravity.CENTER;
//        dialog.getWindow().setAttributes(params);

        new MyDialog().show(getSupportFragmentManager(), "dd");
    }

    private void startNewAcitivity(ActivityOptionsCompat options) {
        Intent intent = new Intent(this, ImageActivity.class);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.clear();
    }

    class MyDialog extends DialogFragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setLayout(width, height);
            View view = View.inflate(getActivity(), R.layout.dialog_test, null);
            return view;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    Uri uri = data.getData();
                    if (uri != null) {
                        Toast.makeText(LoginActivity.this, "sssss", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    }

    public void checkPermission() {
        // 检查是否已经授权该权限
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

//            // 判断是否需要解释获取权限原因
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                // 需要向用户解释
//                // 此处可以弹窗或用其他方式向用户解释需要该权限的原因
//            } else {
//                // 无需解释，直接请求权限
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                        1);
//                // MY_PERMISSIONS_REQUEST_READ_CONTACTS 是自定义的常量，在回调方法中可以获取到
//                checkPermission();
//            }

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        } else {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        }
    }

    // 数据库 参考：http://www.jianshu.com/p/853401a7d02b
    // http://www.jianshu.com/p/252555228b72
    private void test() {
        final UserDao userDao = DingYueApplication.getApplication().getDaoSession().getUserDao();
//        final User user = new User();
//        user.setAge(25);
//        user.setName("hahah");
//        user.setSex(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    User user = new User("测试用户" + i, i, i);

                    userDao.insert(user);
                }

                List<User> users = userDao.loadAll();
                User user1 = users.get(0);
                Log.e("数据", user1.getName());

                String path = DingYueApplication.getApplication().getDb().getPath();
                Log.e("数据库路径", path);
            }
        }).start();
        Log.e("数据库路径","我是test3分支");
    }
}
