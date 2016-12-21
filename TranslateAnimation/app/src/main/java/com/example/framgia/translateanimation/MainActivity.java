package com.example.framgia.translateanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int mDuration = 1500;

        float mTranslationX = 400;
        float mTranslationY = 400;

        float mScaleX = 2f;
        float mScaleY = 2f;

        ImageView view = (ImageView) findViewById(R.id.image_main);

        ValueAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", mTranslationX);
        ValueAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", mTranslationY);
        ValueAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", mScaleX);
        ValueAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", mScaleY);

        scaleX.setDuration(mDuration);
        scaleY.setDuration(mDuration);
        translationY.setDuration(mDuration);
        translationX.setDuration(mDuration);

        scaleX.setRepeatCount(ValueAnimator.INFINITE);
        scaleY.setRepeatCount(ValueAnimator.INFINITE);
        translationY.setRepeatCount(ValueAnimator.INFINITE);
        translationX.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleX).with(scaleY).with(translationX).with(translationY);
        animatorSet.start();
    }
}
