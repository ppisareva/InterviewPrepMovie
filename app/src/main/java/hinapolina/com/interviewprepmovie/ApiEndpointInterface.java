package hinapolina.com.interviewprepmovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by polina on 2/11/18.
 */

public interface ApiEndpointInterface {


    @GET("movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed")
    Call<Response> moviesList(@Query("page") int page);


}
