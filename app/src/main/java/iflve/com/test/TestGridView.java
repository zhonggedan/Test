package iflve.com.test;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by admin on 2016/3/29.
 */
public class TestGridView extends GridView {
    public TestGridView(Context context) {
        super(context);
    }

    public TestGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public TestGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
