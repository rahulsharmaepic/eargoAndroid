package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Flags{

	@SerializedName("sources")
	private List<String> sources;

	@SerializedName("units")
	private String units;

	public void setSources(List<String> sources){
		this.sources = sources;
	}

	public List<String> getSources(){
		return sources;
	}

	public void setUnits(String units){
		this.units = units;
	}

	public String getUnits(){
		return units;
	}

	@Override
 	public String toString(){
		return 
			"Flags{" + 
			"sources = '" + sources + '\'' + 
			",units = '" + units + '\'' + 
			"}";
		}
}