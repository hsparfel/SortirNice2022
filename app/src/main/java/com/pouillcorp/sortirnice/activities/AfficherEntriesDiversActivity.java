package com.pouillcorp.sortirnice.activities;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.DateMaj;
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
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEntriesDiversActivity extends NavDrawerActivity implements RecyclerAdapterEntries.Listener {

    public static final String TAG = AfficherEntriesDiversActivity.class.getSimpleName();
    public static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    public String myUrl = BASE_URL;

    boolean isMajToday;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //super.onCreateOptionsMenu(Menu menu);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_entry_various);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        Log.e(TAG, "on create method");
        listEntries = new ArrayList<>();
        nbEntries = 0;

        //setHasOptionsMenu(true);

        setTitle("Divers");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_entry).setChecked(true);
        dateDemande = new Date();
        dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
        myUrl += dateDemandeString + "/";
        chargerTous();
        masquerFragmentFiltreEntry();
        masquerFragmentType();
        listCheckboxEntryType.add(checkboxEntryTypeBoutique);
        listCheckboxEntryType.add(checkboxEntryTypeSortie);
        listCheckboxEntryType.add(checkboxEntryTypeUtile);
        listCheckboxEntryType.add(checkboxEntryTypeVisite);
        listCheckboxEntryType.add(checkboxEntryTypeHebergement);
        listCheckboxEntryType.add(checkboxEntryTypeHotel);
        listCheckboxEntryType.add(checkboxEntryTypeRestaurant);
        listCheckboxEntryType.add(checkboxEntryTypeTransport);
        listCheckboxEntryType.add(checkboxEntryTypeShopping);

    }



    @Override
    protected void onResume() {
        super.onResume();
        for (Object current : listEntryEntities) {
            ((EntryEntity) current).refresh();
        }
        configureRecyclerViewEntry();
        list_recycler_entry.scrollToPosition(positionScroll);
        Log.e(TAG, "on resume method");
    }



    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_entry_type:
                Log.e(TAG, "click sur type entry");
                if (layoutTypeAffiche) {
                    masquerFragmentType();
                } else {
                    afficherFragmentType();
                }
                masquerFragmentFiltreEntry();
                break;
            case R.id.menu_activity_main_entry_filter:
                Log.e(TAG, "click sur filtre entry");
                if (layoutFiltreAffiche) {
                    masquerFragmentFiltreEntry();
                } else {
                    afficherFragmentFiltre();
                }
                masquerFragmentType();
                break;
        }
        return true;
    }

    @Override
    public void onClickEntriesButton(int position) {
    }

    public void chargerTous() {
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
        /*AsyncTaskRunnerRechercheGlobale runner = new AsyncTaskRunnerRechercheGlobale();
        runner.execute();*/
        AsyncTaskRunnerVerifRechercheJour runner = new AsyncTaskRunnerVerifRechercheJour();
        runner.execute();
    }

    private class AsyncTaskRunnerVerifRechercheJour extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            String dateString;
            Date date = new Date();
            dateString = DateUtils.formatDateDD_MM_YYYY(date);
            List<DateMaj> listDateLastMaj = dateMajDao.loadAll();new ArrayList<>();
            listDateLastMaj = dateMajDao.loadAll();
            isMajToday = false;
            if (listDateLastMaj.size() > 0) {
                DateMaj dateLastMaj = listDateLastMaj.get(0);
                if (dateLastMaj.getDateMajEntry().equalsIgnoreCase(dateString)) {
                    isMajToday = true;
                }
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            if (!isMajToday) {
                AsyncTaskRunnerRechercheGlobale runner = new AsyncTaskRunnerRechercheGlobale();
                runner.execute();
            } else {
                loadAllEntryFromDB();
                listEntryEntitiesBasique.addAll(listEntryEntities);
                configureRecyclerViewEntry();

                /*itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
                itemEntryType.setVisible(true);
                itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
                itemEntryFiltre.setVisible(false);*/
                listerFiltreEntry();
                initListFiltresEntry();
                initCheckboxesSelectAllClickEntry();
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    private class AsyncTaskRunnerRechercheGlobale extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            lancerRechercheGlobale();
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private void connectAndGetApiDataEntries(String url, EntriesType entryType) {
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
                                 cptrEntriesType++;
                                 for (Entry current : response.body().getListEntries()) {
                                     current.setEntryType(entryType);
                                 }
                                 switch (entryType) {
                                     case Boutique:
                                         listEntriesBoutique.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesBoutique, entryType));
                                         break;
                                     case Hebergement:
                                         listEntriesHebergement.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesHebergement, entryType));
                                         break;
                                     case Hotel:
                                         listEntriesHotel.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesHotel, entryType));
                                         break;
                                     case Restaurant:
                                         listEntriesRestaurant.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesRestaurant, entryType));
                                         break;
                                     case Shopping:
                                         listEntriesShopping.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesShopping, entryType));
                                         break;
                                     case Sortie:
                                         listEntriesSortie.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesSortie, entryType));
                                         break;
                                     case Transport:
                                         listEntriesTransport.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesTransport, entryType));
                                         break;
                                     case Utile:
                                         listEntriesUtile.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesUtile, entryType));
                                         break;
                                     case Visite:
                                         listEntriesVisite.addAll(response.body().getListEntries());
                                         listEntryEntities.addAll(saveListEntries(listEntriesVisite, entryType));
                                         break;
                                     default:
                                 }
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

                             if (cptrEntriesType == 9) {
                                 majEntryObsolete(listEntryEntities);
                                 deleteEntryObsolete();
                                 isResponded = true;
                                 loadAllEntryFromDB();
                                 listEntryEntitiesBasique.addAll(listEntryEntities);
                                 configureRecyclerViewEntry();
                                 itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
                                 itemEntryType.setVisible(true);
                                 itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
                                 itemEntryFiltre.setVisible(false);
                                 listerFiltreEntry();
                                 initListFiltresEntry();
                                 initCheckboxesSelectAllClickEntry();

                                 Date dateJour = new Date();
                                 String dateJourString = DateUtils.formatDateDD_MM_YYYY(dateJour);
                                 List<DateMaj> listDateMaj = dateMajDao.loadAll();
                                 if (listDateMaj.size() >0) {
                                     DateMaj dateMaj = listDateMaj.get(0);
                                     dateMaj.setDateMajEntry(dateJourString);
                                     dateMajDao.update(dateMaj);
                                 } else {
                                     DateMaj dateMaj = new DateMaj();
                                     dateMaj.setDateMajEntry(dateJourString);
                                     dateMajDao.insert(dateMaj);
                                 }
                                 progressBar.setVisibility(View.GONE);
                             }
                         }

                         @Override
                         public void onFailure(Call<Entries> call, Throwable throwable) {
                             Log.e(TAG, throwable.toString());
                             cptrEntriesType--;
                             Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                             gererErreur(entryType, throwable.toString());
                             progressBar.setVisibility(View.GONE);
                         }
                     }
        );
    }

    private void lancerRechercheGlobale() {
        Long nbEntriesEnBD = entryEntityDao.count();
        if (nbEntriesEnBD == 0) {
            Snackbar.make(bottomNavigationView, R.string.msg_entry_first_connection, Snackbar.LENGTH_LONG).show();
        }
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

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Boutique);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheHebergement extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Hebergement);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheHotel extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Hotel);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheRestaurant extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Restaurant);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheShopping extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Shopping);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheSortie extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Sortie);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheTransport extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Transport);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheUtile extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Utile);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }

    private class AsyncTaskRunnerRechercheVisite extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void... voids) {
            connectAndGetApiDataEntries(myUrl, EntriesType.Visite);
            return null;
        }

        protected void onPostExecute(Void result) {
        }
    }


}