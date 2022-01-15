package com.pouillcorp.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EventEntity;
import com.pouillcorp.sortirnice.interfaces.EventsApiService;
import com.pouillcorp.sortirnice.modelevents.Address;
import com.pouillcorp.sortirnice.modelevents.Description;
import com.pouillcorp.sortirnice.modelevents.Event;
import com.pouillcorp.sortirnice.modelevents.Events;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvents;
import com.pouillcorp.sortirnice.utils.DateUtils;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEventsActivity extends NavDrawerActivity implements RecyclerAdapterEvents.Listener {

    int nbEvents;
    List<Event> listEvents;
    List<EventEntity> listEventEntities = new ArrayList<>();

    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;

    private RecyclerAdapterEvents adapterEvents;

    private static final String TAG = AfficherEventsActivity.class.getSimpleName();
    public static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    public String myUrl = BASE_URL;
    private static Retrofit retrofit = null;
    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    private String dateDemandeString;
    private String dateVeilleString;
    private Date dateDemande;
    private Date dateVeille;

    boolean isResponded = false;

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
        //dateVeille = DateUtils.calculerVeille(dateDemande);
        //dateVeilleString = DateUtils.formatDateYYYY_MM_DD(dateVeille);
        myUrl += dateDemandeString+"/";
        //while (!isResponded) {
            connectAndGetApiData(myUrl);
            /*dateDemande = DateUtils.calculerVeille(dateDemande);
            dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
            myUrl = BASE_URL+dateDemandeString+"/";*/
       // }
        //connectAndGetApiData(dateJourString);
    }

    public void connectAndGetApiData(String url) {
        //if (retrofit == null) {
            //BASE_URL +=
            retrofit = new Retrofit.Builder()
                   // .baseUrl(BASE_URL+"/"+dateString)
                    .baseUrl(url)
                    .client(new OkHttpClient())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
       // }
        EventsApiService eventApiService = retrofit.create(EventsApiService.class);
        //Call<Events> call = eventApiService.getEvents(API_KEY);
        Call<Events> call = eventApiService.getEvents();
        call.enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                if (response.code()==200) {


                    listEvents = response.body().getListEvents();
                    configureRecyclerView();
                    //recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                    saveListEvents();
                    isResponded = true;
                    Log.e(TAG, "Number of events received: " + listEvents.size());
                    progressBar.setVisibility(View.GONE);
                } else {

                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    myUrl = BASE_URL+dateDemandeString+"/";
                    connectAndGetApiData(myUrl);
                    Log.e(TAG, dateDemandeString + " : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Events> call, Throwable throwable) {

                Log.e(TAG, throwable.toString());
                progressBar.setVisibility(View.GONE);
                Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private boolean isEventExistant(Event event){
        List<EventEntity> listEventsNonFavoris = eventEntityDao.queryRaw("where event_id = ?"+event.getId());
        if (listEventsNonFavoris.size()>0){
            return true;
        }
        return false;
    }

    /*private boolean isEventAndEventEntityIdentique(Event event, EventEntity eventEntity){
        //boolean reponse = true;
        if (event.getId() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListAddresses() != eventEntity.getEventId()){
            return false;
        }
        if (event.getCreated().equalsIgnoreCase(eventEntity.getCreated())){
            return false;
        }
        if (event.getEmail().equalsIgnoreCase(eventEntity.getEmail())){
            return false;
        }
        if (event.getEnd().equalsIgnoreCase(eventEntity.getEnd())){
            return false;
        }
        if (event.getLatitude() != eventEntity.getLatitude()){
            return false;
        }
        if (event.getListCategories() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListDescriptions() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListImages() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListOptions() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListProfiles() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListRefEntries() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListSectors() != eventEntity.getEventId()){
            return false;
        }
        if (event.getListStations() != eventEntity.getEventId()){
            return false;
        }
        if (event.getLongitude() != eventEntity.getLongitude()){
            return false;
        }
        if (event.getNameFr().equalsIgnoreCase(eventEntity.getNameFr())){
            return false;
        }
        if (event.getNote() != eventEntity.getNote()){
            return false;
        }
        if (event.getPhone().equalsIgnoreCase(eventEntity.getPhone())){
            return false;
        }
        if (event.getStart().equalsIgnoreCase(eventEntity.getStart())){
            return false;
        }
        if (event.getUpdated().equalsIgnoreCase(eventEntity.getUpdated())){
            return false;
        }
        if (event.getWebsiteMap() != eventEntity.getEventId()){
            return false;
        }




    }*/

    private void saveListEvents() {
        //eventEntityDao.deleteAll();
        List<EventEntity> listEventsNonFavoris = eventEntityDao.queryRaw("where favori = 0");
        int nbTotalEvensNonFavoris = listEventsNonFavoris.size();
        long nbTotalEvents = eventEntityDao.count();
        for (EventEntity current : listEventsNonFavoris){
            eventEntityDao.delete(current);

        }

        Log.e("TAG", "suppression event non favoris termine - "+nbTotalEvensNonFavoris+" sur "+nbTotalEvents);


        for (Event current : listEvents) {

            //rechercher si un existant deja
            //chercher à partir de l'id et verifier si parfaitmeent similaire sinon l'enregistrer quand même


            EventEntity eventToSave = new EventEntity();
            eventToSave.setEventId(Long.valueOf(current.getId()));
            eventToSave.setNameFr(current.getNameFr());
            eventToSave.setStart(current.getStart());
            eventToSave.setEnd(current.getEnd());

            //remplacer par boucle pour 2 types
            //eventToSave.setAdressSituationContent(current.getAddress()!=null ? current.getAddress().getAddressContent() : null);
            //eventToSave.setAdressSituationZip(current.getAddress()!=null ? current.getAddress().getZip() : null);
            //eventToSave.setAdressSituationCity(current.getAddress()!=null ? current.getAddress().getCity() : null);
            if (current.getListAddresses() != null && current.getListAddresses().size()>0) {
                for (Address currentAddress : current.getListAddresses()) {
                    if (currentAddress.getType().equalsIgnoreCase("situation")) {
                        eventToSave.setAdressSituationContent(currentAddress.getAddressContent());
                        eventToSave.setAdressPrincipalZip(currentAddress.getZip());
                        eventToSave.setAdressSituationCity(currentAddress.getCity());
                    } else if (currentAddress.getType().equalsIgnoreCase("principal")) {
                        eventToSave.setAdressSituationContent(currentAddress.getAddressContent());
                        eventToSave.setAdressPrincipalZip(currentAddress.getZip());
                        eventToSave.setAdressSituationCity(currentAddress.getCity());
                    }
                }
            }



            eventToSave.setPhone(current.getPhone());
            eventToSave.setEmail(current.getEmail());
            eventToSave.setWebsiteSituation(current.getWebsiteMap().get("situation"));
            eventToSave.setWebsitePrincipal(current.getWebsiteMap().get("principal"));
            eventToSave.setProfile((current.getListProfiles()!=null &&current.getListProfiles().size()>0) ? current.getListProfiles().get(0).getValue() : null);
            eventToSave.setStation((current.getListStations()!=null && current.getListStations().size()>0) ? current.getListStations().get(0).getValue() : null);
            eventToSave.setCategory((current.getListCategories()!=null && current.getListCategories().size()>0) ? current.getListCategories().get(0).getValue() : null);
            eventToSave.setOption((current.getListOptions()!=null && current.getListOptions().size()>0) ? current.getListOptions().get(0).getValue() : null);
            eventToSave.setSecto((current.getListSectors()!=null && current.getListSectors().size()>0) ? current.getListSectors().get(0).getValue() : null);
            for (Description currentDescription : current.getListDescriptions()) {
                if (currentDescription.getLanguage().equalsIgnoreCase("fr")) {
                    if (currentDescription.getType().equalsIgnoreCase("Situation")) {
                        eventToSave.setDescriptionSituation(currentDescription.getValue());
                    } else if (currentDescription.getType().equalsIgnoreCase("Horaires")) {
                        eventToSave.setDescriptionHoraires(currentDescription.getValue());
                    } else if (currentDescription.getType().equalsIgnoreCase("Tarification")) {
                        eventToSave.setDescriptionTarification(currentDescription.getValue());
                    } else if (currentDescription.getType().equalsIgnoreCase("Description")) {
                        eventToSave.setDescriptionDescription(currentDescription.getValue());
                    }
                }
            }
            eventToSave.setImage((current.getListImages()!=null && current.getListImages().size()>0) ? current.getListImages().get(0).getUrl() : null);
            eventToSave.setLatitude(current.getLatitude());
            eventToSave.setLongitude(current.getLongitude());
            eventToSave.setNote(current.getNote());
            //eventToSave.setEntryId(current.getRefEntries()!=null ? current.getRefEntries().getRefEntryId() : null);
            //eventToSave.setEntryName(current.getRefEntries()!=null ? current.getRefEntries().getRefEntryName() : null);
            eventToSave.setEntryId((current.getListRefEntries()!=null && current.getListRefEntries().size()>0) ? current.getListRefEntries().get(0).getRefEntryId() : null);
            eventToSave.setEntryName((current.getListRefEntries()!=null && current.getListRefEntries().size()>0) ? current.getListRefEntries().get(0).getRefEntryName() : null);
            eventToSave.setCreated(current.getCreated());
            eventToSave.setUpdated(current.getUpdated());
            eventEntityDao.insert(eventToSave);
            Log.e(TAG, "Ajout "+eventToSave.getNameFr());
            listEventEntities.add(eventToSave);
        }
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        ouvrirActiviteSuivante(AfficherEventsActivity.this,AfficherEventDetailActivity.class,"eventId",listEventEntities.get(position).getId(),false);
                        Log.e("TAG", "Position : "+position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEvents = new RecyclerAdapterEvents(listEvents, this);
        list_recycler_event.setAdapter(adapterEvents);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    private void fillAllFields() {
       // textName.setText(saisonTransmise.getSerie().toString()+" - Saison "+BasicUtils.afficherChiffre(saisonTransmise.getNumSaison()));
    }

    @Override
    public void onClickEventsButton(int position) {
      //  ouvrirActiviteSuivante(this,AfficherEventDetailActivity.class,"eventId",listEventEntities.get(position).getId(),false);
    }
}