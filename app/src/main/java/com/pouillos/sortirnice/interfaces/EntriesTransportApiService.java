package com.pouillos.sortirnice.interfaces;

import com.pouillos.sortirnice.modelentries.Entries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesTransportApiService {

    @GET("entries_transports.xml")
    Call<Entries> getEntries();
}
