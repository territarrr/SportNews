package n.s.news.newslist.category;

import android.view.ViewGroup;

import n.s.news.base.BaseAdapter;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class RVAdapter extends BaseAdapter<NewsItem, ItemVH> {

    @Override
    public void onBind(ItemVH holder, int position) {
        holder.bind(getData().get(position));
    }

    @Override
    public ItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemVH(parent);
    }
}
