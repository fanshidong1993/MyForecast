package udacity.com.fanshidong.www.myforecast;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import org.greenrobot.eventbus.EventBus;


public class MyService extends Service {
    MyInterface myInterface;
    public MyService(MyInterface myInterface) {
        this.myInterface = myInterface;
    }
    public MyService(){

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(){
            @Override
            public void run() {
                super.run();

                while (true) {
                    try {
                        Thread.sleep(1000);
                        //EventBus.getDefault().post(new Event());
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();

       // EventBus.getDefault().post(new Event());
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            EventBus.getDefault().post(new Event());
        }
    };
}
