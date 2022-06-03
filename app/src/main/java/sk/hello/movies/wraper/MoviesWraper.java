package sk.hello.movies.wraper;

import com.squareup.moshi.Json;

import java.util.List;

import sk.hello.movies.model.Movie;

public class MoviesWraper {

    @Json(name = "results")
    private List<Movie> movies;

    public List<Movie> getMovieList() {
        return movies;
    }

}
