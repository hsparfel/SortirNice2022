package com.pouillcorp.sortirnice.services;

import android.util.Log;
import android.view.View;

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillcorp.sortirnice.modelentries.Entries;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class BoutiqueApiServices {

    private static BoutiqueApiServices apiService = new BoutiqueApiServices();

    public List<Entry> listEntries;

    public static BoutiqueApiServices getInstance( )
    {
        return apiService;
    }

    /*public void connectAndGetApiData(String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        EntriesBoutiqueApiService entriesBoutiqueApiService = retrofit.create(EntriesBoutiqueApiService.class);
        Call<Entries> call = entriesBoutiqueApiService.getEntries();
        call.enqueue(new Callback<Entries>() {
            @Override
            public void onResponse(Call<Entries> call, Response<Entries> response) {
                if (response.code()==200) {
                    listEntries = response.body().getListEntries();
                    configureRecyclerView();
                    isResponded = true;
                    Log.d(TAG, "Number of entries received: " + listEntries.size());
                    listerFiltre();
                    initListFiltres();
                    afficherFiltreNonVide();
                    initCheckboxesTitreClick();
                    initCheckboxesSelectAllClick();
                    progressBar.setVisibility(View.GONE);
                    Log.e("verif menuItemB2", "menuItem : "+menuItems);
                    Log.e("verif itemB2", "item : "+item);
                    item = menuItems.findItem(R.id.menu_activity_main_filter);
                    item.setVisible(true);

                } else {
                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    Log.e("TAG", "date rch : "+dateDemandeString);
                    myUrl = BASE_URL+dateDemandeString+"/";
                    connectAndGetApiData(myUrl);
                }
            }

            @Override
            public void onFailure(Call<Entries> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
                gererErreur(EntriesType.Boutique,throwable.toString());
            }
        });
    }*/



}
