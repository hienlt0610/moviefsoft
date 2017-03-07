package hutech.hienlt.movie.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import hutech.hienlt.movie.common.Config;
import hutech.hienlt.movie.model.result.CastResult;
import hutech.hienlt.movie.R;

/**
 * Created by HienLT9 on 3/6/2017.
 */

public class ListCastAdapter extends RecyclerArrayAdapter<CastResult> {

    public ListCastAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    public class ViewHolder extends BaseViewHolder<CastResult>{
        @BindView(R.id.imgCast)
        ImageView imgCast;
        @BindView(R.id.tvCastName)
        TextView tvCastName;
        public ViewHolder(ViewGroup parent) {
            super(parent, R.layout.list_cast);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(CastResult data) {
            super.setData(data);
            Glide.with(getContext()).load(Config.BASE_IMG_URL+"/w342"+data.getProfilePath()).into(imgCast);
            tvCastName.setText(data.getName());
        }
    }
}
