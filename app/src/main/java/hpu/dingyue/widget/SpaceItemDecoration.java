package hpu.dingyue.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 空白间隔
 * Created by Administrator on 2016/11/24.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int verticalItemSpace;
    private final int horizontalItemSpace;

    public SpaceItemDecoration(int verticalItemSpace, int horizontalItemSpace) {
        this.verticalItemSpace = verticalItemSpace;
        this.horizontalItemSpace = horizontalItemSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = horizontalItemSpace;
        outRect.right = horizontalItemSpace;
        outRect.top = verticalItemSpace;
        outRect.bottom = verticalItemSpace;
        // 第二种
//        int left = horizontalItemSpace;
//        int right = horizontalItemSpace;
//        int top = verticalItemSpace;
//        int bottom = verticalItemSpace;
//        outRect.set(left, top, right, bottom);
    }
}
