package hutech.hienlt.movie.ui.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.modelmapper.ModelMapper;

import butterknife.BindView;
import hutech.hienlt.movie.R;
import hutech.hienlt.movie.adapter.ListMovieAdapter;
import hutech.hienlt.movie.common.BaseMvpFragment;
import hutech.hienlt.movie.event.ChangeListStyleEvent;
import hutech.hienlt.movie.model.Movie;
import hutech.hienlt.movie.model.db.MovieDTO;
import hutech.hienlt.movie.model.result.MovieResult;
import hutech.hienlt.movie.model.result.MovieResultPage;
import hutech.hienlt.movie.ui.movie_detail.MovieDetailActivity;

/**
 * Created by HienLT9 on 3/2/2017.
 */

public class MovieFragment extends BaseMvpFragment<MoviePresenter, MovieView> implements MovieView, RecyclerArrayAdapter.OnMoreListener, RecyclerArrayAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerMovie;

    private ListMovieAdapter adapter;
    private boolean isListStyle = true;
    private int page = 1;
    private ModelMapper mapper;
    @Override
    public int getResLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ListMovieAdapter(getActivity());
        mapper = new ModelMapper();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        getPresenter().showPopularMovie(1);
        recyclerMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ListMovieAdapter(getActivity());
        recyclerMovie.setAdapter(adapter);
        adapter.setMore(R.layout.load_more,this);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChangeListStyleEvent event) {
        isListStyle = !isListStyle;
        if(isListStyle){
            recyclerMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter.setTypeShow(ListMovieAdapter.TypeShow.LIST);
        }else{
            recyclerMovie.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            adapter.setTypeShow(ListMovieAdapter.TypeShow.GRID);
        }
        recyclerMovie.setAdapter(adapter);
    }

    boolean isOk = true;


    @NonNull
    @Override
    public MoviePresenter providePresenter() {
        return new MoviePresenter();
    }

    @Override
    public void showPopularMovie(MovieResultPage result) {
        for(MovieResult movieResult : result.getResults()){
            Movie movie = mapper.map(movieResult, Movie.class);
            boolean isFavorite = (MovieDTO.find(MovieDTO.class,"_id = ?", String.valueOf(movieResult.getId())).size() > 0) ? true : false;
            movie.setFavorite(isFavorite);
            adapter.add(movie);
        }
    }

    @Override
    public void loadMore(MovieResultPage result) {
        for(MovieResult movieResult : result.getResults()){
            Movie movie = mapper.map(movieResult, Movie.class);
            boolean isFavorite = (MovieDTO.find(MovieDTO.class,"_id = ?", String.valueOf(movie.getId())).size() > 0) ? true : false;
            movie.setFavorite(isFavorite);
            adapter.add(movie);
        }
    }

    @Override
    public void onMoreShow() {
        page++;
        getPresenter().showMoreMovie(page);
    }

    @Override
    public void onMoreClick() {

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        intent.putExtra("movie_id", adapter.getItem(position).getId());
        getActivity().startActivity(intent);
    }
}
