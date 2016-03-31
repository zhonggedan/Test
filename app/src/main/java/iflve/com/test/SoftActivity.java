package iflve.com.test;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;


public class SoftActivity extends AppCompatActivity {
    private Button buttonCamera;
    private TestGridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_soft);
        Log.i("sb", "excute！");
        gridview = (TestGridView) findViewById(R.id.gridview);
        gridview.setAdapter(new TestGridViewAdapter(this));
    }

}
