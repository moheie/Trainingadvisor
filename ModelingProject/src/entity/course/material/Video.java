package entity.course.material;

import java.util.ArrayList;
import java.util.List;

public class Video {
    private String url;

    public Video(String url) {
        this.url = url;
    }

    public Video() {
        this.url = "";
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
}
