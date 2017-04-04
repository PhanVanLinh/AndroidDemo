package example.toong.testremovelogusingproguard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "hehe");
        for(int i = 0; i < 20; i++) {
            Log.d("TAG", "hehe");
            Log.i("TAG", "hihi");
        }
    }
}
