package com.pouillcorp.sortirnice.interfaces;

import com.pouillcorp.sortirnice.modelentries.Entries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EntriesTransportApiService {

    @GET("entries_transports.xml")
    Call<Entries> getEntries();
}
