package sk.hello.movies.interfacers;


import java.util.List;

import io.reactivex.Observable;
import sk.hello.movies.interfaces.MovieDetailsInterface;
import sk.hello.movies.model.Review;
import sk.hello.movies.model.Video;
import sk.hello.movies.utils.TmdbWebService;
import sk.hello.movies.wraper.ReviewsWrapper;
import sk.hello.movies.wraper.VideoWrapper;


public class MovieDetailsInteractorImpl implements MovieDetailsInterface {

    private TmdbWebService tmdbWebService;

    public MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
