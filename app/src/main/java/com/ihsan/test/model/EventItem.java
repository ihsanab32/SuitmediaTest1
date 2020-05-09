package com.ihsan.test.model;

import com.google.gson.annotations.SerializedName;

public class EventItem {

	@SerializedName("eventid")
	private int eventid;

	@SerializedName("enddate")
	private String enddate;

	@SerializedName("address")
	private String address;

	@SerializedName("nama")
	private String nama;

	@SerializedName("foto")
	private String foto;

	@SerializedName("lng")
	private Object lng;

	@SerializedName("description")
	private String description;

	@SerializedName("startdate")
	private String startdate;

	@SerializedName("lat")
	private Object lat;

	public void setEventid(int eventid){
		this.eventid = eventid;
	}

	public int getEventid(){
		return eventid;
	}

	public void setEnddate(String enddate){
		this.enddate = enddate;
	}

	public String getEnddate(){
		return enddate;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setLng(Object lng){
		this.lng = lng;
	}

	public Object getLng(){
		return lng;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setStartdate(String startdate){
		this.startdate = startdate;
	}

	public String getStartdate(){
		return startdate;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"eventid = '" + eventid + '\'' + 
			",enddate = '" + enddate + '\'' + 
			",address = '" + address + '\'' + 
			",nama = '" + nama + '\'' + 
			",foto = '" + foto + '\'' + 
			",lng = '" + lng + '\'' + 
			",description = '" + description + '\'' + 
			",startdate = '" + startdate + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}