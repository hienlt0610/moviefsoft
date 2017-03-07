package hutech.hienlt.movie.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultPage<T>{

	@SerializedName("page")
	@Expose
	private int page;

	@SerializedName("total_pages")
	@Expose
	private int totalPages;

	@SerializedName("results")
	@Expose
	private List<T> results;

	@SerializedName("total_results")
	@Expose
	private int totalResults;

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setResults(List<T> results){
		this.results = results;
	}

	public List<T> getResults(){
		return results;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}
}