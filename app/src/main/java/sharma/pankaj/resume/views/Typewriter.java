package sharma.pankaj.resume.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Type Writer Class from StackOver flow User Devunwired
 *
 * @link http://stackoverflow.com/questions/6700374/android-character-by-character-display-text-animation
 * <p/>
 * Although I know this work I was working late at night so felt quiet lazy to do this
 */
public class Typewriter extends TextView {

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 80; //Default 500ms delay
    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public Typewriter(Context context) {
        super(context);
        init();
    }

    public Typewriter(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * added to animate the text provided in the xml attribute!
     */
    private void init() {
        String text;
        if (getText() != null) {
            text = getText().toString();
            setText("");
            animateText(text);
        }
    }

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
}