package com.pouillos.sortirnice.activities;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.EntryEntity;
import com.pouillos.sortirnice.interfaces.EntriesApiService;


import com.pouillos.sortirnice.modelentries.Entries;
import com.pouillos.sortirnice.modelentries.Entry;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillos.sortirnice.utils.DateUtils;
import com.pouillos.sortirnice.utils.ItemClickSupport;

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

public class AfficherEntriesActivity extends NavDrawerActivity implements RecyclerAdapterEntries.Listener {

    int nbEntries;
    List<Entry> listEntries;
    List<EntryEntity> listEntryEntities = new ArrayList<>();

    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;

    private RecyclerAdapterEntries adapterEntries;

    private static final String TAG = AfficherEntriesActivity.class.getSimpleName();
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

        listEntries = new ArrayList<>();
        nbEntries = 0;

        setTitle("Liste des Entries");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);

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
        EntriesApiService entriesApiService = retrofit.create(EntriesApiService.class);
        //Call<Entries> call = eventApiService.getEntries(API_KEY);
        Call<Entries> call = entriesApiService.getEntries();
        call.enqueue(new Callback<Entries>() {
            @Override
            public void onResponse(Call<Entries> call, Response<Entries> response) {
                if (response.code()==200) {


                    listEntries = response.body().getListEntries();
                    configureRecyclerView();
                    //recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                    saveListEntries();
                    isResponded = true;
                    Log.d(TAG, "Number of entries received: " + listEntries.size());
                    progressBar.setVisibility(View.GONE);
                } else {

                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    myUrl = BASE_URL+dateDemandeString+"/";
                    connectAndGetApiData(myUrl);
                    //Log.d(TAG, dateDemandeString + " : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Entries> call, Throwable throwable) {

                Log.e(TAG, throwable.toString());
            }
        });
    }

    private void saveListEntries() {
        entryEntityDao.deleteAll();
        for (Entry current : listEntries) {
            EntryEntity entryToSave = new EntryEntity();
           /* eventToSave.setEntryId(Long.valueOf(current.getId()));
            eventToSave.setNameFr(current.getNameFr());
            eventToSave.setStart(current.getStart());
            eventToSave.setEnd(current.getEnd());
            eventToSave.setAdressContent(current.getAddress()!=null ? current.getAddress().getAddressContent() : null);
            eventToSave.setAdressZip(current.getAddress()!=null ? current.getAddress().getZip() : null);
            eventToSave.setAdressCity(current.getAddress()!=null ? current.getAddress().getCity() : null);
            eventToSave.setPhone(current.getPhone());
            eventToSave.setEmail(current.getEmail());
            eventToSave.setWebsiteSituation(current.getWebsiteMap().get("situation"));
            eventToSave.setWebsitePrincipal(current.getWebsiteMap().get("principal"));
            eventToSave.setProfile(current.getListProfiles().size()>0 ? current.getListProfiles().get(0).getValue() : null);
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
            eventToSave.setEntryId(current.getRefEntries()!=null ? current.getRefEntries().getRefEntryId() : null);
            eventToSave.setEntryName(current.getRefEntries()!=null ? current.getRefEntries().getRefEntryName() : null);
            eventToSave.setCreated(current.getCreated());
            eventToSave.setUpdated(current.getUpdated());*/
            entryEntityDao.insert(entryToSave);
            listEntryEntities.add(entryToSave);
        }
    }

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        ouvrirActiviteSuivante(AfficherEntriesActivity.this,AfficherEntryDetailActivity.class,"entryId",listEntryEntities.get(position).getId(),false);
                        Log.e("TAG", "Position : "+position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntries(listEntries, this);
        list_recycler_event.setAdapter(adapterEntries);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    private void fillAllFields() {
       // textName.setText(saisonTransmise.getSerie().toString()+" - Saison "+BasicUtils.afficherChiffre(saisonTransmise.getNumSaison()));
    }

    @Override
    public void onClickEntriesButton(int position) {
      //  ouvrirActiviteSuivante(this,AfficherEntryDetailActivity.class,"eventId",listEntryEntities.get(position).getId(),false);
    }
}