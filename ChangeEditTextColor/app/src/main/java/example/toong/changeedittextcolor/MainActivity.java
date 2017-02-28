package example.toong.changeedittextcolor;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt1 = (EditText) findViewById(R.id.edt1);

        Drawable drawable = edt1.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if(Build.VERSION.SDK_INT > 16) {
            edt1.setBackground(drawable); // set the new drawable to EditText
        }else{
            edt1.setBackgroundDrawable(drawable); // use setBackgroundDrawable because setBackground required API 16
        }


        EditText edt2 = (EditText) findViewById(R.id.edt2);
        Drawable drawable2 = edt2.getBackground(); // get current EditText drawable
        drawable2.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if(Build.VERSION.SDK_INT > 16) {
            edt2.setBackground(drawable2); // set the new drawable to EditText
        }else{
            edt2.setBackgroundDrawable(drawable2); // use setBackgroundDrawable because setBackground required API 16
        }

    }
}
