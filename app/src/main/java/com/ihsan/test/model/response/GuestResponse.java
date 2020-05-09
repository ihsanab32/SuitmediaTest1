package com.ihsan.test.model.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.ihsan.test.model.GuestItem;

public class GuestResponse{

	@SerializedName("data")
	private List<GuestItem> data;

	@SerializedName("status")
	private String status;

	public void setData(List<GuestItem> data){
		this.data = data;
	}

	public List<GuestItem> getData(){
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
			"GuestResponse{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}