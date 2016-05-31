package hpu.dingyue.net;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lenovo on 2016/5/30.
 */
public interface ImageService {

    @GET("imgs?col=美女&tag=少妇&sort=0&tag3=&pn=0&rn=30&p=channel&from=1")
    Observable<Image> getImage();
}
