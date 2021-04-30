package com.pouillos.sortirnice.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.stetho.Stetho;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillos.sortirnice.App;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.entry.EntryEntity;
import com.pouillos.sortirnice.entities.event.EventEntity;
import com.pouillos.sortirnice.entities.event.EventSauvegardeEntity;
import com.pouillos.sortirnice.enumeration.EntriesType;
import com.pouillos.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillos.sortirnice.modelentries.Amenity;
import com.pouillos.sortirnice.modelentries.Animation;
import com.pouillos.sortirnice.modelentries.Atmospher;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Closing;
import com.pouillos.sortirnice.modelentries.Closure;
import com.pouillos.sortirnice.modelentries.Closures;
import com.pouillos.sortirnice.modelentries.Entries;
import com.pouillos.sortirnice.modelentries.Entry;
import com.pouillos.sortirnice.modelentries.Grid;
import com.pouillos.sortirnice.modelentries.Label;
import com.pouillos.sortirnice.modelentries.Location;
import com.pouillos.sortirnice.modelentries.Opening;
import com.pouillos.sortirnice.modelentries.Option;
import com.pouillos.sortirnice.modelentries.Payment;
import com.pouillos.sortirnice.modelentries.Service;
import com.pouillos.sortirnice.modelentries.Station;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntriesBoutique;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntriesSauvegarde;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEvents;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEventsSauvegarde;
import com.pouillos.sortirnice.utils.DateUtils;
import com.pouillos.sortirnice.utils.ItemClickSupport;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

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

    @BindView(R.id.chipBoutique)
    Chip chipBoutique;
    @BindView(R.id.chipEvent)
    Chip chipEvent;
    @BindView(R.id.chipHebergement)
    Chip chipHebergement;
    @BindView(R.id.chipHotel)
    Chip chipHotel;
    @BindView(R.id.chipRestaurant)
    Chip chipRestaurant;
    @BindView(R.id.chipVisite)
    Chip chipVisite;
    @BindView(R.id.chipShopping)
    Chip chipShopping;
    @BindView(R.id.chipTransport)
    Chip chipTransport;
    @BindView(R.id.chipSortie)
    Chip chipSortie;
    @BindView(R.id.chipUtile)
    Chip chipUtile;

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
            setTitle("Selection");
            Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
            bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
        }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("type")) {
            String type = intent.getStringExtra("type");
            if (type.equalsIgnoreCase(EntriesType.Boutique.toString())) {
                chipBoutique.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Shopping.toString())) {
                chipShopping.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Sortie.toString())) {
                chipSortie.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Restaurant.toString())) {
                chipRestaurant.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Hebergement.toString())) {
                chipHebergement.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Hotel.toString())) {
                chipHotel.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Sortie.toString())) {
                chipSortie.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Transport.toString())) {
                chipTransport.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Utile.toString())) {
                chipUtile.callOnClick();
            } else if (type.equalsIgnoreCase(EntriesType.Visite.toString())) {
                chipVisite.callOnClick();
            } else {
                chipEvent.callOnClick();
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
                            if (!isEntry) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEventDetailActivity.class,"eventSauvegardeId",listEvents.get(position).getId(),false);
                            } else if (chipBoutique.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryBoutiqueDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipHebergement.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryHebergementDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipHotel.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryHotelDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipRestaurant.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryRestaurantDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipShopping.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryShoppingDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipVisite.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryVisiteDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipUtile.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryUtileDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipTransport.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntryTransportDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            } else if (chipSortie.isChecked()) {
                                ouvrirActiviteSuivante(AfficherChoixEnregistrementActivity.this, AfficherEntrySortieDetailActivity.class,"entryId",listEntriesFiltres.get(position).getId(),false);
                            }
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

    @OnClick(R.id.chipEvent)
    public void setChipEventClick() {
        decocherAutresChip(null);
        isEntry = false;
        configureRecyclerView();
    }

    @OnClick(R.id.chipBoutique)
    public void setChipBoutiqueClick() {
        decocherAutresChip(EntriesType.Boutique);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Boutique) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipUtile)
    public void setChipUtileClick() {
        decocherAutresChip(EntriesType.Utile);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Utile) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipSortie)
    public void setChipSortieClick() {
        decocherAutresChip(EntriesType.Sortie);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Sortie) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipTransport)
    public void setChipTransportClick() {
        decocherAutresChip(EntriesType.Transport);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Transport) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipShopping)
    public void setChipShoppingClick() {
        decocherAutresChip(EntriesType.Shopping);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Shopping) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipVisite)
    public void setChipVisiteClick() {
        decocherAutresChip(EntriesType.Visite);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Visite) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipRestaurant)
    public void setChipRestaurantClick() {
        decocherAutresChip(EntriesType.Restaurant);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Restaurant) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipHotel)
    public void setChipHotelClick() {
        decocherAutresChip(EntriesType.Hotel);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Hotel) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    @OnClick(R.id.chipHebergement)
    public void setChipHebergementClick() {
        decocherAutresChip(EntriesType.Hebergement);
        isEntry = true;
        listEntriesFiltres.clear();
        for (EntryEntity current : listEntries) {
            if (current.getEntryType() == EntriesType.Hebergement) {
                listEntriesFiltres.add(current);
            }
        }
        configureRecyclerView();
    }

    private void decocherAutresChip(EntriesType type) {
            if (type != null) {
                chipEvent.setChecked(false);
            }
            if (type != EntriesType.Boutique) {
                chipBoutique.setChecked(false);
            }
        if (type != EntriesType.Visite) {
            chipVisite.setChecked(false);
        }
        if (type != EntriesType.Utile) {
            chipUtile.setChecked(false);
        }
        if (type != EntriesType.Transport) {
            chipTransport.setChecked(false);
        }
        if (type != EntriesType.Sortie) {
            chipSortie.setChecked(false);
        }
        if (type != EntriesType.Shopping) {
            chipShopping.setChecked(false);
        }
        if (type != EntriesType.Restaurant) {
            chipRestaurant.setChecked(false);
        }
        if (type != EntriesType.Hotel) {
            chipHotel.setChecked(false);
        }
        if (type != EntriesType.Hebergement) {
            chipHebergement.setChecked(false);
        }
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