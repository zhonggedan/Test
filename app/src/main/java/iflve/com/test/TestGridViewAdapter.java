package iflve.com.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2016/3/29.
 */
public class TestGridViewAdapter extends BaseAdapter {

    public String[] img_text = {"android开发", "ios开发", "微信平台", "淘宝平台", "支付宝平台", "汇潮支付",
            "国付宝", "连连支付", "行业应用", "网站建设", "联系我们"};
    public int[] imgs = {R.drawable.android, R.drawable.apple,
            R.drawable.weixin, R.drawable.taobao,
            R.drawable.zhifubao, R.drawable.huichao,
            R.drawable.guofubao, R.drawable.lianlian, R.drawable.windows, R.drawable.wangzhanjianshe, R.drawable.lianxiwm};
    private Context mContext;

    public TestGridViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return img_text.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.griditem_bg, parent, false);
        }
        TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
        ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);


        iv.setBackgroundResource(imgs[position]);

        tv.setText(img_text[position]);
        return convertView;
    }
}
