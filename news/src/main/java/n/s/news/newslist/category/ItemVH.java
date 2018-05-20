package n.s.news.newslist.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import n.s.news.R;
import n.s.news.base.BaseVH;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class ItemVH extends BaseVH<NewsItem> {

    private TextView title;
    private TextView coefficient;
    private TextView place;
    private TextView time;
    private TextView preview;

    public ItemVH(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false));
        title = (TextView) itemView.findViewById(R.id.tvTitle);
        coefficient = (TextView) itemView.findViewById(R.id.tvCoefficient);
        place = (TextView) itemView.findViewById(R.id.tvPlace);
        time = (TextView) itemView.findViewById(R.id.tvTime);
        preview = (TextView) itemView.findViewById(R.id.tvPreview);
}

    @Override
    public void bind(NewsItem item) {
        title.setText(item.getTitle());
        coefficient.setText(item.getCoefficient());
        place.setText(item.getPlace());
        time.setText(item.getTime());
        preview.setText(item.getPreview());
    }
}
