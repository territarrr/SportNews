package n.s.news.newslist.category;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class NewsItem {
    private String title, coefficient, time, place, preview, article;
    public NewsItem( String title, String coefficient, String preview, String article) {
        this.title = title;
        this.coefficient = coefficient;
        this.preview = preview;
        this.article = article;
    }
    public NewsItem(){}

    public String getCoefficient(){
        return coefficient;
    }

    public String getTime(){
        return time;
    }

    public String getPlace(){
        return place;
    }

    public String getTitle(){
        return title;
    }

    public String getPreview(){
        return preview;
    }

    public String getArticle() {return article;}

    public void setCoefficient(String coefficient){
        this.coefficient = coefficient;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPreview(String preview){
        this.preview = preview;
    }

    public void setArticle(String article) { this.article = article; }

    public void setTime(String time) { this.time = time; }

    public void setPlace(String place) { this.place = place; }
}
