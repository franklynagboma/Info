package com.franklyn.info.helper;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by FRANKLYN on 03/13/2016.
 */
public class TextWriter extends AppCompatTextView {


    private CharSequence mText;
    private int mIndex;
    private long mDelay = 500; //Default 500ms delay


    public TextWriter(Context context) {
        super(context);
    }

    public TextWriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }

    public CharSequence getmText() {
        return mText;
    }
}
