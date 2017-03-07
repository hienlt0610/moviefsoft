package hutech.hienlt.movie.ui.movie_detail;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import hutech.hienlt.movie.adapter.ListCastAdapter;
import hutech.hienlt.movie.common.BaseMvpActivity;
import hutech.hienlt.movie.common.Config;
import hutech.hienlt.movie.common.ItemClickSupport;
import hutech.hienlt.movie.dialog.ReminderDatePicker;
import hutech.hienlt.movie.model.result.CastCrewListResult;
import hutech.hienlt.movie.model.result.MovieResult;
import hutech.hienlt.movie.util.DateUtils;
import hutech.hienlt.movie.R;
import timber.log.Timber;

/**
 * Created by HienLT9 on 3/6/2017.
 */

public class MovieDetailActivity extends BaseMvpActivity<MovieDetailPresenter, MovieDetailView> implements MovieDetailView,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.tvReleaseDate)
    TextView tvRelease;
    @BindView(R.id.tvRating)
    TextView tvRating;
    @BindView(R.id.btnRate)
    ImageButton btnRate;
    @BindView(R.id.imgPoster)
    ImageView imgPoster;
    @BindView(R.id.tvOverview)
    TextView tvOverview;
    @BindView(R.id.btnReminder)
    Button btnReminder;
    @BindView(R.id.recyclerCast)
    EasyRecyclerView recyclerCast;

    private ListCastAdapter castAdapter;
    private Calendar reminderTime;

    @Override
    public int getResLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @NonNull
    @Override
    public MovieDetailPresenter providePresenter() {
        return new MovieDetailPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        onNewIntent(getIntent());
    }

    private void init() {
        recyclerCast.getRecyclerView().setHorizontalScrollBarEnabled(false);
        recyclerCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        castAdapter = new ListCastAdapter(this);
        showHomeAsUp(true);
        recyclerCast.setAdapter(castAdapter);
        reminderTime = Calendar.getInstance();

        ItemClickSupport.addTo(recyclerCast.getRecyclerView()).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(MovieDetailActivity.this, "position: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showMovieDetail(MovieResult movie) {
        tvRelease.setText(DateUtils.dateFormat(movie.getReleaseDate(),"dd/MM/yy"));
        tvRating.setText(movie.getVoteAverage()+"");
        Glide.with(this).load(Config.getImageUrl(movie.getPosterPath())).into(imgPoster);
        tvOverview.setText(movie.getOverview());
        setTitle(movie.getTitle());
    }

    @Override
    public void showCasts(CastCrewListResult result) {
        Timber.d(new Gson().toJson(result));
        castAdapter.addAll(result.getCastResults());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int movieId = intent.getIntExtra("movie_id", 0);
        getPresenter().showDetail(movieId);
        getPresenter().showListCast(movieId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
        }
        return true;
    }

    @OnClick(R.id.btnReminder)
    public void reminderOnClick(View view){
        Calendar now = Calendar.getInstance();
        ReminderDatePicker picker = ReminderDatePicker.newInstance(this, now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DATE));
        picker.show(getFragmentManager(),"Datepicker");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        reminderTime.set(Calendar.YEAR, year);
        reminderTime.set(Calendar.MONTH, monthOfYear);
        reminderTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        Calendar now = Calendar.getInstance();
        TimePickerDialog dialog = TimePickerDialog.newInstance(this, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE),true);
        dialog.show(getFragmentManager(),"Timepicker");
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        reminderTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        reminderTime.set(Calendar.MINUTE, minute);
        reminderTime.set(Calendar.SECOND, second);

        Toast.makeText(this, DateUtils.dateFormat(reminderTime.getTime(), "dd/MM/yyyy HH:mm:ss"), Toast.LENGTH_SHORT).show();
    }
}
