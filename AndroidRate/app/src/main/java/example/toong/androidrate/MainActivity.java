package example.toong.androidrate;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import example.toong.androidrate.utils.AndroidRate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAndroidRate();
            }
        });
    }

    private void showAndroidRate(){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).setTitle("s").create();
        AndroidRate.getInstance().show(alertDialog);
    }
}
