package com.pouillos.sortirnice.interfaces;

import com.pouillos.sortirnice.modelentries.Entries;
import com.pouillos.sortirnice.modelentries.Entry;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesApiService {

    @GET("entries_sorties.xml")
    Call<Entries> getEntries();
    //Call<Events> getEvents(@Query("dae3988a-a667-40a6-a74c-42df34b5aff9") String apiKey);

}
