package sk.hello.movies.interfaces;


import java.util.List;

import sk.hello.movies.model.Review;
import sk.hello.movies.model.Video;
import sk.hello.movies.model.Movie;


public interface MovieDetailsView {
    void showDetails(Movie movie);

    void showTrailers(List<Video> trailers);

    void showReviews(List<Review> reviews);

    void showFavorited();

    void showUnFavorited();
}
