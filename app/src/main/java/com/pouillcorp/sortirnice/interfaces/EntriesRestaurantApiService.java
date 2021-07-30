package com.pouillcorp.sortirnice.interfaces;

import com.pouillcorp.sortirnice.modelentries.Entries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesRestaurantApiService {

    @GET("entries_restaurants.xml")
    Call<Entries> getEntries();
}
