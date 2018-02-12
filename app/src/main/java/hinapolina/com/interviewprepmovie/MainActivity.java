package hinapolina.com.interviewprepmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity   {
    List<Movie> list=new ArrayList<>();
    MovieAdapter adapter;
    int page  = 1;
    @BindView(R.id.rvMovie) RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new MovieAdapter(list, this);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        rv.addOnScrollListener(new EndlessScrollListener(manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                page++;
                loadMovies(page);
            }
        });
        loadMovies(page);

    }

    private void loadMovies(int page) {
        Call<Response> responseCall = Network.getService().moviesList(page);
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                list.addAll(response.body().movies);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }


    
}
