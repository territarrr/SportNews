package n.s.news.newslist.category;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * Created by Sovochka on 20.05.2018.
 */

public interface INewsApi {
    @GET("/list.php")
    Call<NewsResponse> getNews(@Query("category") String category);
}
