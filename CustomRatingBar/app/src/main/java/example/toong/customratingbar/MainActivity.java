package example.toong.customratingbar;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText yourEditText = (EditText) findViewById(R.id.text);

        Drawable drawable = yourEditText.getBackground(); // get current EditText drawable
        drawable.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP); // change the drawable color

        if(Build.VERSION.SDK_INT > 16) {
            yourEditText.setBackground(drawable); // set the new drawable to EditText
        }else{
            yourEditText.setBackgroundDrawable(drawable); // use setBackgroundDrawable because setBackground required API 16
        }
    }
}
