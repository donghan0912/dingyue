package hpu.dingyue.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by lenovo on 2016/5/30.
 */
public class ImageUtils {

    public static Observable<Image> getImage() {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl("http://image.baidu.com/data/").build();
        return retrofit.create(ImageService.class).getImage();
    }
}
