package example.toong.moreeffectiveapplication.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import example.toong.moreeffectiveapplication.R;
import example.toong.moreeffectiveapplication.utils.SpannableUtils;

/**
 * Created by phanvanlinh on 03/03/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class BaseFragment extends Fragment {
    protected ClickableSpan settingClickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            openSetting();
        }
    };

    protected void openSetting() {
        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
    }

    protected void addSetting(TextView textView) {
        addLink(textView, R.string.title_setting, settingClickableSpan);
    }

    protected void addLink(TextView textView, int resource, ClickableSpan clickableSpan) {
        SpannableUtils.createLink(textView, getContext().getString(resource), clickableSpan);
    }
}
