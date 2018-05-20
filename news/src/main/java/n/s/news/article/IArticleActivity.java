package n.s.news.article;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sovochka on 20.05.2018.
 */

public interface IArticleActivity {
    @GET("/post.php")
    Call<ArticleResponse> getNews(@Query("article") String category);
}
