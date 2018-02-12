package hinapolina.com.interviewprepmovie;

import com.google.gson.annotations.SerializedName;

/**
 * Created by polina on 2/11/18.
 */

public class Movie {
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("backdrop_path")
    String imageLand;
    @SerializedName("poster_path")
    String image;
    @SerializedName("overview")
    String overview;

    public String getImageLand() {
        return imageLand;
    }

    public void setImageLand(String imageLand) {
        this.imageLand = imageLand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }


}
