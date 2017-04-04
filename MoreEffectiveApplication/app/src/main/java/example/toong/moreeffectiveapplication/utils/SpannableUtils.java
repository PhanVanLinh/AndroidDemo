package example.toong.moreeffectiveapplication.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.widget.TextView;

/**
 * Created by phanvanlinh on 03/03/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class SpannableUtils {

    public static TextView createLink(TextView targetTextView,
            String partToClick, ClickableSpan clickableAction) {

        SpannableString spannableString = new SpannableString(targetTextView.getText());

        // make sure the String is exist, if it doesn't exist
        // it will throw IndexOutOfBoundException
        int startPosition = targetTextView.getText().toString().indexOf(partToClick);
        int endPosition = targetTextView.getText().toString().lastIndexOf(partToClick) + partToClick.length();

        spannableString.setSpan(clickableAction, startPosition, endPosition,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#e1e3e5")), startPosition, endPosition,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        targetTextView.setText(spannableString);
        targetTextView.setMovementMethod(LinkMovementMethod.getInstance());

        return targetTextView;
    }
}
