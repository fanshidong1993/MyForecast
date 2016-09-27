package udacity.com.fanshidong.www.myforecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.txt);
        EventBus.getDefault().register(this);
        i = 0;
        startService(new Intent(this,MyService.class));
    }


    @Subscribe
    public void onEvent(Event event){
        tv.setText("Hello Activity I am Service."+(i++));
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
