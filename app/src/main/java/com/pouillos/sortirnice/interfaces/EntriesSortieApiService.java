package com.pouillos.sortirnice.interfaces;

import com.pouillos.sortirnice.modelentries.Entries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesSortieApiService {

    @GET("entries_sorties.xml")
    Call<Entries> getEntries();
}
