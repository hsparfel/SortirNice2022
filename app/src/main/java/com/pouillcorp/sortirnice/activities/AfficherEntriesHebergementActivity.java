package com.pouillcorp.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.interfaces.EntriesHebergementApiService;
import com.pouillcorp.sortirnice.modelentries.Entries;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.utils.DateUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEntriesHebergementActivity extends NavDrawerEntryActivity {

    //private static final String TAG = AfficherEntriesHebergementActivity.class.getSimpleName();
    //private RecyclerAdapterEntries adapterEntries;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_entry_various);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        setTitle(R.string.hebergements);
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_entry).setChecked(true);

        connectAndGetApiData(myUrl);
        entryType = EntriesType.Hebergement;
    }

    public void connectAndGetApiData(String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        EntriesHebergementApiService entriesHebergementApiService = retrofit.create(EntriesHebergementApiService.class);
        Call<Entries> call = entriesHebergementApiService.getEntries();
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
                    item = menuItems.findItem(R.id.menu_activity_main_entry_filter);
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
            }
        });
    }

    /*public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntries(listEntries, this);
        list_recycler_event.setAdapter(adapterEntries);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    @Override
    public void onClickEntriesButton(int position) {
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        saveEntry(selectedEntry,EntriesType.Hebergement);
        //fabExit.performClick();
        fabSave.hide();
    }*/
}