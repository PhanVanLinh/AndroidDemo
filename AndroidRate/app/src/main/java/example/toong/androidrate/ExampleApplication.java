package example.toong.androidrate;

import android.app.Application;
import example.toong.androidrate.utils.AndroidRate;

/**
 * Created by phanvanlinh on 23/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AndroidRate.Configuration configuration = new AndroidRate.Configuration.Builder().
                setDaysUntilPrompt(2).setUseUntilPrompt(2).build();

        AndroidRate.getInstance().init(configuration);
    }
}
