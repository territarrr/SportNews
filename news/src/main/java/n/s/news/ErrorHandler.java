package n.s.news;

import android.content.Context;
import android.widget.Toast;

import java.net.UnknownHostException;

import n.s.news.article.ArticleResponse;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class ErrorHandler {
    public static void onFailure(Context context, Call<?> call, Throwable t) {
        String errText;
        if(t instanceof UnknownHostException) {
            errText = context.getString(R.string.err_no_internet);
        } else {
            errText = t.getMessage();
        }
        Toast.makeText(context, errText, Toast.LENGTH_SHORT).show();
    }
}
