package example.toong.videoviewexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextureVideoView video = (TextureVideoView) findViewById(R.id.videoview);

        video.setShouldRequestAudioFocus(false);

        String path = "android.resource://"
                + getPackageName()
                + "/"
                + R.raw.video_open_gift_tutorial;
        video.setVideoURI(Uri.parse(path));

        video.start();
    }
}