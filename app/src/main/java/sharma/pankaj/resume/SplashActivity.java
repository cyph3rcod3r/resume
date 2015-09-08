package sharma.pankaj.resume;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class SplashActivity extends BaseActivity {

    private CircleImageView cImgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cImgIcon = (CircleImageView) findViewById(R.id.civ_splash);
        cImgIcon.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadActivityAccordingToSdk();
                    }
                }, 200);
            }
        });
    }

    @Override
    public void initContent() {
        setContentView(R.layout.activity_splash);
    }

    /**
     * I tried Shared Element in this piece of code
     * But somehow its laggy.
     * I need to figure this out
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void loadActivityAccordingToSdk() {
        Intent i = new Intent(SplashActivity.this, DashboardActivity.class);

//        View sharedView = cImgIcon;
//        String transitionName = getString(R.string.transition_name);
        startActivity(i);

//        if (isGreaterThanLollipop()) {
//            ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this, sharedView, transitionName);
//            startActivity(i, transitionActivityOptions.toBundle());
//        } else {
//            startActivity(i);
//        }
    }

}
