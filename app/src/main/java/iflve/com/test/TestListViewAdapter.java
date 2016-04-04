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
    private String[] BillTime = {"2014年11月25日 10：11：26",
            "2015年11月25日 08：22：14",
            "2016年01月02日 08：55：05",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26",
            "2014年11月25日 10：11：26"};
    private String[] tYpe = {"99.51","100.00","6500.00","891.00","450.20","520.00","15000.00","800.00","700.00","3500.00","6500.00","8500.00","14000.00"};
    private String[] bAnk = {"招商银行","农业银行","工商银行","招商银行","农业银行","工商银行","工商银行","工商银行","工商银行","工商银行","工商银行","工商银行","工商银行"};
    private String[] bankAcount={"622848**********910","622848**********425","622848**********223","622848**********910","622848**********425","622848**********223","622848**********223","622848**********223","622848**********223","622848**********223","622848**********223","622848**********223","622848**********223"};
    private int[] bankLogo={R.drawable.zhaoshang,R.drawable.nongye,R.drawable.gongshang,R.drawable.zhaoshang,R.drawable.nongye,R.drawable.gongshang,R.drawable.gongshang,R.drawable.gongshang,R.drawable.gongshang,R.drawable.gongshang,R.drawable.gongshang,R.drawable.gongshang,R.drawable.gongshang};
    private Context mContext;

    public TestListViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return BillTime.length;
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
        TextView billtime = BaseViewHolder.get(convertView, R.id.time);
        TextView bank = BaseViewHolder.get(convertView, R.id.bank);
        TextView type = BaseViewHolder.get(convertView, R.id.type);
        TextView acount = BaseViewHolder.get(convertView, R.id.acount);
        ImageView iv = BaseViewHolder.get(convertView, R.id.banklogo);
        billtime.setText(BillTime[position]);
        bank.setText(bAnk[position]);
        type.setText(tYpe[position]);
        acount.setText(bankAcount[position]);
        iv.setBackgroundResource(bankLogo[position]);
        Log.i("sb", convertView.toString());
        return convertView;
    }

}
