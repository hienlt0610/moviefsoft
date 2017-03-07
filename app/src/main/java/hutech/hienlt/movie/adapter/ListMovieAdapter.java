package hutech.hienlt.movie.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.orm.query.Condition;
import com.orm.query.Select;

import org.modelmapper.ModelMapper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hutech.hienlt.movie.R;
import hutech.hienlt.movie.common.Config;
import hutech.hienlt.movie.model.Movie;
import hutech.hienlt.movie.model.db.MovieDTO;
import hutech.hienlt.movie.model.result.MovieResult;
import hutech.hienlt.movie.util.DateUtils;
import hutech.hienlt.movie.util.StringUtils;

/**
 * Created by HienLT9 on 3/2/2017.
 */

public class ListMovieAdapter extends RecyclerArrayAdapter<Movie> {

    public enum TypeShow{LIST, GRID};

    private TypeShow typeShow = TypeShow.LIST;
    private Context context;
    private ModelMapper mapper;


    public ListMovieAdapter(Context context) {
        super(context);
        this.context = context;
        mapper = new ModelMapper();
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        if(typeShow == TypeShow.LIST)
            return new ViewHolderList(parent);
        else
            return new ViewHolderGrid(parent);
    }

    public class ViewHolderList extends BaseViewHolder<Movie> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.imgPoster)
        ImageView imgPoster;

        @BindView(R.id.tvReleaseDate)
        TextView tvReleaseDate;

        @BindView(R.id.tvRating)
        TextView tvRating;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @BindView(R.id.tvType)
        TextView tvType;

        @BindView(R.id.btnRate)
        ImageButton btnRate;

        private boolean isFavorite;

        public ViewHolderList(ViewGroup parent) {
            super(parent, R.layout.list_movie);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(Movie data) {
            tvTitle.setText(data.getTitle());
            tvReleaseDate.setText(DateUtils.dateFormat(data.getReleaseDate(), "dd/MM/yyyy"));
            tvRating.setText(data.getVoteAverage()+"/10");
            tvDescription.setText(StringUtils.limitWord(data.getOverView(),13)+"...");
            Glide.with(context).load(Config.BASE_IMG_URL+"/w342"+data.getPosterPath()).into(imgPoster);

            if(data.isAdult()){
                ((GradientDrawable)tvType.getBackground())
                        .setColor(ContextCompat.getColor(context, R.color.material_red_400));
                tvType.setText(context.getString(R.string.adult));
            }else{
                ((GradientDrawable)tvType.getBackground())
                        .setColor(ContextCompat.getColor(context, R.color.material_green_400));
                tvType.setText(context.getString(R.string.all));
            }

            updateFavoriteState(data.isFavorite());
        }
        @OnClick(R.id.btnRate)
        public void onRateChanged(View view) {
//            MovieResult movie = getItem(getAdapterPosition());
//            isFavorite = (MovieDTO.find(MovieDTO.class,"_id = ?", String.valueOf(movie.getId())).size() > 0) ? true : false;
//            if(isFavorite){
//                Select.from(MovieDTO.class).where(Condition.prop("_id").eq(movie.getId())).first().delete();
//                btnRate.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.star_off));
//            }else{
//                MovieDTO model = new MovieDTO(movie);
//                model.save();
//                btnRate.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.star_on));
//            }
            Movie movie = getItem(getAdapterPosition());
            if(movie.isFavorite()){
                //Remove favorite
                boolean isSuccess = Select.from(MovieDTO.class).where(Condition.prop("_id").eq(movie.getId())).first().delete();
                if(isSuccess){
                    movie.setFavorite(!movie.isFavorite());
                }
            }else{
                //Add favorite
                MovieDTO model = mapper.map(movie, MovieDTO.class);
//                model.setTitle(movie.getTitle());
//                model.setPosterPath(movie.getPosterPath());
//                model.setAdult(movie.isAdult());
//                model.setId(movie.getId());
//                model.setOverview(movie.getOverView());
//                model.setReleaseDate(movie.getReleaseDate());
//                model.setVoteAverage(movie.getVoteAverage());
                if(model.save() > 0){
                    movie.setFavorite(!movie.isFavorite());
                }
            }

            updateFavoriteState(movie.isFavorite());
        }

        private void updateFavoriteState(boolean isFavorite){
            if(isFavorite){
                btnRate.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.star_on));
            }else{
                btnRate.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.star_off));
            }
        }
    }

    public class ViewHolderGrid extends BaseViewHolder<MovieResult>{

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.imgPoster)
        ImageView imgPoster;

        public ViewHolderGrid(ViewGroup parent) {
            super(parent, R.layout.grid_movie);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(MovieResult data) {
            super.setData(data);
            tvTitle.setText(data.getTitle());
            Glide.with(context).load(Config.BASE_IMG_URL+"/w342"+data.getPosterPath()).into(imgPoster);
        }
    }

    public TypeShow getTypeShow() {
        return typeShow;
    }

    public void setTypeShow(TypeShow typeShow) {
        this.typeShow = typeShow;
    }
}
