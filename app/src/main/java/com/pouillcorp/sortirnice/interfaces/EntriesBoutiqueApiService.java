package com.pouillcorp.sortirnice.interfaces;

import com.pouillcorp.sortirnice.modelentries.Entries;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesBoutiqueApiService {

    @GET("entries_boutiques.xml")
    Call<Entries> getEntries();
}
