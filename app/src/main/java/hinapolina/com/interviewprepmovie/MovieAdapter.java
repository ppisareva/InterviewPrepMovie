package hinapolina.com.interviewprepmovie;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by polina on 2/11/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.VH> {
    List<Movie> list = new ArrayList<>();
    Context context;
    int position;

    public MovieAdapter(List<Movie> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);


        View contactView = inflater.inflate(R.layout.item_movie, parent, false);

        VH viewHolder = new VH(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        setPosition(position);
    Movie movie  = list.get(position);
        holder.title.setText(movie.getTitle());
        holder.desc.setText(movie.getOverview());
        if( context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w500" + movie.getImageLand())
                    .centerCrop()
                    .into(holder.image);
        } else{
            Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w500" + movie.getImage())
                    .centerCrop()
                    .into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.textTitle)  TextView title;
        @BindView(R.id.textDescrip)  TextView desc;
        @BindView(R.id.imageMovie)  ImageView image;
        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
