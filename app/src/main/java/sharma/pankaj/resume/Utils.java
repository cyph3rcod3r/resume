package sharma.pankaj.resume;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by Cyph3r on 09/09/15.
 */
public class Utils {
    public static final String TAG = "resume_app";

    public static int[] getScreenWidthAndHeight(Activity ctx) {
        int[] arr = new int[2];
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ctx.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        arr[0] = displaymetrics.widthPixels;
        arr[1] = displaymetrics.heightPixels;
        logError("Screen width & height :" + displaymetrics.widthPixels + " - " + displaymetrics.heightPixels);
        return arr;
    }

    public static void logError(String msg) {
        Log.e(TAG, msg);
    }
}
