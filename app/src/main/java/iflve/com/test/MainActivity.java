package iflve.com.test;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import  android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabHost th;
    private Intent soft;
    private Intent money;
    private Intent bill;
    private Intent me;
    private ViewPager viewPage;
    private LocalActivityManager localActivityManager;
    public List<View> lvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localActivityManager = new LocalActivityManager(this, true);
        localActivityManager.dispatchCreate(savedInstanceState);
        soft=new Intent(this,SoftActivity.class);
        money=new Intent(this,MoneyActivity.class);
        bill=new Intent(this,BillActivity.class);
        me=new Intent(this,MeActivity.class);
        viewPage=(ViewPager)findViewById(R.id.viewPage);
        //viewPage.setVisibility(View.VISIBLE);
        th = (TabHost) findViewById(R.id.tabHost);
        th.setup(localActivityManager);
        th.getTabWidget().setBackgroundColor(Color.parseColor("#eeeeee"));
        th.addTab(th.newTabSpec("tab1").setIndicator("美银软件").setContent(soft));
        th.addTab(th.newTabSpec("tab2").setIndicator("美银钱包").setContent(money));
        th.addTab(th.newTabSpec("tab3").setIndicator("我的账单").setContent(bill));
        th.addTab(th.newTabSpec("tab4").setIndicator("个人中心").setContent(me));
        th.setCurrentTab(0);
        th.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                switch (tabId) {
                    case "tab1":
                        viewPage.setCurrentItem(0);
                        break;
                    case "tab2":
                        viewPage.setCurrentItem(1);
                        break;
                    case "tab3":
                        viewPage.setCurrentItem(2);
                        break;
                    case "tab4":
                        viewPage.setCurrentItem(3);
                        break;
                }
            }
        });
        initViewPage();
     viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
         }

         @Override
         public void onPageSelected(int position) {
             th.setCurrentTab(position);
         }

         @Override
         public void onPageScrollStateChanged(int state) {
         }
     });
    }




    private void initViewPage(){
       //viewPage
        lvm = new ArrayList<View>();
        lvm.add(getView(MainActivity.this, soft));
        lvm.add(getView(MainActivity.this,money));
        lvm.add(getView(MainActivity.this,bill));
        lvm.add(getView(MainActivity.this, me));
        MyPageAdapter myPageAdapter= new MyPageAdapter(lvm);
        viewPage.setAdapter(myPageAdapter);
        viewPage.setCurrentItem(0);
    }

    public View getView(Context parent, Intent intent) {

        final Window w = localActivityManager.startActivity(
                "TagName", intent);
        final View wd = w != null ? w.getDecorView() : null;
        return wd ;
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


    private void change(){
        for (int i = 0; i < 3; i++) {
            TextView tv = (TextView) th.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#999999"));
        }
        TextView tv = (TextView) th.getCurrentTabView().findViewById(android.R.id.title);
        tv.setTextColor(Color.parseColor("#33b5e5"));
    }


    class MyPageAdapter extends PagerAdapter{
        public List<View> mListViews;

        public MyPageAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }


        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(mListViews.get(arg1));
        }

        @Override
        public void finishUpdate(View arg0) {
        }

        @Override
        public int getCount() {
            return mListViews.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(mListViews.get(arg1), 0);
            return mListViews.get(arg1);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == (arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }
    }


}



