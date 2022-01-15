package com.pouillcorp.sortirnice.activities;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.email.SendEmailService;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesHebergementApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesHotelApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesRestaurantApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesShoppingApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesSortieApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesTransportApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesUtileApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesVisiteApiService;

import com.pouillcorp.sortirnice.modelentries.Entries;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RechercherAllEntriesActivity extends NavDrawerEntryActivity implements RecyclerAdapterEntries.Listener {

    private static final String TAG = RechercherAllEntriesActivity.class.getSimpleName();
    private RecyclerAdapterEntries adapterEntries;

    int compteur = 0;

    int cptrEntriesType;

    List<Entry> listEntriesBoutique;
    List<Entry> listEntriesHebergement;
    List<Entry> listEntriesHotel;
    List<Entry> listEntriesRestaurant;
    List<Entry> listEntriesUtile;
    List<Entry> listEntriesVisite;
    List<Entry> listEntriesShopping;
    List<Entry> listEntriesSortie;
    List<Entry> listEntriesTransport;



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_rechercher_all_entries);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        setTitle(R.string.rechercher_entries);
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_entry).setChecked(true);
        progressBar.setVisibility(View.GONE);

    }

    public void rechercheGlobale(View view) {
      //  progressBar.setVisibility(View.VISIBLE);
        cptrEntriesType = 0;
        listEntries = new ArrayList<>();
        Snackbar.make(bottomNavigationView, "Veuillez Patientez", Snackbar.LENGTH_LONG).show();
        //for (EntriesType entryType : EntriesType.values()) {
         //   Snackbar.make(bottomNavigationView, "debut de "+entryType.toString(), Snackbar.LENGTH_LONG).show();
            progressBar.setVisibility(View.VISIBLE);

        //lancer le traitement global - commencer par boutique
            //connectAndGetApiData(myUrl,entryType);
        connectAndGetApiDataFirstBoutique(myUrl);
        //}
     //   progressBar.setVisibility(View.GONE);
       // Snackbar.make(bottomNavigationView, "nb entree totale = "+listEntries.size(), Snackbar.LENGTH_LONG).show();
    }



    public void envoyerEmailErreur(EntriesType entryType){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                //SendEmailService.getInstance(getApplicationContext()).sendEmailErreurSynchro(entryType);
            }
        });
    }



    @Override
    public void onClickEntriesButton(int position) {
    }

    @Optional
    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        saveEntry(selectedEntry,EntriesType.Boutique);
        //fabExit.performClick();
        fabSave.hide();
    }

    public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntries(listEntries, this);
        list_recycler_event.setAdapter(adapterEntries);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    public void connectAndGetApiDataFirstBoutique(String url) {

        listEntriesBoutique = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesBoutiqueApiService entriesBoutiqueApiService = retrofit.create(EntriesBoutiqueApiService.class);
        call = entriesBoutiqueApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                             @Override
                             public void onResponse(Call<Entries> call, Response<Entries> response) {
                                 if (response.code() == 200) {
                                     cptrEntriesType ++;
                                     for (Entry current : response.body().getListEntries()) {
                                         current.setEntryType(EntriesType.Boutique);
                                     }
                                     listEntriesBoutique.addAll(response.body().getListEntries());

                                     Log.e(TAG, "type: " + EntriesType.Boutique);
                                     Log.e(TAG, "Number of entries received: " + listEntriesBoutique.size());
                                     //progressBar.setVisibility(View.GONE);
                                     connectAndGetApiDataSecondHebergement(myUrl);
                                 } else {
                                     dateDemande = DateUtils.calculerVeille(dateDemande);
                                     dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                     Log.e("TAG", "date rch : " + dateDemandeString);
                                     myUrl = BASE_URL + dateDemandeString + "/";
                                     connectAndGetApiDataFirstBoutique(myUrl);
                                 }
                             }

                             @Override
                             public void onFailure(Call<Entries> call, Throwable throwable) {
                                 Log.e(TAG, throwable.toString());
                                 progressBar.setVisibility(View.GONE);
                                 Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                                 envoyerEmailErreur(EntriesType.Boutique);
                             }
                         }
            );
    }

    public void connectAndGetApiDataSecondHebergement(String url) {

        listEntriesHebergement = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesHebergementApiService entriesHebergementApiService = retrofit.create(EntriesHebergementApiService.class);
        call = entriesHebergementApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Hebergement);
                                 }
                                 listEntriesHebergement.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Hebergement);
                                 Log.e(TAG, "Number of entries received: " + listEntriesHebergement.size());
                                 //progressBar.setVisibility(View.GONE);
                                 connectAndGetApiDataThirdShopping(myUrl);
                             } else {
                                 dateDemande = DateUtils.calculerVeille(dateDemande);
                                 dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataSecondHebergement(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Hebergement);
                         }
                     }
        );
    }

    public void connectAndGetApiDataThirdShopping(String url) {

        listEntriesShopping = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesShoppingApiService entriesShoppingApiService = retrofit.create(EntriesShoppingApiService.class);
        call = entriesShoppingApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Shopping);
                                 }
                                 listEntriesShopping.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Shopping);
                                 Log.e(TAG, "Number of entries received: " + listEntriesShopping.size());
                                 //progressBar.setVisibility(View.GONE);
                                 connectAndGetApiDataFourthHotel(myUrl);
                             } else {
                                 if (compteur < 15) {
                                     dateDemande = DateUtils.calculerVeille(dateDemande);
                                     dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                     compteur++;
                                 } else {
                                     dateDemandeString = "20160726";
                                 }
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataThirdShopping(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Shopping);
                         }
                     }
        );
    }

    public void connectAndGetApiDataFourthHotel(String url) {

        listEntriesHotel = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesHotelApiService entriesHotelApiService = retrofit.create(EntriesHotelApiService.class);
        call = entriesHotelApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Hotel);
                                 }
                                 listEntriesHotel.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Hotel);
                                 Log.e(TAG, "Number of entries received: " + listEntriesHotel.size());
                                 //progressBar.setVisibility(View.GONE);
                                 connectAndGetApiDataFifthVisite(myUrl);
                             } else {
                                 dateDemande = DateUtils.calculerVeille(dateDemande);
                                 dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataFourthHotel(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Hotel);
                         }
                     }
        );
    }

    public void connectAndGetApiDataFifthVisite(String url) {

        listEntriesVisite = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesVisiteApiService entriesVisiteApiService = retrofit.create(EntriesVisiteApiService.class);
        call = entriesVisiteApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Visite);
                                 }
                                 listEntriesVisite.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Visite);
                                 Log.e(TAG, "Number of entries received: " + listEntriesVisite.size());
                                 //progressBar.setVisibility(View.GONE);
                                 connectAndGetApiDataSixthUtile(myUrl);
                             } else {
                                 dateDemande = DateUtils.calculerVeille(dateDemande);
                                 dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataFifthVisite(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Visite);
                         }
                     }
        );
    }

    public void connectAndGetApiDataSixthUtile(String url) {

        listEntriesUtile = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesUtileApiService entriesUtileApiService = retrofit.create(EntriesUtileApiService.class);
        call = entriesUtileApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Utile);
                                 }
                                 listEntriesUtile.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Utile);
                                 Log.e(TAG, "Number of entries received: " + listEntriesUtile.size());
                                 //progressBar.setVisibility(View.GONE);
                                 connectAndGetApiDataSeventhTransport(myUrl);
                             } else {
                                 dateDemande = DateUtils.calculerVeille(dateDemande);
                                 dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataSixthUtile(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Utile);
                         }
                     }
        );
    }

    public void connectAndGetApiDataSeventhTransport(String url) {

        listEntriesTransport = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesTransportApiService entriesTransportApiService = retrofit.create(EntriesTransportApiService.class);
        call = entriesTransportApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Transport);
                                 }
                                 listEntriesTransport.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Transport);
                                 Log.e(TAG, "Number of entries received: " + listEntriesTransport.size());
                                 //progressBar.setVisibility(View.GONE);
                                 connectAndGetApiDataEighthSortie(myUrl);
                             } else {
                                 dateDemande = DateUtils.calculerVeille(dateDemande);
                                 dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataSeventhTransport(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Transport);
                         }
                     }
        );
    }

    public void connectAndGetApiDataEighthSortie(String url) {

        listEntriesSortie = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesSortieApiService entriesSortieApiService = retrofit.create(EntriesSortieApiService.class);
        call = entriesSortieApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Sortie);
                                 }
                                 listEntriesSortie.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Sortie);
                                 Log.e(TAG, "Number of entries received: " + listEntriesSortie.size());
                                 //progressBar.setVisibility(View.GONE);
                                 connectAndGetApiDataNinethRestaurant(myUrl);
                             } else {
                                 dateDemande = DateUtils.calculerVeille(dateDemande);
                                 dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataEighthSortie(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Sortie);
                         }
                     }
        );
    }

    public void connectAndGetApiDataNinethRestaurant(String url) {

        listEntriesRestaurant = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        EntriesRestaurantApiService entriesRestaurantApiService = retrofit.create(EntriesRestaurantApiService.class);
        call = entriesRestaurantApiService.getEntries();

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(EntriesType.Restaurant);
                                 }
                                 listEntriesRestaurant.addAll(response.body().getListEntries());

                                 Log.e(TAG, "type: " + EntriesType.Restaurant);
                                 Log.e(TAG, "Number of entries received: " + listEntriesRestaurant.size());
                                 //progressBar.setVisibility(View.GONE);
                                 //connectAndGetApiDataSecondHebergement(myUrl);
                                 gererAllEntries();
                             } else {
                                 dateDemande = DateUtils.calculerVeille(dateDemande);
                                 dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                 Log.e("TAG", "date rch : " + dateDemandeString);
                                 myUrl = BASE_URL + dateDemandeString + "/";
                                 connectAndGetApiDataNinethRestaurant(myUrl);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             envoyerEmailErreur(EntriesType.Restaurant);
                         }
                     }
        );
    }

    public void gererAllEntries() {
        Log.e(TAG, "type: " + EntriesType.Boutique);
        Log.e(TAG, "Number of entries received: " + listEntriesBoutique.size());
        Log.e(TAG, "type: " + EntriesType.Hebergement);
        Log.e(TAG, "Number of entries received: " + listEntriesHebergement.size());
        Log.e(TAG, "type: " + EntriesType.Shopping);
        Log.e(TAG, "Number of entries received: " + listEntriesShopping.size());
        Log.e(TAG, "type: " + EntriesType.Hotel);
        Log.e(TAG, "Number of entries received: " + listEntriesHotel.size());
        Log.e(TAG, "type: " + EntriesType.Visite);
        Log.e(TAG, "Number of entries received: " + listEntriesVisite.size());
        Log.e(TAG, "type: " + EntriesType.Utile);
        Log.e(TAG, "Number of entries received: " + listEntriesUtile.size());
        Log.e(TAG, "type: " + EntriesType.Transport);
        Log.e(TAG, "Number of entries received: " + listEntriesTransport.size());
        Log.e(TAG, "type: " + EntriesType.Sortie);
        Log.e(TAG, "Number of entries received: " + listEntriesSortie.size());
        Log.e(TAG, "type: " + EntriesType.Restaurant);
        Log.e(TAG, "Number of entries received: " + listEntriesRestaurant.size());
        listEntries.addAll(listEntriesBoutique);
        listEntries.addAll(listEntriesHebergement);
        listEntries.addAll(listEntriesShopping);
        listEntries.addAll(listEntriesHotel);
        listEntries.addAll(listEntriesVisite);
        listEntries.addAll(listEntriesUtile);
        listEntries.addAll(listEntriesTransport);
        listEntries.addAll(listEntriesSortie);
        listEntries.addAll(listEntriesRestaurant);
        Log.e(TAG, "type: All");
        Log.e(TAG, "Number of entries received: " + listEntries.size());
        progressBar.setVisibility(View.GONE);
        configureRecyclerView();

    }
}