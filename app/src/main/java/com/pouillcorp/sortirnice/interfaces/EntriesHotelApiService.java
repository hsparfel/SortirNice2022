package com.pouillcorp.sortirnice.interfaces;

import com.pouillcorp.sortirnice.modelentries.Entries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesHotelApiService {

    @GET("entries_hotels.xml")
    Call<Entries> getEntries();
}
