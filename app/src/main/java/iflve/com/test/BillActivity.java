package iflve.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

public class BillActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_bill);

        Log.i("sb", "111111111111111111111111111111111111");
        listView = (ListView)findViewById(R.id.listView);
        Log.i("sb",String.valueOf(new TestListViewAdapter(this).getCount()));
       // Log.i("sb",typeof());
        listView.setVerticalScrollBarEnabled(true);
       listView.setAdapter(new TestListViewAdapter(this));
        Log.i("sb", "333333333333333333333333333333");
    }
}
