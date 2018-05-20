package n.s.news;

import android.support.annotation.StringRes;

/**
 * Created by Sovochka on 20.05.2018.
 */

public enum SportCategory {
    FOOTBALL(R.string.cat_football, "football"),
    HOCKEY(R.string.cat_hockey, "hockey"),
    TENNIS(R.string.cat_tennis, "tennis"),
    BASKETBALL(R.string.cat_basketball, "basketball"),
    VOLLEYBALL(R.string.cat_volleyball, "volleyball"),
    CYBERSPORT(R.string.cat_cybersport, "cybersport");

    @StringRes
    private final int catName;
    private final String catParam;

    SportCategory(@StringRes int catName, String catParam) {
        this.catName = catName;
        this.catParam = catParam;
    }

    @StringRes
    public int getCatName() {
        return catName;
    }

    public String getCatParam() {
        return catParam;
    }
}
