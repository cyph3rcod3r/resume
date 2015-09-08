package sharma.pankaj.resume;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Cyph3r on 08/09/15.
 */
public class MainFrameActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    private int[] screenSize;
    private CoordinatorLayout mCoordinatorLayout;
    private boolean isAnimated = false;

    @Override
    public void initContent() {
        setContentView(R.layout.activity_main_frame);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenSize = Utils.getScreenWidthAndHeight(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                if (!isAnimated) {
                    floatViewToCenter(view);
                } else {
                    floatViewBack(view);
                }
            }
        });
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void floatViewToCenter(View v) {
//        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("x", 0);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", screenSize[1] / 2);
        ObjectAnimator oa = ObjectAnimator.ofPropertyValuesHolder(v, pvhY);
        oa.start();
        isAnimated = true;
    }

    private void floatViewBack(View v) {
        int yValue = mCoordinatorLayout.getHeight() - (v.getHeight() + v.getPaddingBottom());
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("y", yValue);
        ObjectAnimator oa = ObjectAnimator.ofPropertyValuesHolder(v, pvhY);
        oa.start();
        isAnimated = false;
    }
}
