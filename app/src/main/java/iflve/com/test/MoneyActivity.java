package iflve.com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

    }

}
