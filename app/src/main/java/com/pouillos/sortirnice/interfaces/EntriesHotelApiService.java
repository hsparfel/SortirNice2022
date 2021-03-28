package com.pouillos.sortirnice.interfaces;

import com.pouillos.sortirnice.modelentries.Entries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesHotelApiService {

    @GET("entries_hotels.xml")
    Call<Entries> getEntries();
}
