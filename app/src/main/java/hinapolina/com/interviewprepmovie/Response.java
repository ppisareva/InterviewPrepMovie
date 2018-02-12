package hinapolina.com.interviewprepmovie;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by polina on 2/11/18.
 */

public class Response {
    @SerializedName("results")
        List<Movie> movies;



        public Response() {
            movies = new ArrayList<Movie>();
        }


    }
