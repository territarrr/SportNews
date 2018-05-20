package n.s.news.newslist.category;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import n.s.news.ErrorHandler;
import n.s.news.R;
import n.s.news.SportCategory;
import n.s.news.base.BaseAdapter;
import n.s.news.base.BaseFragment;
import n.s.news.article.ArticleActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class PageFragment extends BaseFragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private SportCategory category;

    private static INewsApi iData;

    private RecyclerView rv;
    private RVAdapter rvAdapter;
    private ProgressBar pb;
    private LinearLayoutManager llm;
    private SwipeRefreshLayout refresh;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = SportCategory.values()[getArguments().getInt(ARG_PAGE)];
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newscategory, container, false);

        refresh = view.findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadDada();
            }
        });
        rv = view.findViewById(R.id.rv);
        llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        pb = view.findViewById(R.id.pb);

        rvAdapter = new RVAdapter();
        rvAdapter.setListener(new BaseAdapter.OnClickListener<NewsItem, ItemVH>() {
            @Override
            public void onItemClick(NewsItem item, ItemVH itemVH) {
                Intent intent = new Intent(getContext(), ArticleActivity.class);
                intent.putExtra("article", item.getArticle());
                intent.putExtra("title", item.getTitle());
                startActivity(intent);
            }
        });
        rv.setAdapter(rvAdapter);

        iData = getApp().getRetrofit().create(INewsApi.class);
        loadDada();
        // TextView textView = (TextView) view;
        //textView.setText("Fragment #" + category);
        return view;
    }

    private void loadDada() {
        iData.getNews(category.getCatParam()).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                for (NewsItem item : response.body().getEvents()) {
                    rvAdapter.addItem(item);
                }
                pb.setVisibility(View.GONE);
                refresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                ErrorHandler.onFailure(getApp(), call, t);
                pb.setVisibility(View.GONE);
                refresh.setRefreshing(false);
            }
        });
    }
}
