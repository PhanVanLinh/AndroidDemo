package example.toong.androidgpsapplication;

import android.location.Location;
import android.widget.TextView;

/**
 * Created by phanvanlinh on 14/03/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class LogLocation {

    private static StringBuilder longLatStringBuilder = new StringBuilder();


    public static void printLocation(Location location, TextView textView, String prefix){

        longLatStringBuilder.append(prefix+"long:"
                + location.getLatitude()
                + " - lat:"
                + location.getLongitude()
                + " - isMock :"
                + location.isFromMockProvider()
                + "\n");
        textView.setText(longLatStringBuilder);
    }
}
