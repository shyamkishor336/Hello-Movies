package sk.hello.movies.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import sk.hello.movies.model.Movie;

public class MovieRealmObject extends RealmObject {

    @PrimaryKey
    private String id;
    private String overview;
    private String releaseDate;
    private String posterPath;
    private String backdropPath;
    private String title;
    private double voteAverage;

    public static final String ID = "id";
    public static final String OVERVIEW = "overview";
    public static final String RELEASE_DATE = "releaseDate";
    public static final String POSTER_PATH = "posterPath";
    public static final String BACKDROP_PATH = "backdropPath";
    public static final String TITLE = "title";
    public static final String VOTE_AVERAGE = "voteAverage";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }


    public String getReleaseDate() {
        return releaseDate;
    }


    public String getPosterPath() {
        return posterPath;
    }


    public String getBackdropPath() {
        return backdropPath;
    }


    public String getTitle() {
        return title;
    }


    public double getVoteAverage() {
        return voteAverage;
    }


    public MovieRealmObject(Movie movie) {
        id = movie.getId();
        overview = movie.getOverview();
        releaseDate = movie.getReleaseDate();
        posterPath = movie.getPosterPath();
        backdropPath = movie.getBackdropPath();
        title = movie.getTitle();
        voteAverage = movie.getVoteAverage();
    }

    public MovieRealmObject() {

    }
}
