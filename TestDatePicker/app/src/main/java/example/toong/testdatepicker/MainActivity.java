package example.toong.testdatepicker;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Intent;
import android.media.AudioManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                intent.addCategory("com.android.settings.SHORTCUT");

                startActivityForResult(intent, 0);
            }
        });

        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        int volume_level= am.getStreamVolume(AudioManager.STREAM_MUSIC);
        int volume_max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        MainActivity m = (MainActivity) this;
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
//        AppWidgetHost host = m.getAppWidgetHost();

        List<AppWidgetProviderInfo> widgetList = manager.getInstalledProviders();
//
//        AppWidgetProviderInfo searchProvider = null;
//        AppWidgetProviderInfo search2Provider = null;
//        AppWidgetProviderInfo clockProvider = null;

        for ( AppWidgetProviderInfo info : widgetList ) {
            Log.i("Linh", "info"+info.provider.getClassName());
        }
    }
}

