package com.pouillos.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.enumeration.EntriesType;
import com.pouillos.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillos.sortirnice.modelentries.Entries;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntriesBoutique;
import com.pouillos.sortirnice.utils.DateUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEntriesBoutiqueActivity extends NavDrawerEntryActivity implements RecyclerAdapterEntriesBoutique.Listener {

    private static final String TAG = AfficherEntriesBoutiqueActivity.class.getSimpleName();
    private RecyclerAdapterEntriesBoutique adapterEntries;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_entry_boutique);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        setTitle("Liste des Boutiques");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);

        connectAndGetApiData(myUrl);
    }

    public void connectAndGetApiData(String url) {
        retrofit = new Retrofit.Builder()
                // .baseUrl(BASE_URL+"/"+dateString)
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
                    progressBar.setVisibility(View.GONE);
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
            }
        });
    }

    @Override
    public void onClickEntriesButton(int position) {
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        saveEntry(selectedEntry,EntriesType.Boutique);
        fabExit.performClick();
    }

    public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntriesBoutique(listEntries, this);
        list_recycler_event.setAdapter(adapterEntries);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }
}