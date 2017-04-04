package example.toong.testmaxvalueapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView a = (TextView) findViewById(R.id.text);


//        for(int i = 0; i < Integer.MAX_VALUE; i++){
//
//        }

        a.setText(""+Integer.MAX_VALUE+"\n"+(Integer.MAX_VALUE+10)+"\n"+(Integer.MAX_VALUE+3));


        int as = Integer.MAX_VALUE+10;

        as += 916421649;

        a.append("\n"+as);



// Max int: 2147483647

//        2147476591

//        2147483647 - 2147476591 = 7056
    }
}
