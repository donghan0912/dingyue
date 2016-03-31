package hpu.dingyue.commonUtils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by Administrator on 2016/3/31.
 */
public class AnimationUtils {

    /**
     * alpha(渐变)、rotation(旋转)、translationX(平移)和scaleY(旋转)
     * AnimatorSet类提供了一个play()方法，如果我们向这个方法中传入一个Animator对象(ValueAnimator
     * 或ObjectAnimator)将会返回一个AnimatorSet.Builder的实例，AnimatorSet.Builder中包括以下四个方法：
     * 1. after(Animator anim)   将现有动画插入到传入的动画之后执行
     * 2. after(long delay)   将现有动画延迟指定毫秒后执行
     * 3. before(Animator anim)   将现有动画插入到传入的动画之前执行
     * 4. with(Animator anim)   将现有动画和传入的动画同时执行
     *
     * 参考资料：http://blog.csdn.net/guolin_blog/article/details/43536355
     *
     */
    public static void scale(View view) {// 缩放动画
        view.setPivotX(0);
        view.setPivotY(0);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "scaleX", 1, 0);// X轴方向缩放
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleY", 1, 0);// Y轴方向缩放
        AnimatorSet animatorSet = new AnimatorSet();// 多个动画执行
        animatorSet.play(animator1).with(animator2);
        animatorSet.setDuration(2000).start();
    }

    /**
     * 平移
     * @param view
     */
    public static void translation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0, -540);// X轴方向平移
        animator.setDuration(2000);
        animator.start();
    }
}
