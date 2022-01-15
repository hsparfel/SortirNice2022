package com.pouillcorp.sortirnice.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
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
import com.pouillcorp.sortirnice.services.ApiServices;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AccueilActivity extends NavDrawerEntryActivity {

    List<Entry> listEntriesBoutique = new ArrayList<>();
    List<Entry> listEntriesHebergement = new ArrayList<>();
    List<Entry> listEntriesHotel = new ArrayList<>();
    List<Entry> listEntriesRestaurant = new ArrayList<>();
    List<Entry> listEntriesUtile = new ArrayList<>();
    List<Entry> listEntriesVisite = new ArrayList<>();
    List<Entry> listEntriesShopping = new ArrayList<>();
    List<Entry> listEntriesSortie = new ArrayList<>();
    List<Entry> listEntriesTransport = new ArrayList<>();
    int cptrEntriesType;
    int compteur = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Stetho.initializeWithDefaults(this);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        setTitle("Accueil");
    }

    public void afficherEvents(View view) {
        ouvrirActiviteSuivante(this, AfficherEventsActivity.class,false);
    }

    public void afficherEvenements(View view) {
        ouvrirActiviteSuivante(this, AfficherEvenementsActivity.class,false);
    }

    public void afficherEntriesSortie(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesSortieActivity.class,false);
    }

    public void afficherEntriesRestaurant(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesRestaurantActivity.class,false);
    }

    public void afficherEntriesTransport(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesTransportActivity.class,false);
    }

    public void afficherEntriesHotel(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesHotelActivity.class,false);
    }

    public void afficherEntriesBoutique(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesBoutiqueActivity.class,false);
    }

    public void afficherEntriesHebergement(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesHebergementActivity.class,false);
    }

    public void afficherEntriesVisite(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesVisiteActivity.class,false);
    }

    public void afficherEntriesShopping(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesShoppingActivity.class,false);
    }

    public void afficherEntriesUtile(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesUtileActivity.class,false);
    }
    public void afficherMesFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherMesFavorisActivity.class,false);
    }
    public void chargerTous(View view) {
        cptrEntriesType = 0;
        listEntryEntities = new ArrayList<>();
        listEntriesBoutique = new ArrayList<>();
        listEntriesHebergement = new ArrayList<>();
        listEntriesHotel = new ArrayList<>();
        listEntriesRestaurant = new ArrayList<>();
        listEntriesUtile = new ArrayList<>();
        listEntriesVisite = new ArrayList<>();
        listEntriesShopping = new ArrayList<>();
        listEntriesSortie = new ArrayList<>();
        listEntriesTransport = new ArrayList<>();
        AsyncTaskRunnerRechercheGlobale runner = new AsyncTaskRunnerRechercheGlobale();
        runner.execute();
    }

    private class AsyncTaskRunnerRechercheGlobale extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            lancerRechercheGlobale();
            return null;
        }

        protected void onPostExecute(Void result) {
            //Log.e(TAG, "fin de recherche globale");
        }
    }

    private void connectAndGetApiDataEntries(String url, EntriesType entryType) {

        //progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        switch (entryType) {
            case Boutique:
                EntriesBoutiqueApiService entriesBoutiqueApiService = retrofit.create(EntriesBoutiqueApiService.class);
                call = entriesBoutiqueApiService.getEntries();
                break;
            case Hebergement:
                EntriesHebergementApiService entriesHebergementApiService = retrofit.create(EntriesHebergementApiService.class);
                call = entriesHebergementApiService.getEntries();
                break;
            case Hotel:
                EntriesHotelApiService entriesHotelApiService = retrofit.create(EntriesHotelApiService.class);
                call = entriesHotelApiService.getEntries();
                break;
            case Restaurant:
                EntriesRestaurantApiService entriesRestaurantApiService = retrofit.create(EntriesRestaurantApiService.class);
                call = entriesRestaurantApiService.getEntries();
                break;
            case Shopping:
                EntriesShoppingApiService entriesShoppingApiService = retrofit.create(EntriesShoppingApiService.class);
                call = entriesShoppingApiService.getEntries();
                break;
            case Sortie:
                EntriesSortieApiService entriesSortieApiService = retrofit.create(EntriesSortieApiService.class);
                call = entriesSortieApiService.getEntries();
                break;
            case Transport:
                EntriesTransportApiService entriesTransportApiService = retrofit.create(EntriesTransportApiService.class);
                call = entriesTransportApiService.getEntries();
                break;
            case Utile:
                EntriesUtileApiService entriesUtileApiService = retrofit.create(EntriesUtileApiService.class);
                call = entriesUtileApiService.getEntries();
                break;
            case Visite:
                EntriesVisiteApiService entriesVisiteApiService = retrofit.create(EntriesVisiteApiService.class);
                call = entriesVisiteApiService.getEntries();
                break;
            default:
                call = null;
        }

        call.enqueue(new Callback<Entries>() {
                         @Override
                         public void onResponse(Call<Entries> call, Response<Entries> response) {
                             if (response.code() == 200) {
                                 cptrEntriesType ++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(entryType);
                                 }
                                 switch (entryType) {
                                     case Boutique:
                                         listEntriesBoutique.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Boutique recuperes: " + listEntriesBoutique.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesBoutique,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Hebergement:
                                         listEntriesHebergement.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Hebergement recuperes: " + listEntriesHebergement.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesHebergement,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Hotel:
                                         listEntriesHotel.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Hotel recuperes: " + listEntriesHotel.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesHotel,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Restaurant:
                                         listEntriesRestaurant.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Restaurant recuperes: " + listEntriesRestaurant.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesRestaurant,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Shopping:
                                         listEntriesShopping.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Shopping recuperes: " + listEntriesShopping.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesShopping,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Sortie:
                                         listEntriesSortie.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Sortie recuperes: " + listEntriesSortie.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesSortie,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Transport:
                                         listEntriesTransport.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Transport recuperes: " + listEntriesTransport.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesTransport,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Utile:
                                         listEntriesUtile.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Utile recuperes: " + listEntriesUtile.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesUtile,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     case Visite:
                                         listEntriesVisite.addAll(response.body().getListEntries());
                                         Log.e(TAG, "Number of entries Visite recuperes: " + listEntriesVisite.size());
                                         listEntryEntities.addAll(saveListEntries(listEntriesVisite,entryType));
                                         Log.e(TAG, "Number of entries entity Total sauv en DB: " + listEntryEntities.size());
                                         break;
                                     default:
                                 }
                                 //progressBar.setVisibility(View.GONE);
                             } else {
                                 if (entryType != EntriesType.Shopping) {
                                     dateDemande = DateUtils.calculerVeille(dateDemande);
                                     dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                     myUrl = BASE_URL + dateDemandeString + "/";
                                 } else {
                                     if (compteur < 15) {
                                         dateDemande = DateUtils.calculerVeille(dateDemande);
                                         dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                         compteur++;
                                     } else {
                                         dateDemandeString = "20160726";
                                     }
                                     myUrl = BASE_URL + dateDemandeString + "/";
                                 }
                                 connectAndGetApiDataEntries(myUrl, entryType);
                             }

                             if (cptrEntriesType == 9){
                                 Log.e("TAG", "rch global termine");
                                 majEntryObsolete(listEntryEntities);
                                 deleteEntryObsolete();
                                 //progressBar.setVisibility(View.GONE);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             cptrEntriesType--;
                             //progressBar.setVisibility(View.GONE);
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();

                             gererErreur(entryType,throwable.toString());
                         }
                     }
        );
    }

    private void lancerRechercheGlobale(){
        AsyncTaskRunnerRechercheBoutique runnerBoutique = new AsyncTaskRunnerRechercheBoutique();
        runnerBoutique.execute();
        AsyncTaskRunnerRechercheHebergement runnerHebergement = new AsyncTaskRunnerRechercheHebergement();
        runnerHebergement.execute();
        AsyncTaskRunnerRechercheHotel runnerHotel = new AsyncTaskRunnerRechercheHotel();
        runnerHotel.execute();
        AsyncTaskRunnerRechercheRestaurant runnerRestaurant = new AsyncTaskRunnerRechercheRestaurant();
        runnerRestaurant.execute();
        AsyncTaskRunnerRechercheShopping runnerShopping = new AsyncTaskRunnerRechercheShopping();
        runnerShopping.execute();
        AsyncTaskRunnerRechercheSortie runnerSortie = new AsyncTaskRunnerRechercheSortie();
        runnerSortie.execute();
        AsyncTaskRunnerRechercheTransport runnerTransport = new AsyncTaskRunnerRechercheTransport();
        runnerTransport.execute();
        AsyncTaskRunnerRechercheUtile runnerUtile = new AsyncTaskRunnerRechercheUtile();
        runnerUtile.execute();
        AsyncTaskRunnerRechercheVisite runnerVisite = new AsyncTaskRunnerRechercheVisite();
        runnerVisite.execute();
    }

    private class AsyncTaskRunnerRechercheBoutique extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Boutique);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheHebergement extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Hebergement);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheHotel extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Hotel);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheRestaurant extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Restaurant);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheShopping extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Shopping);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheSortie extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Sortie);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheTransport extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Transport);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheUtile extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Utile);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
    private class AsyncTaskRunnerRechercheVisite extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Visite);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }
}
