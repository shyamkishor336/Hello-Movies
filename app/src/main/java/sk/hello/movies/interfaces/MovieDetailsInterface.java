package sk.hello.movies.interfaces;



import java.util.List;

import io.reactivex.Observable;
import sk.hello.movies.model.Review;
import sk.hello.movies.model.Video;

public interface MovieDetailsInterface {
    Observable<List<Video>> getTrailers(String id);

    Observable<List<Review>> getReviews(String id);
}
