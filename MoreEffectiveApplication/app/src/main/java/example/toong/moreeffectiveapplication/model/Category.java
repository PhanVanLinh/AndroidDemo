package example.toong.moreeffectiveapplication.model;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by phanvanlinh on 28/02/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class Category {
    public static final int BATTERY = 0;
    public static final int HEALTH = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;

    @IntDef({ BATTERY, HEALTH, TUESDAY, WEDNESDAY })
    @Retention(RetentionPolicy.SOURCE)
    public @interface WeekDays {
    }

    @WeekDays
    int currentDay = BATTERY;
    private String name;
    private int icon;
    private
    @WeekDays
    int type;

    public void setType(@WeekDays int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getType() {
        return type;
    }
}
