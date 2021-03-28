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
import com.pouillos.sortirnice.entities.entry.EntryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryActivityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAddressEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAffiliationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCapacityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryChainEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCommonTagEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryContactEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDescriptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDisabledOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFrpOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryGridEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryGroupOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryImageEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLanguageEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLivingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOpeningEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPoiOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryProfileEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPublicationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySectorEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySpaceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStandingLevelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryTariffEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryActivityEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAffiliationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryChainEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCommonTagEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryContactEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDescriptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDisabledOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFrpOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryGroupOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryImageEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLanguageEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryOpeningEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPoiOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryProfileEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPublicationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySectorEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySpaceEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStandingLevelEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryTariffEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryOpeningEntityWithEntryGridEntity;
import com.pouillos.sortirnice.enumeration.EntriesType;
import com.pouillos.sortirnice.interfaces.EntriesUtileApiService;
import com.pouillos.sortirnice.modelentries.Activity;
import com.pouillos.sortirnice.modelentries.Affiliation;
import com.pouillos.sortirnice.modelentries.Amenity;
import com.pouillos.sortirnice.modelentries.Animation;
import com.pouillos.sortirnice.modelentries.Atmospher;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Chain;
import com.pouillos.sortirnice.modelentries.Closing;
import com.pouillos.sortirnice.modelentries.Closure;
import com.pouillos.sortirnice.modelentries.CommonTag;
import com.pouillos.sortirnice.modelentries.Contact;
import com.pouillos.sortirnice.modelentries.Description;
import com.pouillos.sortirnice.modelentries.DisabledOption;
import com.pouillos.sortirnice.modelentries.Entries;
import com.pouillos.sortirnice.modelentries.Entry;
import com.pouillos.sortirnice.modelentries.FamilyOption;
import com.pouillos.sortirnice.modelentries.FrpOption;
import com.pouillos.sortirnice.modelentries.Grid;
import com.pouillos.sortirnice.modelentries.GroupOption;
import com.pouillos.sortirnice.modelentries.Image;
import com.pouillos.sortirnice.modelentries.Label;
import com.pouillos.sortirnice.modelentries.Language;
import com.pouillos.sortirnice.modelentries.Location;
import com.pouillos.sortirnice.modelentries.Opening;
import com.pouillos.sortirnice.modelentries.Option;
import com.pouillos.sortirnice.modelentries.Payment;
import com.pouillos.sortirnice.modelentries.PoiOption;
import com.pouillos.sortirnice.modelentries.Profile;
import com.pouillos.sortirnice.modelentries.Publication;
import com.pouillos.sortirnice.modelentries.Sector;
import com.pouillos.sortirnice.modelentries.Service;
import com.pouillos.sortirnice.modelentries.Space;
import com.pouillos.sortirnice.modelentries.StandingLevel;
import com.pouillos.sortirnice.modelentries.Station;
import com.pouillos.sortirnice.modelentries.Tariff;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntriesUtile;
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

public class AfficherEntriesUtileActivity extends NavDrawerActivity implements RecyclerAdapterEntriesUtile.Listener {

    int nbEntries;
    List<Entry> listEntries;
    List<EntryEntity> listEntryEntities = new ArrayList<>();

    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;

    private RecyclerAdapterEntriesUtile adapterEntries;

    private static final String TAG = AfficherEntriesUtileActivity.class.getSimpleName();
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

        setTitle("Liste des Utiles");
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
        EntriesUtileApiService entriesUtileApiService = retrofit.create(EntriesUtileApiService.class);
        //Call<Entries> call = eventApiService.getEntries(API_KEY);
        Call<Entries> call = entriesUtileApiService.getEntries();
        call.enqueue(new Callback<Entries>() {
            @Override
            public void onResponse(Call<Entries> call, Response<Entries> response) {
                if (response.code()==200) {


                    listEntries = response.body().getListEntries();
                    configureRecyclerView();
                    //recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                    //saveListEntries();
                    listEntryEntities = saveListEntries(listEntries);
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



    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        ouvrirActiviteSuivante(AfficherEntriesUtileActivity.this, AfficherEntryUtileDetailActivity.class,"entryId",listEntryEntities.get(position).getId(),false);
                        Log.e("TAG", "Position : "+position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntriesUtile(listEntries, this);
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