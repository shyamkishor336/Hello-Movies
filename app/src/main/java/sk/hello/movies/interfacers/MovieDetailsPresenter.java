package sk.hello.movies.interfacers;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import sk.hello.movies.interfaces.FavoritesInterface;
import sk.hello.movies.interfaces.MovieDetailsInterface;
import sk.hello.movies.interfaces.MovieDetailsView;
import sk.hello.movies.model.Movie;
import sk.hello.movies.model.Review;
import sk.hello.movies.model.Video;
import sk.hello.movies.utils.RxUtils;


public class MovieDetailsPresenter implements sk.hello.movies.interfaces.MovieDetailsPresenter {
    private MovieDetailsView view;
    private MovieDetailsInterface movieDetailsInterface;
    private FavoritesInterface favoritesInterface;
    private Disposable trailersSubscription;
    private Disposable reviewSubscription;

    public MovieDetailsPresenter(MovieDetailsInterface movieDetailsInterface, FavoritesInterface favoritesInterface) {
        this.movieDetailsInterface = movieDetailsInterface;
        this.favoritesInterface = favoritesInterface;
    }

    @Override
    public void setView(MovieDetailsView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(trailersSubscription, reviewSubscription);
    }

    @Override
    public void showDetails(Movie movie) {
        if (isViewAttached()) {
            view.showDetails(movie);
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void showTrailers(Movie movie) {
        trailersSubscription = movieDetailsInterface.getTrailers(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTrailersSuccess, t -> onGetTrailersFailure());
    }

    private void onGetTrailersSuccess(List<Video> videos) {
        if (isViewAttached()) {
            view.showTrailers(videos);
        }
    }

    private void onGetTrailersFailure() {
        // Do nothing
    }

    @Override
    public void showReviews(Movie movie) {
        reviewSubscription = movieDetailsInterface.getReviews(movie.getId()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetReviewsSuccess, t -> onGetReviewsFailure());
    }

    private void onGetReviewsSuccess(List<Review> reviews) {
        if (isViewAttached()) {
            view.showReviews(reviews);
        }
    }

    private void onGetReviewsFailure() {
        // Do nothing
    }

    @Override
    public void showFavoriteButton(Movie movie) {
        boolean isFavorite = favoritesInterface.isFavorite(movie.getId());
        if (isViewAttached()) {
            if (isFavorite) {
                view.showFavorited();
            } else {
                view.showUnFavorited();
            }
        }
    }

    @Override
    public void onFavoriteClick(Movie movie) {
        if (isViewAttached()) {
            boolean isFavorite = favoritesInterface.isFavorite(movie.getId());
            if (isFavorite) {
                favoritesInterface.unFavorite(movie.getId());
                view.showUnFavorited();
            } else {
                favoritesInterface.setFavorite(movie);
                view.showFavorited();
            }
        }
    }
}
