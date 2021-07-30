package com.pouillcorp.sortirnice.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.event.EventSauvegardeEntity;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntriesSauvegarde;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEventsSauvegarde;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;

public class AfficherChoixEnregistrementActivity extends NavDrawerActivity implements RecyclerAdapterEntriesSauvegarde.Listener, RecyclerAdapterEventsSauvegarde.Listener {

        @BindView(R.id.list_recycler_event)
        RecyclerView list_recycler_event;

        private RecyclerAdapterEntriesSauvegarde adapterEntries;
    private RecyclerAdapterEventsSauvegarde adapterEvents;

        @BindView(R.id.scrollView)
        ScrollView scrollView;

        List<EntryEntity> listEntries;
    List<EntryEntity> listEntriesFiltres;
    EntryEntity selectedEntry;

    List<EventSauvegardeEntity> listEvents;
    EventSauvegardeEntity selectedEvent;

    boolean isEntry;

    @BindView(R.id.btn_boutique)
    Button btnBoutique;
    @BindView(R.id.btn_event)
    Button btnEvent;
    @BindView(R.id.btn_hebergement)
    Button btnHebergement;
    @BindView(R.id.btn_hotel)
    Button btnHotel;
    @BindView(R.id.btn_restaurant)
    Button btnRestaurant;
    @BindView(R.id.btn_visit)
    Button btnVisite;
    @BindView(R.id.btn_shopping)
    Button btnShopping;
    @BindView(R.id.btn_transport)
    Button btnTransport;
    @BindView(R.id.btn_sortie)
    Button btnSortie;
    @BindView(R.id.btn_utile)
    Button btnUtile;

    static AfficherChoixEnregistrementActivity AfficherChoixEnregistrementActivity;

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Icepick.restoreInstanceState(this, savedInstanceState);
            setContentView(R.layout.activity_afficher_choix_enregistrement);

            AfficherChoixEnregistrementActivity = this;

            this.configureToolBar();
            this.configureBottomView();

            ButterKnife.bind(this);



            listEntries = new ArrayList<>();
            listEntriesFiltres = new ArrayList<>();

            AsyncTaskRunnerBD runnerBD = new AsyncTaskRunnerBD();
            runnerBD.execute();
            setTitle(R.string.mes_favoris);
            Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
            bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).setChecked(true);
        }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("type")) {
            String type = intent.getStringExtra("type");
            if (type.equalsIgnoreCase(EntriesType.Boutique.toString())) {
                btnBoutique.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Shopping.toString())) {
                btnShopping.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Sortie.toString())) {
                btnSortie.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Restaurant.toString())) {
                btnRestaurant.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Hebergement.toString())) {
                btnHebergement.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Hotel.toString())) {
                btnHotel.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Sortie.toString())) {
                btnSortie.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Transport.toString())) {
                btnTransport.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Utile.toString())) {
                btnUtile.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Visite.toString())) {
                btnVisite.callOnClick();
            } else {
                btnEvent.callOnClick();
            }
        }
    }

        private void configureOnClickRecyclerView(){
            ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                    .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                            //ouvrirActiviteSuivante(AfficherEntriesBoutiqueActivity.this, AfficherEntryBoutiqueDetailActivity.class,"entryId",listEntryEntities.get(position).getId(),false);
                            Log.e("TAG", "Position : "+position);
                            if (isEntry) {
                                selectedEntry = listEntries.get(position);
                            } else {
                                selectedEvent = listEvents.get(position);
                            }
                            /*if (!isEntry) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEventDetailActivity.class,"eventSauvegardeId",listEvents.get(position).getId(),false);
                            } else if (btnBoutique.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryBoutiqueDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnHebergement.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryHebergementDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnHotel.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryHotelDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnRestaurant.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryRestaurantDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnShopping.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryShoppingDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnVisite.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryVisiteDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnUtile.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryUtileDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnTransport.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryTransportDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (btnSortie.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntrySortieDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            }*/
                        }
                    });
        }

        public void configureRecyclerView() {
            if (isEntry) {
                adapterEntries = new RecyclerAdapterEntriesSauvegarde(listEntriesFiltres, this);
                list_recycler_event.setAdapter(adapterEntries);
                list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
            } else {
                adapterEvents = new RecyclerAdapterEventsSauvegarde(listEvents, this);
                list_recycler_event.setAdapter(adapterEvents);
                list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
            }
            configureOnClickRecyclerView();
        }

        @Override
        public void onClickEntriesButton(int position) {
            //  ouvrirActiviteSuivante(this,AfficherEntryDetailActivity.class,"eventId",listEntryEntities.get(position).getId(),false);
        }

    @Override
    public void onClickEventsButton(int position) {

    }

    @OnClick(R.id.btn_event)
    public void setButtonEventClick() {

        isEntry = false;
        configureRecyclerView();
    }

    @OnClick(R.id.btn_boutique)
    public void setButtonBoutiqueClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Boutique) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_utile)
    public void setButtonUtileClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Utile) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_sortie)
    public void setButtonSortieClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Sortie) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_transport)
    public void setButtonTransportClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Transport) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_shopping)
    public void setButtonShoppingClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Shopping) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_visit)
    public void setButtonVisiteClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Visite) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_restaurant)
    public void setButtonRestaurantClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Restaurant) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_hotel)
    public void setButtonHotelClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Hotel) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.btn_hebergement)
    public void setButtonHebergementClick() {

        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Hebergement) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }



    private class AsyncTaskRunnerBD extends AsyncTask<Void, Integer, Void> {

            protected Void doInBackground(Void...voids) {
                listEvents = eventSauvegardeEntityDao.loadAll();
                listEntries = entryEntityDao.loadAll();
                return null;
            }

            protected void onPostExecute(Void result) {
            traiterIntent();
            }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
        }
    public static AfficherChoixEnregistrementActivity getInstance(){
        return AfficherChoixEnregistrementActivity;
    }
    }