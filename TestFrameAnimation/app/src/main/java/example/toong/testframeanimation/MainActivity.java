package example.toong.testframeanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
    }

    public void startAnimation(){
        final ImageView img = (ImageView) findViewById(R.id.image);
        if(((AnimationDrawable) img.getBackground()).isRunning()){
            ((AnimationDrawable) img.getBackground()).stop();
        }
        ((AnimationDrawable) img.getBackground()).start();
    }
}
