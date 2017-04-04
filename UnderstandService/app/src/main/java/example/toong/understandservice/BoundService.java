package example.toong.understandservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BoundService extends Service {
    private IBinder binder;

    // phương thức khởi tạo
    @Override
    public void onCreate() {
        Log.d("ServiceDemo", "Đã gọi onCreate()");

        binder = new MyBinder(); // do MyBinder được extends Binder
        super.onCreate();
    }

    // Bắt đầu một Service
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("ServiceDemo", "Đã gọi onBind()");
        // trả về đối tượng binder cho ActivityMain
        Toast.makeText(this, "Service onBind", Toast.LENGTH_LONG).show();
        return binder;
    }

    // Kết thúc một Service
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("ServiceDemo", "Đã gọi onBind()");
        Toast.makeText(this, "Service onUnbind", Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service onDestroy", Toast.LENGTH_LONG).show();
    }

    public class MyBinder extends Binder{
        // phương thức này trả về đối tượng MyService
        public BoundService getService() {
            return BoundService.this;
        }
    }
}