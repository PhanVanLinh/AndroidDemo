package example.toong.moreeffectiveapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import example.toong.moreeffectiveapplication.fragment.BaseFragment;
import example.toong.moreeffectiveapplication.utils.SpannableUtils;

public class OneFragment extends BaseFragment{
 
    public OneFragment() {
        // Required empty public constructor
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        TextView tv = (TextView) view.findViewById(R.id.textView);

        replaceText(tv, "O", Color.BLUE);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            }
        };

        SpannableUtils.createLink(tv, getContext().getString(R.string.title_setting),settingClickableSpan);

        addSetting(tv);

        return view;
    }

    private void replaceText(TextView text, String str, int color) {
        Spannable raw = new SpannableString(text.getText());
        BackgroundColorSpan[] spans = raw.getSpans(0,raw.length(),BackgroundColorSpan.class);

        for (BackgroundColorSpan span : spans) {
            raw.removeSpan(span);
        }
        int index = TextUtils.indexOf(raw, str);
        while (index >= 0) {
            raw.setSpan(new BackgroundColorSpan(color), index, index + str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            index = TextUtils.indexOf(raw, str, index + str.length());
        }
        text.setText(raw);
    }

}