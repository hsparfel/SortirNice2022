package com.pouillcorp.sortirnice.interfaces;

import com.pouillcorp.sortirnice.modelevents.Events;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventsApiService {

    @GET("events_public.xml")
    Call<Events> getEvents();
    //Call<Events> getEvents(@Query("dae3988a-a667-40a6-a74c-42df34b5aff9") String apiKey);

}
