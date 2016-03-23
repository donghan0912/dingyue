package hpu.dingyue.net;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/3/23.
 */
public class DYHttp {
    // TODO 最好单例
    public static void post(RequestParams params, RequestCallBack callback) {
        params.addQueryStringParameter("wd", "xUtils");
        x.http().post(params, callback);
    }
}
