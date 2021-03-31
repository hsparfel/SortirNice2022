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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillos.sortirnice.App;
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
import com.pouillos.sortirnice.interfaces.EntriesHotelApiService;
import com.pouillos.sortirnice.interfaces.EntriesHotelApiService;
import com.pouillos.sortirnice.modelentries.Activity;
import com.pouillos.sortirnice.modelentries.Affiliation;
import com.pouillos.sortirnice.modelentries.Amenity;
import com.pouillos.sortirnice.modelentries.Animation;
import com.pouillos.sortirnice.modelentries.Atmospher;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Chain;
import com.pouillos.sortirnice.modelentries.Closing;
import com.pouillos.sortirnice.modelentries.Closure;
import com.pouillos.sortirnice.modelentries.Closures;
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
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntriesHotel;
import com.pouillos.sortirnice.recycler.adapter.RecyclerAdapterEntriesHotel;
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

public class AfficherEntriesHotelActivity extends NavDrawerActivity implements RecyclerAdapterEntriesHotel.Listener {

    int nbEntries;
    List<Entry> listEntries;
    List<EntryEntity> listEntryEntities = new ArrayList<>();

    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;



    private RecyclerAdapterEntriesHotel adapterEntries;

    private static final String TAG = AfficherEntriesHotelActivity.class.getSimpleName();
    public static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    public String myUrl = BASE_URL;
    private static Retrofit retrofit = null;
    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    private String dateDemandeString;
    private String dateVeilleString;
    private Date dateDemande;
    private Date dateVeille;

    boolean isResponded = false;





    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name_fr)
    TextView nameFr;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.address_line1)
    TextView addressLine1;
    @BindView(R.id.address_line2)
    TextView addressLine2;
    @BindView(R.id.address_line3)
    TextView addressLine3;
    @BindView(R.id.address_zip)
    TextView addressZip;
    @BindView(R.id.address_city)
    TextView addressCity;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.fax)
    TextView fax;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.website)
    TextView website;
    @BindView(R.id.facebook)
    TextView facebook;
    @BindView(R.id.twitter)
    TextView twitter;
    @BindView(R.id.station)
    TextView station;
    @BindView(R.id.option)
    TextView option;
    @BindView(R.id.payment)
    TextView payment;
    @BindView(R.id.amenity)
    TextView amenity;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.closure)
    TextView closure;
    @BindView(R.id.label)
    TextView label;
    @BindView(R.id.service)
    TextView service;
    @BindView(R.id.opening)
    TextView opening;
    @BindView(R.id.closing)
    TextView closing;
    @BindView(R.id.openings)
    TextView openings;
    @BindView(R.id.closings)
    TextView closings;
    @BindView(R.id.animation)
    TextView animation;
    @BindView(R.id.atmosphere)
    TextView atmosphere;
    @BindView(R.id.capacity_total)
    TextView capacityTotal;
    @BindView(R.id.capacity_interieur)
    TextView capacityInterieur;
    @BindView(R.id.capacity_exterieur)
    TextView capacityExterieur;
    @BindView(R.id.capacity_assis)
    TextView capacityAssis;
    @BindView(R.id.capacity_debout)
    TextView capacityDebout;
    @BindView(R.id.capacity_group)
    TextView capacityGroup;
    @BindView(R.id.capacity_salle)
    TextView capacitySalle;
    @BindView(R.id.layout_address)
    LinearLayout layoutAddress;
    @BindView(R.id.boutons_map_waze)
    LinearLayout boutonsMapWaze;
    @BindView(R.id.ouvert)
    LinearLayout ouvert;
    @BindView(R.id.ferme)
    LinearLayout ferme;
    @BindView(R.id.layout_payment)
    LinearLayout layoutPayment;
    @BindView(R.id.layout_label)
    LinearLayout layoutLabel;
    @BindView(R.id.layout_animation)
    LinearLayout layoutAnimation;

    Bitmap bitmap = null;
    String newLine = System.getProperty("line.separator");

    Entry selectedEntry;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.fabExit)
    FloatingActionButton fabExit;
    @BindView(R.id.fabSave)
    FloatingActionButton fabSave;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_entry_hotel);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        listEntries = new ArrayList<>();
        nbEntries = 0;

        setTitle("Liste des Hotels");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_add_serie).setChecked(true);
        dateDemande = new Date();
        dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
        myUrl += dateDemandeString+"/";
        connectAndGetApiData(myUrl);
    }

    public void connectAndGetApiData(String url) {
        retrofit = new Retrofit.Builder()
                // .baseUrl(BASE_URL+"/"+dateString)
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        EntriesHotelApiService entriesHotelApiService = retrofit.create(EntriesHotelApiService.class);
        Call<Entries> call = entriesHotelApiService.getEntries();
        call.enqueue(new Callback<Entries>() {
            @Override
            public void onResponse(Call<Entries> call, Response<Entries> response) {
                if (response.code()==200) {
                    listEntries = response.body().getListEntries();
                    configureRecyclerView();
                    isResponded = true;
                    Log.d(TAG, "Number of entries received: " + listEntries.size());
                    progressBar.setVisibility(View.GONE);
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

    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        //ouvrirActiviteSuivante(AfficherEntriesHotelActivity.this, AfficherEntryHotelDetailActivity.class,"entryId",listEntryEntities.get(position).getId(),false);
                        Log.e("TAG", "Position : "+position);
                        selectedEntry = listEntries.get(position);
                        fillAllFields();
                        hideFields();
                        AfficherEntriesHotelActivity.AsyncTaskRunnerImage runnerImage = new AfficherEntriesHotelActivity.AsyncTaskRunnerImage();
                        runnerImage.execute();
                        afficherDetail(true);
                    }
                });
    }

    public void afficherDetail(boolean bool) {
        if (bool) {
            scrollView.setVisibility(View.VISIBLE);
            fabExit.setVisibility(View.VISIBLE);
            List<EntryEntity> listEntriesFound = entryEntityDao.queryRaw("where entry_entity_id = ?",""+selectedEntry.getId());
            if (listEntriesFound.size() == 0) {
                fabSave.setVisibility(View.VISIBLE);
            } else {
                fabSave.setVisibility(View.GONE);
            }
        } else {
            scrollView.setVisibility(View.GONE);
            fabExit.setVisibility(View.GONE);
            fabSave.setVisibility(View.GONE);
        }
    }

    public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntriesHotel(listEntries, this);
        list_recycler_event.setAdapter(adapterEntries);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    @Override
    public void onClickEntriesButton(int position) {
        //  ouvrirActiviteSuivante(this,AfficherEntryDetailActivity.class,"eventId",listEntryEntities.get(position).getId(),false);
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        saveEntry(selectedEntry);
        fabExit.performClick();
    }

    private void hideFields() {
        if (selectedEntry.getNameFr() == null) {
            nameFr.setVisibility(View.GONE);
        } else {
            nameFr.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListCategories() == null || selectedEntry.getListCategories().size() == 0) {
            category.setVisibility(View.GONE);
        } else {
            category.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListLocations() == null || selectedEntry.getListLocations().size() == 0) {
            location.setVisibility(View.GONE);
        } else {
            location.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListAtmosphere() == null || selectedEntry.getListAtmosphere().size() == 0) {
            atmosphere.setVisibility(View.GONE);
        } else {
            atmosphere.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListServices() == null || selectedEntry.getListServices().size() == 0) {
            service.setVisibility(View.GONE);
        } else {
            service.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress() == null && (selectedEntry.getListStations() == null || selectedEntry.getListStations().size() == 0)) {
            layoutAddress.setVisibility(View.GONE);
        } else {
            layoutAddress.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress() == null) {
            boutonsMapWaze.setVisibility(View.GONE);
        } else {
            boutonsMapWaze.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress().getAddressLine1() == null) {
            addressLine1.setVisibility(View.GONE);
        } else {
            addressLine1.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress().getAddressLine2() == null) {
            addressLine2.setVisibility(View.GONE);
        } else {
            addressLine2.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress().getAddressLine3() == null) {
            addressLine3.setVisibility(View.GONE);
        } else {
            addressLine3.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress().getZip() == null) {
            addressZip.setVisibility(View.GONE);
        } else {
            addressZip.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress().getCity() == null) {
            addressCity.setVisibility(View.GONE);
        } else {
            addressCity.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListStations() == null || selectedEntry.getListStations().size() == 0) {
            station.setVisibility(View.GONE);
        } else {
            station.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getPhone() == null) {
            phone.setVisibility(View.GONE);
        } else {
            phone.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getFax() == null) {
            fax.setVisibility(View.GONE);
        } else {
            fax.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getEmail() == null) {
            email.setVisibility(View.GONE);
        } else {
            email.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getWebsite() == null) {
            website.setVisibility(View.GONE);
        } else {
            website.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getFacebook() == null) {
            facebook.setVisibility(View.GONE);
        } else {
            facebook.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getTwitter() == null) {
            twitter.setVisibility(View.GONE);
        } else {
            twitter.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListPayments() == null || selectedEntry.getListPayments().size() == 0) {
            layoutPayment.setVisibility(View.GONE);
        } else {
            layoutPayment.setVisibility(View.VISIBLE);
        }
        if ((selectedEntry.getListOpenings() == null || selectedEntry.getListOpenings().size() == 0) && selectedEntry.getOpening() == null) {
            ouvert.setVisibility(View.GONE);
        } else {
            ouvert.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListOpenings() == null|| selectedEntry.getListOpenings().size() == 0) {
            openings.setVisibility(View.GONE);
        } else {
            openings.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getOpening() == null) {
            opening.setVisibility(View.GONE);
        } else {
            opening.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListLabels() == null || selectedEntry.getListLabels().size() == 0) {
            layoutLabel.setVisibility(View.GONE);
        } else {
            layoutLabel.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListAnimations() == null || selectedEntry.getListAnimations().size() == 0) {
            layoutAnimation.setVisibility(View.GONE);
        } else {
            layoutAnimation.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListOptions() == null || selectedEntry.getListOptions().size() == 0) {
            option.setVisibility(View.GONE);
        } else {
            option.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListAmenities() == null || selectedEntry.getListAmenities().size() == 0) {
            amenity.setVisibility(View.GONE);
        } else {
            amenity.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getCapacity() == null || selectedEntry.getCapacity().getGroup() == 0) {
            capacityGroup.setVisibility(View.GONE);
        } else {
            capacityGroup.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getCapacity() == null || selectedEntry.getCapacity().getCocktail() == 0) {
            capacityDebout.setVisibility(View.GONE);
        } else {
            capacityDebout.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getCapacity() == null || selectedEntry.getCapacity().getSeated() == 0) {
            capacityAssis.setVisibility(View.GONE);
        } else {
            capacityAssis.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getCapacity() == null || selectedEntry.getCapacity().getOutdoor() == 0) {
            capacityExterieur.setVisibility(View.GONE);
        } else {
            capacityExterieur.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getCapacity() == null || selectedEntry.getCapacity().getIndoor() == 0) {
            capacityInterieur.setVisibility(View.GONE);
        } else {
            capacityInterieur.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getCapacity() == null || selectedEntry.getCapacity().getTotal() == 0) {
            capacityTotal.setVisibility(View.GONE);
        } else {
            capacityTotal.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getCapacity() == null || selectedEntry.getCapacity().getRoomCount() == 0) {
            capacitySalle.setVisibility(View.GONE);
        } else {
            capacitySalle.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListClosings() == null || selectedEntry.getListClosings().size() == 0) {
            closings.setVisibility(View.GONE);
        } else {
            closings.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getClosing() == null) {
            closing.setVisibility(View.GONE);
        } else {
            closing.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListClosures() == null || selectedEntry.getListClosures().size() == 0) {
            closure.setVisibility(View.GONE);
        } else {
            closure.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListClosures() != null){
            for (Closures closures : selectedEntry.getListClosures()){
                if (closures.getListClosure() == null || closures.getListClosure().size() == 0) {
                    closure.setVisibility(View.GONE);
                } else {
                    closure.setVisibility(View.VISIBLE);
                }
            }
        }
        if (closings.getVisibility() == View.GONE && closing.getVisibility() == View.GONE
                && closure.getVisibility() == View.GONE) {
            ferme.setVisibility(View.GONE);
        } else {
            ferme.setVisibility(View.VISIBLE);
        }
    }

    private void fillAllFields() {
        nameFr.setText(selectedEntry.getNameFr());
        addressLine1.setText(selectedEntry.getAddress().getAddressLine1());
        addressLine2.setText(selectedEntry.getAddress().getAddressLine2());
        addressLine3.setText(selectedEntry.getAddress().getAddressLine3());
        addressZip.setText(selectedEntry.getAddress().getZip());
        addressCity.setText(selectedEntry.getAddress().getCity());
        phone.setText("Tel: "+selectedEntry.getPhone());
        fax.setText("Fax: "+selectedEntry.getFax());
        email.setText("Email: "+selectedEntry.getEmail());
        website.setText("Site: "+selectedEntry.getWebsite());
        facebook.setText("Fb: "+selectedEntry.getFacebook());
        twitter.setText("Twitter: "+selectedEntry.getTwitter());
        opening.setText(selectedEntry.getOpening());
        closing.setText(selectedEntry.getClosing());
        capacityTotal.setText("Cap. Total: "+selectedEntry.getCapacity().getTotal()+" pers");
        capacityInterieur.setText("Cap. Intérieur: "+selectedEntry.getCapacity().getIndoor()+" pers");
        capacityExterieur.setText("Cap. Extérieur: "+selectedEntry.getCapacity().getOutdoor()+" pers");
        capacityAssis.setText("Cap. Assis: "+selectedEntry.getCapacity().getSeated()+" pers");
        capacityDebout.setText("Cap. Debout: "+selectedEntry.getCapacity().getCocktail()+" pers");
        capacityGroup.setText("Cap. Group: "+selectedEntry.getCapacity().getGroup()+" pers");
        capacitySalle.setText("Nb Salle: "+selectedEntry.getCapacity().getRoomCount());

        String paymentString = "";
        if (selectedEntry.getListPayments()!=null) {
            int i = 1;
            for (Payment current : selectedEntry.getListPayments()) {
                paymentString += current.getValue();
                if (i < selectedEntry.getListPayments().size()) {
                    paymentString += " / ";
                }
                i++;
            }
        }
        payment.setText(paymentString);

        String amenityString = "";
        if (selectedEntry.getListAmenities()!=null) {
            int i = 1;
            for (Amenity current : selectedEntry.getListAmenities()) {
                amenityString += current.getValue();
                if (i < selectedEntry.getListAmenities().size()) {
                    amenityString += " / ";
                }
                i++;
            }
        }
        amenity.setText(amenityString);

        String locationString = "";
        if (selectedEntry.getListLocations()!=null) {
            int i = 1;
            for (Location current : selectedEntry.getListLocations()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.metropole))) {
                    locationString += current.getValue();
                    if (i < selectedEntry.getListLocations().size()) {
                        locationString += " / ";
                    }
                }
                i++;
            }
        }
        location.setText(locationString);

        String closureString = "";
        if (selectedEntry.getListClosures()!=null) {
            int i = 1;
            for (Closures closures : selectedEntry.getListClosures()) {
                if (closures.getListClosure() != null) {
                    for (Closure current : closures.getListClosure()) {
                        closureString += current.getClosureDay() + " - " + current.getClosureSpan();
                        if (i < closures.getListClosure().size()) {
                            closureString += newLine;
                        }
                        i++;
                    }
                }
            }
        }
        closure.setText(closureString);

        String labelString = "";
        if (selectedEntry.getListLabels()!=null) {
            int i = 1;
            for (Label current : selectedEntry.getListLabels()) {
                labelString += current.getValue();
                if (i < selectedEntry.getListLabels().size()) {
                    labelString += " / ";
                }
                i++;
            }
        }
        label.setText(labelString);

        String optionString = "";
        if (selectedEntry.getListOptions()!=null) {
            int i = 1;
            for (Option current : selectedEntry.getListOptions()) {
                optionString += current.getValue();
                if (i < selectedEntry.getListOptions().size()) {
                    optionString += " / ";
                }
                i++;
            }
        }
        option.setText(optionString);

        String openingString = "";
        if (selectedEntry.getListOpenings()!=null) {
            int i = 1;
            int j = 1;
            for (Opening current : selectedEntry.getListOpenings()) {
                openingString += current.getOpeningStart() + " - "+current.getOpeningEnd()+newLine;
                if (current.getListGrids() != null) {
                    for (Grid currentGrid : current.getListGrids()) {
                        openingString += currentGrid.getOpeningDays() + " - " + currentGrid.getOpeningHours();
                        if (j < current.getListGrids().size()) {
                            openingString += " / ";
                        }
                        j++;
                    }
                }
                if (i < selectedEntry.getListOpenings().size()) {
                    openingString += " / ";
                }
                i++;
            }
        }
        openings.setText(openingString);

        String closingString = "";
        if (selectedEntry.getListClosings()!=null) {
            int i = 1;
            for (Closing current : selectedEntry.getListClosings()) {
                closingString += current.getValue();
                if (i < selectedEntry.getListClosings().size()) {
                    closingString += " / ";
                }
                i++;
            }
        }
        closings.setText(closingString);

        String serviceString = "";
        if (selectedEntry.getListServices()!=null) {
            int i = 1;
            for (Service current : selectedEntry.getListServices()) {
                serviceString += current.getValue();
                if (i < selectedEntry.getListServices().size()) {
                    serviceString += " / ";
                }
                i++;
            }
        }
        service.setText(serviceString);

        String stationString = "";
        if (selectedEntry.getListStations()!=null) {
            int i = 1;
            for (Station current : selectedEntry.getListStations()) {
                stationString += current.getValue();
                if (i < selectedEntry.getListStations().size()) {
                    stationString += " / ";
                }
                i++;
            }
        }
        station.setText(stationString);

        String animationString = "";
        if (selectedEntry.getListAnimations()!=null) {
            int i = 1;
            for (Animation current : selectedEntry.getListAnimations()) {
                animationString += current.getValue();
                if (i < selectedEntry.getListAnimations().size()) {
                    animationString += " / ";
                }
                i++;
            }
        }
        animation.setText(animationString);

        String categoryString = "";
        if (selectedEntry.getListCategories()!=null) {
            int i = 1;
            for (Category current : selectedEntry.getListCategories()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))) {
                    categoryString += current.getValue();
                    if (i < selectedEntry.getListCategories().size()) {
                        categoryString += " / ";
                    }
                }
                i++;
            }
        }
        category.setText(categoryString);

        String atmosphereString = "";
        if (selectedEntry.getListAtmosphere()!=null) {
            int i = 1;
            for (Atmospher current : selectedEntry.getListAtmosphere()) {
                atmosphereString += current.getValue();
                if (i < selectedEntry.getListAtmosphere().size()) {
                    atmosphereString += " / ";
                }
                i++;
            }
        }
        atmosphere.setText(atmosphereString);
    }

    private class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url = null;
            bitmap = null;
            if (selectedEntry.getListImages()!= null) {
                if (selectedEntry.getListImages().size()>0 && selectedEntry.getListImages().get(0).getUrl().length() > 0) {
                    try {
                        url = new URL(selectedEntry.getListImages().get(0).getUrl());
                        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                        httpConn.connect();
                        int resCode = httpConn.getResponseCode();
                        if (resCode == HttpURLConnection.HTTP_OK) {
                            InputStream in = httpConn.getInputStream();
                            bitmap = BitmapFactory.decodeStream(in);
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            if (bitmap != null) {
                image.setImageBitmap(bitmap);
            } else {
                image.setImageResource(R.drawable.outline_camera);
                image.setVisibility(View.GONE);
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        protected void onProgressUpdate(Integer... integer) {
            //progressBar.setProgress(integer[0],true);
        }
    }

    public void exit(View view) {
        afficherDetail(false);
    }

    public void launchGoogleMap(View view) {
        String url = "geo:";
        String addr = "";
        if (selectedEntry.getLatitude() != 0 && selectedEntry.getLongitude() != 0) {
            url += selectedEntry.getLatitude()+","+selectedEntry.getLongitude();
            url += "?q="+selectedEntry.getLatitude()+","+selectedEntry.getLongitude();
        } else if (selectedEntry.getAddress().getAddressLine1() != null
                || selectedEntry.getAddress().getAddressLine2() != null
                || selectedEntry.getAddress().getAddressLine3() != null
                || selectedEntry.getAddress().getZip() != null
                || selectedEntry.getAddress().getCity() != null) {
            url += "0,0?q=";
            addr += Uri.parse(selectedEntry.getAddress().getAddressLine1()
                    +" "+selectedEntry.getAddress().getAddressLine2()
                    +" "+selectedEntry.getAddress().getAddressLine3()
                    +" "+selectedEntry.getAddress().getZip()
                    +" "+selectedEntry.getAddress().getCity());
            url += addr;
        }
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void launchWaze(View view) {
        try
        {
            String url = "";
            if (selectedEntry.getLatitude() !=0d && selectedEntry.getLongitude()!=0d) {
                url = "https://waze.com/ul?ll=";
                url += selectedEntry.getLatitude()+","+selectedEntry.getLongitude()+"&navigate=yes";
            } else {
                url = "https://waze.com/ul?q=";
                url += selectedEntry.getAddress().getAddressLine1()
                        +" " +selectedEntry.getAddress().getAddressLine2()
                        +" " +selectedEntry.getAddress().getAddressLine3()
                        +" " +selectedEntry.getAddress().getZip()
                        +" " + selectedEntry.getAddress().getCity();
            }
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
            startActivity( intent );
        }
        catch ( ActivityNotFoundException ex  )
        {
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
            startActivity(intent);
        }
    }


}