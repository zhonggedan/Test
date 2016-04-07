package iflve.com.test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2016/3/31.
 */
public class TestListViewAdapter extends BaseAdapter {
    private String[] shijianX = {"2014年11月25日",
            "2015年11月25日",
            "2016年01月02日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日",
            "2014年11月25日"};
    private String[] jineX = {"99.51","100.00","6500.00","891.00","450.20","520.00","15000.00","800.00","700.00","3500.00","6500.00","8500.00","14000.00"};
    private String[] leixingX = {"招商银行","农业银行","工商银行","招商银行","农业银行","工商银行","工商银行","工商银行","工商银行","工商银行","工商银行","工商银行","工商银行"};
     private int[] tupianX={R.drawable.pay0,
             R.drawable.pay2,
             R.drawable.pay3,
             R.drawable.pay0,
             R.drawable.pay1,
             R.drawable.pay0,
             R.drawable.pay4,
             R.drawable.pay4,
             R.drawable.pay3,
             R.drawable.pay0,
             R.drawable.pay0,
             R.drawable.pay0,
             R.drawable.pay2};
    private Context mContext;

    public TestListViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return shijianX.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(
                R.layout.listitem_bg, parent, false);
    }
        TextView shijian = BaseViewHolder.get(convertView, R.id.shijian);
        TextView leixing = BaseViewHolder.get(convertView, R.id.leixing);
        TextView jine = BaseViewHolder.get(convertView, R.id.jine);
        ImageView iv = BaseViewHolder.get(convertView, R.id.tupian);
        shijian.setText(shijianX[position]);
        jine.setText(jineX[position]);
        leixing.setText(leixingX[position]);
        iv.setBackgroundResource(tupianX[position]);
        return convertView;
    }

}
