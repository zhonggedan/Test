package iflve.com.test;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TabHost th;
    private Intent soft;
    private Intent money;
    private Intent bill;
    private Intent me;
    private RadioGroup rg;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocalActivityManager localActivityManager = new LocalActivityManager(this, true);
        localActivityManager.dispatchCreate(savedInstanceState);
        th = (TabHost) findViewById(R.id.tabHost);
        th.setup(localActivityManager);
        th.getTabWidget().setBackgroundColor(Color.parseColor("#eeeeee"));
        th.addTab(th.newTabSpec("tab1").setIndicator("美银软件").setContent(new Intent(this,SoftActivity.class)));
        th.addTab(th.newTabSpec("tab2").setIndicator("美银钱包").setContent(new Intent(this,MoneyActivity.class)));
        th.addTab(th.newTabSpec("tab3").setIndicator("我的账单").setContent(new Intent(this,BillActivity.class)));
        th.addTab(th.newTabSpec("tab4").setIndicator("个人中心").setContent(new Intent(this,MeActivity.class)));
        th.setCurrentTab(0);
        th.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < th.getTabWidget().getChildCount(); i++) {
                    TextView tv = (TextView) th.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
                    tv.setTextColor(Color.parseColor("#999999"));
                }
                TextView tv = (TextView) th.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
                tv.setTextColor(Color.parseColor("#33b5e5"));
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem mi1 = menu.add(1, Menu.FIRST + 1, 1, "搜索");
        mi1.setShowAsAction(1);
        mi1.setIcon(R.drawable.shousuo);
        MenuItem mi2 = menu.add(1, Menu.FIRST + 2, 1, "刷新");
        mi2.setShowAsAction(1);
        mi2.setIcon(R.drawable.shuaxin);
        menu.add(2, Menu.FIRST + 3, 1, "设置");
        menu.add(2, Menu.FIRST + 4, 1, "退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView tv;
        for (int i = 0; i < th.getTabWidget().getChildCount(); i++) {
            tv = (TextView) th.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#999999"));
        }
        tv = (TextView) th.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
        tv.setTextColor(Color.parseColor("#33b5e5"));
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }
}



