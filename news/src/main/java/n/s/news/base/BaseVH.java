package n.s.news.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Sovochka on 20.05.2018.
 */

public abstract class BaseVH<D> extends RecyclerView.ViewHolder {

    public BaseVH(View itemView) {
        super(itemView);
    }

    public abstract void bind(D item);
}
