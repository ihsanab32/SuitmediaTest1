package com.ihsan.test.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.ihsan.test.model.EventItem;

public class EventResponse{

	@SerializedName("data")
	private List<EventItem> data;

	@SerializedName("status")
	private String status;

	public void setData(List<EventItem> data){
		this.data = data;
	}

	public List<EventItem> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"EventResponse{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}