package iflve.com.test;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by admin on 2016/3/31.
 */
public class TestListViewAdapter extends BaseAdapter {
    public String[] BillTime = {"2014年11月25日 10：11：26", "2015年11月25日 08：22：14", "2016年01月02日 08：55：05"};
    private String[] type = {"生活消费","生活消费","生活消费"};
    private String[] bank = {"招商银行","农业银行","工商银行"};
    private String[] bankAcount={"622848**********910","622848**********425","622848**********223"};
    private int[] bankLogo={R.drawable.qianbao,R.drawable.qianbao，R.drawable.qianbao};
    private Context mContext;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }

}
