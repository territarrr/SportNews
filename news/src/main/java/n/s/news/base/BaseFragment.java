package n.s.news.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import n.s.news.App;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class BaseFragment extends Fragment {
    public App getApp() {
        return (App) getActivity().getApplication();
    }
}
