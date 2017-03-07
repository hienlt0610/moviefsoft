package hutech.hienlt.movie.model.result;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by HienLT9 on 3/6/2017.
 */

public class CastCrewListResult {
    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private ArrayList<CastResult> castResults;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CastResult> getCastResults() {
        return castResults;
    }

    public void setCastResults(ArrayList<CastResult> castResults) {
        this.castResults = castResults;
    }
}
