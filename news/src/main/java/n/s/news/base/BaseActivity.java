package n.s.news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import n.s.news.App;
import n.s.news.R;

/**
 * Created by Sovochka on 20.05.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public App getApp() {
        return (App) getApplication();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (toolbar == null) {
            toolbar = findViewById(R.id.toolbar);
            if (toolbar != null) {
                initToolbar(toolbar);
            }
        }
    }

    protected void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        setTitle(getTitleStr());
    }

    protected abstract String getTitleStr();
}
