package n.s.news.base;

/**
 * Created by Sovochka on 20.05.2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseAdapter<D, VH extends BaseVH<D>> extends RecyclerView.Adapter<VH> {

    private List<D> data = new ArrayList<>();
    private OnClickListener<D, VH> listener;


    public abstract void onBind(VH holder, int position);

    @Override
    public final void onBindViewHolder(final VH holder, final int position) {
        onBind(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(getData().get(position), holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public List<D> getData() {
        return data;
    }

    public void addItem(D item) {
        data.add(item);
        notifyItemInserted(data.size() - 1);
    }

    public void addItems(Collection<D> items) {
        int startRange = data.size();
        data.addAll(items);
        int endRange = data.size();
        notifyItemRangeInserted(startRange, endRange);
    }

    public void setData(Collection<D> items) {
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    public void setListener(OnClickListener<D, VH> listener) {
        this.listener = listener;
    }

    public interface OnClickListener<D, VH> {
        void onItemClick(D item, VH vh);
    }
}
