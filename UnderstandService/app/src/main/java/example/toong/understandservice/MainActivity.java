package example.toong.understandservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Different between bound service and unbound service
 * http://stackoverflow.com/a/25240537/5381331
 *
 * Both bound and unbound service will destroy when we call stopService or stopSelf
 *
 * Bound service will destroy when all client unbind
 *
 *
 * Unbound service will destroy when we call stop
 *
 */


public class MainActivity extends AppCompatActivity {
    private boolean isBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forBoundService();

        forUnBoundService();
    }

    private void forBoundService() {
        // Khởi tạo ServiceConnection
        final ServiceConnection connection = new ServiceConnection() {

            // Phương thức này được hệ thống gọi khi kết nối tới service bị lỗi
            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound = false;
            }

            // Phương thức này được hệ thống gọi khi kết nối tới service thành công
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                BoundService.MyBinder binder = (BoundService.MyBinder) service;
                BoundService myService = binder.getService(); // lấy đối tượng MyService
                isBound = true;
            }
        };

        Button btnStartBoundService = (Button) findViewById(R.id.btnStartBoundService);
        Button btnStopBoundService = (Button) findViewById(R.id.btnStopBoundService);
        final Intent intent = new Intent(MainActivity.this, BoundService.class);
        btnStartBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
                // Bắt đầu một service sủ dụng bind
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                // Đối thứ ba báo rằng Service sẽ tự động khởi tạo
            }
        });

        btnStopBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nếu Service đang hoạt động
                if (isBound) {
                    // Tắt Service
                    unbindService(connection);
                    isBound = false;
                    stopService(intent);
                }
            }
        });
    }

    private void forUnBoundService() {
        Button btnStartUnBoundService = (Button) findViewById(R.id.btnStartUnBoundService);
        Button btnStopUnBoundService = (Button) findViewById(R.id.btnStopUnBoundService);

        btnStartUnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, UnBoundMyService.class));
            }
        });

        btnStopUnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, UnBoundMyService.class));
            }
        });
    }
}
