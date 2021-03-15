package com.pouillos.sortirnice.interfaces;

import com.pouillos.sortirnice.model.Events;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventsApiService {

    @GET("20210315/events_public.xml")
    Call<Events> getEvents();
    //Call<Events> getEvents(@Query("dae3988a-a667-40a6-a74c-42df34b5aff9") String apiKey);

}
