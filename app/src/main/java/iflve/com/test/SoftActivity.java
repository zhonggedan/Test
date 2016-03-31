package iflve.com.test;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class SoftActivity extends AppCompatActivity {
    private Button buttonCamera;
    private TestGridView gridview;
    public static SoftActivity self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft);


    }
   public void createX(){
       gridview = (TestGridView) findViewById(R.id.gridview);
       gridview.setAdapter(new TestGridViewAdapter(this));
   }

}
