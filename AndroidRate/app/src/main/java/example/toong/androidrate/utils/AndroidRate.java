package example.toong.androidrate.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by phanvanlinh on 23/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class AndroidRate {
    private static final String PREF_DATE_FIRST_LAUNCHED = "";
    private static final String PREF_LAUNCH_COUNT = "launch_count";
    private static final String PREF_IS_RATE = "is_rate";
    private volatile static AndroidRate instance;
    private Configuration mConfiguration;

    public static AndroidRate getInstance(Context context) {
        if (instance == null) {
            synchronized (AndroidRate.class) {
                if (instance == null) {
                    instance = new AndroidRate(context);
                }
            }
        }
        return instance;
    }

    private AndroidRate(Context context) {
        saveInt(context, PREF_LAUNCH_COUNT, getInt(context, PREF_LAUNCH_COUNT) + 1);
    }

    public void saveInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(Context context, String key) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(key, 0);
    }

    public void init(Configuration configuration) {
        mConfiguration = configuration;
        if (mConfiguration == null) {
            throw new IllegalArgumentException("You must init configuration");
        }
    }

    public void show(Dialog dialog) {

        dialog.show();
    }

    public static class Configuration {
        private int daysUntilPrompt;
        private int useUntilPrompt;

        public Configuration() {
        }

        public Configuration(int daysUntilPrompt, int useUntilPrompt) {
            this.daysUntilPrompt = daysUntilPrompt;
            this.useUntilPrompt = useUntilPrompt;
        }

        public static class Builder {
            private int daysUntilPrompt;
            private int useUntilPrompt;

            public Builder() {
            }

            public Configuration build() {
                return new Configuration(daysUntilPrompt, useUntilPrompt);
            }

            public Builder setDaysUntilPrompt(int daysUntilPrompt) {
                this.daysUntilPrompt = daysUntilPrompt;
                return this;
            }

            public Builder setUseUntilPrompt(int useUntilPrompt) {
                this.useUntilPrompt = useUntilPrompt;
                return this;
            }
        }
    }
}
