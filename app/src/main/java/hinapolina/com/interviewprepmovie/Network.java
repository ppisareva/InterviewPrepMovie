package hinapolina.com.interviewprepmovie;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by polina on 2/11/18.
 */

public class Network {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static String DATE_FORMAT = "yyyy-MM-dd";


    public static ApiEndpointInterface getService() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(DATE_FORMAT);
        Gson gson = gsonBuilder.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ApiEndpointInterface.class);
    }


}
