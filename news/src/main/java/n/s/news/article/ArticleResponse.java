package n.s.news.article;

import java.util.List;

/**
 * Created by Sovochka on 20.05.2018.
 */

public class ArticleResponse {
    private String team1;
    private String team2;
    private String time;
    private String tournament;
    private String place;
    private List<Paragraf> article;
    private String prediction;

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Paragraf> getArticle() {
        return article;
    }

    public void setArticle(List<Paragraf> article) {
        this.article = article;
    }
}
