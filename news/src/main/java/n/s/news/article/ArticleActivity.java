package n.s.news.article;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import n.s.news.ErrorHandler;
import n.s.news.R;
import n.s.news.base.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.ITALIC;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class ArticleActivity extends BaseActivity{
    private static IArticleActivity iDataItem;

    private ProgressBar pb;

    private SwipeRefreshLayout refresh;

    private ScrollView sv;


    TextView tvTitle,tvTeam1, tvVs, tvTeam2, tvTime, tvTournament, tvPlace, tvArticle, tvPrediction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent intent = getIntent();
        final String article = intent.getStringExtra("article");

        sv = (ScrollView)findViewById(R.id.scrollView);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTeam1 = (TextView) findViewById(R.id.tvTeam1);
        tvTeam2 = (TextView) findViewById(R.id.tvTeam2);
        tvVs = (TextView) findViewById(R.id.tvVs);
        tvTournament = (TextView) findViewById(R.id.tvTournament);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvPlace = (TextView) findViewById(R.id.tvPlace);
        tvArticle = (TextView) findViewById(R.id.tvArticle);
        tvPrediction = (TextView) findViewById(R.id.tvPrediction);
        pb = (ProgressBar) findViewById(R.id.pb);
        refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData(article);
            }
        });

        iDataItem = getApp().getRetrofit().create(IArticleActivity.class);
        loadData(article);

    }

    private void loadData(String article) {
        iDataItem.getNews(article).enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                //clear old data
                tvPrediction.setText(Html.fromHtml("<b>" + getString(R.string.prediction) + "</b>"));
                tvArticle.setText("");
                //set new data
                ArticleResponse body = response.body();
                tvTitle.setTypeface(tvTitle.getTypeface(), BOLD);
                tvTitle.setText(getIntent().getStringExtra("title"));
                tvTeam1.setText(body.getTeam1());
                tvVs.setTypeface(tvVs.getTypeface(), ITALIC);
                tvVs.setText(R.string.vs);
                tvTeam2.setText(body.getTeam2());
                tvTournament.setText(body.getTournament());
                tvTime.setText(body.getTime());
                tvPlace.setText(body.getPlace());
                tvPrediction.append(" " + body.getPrediction());
                for(Paragraf p : body.getArticle()) {
                    tvArticle.append(Html.fromHtml("<b>" + p.getHeader() + "</b><br/><br/>"));
                    tvArticle.append(p.getText());
                    tvArticle.append(Html.fromHtml("<br/><br/>"));
                }
                pb.setVisibility(View.GONE);
                sv.setVisibility(View.VISIBLE);
                refresh.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                ErrorHandler.onFailure(getApp(), call, t);
                pb.setVisibility(View.GONE);
                refresh.setRefreshing(false);
            }
        });
    }

    @Override
    protected void initToolbar(Toolbar toolbar) {
        super.initToolbar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected String getTitleStr() {
        return "";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
