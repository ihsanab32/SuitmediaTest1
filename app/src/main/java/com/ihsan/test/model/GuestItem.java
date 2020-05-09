package com.ihsan.test.model;

import com.google.gson.annotations.SerializedName;

public class GuestItem {

	@SerializedName("foto")
	private String foto;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("guestid")
	private int guestid;

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setGuestid(int guestid){
		this.guestid = guestid;
	}

	public int getGuestid(){
		return guestid;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"foto = '" + foto + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",guestid = '" + guestid + '\'' + 
			"}";
		}
}