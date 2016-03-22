package hpu.dingyue.net;

import org.xutils.http.RequestParams;
import org.xutils.x;

import hpu.dingyue.bean.ChatMessage;

/**
 * Created by Administrator on 2016/3/22.
 */
public class ChatUtil {


    public static void get(final DYCallBack<Boolean> callBack) {
        RequestParams requestParams = new RequestParams();
        x.http().post(requestParams, new RequestCallBack() {
            @Override
            public void success(String result) {
                callBack.onGet(true);
            }
        });
    }

    public static void getInfo(ChatMessage message, final DYCallBack<String> callBack) {
        RequestParams params = new RequestParams("http://www.tuling123.com/openapi/api");
        params.addBodyParameter("key", "3bc4d8968b4bfccf2a1f16e87e1ab0bb");
        params.addBodyParameter("info", message.msg);
        params.addQueryStringParameter("wd", "xUtils");
        x.http().post(params, new RequestCallBack() {
            @Override
            public void success(String result) {
                callBack.onGet(result);
            }
        });
    }
}
