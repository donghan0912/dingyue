package hpu.dingyue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/9/13.
 */
public class ImageFragment extends Fragment {
    public static final int[] images = new int[]{R.drawable.bg_guide1,
            R.drawable.bg_guide2, R.drawable.bg_guide3};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(images[0]);
        return view;
    }
}
