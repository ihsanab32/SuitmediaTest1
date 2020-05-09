package com.ihsan.test.utils.api;

import com.ihsan.test.model.response.EventResponse;
import com.ihsan.test.model.response.GuestResponse;

import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 09/05/2020.
 * ------------------------------
 * This class for
 */
public interface NetworkStores {

    @GET("listGuest")
    Observable<GuestResponse>
    getGuest(@Header("security") String security);

    @GET("listEvent")
    Observable<EventResponse>
    getEvent(@Header("security") String security);

}
