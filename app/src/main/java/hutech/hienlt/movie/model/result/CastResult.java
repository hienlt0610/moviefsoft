package hutech.hienlt.movie.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CastResult {

	@SerializedName("cast_id")
	@Expose
	private int castId;

	@SerializedName("character")
	@Expose
	private String character;

	@SerializedName("credit_id")
	@Expose
	private String creditId;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("profile_path")
	@Expose
	private String profilePath;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("order")
	@Expose
	private int order;

	public void setCastId(int castId){
		this.castId = castId;
	}

	public int getCastId(){
		return castId;
	}

	public void setCharacter(String character){
		this.character = character;
	}

	public String getCharacter(){
		return character;
	}

	public void setCreditId(String creditId){
		this.creditId = creditId;
	}

	public String getCreditId(){
		return creditId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProfilePath(String profilePath){
		this.profilePath = profilePath;
	}

	public String getProfilePath(){
		return profilePath;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}
}