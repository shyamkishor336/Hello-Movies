package sk.hello.movies.wraper;

import com.squareup.moshi.Json;

import java.util.List;

import sk.hello.movies.model.Video;


public class VideoWrapper {

    @Json(name = "results")
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}
