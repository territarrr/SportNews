package n.s.news.newslist.category;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import n.s.news.SportCategory;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private Context context;

    public PageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override public int getCount() {
        return SportCategory.values().length;
    }

    @Override public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override public CharSequence getPageTitle(int position) {
        return context.getString(SportCategory.values()[position].getCatName());
    }
}
