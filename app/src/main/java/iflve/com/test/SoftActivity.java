package iflve.com.test;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import org.ksoap2.serialization.SoapObject;

public class SoftActivity extends AppCompatActivity {
    private Button buttonCamera;
    private TestGridView gridview;
    private static Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_soft);
        gridview = (TestGridView) findViewById(R.id.gridview);
        gridview.setAdapter(new TestGridViewAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                LoginService xx = new LoginService("sdd");
                               // Log.i("sbsb", "cccssss");
                              //  Log.i("sbsb", xx.LoadResult().getProperty(0).toString());
                            }
                        }).start();
                        Log.i("sbsb","1111111111111111");
                        break;
                    case 1:
                        Log.i("sbsb","222222222222222222222");
                        break;
                    case 2:
                        Log.i("sbsb","333333333333333333333");
                        break;
                    case 3:
                        Log.i("sbsb","44444444444444444444");
                        break;
                    case 4:
                        Log.i("sbsb","55555555555555555555");
                        break;
                    case 5:
                        Log.i("sbsb","66666666666666666666");
                        break;
                    case 6:
                        Log.i("sbsb","777777777777777777");
                        break;
                    case 7:
                        Log.i("sbsb","8888888888888888888888888");
                        break;
                    case 8:
                        Log.i("sbsb","99999999999999999999");
                        break;
                    case 9:
                        Log.i("sbsb","0000000000000000000");
                        break;
                    case 10:
                        Log.i("sbsb","aaaaaaaaaaaaaaaaaa");
                        break;
                }
            }
        });
    }

}
