package example.toong.contacttree;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/NotoSans-Bold.ttf");

        tv.setTypeface(face);
//        tv2.setTypeface(face);
    }
}
