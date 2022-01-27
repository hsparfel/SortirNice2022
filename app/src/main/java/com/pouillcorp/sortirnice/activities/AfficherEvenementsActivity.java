package com.pouillcorp.sortirnice.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.interfaces.EventsApiService;
import com.pouillcorp.sortirnice.modelevents.Events;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvenements;
import com.pouillcorp.sortirnice.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;

import butterknife.ButterKnife;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEvenementsActivity extends NavDrawerActivity implements RecyclerAdapterEvenements.Listener {

    public static final String TAG = AfficherEvenementsActivity.class.getSimpleName();
    public static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    public String myUrl = BASE_URL;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_event);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        listEvents = new ArrayList<>();
        nbEvents = 0;

        setTitle(R.string.evenements);
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_evenement).setChecked(true);

        dateDemande = new Date();
        dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);

        myUrl += dateDemandeString + "/";

        connectAndGetApiData(myUrl);

        masquerFragmentTri();
        masquerFragmentFiltreEvent();

    }



    @Override
    protected void onResume() {
        super.onResume();
        for (Object current : listEventEntities) {
            ((EvenementEntity) current).refresh();
        }
        configureRecyclerView();
        list_recycler_event.scrollToPosition(positionScroll);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_evenement_tri:
                Log.e(TAG, "click sur tri evenement");
                if (layoutTriAffiche) {
                    masquerFragmentTri();
                } else {
                    afficherFragmentTri();
                }
                masquerFragmentFiltreEvent();
                break;
            case R.id.menu_activity_main_evenement_filter:
                Log.e(TAG, "click sur filtre evenement");
                if (layoutFiltreAffiche) {
                    masquerFragmentFiltreEvent();
                } else {
                    afficherFragmentFiltreEvent();
                }
                masquerFragmentTri();
                break;
        }
        return true;
    }

    public void connectAndGetApiData(String url) {

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        EventsApiService eventApiService = retrofit.create(EventsApiService.class);
        Call<Events> call = eventApiService.getEvents();
        call.enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                if (response.code() == 200) {
                    listEvents = response.body().getListEvents();
                    saveListEvents();
                    isResponded = true;
                    loadAllEvenementFromDB();
                    listEventEntitiesBasique.addAll(listEventEntities);
                    configureRecyclerView();
                    itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
                    itemEvenementFiltre.setVisible(true);
                    itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
                    itemEvenementTri.setVisible(true);
                    itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
                    itemEntryType.setVisible(false);
                    listerFiltre();
                    initListFiltres();
                    initCheckboxesSelectAllClick();

                    progressBar.setVisibility(View.GONE);
                } else {

                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    myUrl = BASE_URL + dateDemandeString + "/";
                    connectAndGetApiData(myUrl);
                }
            }

            @Override
            public void onFailure(Call<Events> call, Throwable throwable) {
                progressBar.setVisibility(View.GONE);
                Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                gererErreur(null, throwable.toString());
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClickEventsButton(int position) {
    }
}