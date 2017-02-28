package example.toong.countdowntimerexample;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView mTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextField = (TextView) findViewById(R.id.textView);

        new CountDownTimer(30000, 10000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                mTextField.setText("done!");
            }

        }.start();
    }
}
