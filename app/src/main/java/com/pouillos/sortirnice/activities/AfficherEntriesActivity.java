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
import com.pouillos.sortirnice.interfaces.EntriesApiService;


import com.pouillos.sortirnice.modelentries.Activity;
import com.pouillos.sortirnice.modelentries.Address;
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
        //entryEntityDao.deleteAll();
        for (Entry current : listEntries) {
            List<EntryEntity> listEntriesFound = entryEntityDao.queryRaw("where entry_entity_id = ?",""+current.getId());
            if (listEntriesFound.size()==0) {
                EntryEntity entryToSave = new EntryEntity();
                entryToSave.setEntryEntityId(Long.valueOf(current.getId()));
                entryToSave.setNameFr(current.getNameFr());
                entryToSave.setNameFrShort(current.getNameFrShort());

                //enregistrer address
                EntryAddressEntity entryAddressEntity = new EntryAddressEntity();
                entryAddressEntity.setAddressLine1(current.getAddress().getAddressLine1());
                entryAddressEntity.setAddressLine2(current.getAddress().getAddressLine2());
                entryAddressEntity.setAddressLine3(current.getAddress().getAddressLine3());
                entryAddressEntity.setZip(current.getAddress().getZip());
                entryAddressEntity.setCity(current.getAddress().getCity());
                entryAddressEntity.setId(entryAddressEntityDao.insert(entryAddressEntity));
                entryToSave.setEntryAddressEntityId(entryAddressEntity.getId());

                entryToSave.setPhone(current.getPhone());
                entryToSave.setFax(current.getFax());
                entryToSave.setEmail(current.getEmail());
                entryToSave.setWebsite(current.getWebsite());
                entryToSave.setWebsiteReservation(current.getWebsiteReservation());
                entryToSave.setFacebook(current.getFacebook());
                entryToSave.setTwitter(current.getTwitter());

                //enregistrer living
                EntryLivingEntity entryLivingEntity = new EntryLivingEntity();
                entryLivingEntity.setRoomCount(current.getLiving().getRoomCount());
                entryLivingEntity.setRoomBathCount(current.getLiving().getRoomBathCount());
                entryLivingEntity.setRoomShowerCount(current.getLiving().getRoomShowerCount());
                entryLivingEntity.setRoomNoSmokingCount(current.getLiving().getRoomNoSmokingCount());
                entryLivingEntity.setSuiteCount(current.getLiving().getSuiteCount());
                entryLivingEntity.setStudioCount(current.getLiving().getStudioCount());
                entryLivingEntity.setApartmentCount(current.getLiving().getApartmentCount());
                entryLivingEntity.setRoomAccessibleCount(current.getLiving().getRoomAccessibleCount());
                entryLivingEntity.setSingleCount(current.getLiving().getSingleCount());
                entryLivingEntity.setDoubleCount(current.getLiving().getDoubleCount());
                entryLivingEntity.setTripleCount(current.getLiving().getTripleCount());
                entryLivingEntity.setTwinsCount(current.getLiving().getTwinsCount());
                entryLivingEntity.setFamilyCount(current.getLiving().getFamilyCount());
                entryLivingEntity.setArea(current.getLiving().getArea());
                entryLivingEntity.setType(current.getLiving().getType());
                entryLivingEntity.setFloor(current.getLiving().getFloor());
                entryLivingEntity.setBedroomCount(current.getLiving().getBedroomCount());
                entryLivingEntity.setSleepsCount(current.getLiving().getSleepsCount());
                entryLivingEntity.setFurnishedRoomCount(current.getLiving().getFurnishedRoomCount());
                entryLivingEntity.setId(entryLivingEntityDao.insert(entryLivingEntity));
                entryToSave.setEntryLivingEntityId(entryLivingEntity.getId());

                //enregistrer Capacity
                EntryCapacityEntity entryCapacityEntity = new EntryCapacityEntity();
                entryCapacityEntity.setTotal(current.getCapacity().getTotal());
                entryCapacityEntity.setIndoor(current.getCapacity().getIndoor());
                entryCapacityEntity.setOutdoor(current.getCapacity().getOutdoor());
                entryCapacityEntity.setSeated(current.getCapacity().getSeated());
                entryCapacityEntity.setCocktail(current.getCapacity().getCocktail());
                entryCapacityEntity.setGroup(current.getCapacity().getGroup());
                entryCapacityEntity.setRoomCount(current.getCapacity().getRoomCount());
                entryCapacityEntity.setDisabledCount(current.getCapacity().getDisabledCount());
                entryCapacityEntity.setId(entryCapacityEntityDao.insert(entryCapacityEntity));
                entryToSave.setEntryCapacityEntityId(entryCapacityEntity.getId());

                entryToSave.setOpening(current.getOpening());
                entryToSave.setCommercial(current.getCommercial());
                entryToSave.setClosing(current.getClosing());
                entryToSave.setLatitude(current.getLatitude());
                entryToSave.setLongitude(current.getLongitude());
                entryToSave.setLocation_map(current.getLocationMap());
                entryToSave.setNote(current.getNote());
                entryToSave.setStart(current.getStart());
                entryToSave.setNiceresId(current.getNiceresId());
                entryToSave.setNiceresAvailability(current.isNiceresAvailability());
                entryToSave.setCreated(current.getCreated());
                entryToSave.setUpdated(current.getUpdated());

                //enregistrer Entry pour recup id pour join + plus tard
                entryToSave.setId(entryEntityDao.insert(entryToSave));

                //enregistrer list contacts
                if (current.getListContacts() != null) {
                    for (Contact contact : current.getListContacts()) {
                        List<EntryContactEntity> list = entryContactEntityDao.queryRaw("where civility = ? and name = ? and title = ?" +
                                        "and function = ? and phone = ? and email = ?", contact.getCivility(),
                                contact.getName(), contact.getTitle(), contact.getFunction(), contact.getPhone(),
                                contact.getEmail());
                        JoinEntryEntityWithEntryContactEntity join = new JoinEntryEntityWithEntryContactEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryContactEntityId(list.get(0).getId());
                        } else {
                            EntryContactEntity entryContactEntity = new EntryContactEntity();
                            entryContactEntity.setCivility(contact.getCivility());
                            entryContactEntity.setName(contact.getName());
                            entryContactEntity.setTitle(contact.getTitle());
                            entryContactEntity.setFunction(contact.getFunction());
                            entryContactEntity.setPhone(contact.getPhone());
                            entryContactEntity.setEmail(contact.getEmail());
                            entryContactEntity.setId(entryContactEntityDao.insert(entryContactEntity));
                            join.setEntryContactEntityId(entryContactEntity.getId());
                        }
                        joinEntryEntityWithEntryContactEntityDao.insert(join);
                    }
                }

                //enregistrer list payments
                if (current.getListPayments() != null) {
                    for (Payment payment : current.getListPayments()) {
                        List<EntryPaymentEntity> list = entryPaymentEntityDao.queryRaw("where value = ?", payment.getValue());
                        JoinEntryEntityWithEntryPaymentEntity join = new JoinEntryEntityWithEntryPaymentEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryPaymentEntityId(list.get(0).getId());
                        } else {
                            EntryPaymentEntity entryPaymentEntity = new EntryPaymentEntity();
                            entryPaymentEntity.setValue(payment.getValue());
                            entryPaymentEntity.setId(entryPaymentEntityDao.insert(entryPaymentEntity));
                            join.setEntryPaymentEntityId(entryPaymentEntity.getId());
                        }
                        joinEntryEntityWithEntryPaymentEntityDao.insert(join);
                    }
                }

                //enregistrer list languages
                if (current.getListLanguages() != null) {
                    for (Language language : current.getListLanguages()) {
                        List<EntryLanguageEntity> list = entryLanguageEntityDao.queryRaw("where value = ?", language.getValue());
                        JoinEntryEntityWithEntryLanguageEntity join = new JoinEntryEntityWithEntryLanguageEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryLanguageEntityId(list.get(0).getId());
                        } else {
                            EntryLanguageEntity entryLanguageEntity = new EntryLanguageEntity();
                            entryLanguageEntity.setValue(language.getValue());
                            entryLanguageEntity.setId(entryLanguageEntityDao.insert(entryLanguageEntity));
                            join.setEntryLanguageEntityId(entryLanguageEntity.getId());
                        }
                        joinEntryEntityWithEntryLanguageEntityDao.insert(join);
                    }
                }

                //enregistrer list labels
                if (current.getListLabels() != null) {
                    for (Label label : current.getListLabels()) {
                        List<EntryLabelEntity> list = entryLabelEntityDao.queryRaw("where value = ?", label.getValue());
                        JoinEntryEntityWithEntryLabelEntity join = new JoinEntryEntityWithEntryLabelEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryLabelEntityId(list.get(0).getId());
                        } else {
                            EntryLabelEntity entryLabelEntity = new EntryLabelEntity();
                            entryLabelEntity.setValue(label.getValue());
                            entryLabelEntity.setId(entryLabelEntityDao.insert(entryLabelEntity));
                            join.setEntryLabelEntityId(entryLabelEntity.getId());
                        }
                        joinEntryEntityWithEntryLabelEntityDao.insert(join);
                    }
                }

                //enregistrer list amenities
                if (current.getListAmenities() != null) {
                    for (Amenity amenity : current.getListAmenities()) {
                        List<EntryAmenityEntity> list = entryAmenityEntityDao.queryRaw("where value = ?", amenity.getValue());
                        JoinEntryEntityWithEntryAmenityEntity join = new JoinEntryEntityWithEntryAmenityEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryAmenityEntityId(list.get(0).getId());
                        } else {
                            EntryAmenityEntity entryAmenityEntity = new EntryAmenityEntity();
                            entryAmenityEntity.setValue(amenity.getValue());
                            entryAmenityEntity.setId(entryAmenityEntityDao.insert(entryAmenityEntity));
                            join.setEntryAmenityEntityId(entryAmenityEntity.getId());
                        }
                        joinEntryEntityWithEntryAmenityEntityDao.insert(join);
                    }
                }

                //enregistrer list profiles
                if (current.getListProfiles() != null) {
                    for (Profile profile : current.getListProfiles()) {
                        List<EntryProfileEntity> list = entryProfileEntityDao.queryRaw("where value = ?", profile.getValue());
                        JoinEntryEntityWithEntryProfileEntity join = new JoinEntryEntityWithEntryProfileEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryProfileEntityId(list.get(0).getId());
                        } else {
                            EntryProfileEntity entryProfileEntity = new EntryProfileEntity();
                            entryProfileEntity.setValue(profile.getValue());
                            entryProfileEntity.setId(entryProfileEntityDao.insert(entryProfileEntity));
                            join.setEntryProfileEntityId(entryProfileEntity.getId());
                        }
                        joinEntryEntityWithEntryProfileEntityDao.insert(join);
                    }
                }

                //enregistrer list locations
                if (current.getListLocations() != null) {
                    for (Location location : current.getListLocations()) {
                        List<EntryLocationEntity> list = entryLocationEntityDao.queryRaw("where value = ?", location.getValue());
                        JoinEntryEntityWithEntryLocationEntity join = new JoinEntryEntityWithEntryLocationEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryLocationEntityId(list.get(0).getId());
                        } else {
                            EntryLocationEntity entryLocationEntity = new EntryLocationEntity();
                            entryLocationEntity.setValue(location.getValue());
                            entryLocationEntity.setId(entryLocationEntityDao.insert(entryLocationEntity));
                            join.setEntryLocationEntityId(entryLocationEntity.getId());
                        }
                        joinEntryEntityWithEntryLocationEntityDao.insert(join);
                    }
                }

                //enregistrer list activities

                if (current.getListActivities() != null) {
                    for (Activity activity : current.getListActivities()) {
                        List<EntryActivityEntity> list = entryActivityEntityDao.queryRaw("where value = ?", activity.getValue());
                        JoinEntryEntityWithEntryActivityEntity join = new JoinEntryEntityWithEntryActivityEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryActivityEntityId(list.get(0).getId());
                        } else {
                            EntryActivityEntity entryActivityEntity = new EntryActivityEntity();
                            entryActivityEntity.setValue(activity.getValue());
                            entryActivityEntity.setId(entryActivityEntityDao.insert(entryActivityEntity));
                            join.setEntryActivityEntityId(entryActivityEntity.getId());
                        }
                        joinEntryEntityWithEntryActivityEntityDao.insert(join);
                    }
                }

                //enregistrer list categories
                if (current.getListCategories() != null) {
                    for (Category category : current.getListCategories()) {
                        List<EntryCategoryEntity> list = entryCategoryEntityDao.queryRaw("where value = ?", category.getValue());
                        JoinEntryEntityWithEntryCategoryEntity join = new JoinEntryEntityWithEntryCategoryEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryCategoryEntityId(list.get(0).getId());
                        } else {
                            EntryCategoryEntity entryCategoryEntity = new EntryCategoryEntity();
                            entryCategoryEntity.setValue(category.getValue());
                            entryCategoryEntity.setId(entryCategoryEntityDao.insert(entryCategoryEntity));
                            join.setEntryCategoryEntityId(entryCategoryEntity.getId());
                        }
                        joinEntryEntityWithEntryCategoryEntityDao.insert(join);
                    }
                }

                //enregistrer list atmospheres
                if (current.getListAtmosphere() != null) {
                    for (Atmospher atmospher : current.getListAtmosphere()) {
                        List<EntryAtmospherEntity> list = entryAtmospherEntityDao.queryRaw("where value = ?", atmospher.getValue());
                        JoinEntryEntityWithEntryAtmospherEntity join = new JoinEntryEntityWithEntryAtmospherEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryAtmospherEntityId(list.get(0).getId());
                        } else {
                            EntryAtmospherEntity entryAtmospherEntity = new EntryAtmospherEntity();
                            entryAtmospherEntity.setValue(atmospher.getValue());
                            entryAtmospherEntity.setId(entryAtmospherEntityDao.insert(entryAtmospherEntity));
                            join.setEntryAtmospherEntityId(entryAtmospherEntity.getId());
                        }
                        joinEntryEntityWithEntryAtmospherEntityDao.insert(join);
                    }
                }

                //enregistrer list animations
                if (current.getListAnimations() != null) {
                    for (Animation animation : current.getListAnimations()) {
                        List<EntryAnimationEntity> list = entryAnimationEntityDao.queryRaw("where value = ?", animation.getValue());
                        JoinEntryEntityWithEntryAnimationEntity join = new JoinEntryEntityWithEntryAnimationEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryAnimationEntityId(list.get(0).getId());
                        } else {
                            EntryAnimationEntity entryAnimationEntity = new EntryAnimationEntity();
                            entryAnimationEntity.setValue(animation.getValue());
                            entryAnimationEntity.setId(entryAnimationEntityDao.insert(entryAnimationEntity));
                            join.setEntryAnimationEntityId(entryAnimationEntity.getId());
                        }
                        joinEntryEntityWithEntryAnimationEntityDao.insert(join);
                    }
                }

                //enregistrer list affiliations
                if (current.getListAffiliations() != null) {
                    for (Affiliation affiliation : current.getListAffiliations()) {
                        List<EntryAffiliationEntity> list = entryAffiliationEntityDao.queryRaw("where value = ?", affiliation.getValue());
                        JoinEntryEntityWithEntryAffiliationEntity join = new JoinEntryEntityWithEntryAffiliationEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryAffiliationEntityId(list.get(0).getId());
                        } else {
                            EntryAffiliationEntity entryAffiliationEntity = new EntryAffiliationEntity();
                            entryAffiliationEntity.setValue(affiliation.getValue());
                            entryAffiliationEntity.setId(entryAffiliationEntityDao.insert(entryAffiliationEntity));
                            join.setEntryAffiliationEntityId(entryAffiliationEntity.getId());
                        }
                        joinEntryEntityWithEntryAffiliationEntityDao.insert(join);
                    }
                }

                //enregistrer list stations
                if (current.getListStations() != null) {
                    for (Station station : current.getListStations()) {
                        List<EntryStationEntity> list = entryStationEntityDao.queryRaw("where value = ?", station.getValue());
                        JoinEntryEntityWithEntryStationEntity join = new JoinEntryEntityWithEntryStationEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryStationEntityId(list.get(0).getId());
                        } else {
                            EntryStationEntity entryStationEntity = new EntryStationEntity();
                            entryStationEntity.setValue(station.getValue());
                            entryStationEntity.setId(entryStationEntityDao.insert(entryStationEntity));
                            join.setEntryStationEntityId(entryStationEntity.getId());
                        }
                        joinEntryEntityWithEntryStationEntityDao.insert(join);
                    }
                }

                //enregistrer list standing levels
                if (current.getListStandingLevels() != null) {
                    for (StandingLevel standingLevel : current.getListStandingLevels()) {
                        List<EntryStandingLevelEntity> list = entryStandingLevelEntityDao.queryRaw("where value = ?", standingLevel.getValue());
                        JoinEntryEntityWithEntryStandingLevelEntity join = new JoinEntryEntityWithEntryStandingLevelEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryStandingLevelEntityId(list.get(0).getId());
                        } else {
                            EntryStandingLevelEntity entryStandingLevelEntity = new EntryStandingLevelEntity();
                            entryStandingLevelEntity.setValue(standingLevel.getValue());
                            entryStandingLevelEntity.setId(entryStandingLevelEntityDao.insert(entryStandingLevelEntity));
                            join.setEntryStandingLevelEntityId(entryStandingLevelEntity.getId());
                        }
                        joinEntryEntityWithEntryStandingLevelEntityDao.insert(join);
                    }
                }

                //enregistrer list chains
                if (current.getListChains() != null) {
                    for (Chain chain : current.getListChains()) {
                        List<EntryChainEntity> list = entryChainEntityDao.queryRaw("where value = ?", chain.getValue());
                        JoinEntryEntityWithEntryChainEntity join = new JoinEntryEntityWithEntryChainEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryChainEntityId(list.get(0).getId());
                        } else {
                            EntryChainEntity entryChainEntity = new EntryChainEntity();
                            entryChainEntity.setValue(chain.getValue());
                            entryChainEntity.setId(entryChainEntityDao.insert(entryChainEntity));
                            join.setEntryChainEntityId(entryChainEntity.getId());
                        }
                        joinEntryEntityWithEntryChainEntityDao.insert(join);
                    }
                }

                //enregistrer list services
                if (current.getListServices() != null) {
                    for (Service service : current.getListServices()) {
                        List<EntryServiceEntity> list = entryServiceEntityDao.queryRaw("where value = ?", service.getValue());
                        JoinEntryEntityWithEntryServiceEntity join = new JoinEntryEntityWithEntryServiceEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryServiceEntityId(list.get(0).getId());
                        } else {
                            EntryServiceEntity entryServiceEntity = new EntryServiceEntity();
                            entryServiceEntity.setValue(service.getValue());
                            entryServiceEntity.setId(entryServiceEntityDao.insert(entryServiceEntity));
                            join.setEntryServiceEntityId(entryServiceEntity.getId());
                        }
                        joinEntryEntityWithEntryServiceEntityDao.insert(join);
                    }
                }

                //enregistrer list options
                if (current.getListOptions() != null) {
                    for (Option option : current.getListOptions()) {
                        List<EntryOptionEntity> list = entryOptionEntityDao.queryRaw("where value = ?", option.getValue());
                        JoinEntryEntityWithEntryOptionEntity join = new JoinEntryEntityWithEntryOptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryOptionEntityId(list.get(0).getId());
                        } else {
                            EntryOptionEntity entryOptionEntity = new EntryOptionEntity();
                            entryOptionEntity.setValue(option.getValue());
                            entryOptionEntity.setId(entryOptionEntityDao.insert(entryOptionEntity));
                            join.setEntryOptionEntityId(entryOptionEntity.getId());
                        }
                        joinEntryEntityWithEntryOptionEntityDao.insert(join);
                    }
                }

                //enregistrer list disabled options
                if (current.getListDisabledOptions() != null) {
                    for (DisabledOption disabledOption : current.getListDisabledOptions()) {
                        List<EntryDisabledOptionEntity> list = entryDisabledOptionEntityDao.queryRaw("where value = ?", disabledOption.getValue());
                        JoinEntryEntityWithEntryDisabledOptionEntity join = new JoinEntryEntityWithEntryDisabledOptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryDisabledOptionEntityId(list.get(0).getId());
                        } else {
                            EntryDisabledOptionEntity entryDisabledOptionEntity = new EntryDisabledOptionEntity();
                            entryDisabledOptionEntity.setValue(disabledOption.getValue());
                            entryDisabledOptionEntity.setId(entryDisabledOptionEntityDao.insert(entryDisabledOptionEntity));
                            join.setEntryDisabledOptionEntityId(entryDisabledOptionEntity.getId());
                        }
                        joinEntryEntityWithEntryDisabledOptionEntityDao.insert(join);
                    }
                }

                //enregistrer list frp options
                if (current.getListFrpOptions() != null) {
                    for (FrpOption frpOption : current.getListFrpOptions()) {
                        List<EntryFrpOptionEntity> list = entryFrpOptionEntityDao.queryRaw("where value = ?", frpOption.getValue());
                        JoinEntryEntityWithEntryFrpOptionEntity join = new JoinEntryEntityWithEntryFrpOptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryFrpOptionEntityId(list.get(0).getId());
                        } else {
                            EntryFrpOptionEntity entryFrpOptionEntity = new EntryFrpOptionEntity();
                            entryFrpOptionEntity.setValue(frpOption.getValue());
                            entryFrpOptionEntity.setId(entryFrpOptionEntityDao.insert(entryFrpOptionEntity));
                            join.setEntryFrpOptionEntityId(entryFrpOptionEntity.getId());
                        }
                        joinEntryEntityWithEntryFrpOptionEntityDao.insert(join);
                    }
                }

                //enregistrer list poi options
                if (current.getListPoiOptions() != null) {
                    for (PoiOption poiOption : current.getListPoiOptions()) {
                        List<EntryPoiOptionEntity> list = entryPoiOptionEntityDao.queryRaw("where value = ?", poiOption.getValue());
                        JoinEntryEntityWithEntryPoiOptionEntity join = new JoinEntryEntityWithEntryPoiOptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryPoiOptionEntityId(list.get(0).getId());
                        } else {
                            EntryPoiOptionEntity entryPoiOptionEntity = new EntryPoiOptionEntity();
                            entryPoiOptionEntity.setValue(poiOption.getValue());
                            entryPoiOptionEntity.setId(entryPoiOptionEntityDao.insert(entryPoiOptionEntity));
                            join.setEntryPoiOptionEntityId(entryPoiOptionEntity.getId());
                        }
                        joinEntryEntityWithEntryPoiOptionEntityDao.insert(join);
                    }
                }

                //enregistrer list publications
                if (current.getListPublications() != null) {
                    for (Publication publication : current.getListPublications()) {
                        List<EntryPublicationEntity> list = entryPublicationEntityDao.queryRaw("where value = ?", publication.getValue());
                        JoinEntryEntityWithEntryPublicationEntity join = new JoinEntryEntityWithEntryPublicationEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryPublicationEntityId(list.get(0).getId());
                        } else {
                            EntryPublicationEntity entryPublicationEntity = new EntryPublicationEntity();
                            entryPublicationEntity.setValue(publication.getValue());
                            entryPublicationEntity.setId(entryPublicationEntityDao.insert(entryPublicationEntity));
                            join.setEntryPublicationEntityId(entryPublicationEntity.getId());
                        }
                        joinEntryEntityWithEntryPublicationEntityDao.insert(join);
                    }
                }

                //enregistrer list common tags
                if (current.getListCommonTags() != null) {
                    for (CommonTag commonTag : current.getListCommonTags()) {
                        List<EntryCommonTagEntity> list = entryCommonTagEntityDao.queryRaw("where value = ?", commonTag.getValue());
                        JoinEntryEntityWithEntryCommonTagEntity join = new JoinEntryEntityWithEntryCommonTagEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryCommonTagEntityId(list.get(0).getId());
                        } else {
                            EntryCommonTagEntity entryCommonTagEntity = new EntryCommonTagEntity();
                            entryCommonTagEntity.setValue(commonTag.getValue());
                            entryCommonTagEntity.setId(entryCommonTagEntityDao.insert(entryCommonTagEntity));
                            join.setEntryCommonTagEntityId(entryCommonTagEntity.getId());
                        }
                        joinEntryEntityWithEntryCommonTagEntityDao.insert(join);
                    }
                }

                //enregistrer list sectors
                if (current.getListSectors() != null) {
                    for (Sector sector : current.getListSectors()) {
                        List<EntrySectorEntity> list = entrySectorEntityDao.queryRaw("where value = ?", sector.getValue());
                        JoinEntryEntityWithEntrySectorEntity join = new JoinEntryEntityWithEntrySectorEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntrySectorEntityId(list.get(0).getId());
                        } else {
                            EntrySectorEntity entrySectorEntity = new EntrySectorEntity();
                            entrySectorEntity.setValue(sector.getValue());
                            entrySectorEntity.setId(entrySectorEntityDao.insert(entrySectorEntity));
                            join.setEntrySectorEntityId(entrySectorEntity.getId());
                        }
                        joinEntryEntityWithEntrySectorEntityDao.insert(join);
                    }
                }

                //enregistrer list descriptions
                if (current.getListDescriptions() != null) {
                    for (Description description : current.getListDescriptions()) {
                        List<EntryDescriptionEntity> list = entryDescriptionEntityDao.queryRaw("where value = ?", description.getValue());
                        JoinEntryEntityWithEntryDescriptionEntity join = new JoinEntryEntityWithEntryDescriptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryDescriptionEntityId(list.get(0).getId());
                        } else {
                            EntryDescriptionEntity entryDescriptionEntity = new EntryDescriptionEntity();
                            entryDescriptionEntity.setValue(description.getValue());
                            entryDescriptionEntity.setId(entryDescriptionEntityDao.insert(entryDescriptionEntity));
                            join.setEntryDescriptionEntityId(entryDescriptionEntity.getId());
                        }
                        joinEntryEntityWithEntryDescriptionEntityDao.insert(join);
                    }
                }

                //enregistrer list images
                if (current.getListImages() != null) {
                    for (Image image : current.getListImages()) {
                        List<EntryImageEntity> list = entryImageEntityDao.queryRaw("where url = ?", image.getUrl());
                        JoinEntryEntityWithEntryImageEntity join = new JoinEntryEntityWithEntryImageEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryImageEntityId(list.get(0).getId());
                        } else {
                            EntryImageEntity entryImageEntity = new EntryImageEntity();
                            entryImageEntity.setUrl(image.getUrl());
                            entryImageEntity.setId(entryImageEntityDao.insert(entryImageEntity));
                            join.setEntryImageEntityId(entryImageEntity.getId());
                        }
                        joinEntryEntityWithEntryImageEntityDao.insert(join);
                    }
                }

                //enregistrer list contacts
                if (current.getListTariffs() != null) {
                    for (Tariff tariff : current.getListTariffs()) {
                        List<EntryTariffEntity> list = entryTariffEntityDao.queryRaw("where name = ? and unique = ? and min = ?" +
                                        "and max = ? and average = ? and fixed = ?", tariff.getName(),
                                "" + tariff.getUnique(), "" + tariff.getMin(), "" + tariff.getMax(), "" + tariff.getAverage(),
                                "" + tariff.getFixed());
                        JoinEntryEntityWithEntryTariffEntity join = new JoinEntryEntityWithEntryTariffEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryTariffEntityId(list.get(0).getId());
                        } else {
                            EntryTariffEntity entryTariffEntity = new EntryTariffEntity();
                            entryTariffEntity.setName(tariff.getName());
                            entryTariffEntity.setUnique(tariff.getUnique());
                            entryTariffEntity.setMin(tariff.getMin());
                            entryTariffEntity.setMax(tariff.getMax());
                            entryTariffEntity.setAverage(tariff.getAverage());
                            entryTariffEntity.setFixed(tariff.getFixed());
                            entryTariffEntity.setId(entryTariffEntityDao.insert(entryTariffEntity));
                            join.setEntryTariffEntityId(entryTariffEntity.getId());
                        }
                        joinEntryEntityWithEntryTariffEntityDao.insert(join);
                    }
                }

                //enregistrer list closures
                if (current.getListClosures() != null) {
                    for (Closure closure : current.getListClosures()) {
                        List<EntryClosureEntity> list = entryClosureEntityDao.queryRaw("where closure_day = ? and closure_span = ?"
                                , closure.getClosureDay(),
                                "" + closure.getClosureSpan());
                        JoinEntryEntityWithEntryClosureEntity join = new JoinEntryEntityWithEntryClosureEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryClosureEntityId(list.get(0).getId());
                        } else {
                            EntryClosureEntity entryClosureEntity = new EntryClosureEntity();
                            entryClosureEntity.setClosureDay(closure.getClosureDay());
                            entryClosureEntity.setClosureSpan(closure.getClosureSpan());
                            entryClosureEntity.setId(entryClosureEntityDao.insert(entryClosureEntity));
                            join.setEntryClosureEntityId(entryClosureEntity.getId());
                        }
                        joinEntryEntityWithEntryClosureEntityDao.insert(join);
                    }
                }

                //enregistrer list spaces
                if (current.getListSpaces() != null) {
                    for (Space space : current.getListSpaces()) {
                        List<EntrySpaceEntity> list = entrySpaceEntityDao.queryRaw("where name = ? and capacity_theater = ? and capacity_classroom = ?" +
                                        "and capacity_u = ? and capacity_cocktail = ? and capacity_seatedmeal = ?" +
                                        "and ceiling_height = ? and is_natural_light=?", space.getName(),
                                "" + space.getCapacityTheater(), "" + space.getCapacityClassroom(), "" + space.getCapacityU(), "" + space.getCapacityCocktail(),
                                "" + space.getCapacitySeatedmeal(), "" + space.getCeilingHeight(), "" + space.getIsNaturalLight());
                        JoinEntryEntityWithEntrySpaceEntity join = new JoinEntryEntityWithEntrySpaceEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntrySpaceEntityId(list.get(0).getId());
                        } else {
                            EntrySpaceEntity entrySpaceEntity = new EntrySpaceEntity();
                            entrySpaceEntity.setName(space.getName());
                            entrySpaceEntity.setCapacityTheater(space.getCapacityTheater());
                            entrySpaceEntity.setCapacityClassroom(space.getCapacityClassroom());
                            entrySpaceEntity.setCapacityU(space.getCapacityU());
                            entrySpaceEntity.setCapacityCocktail(space.getCapacityCocktail());
                            entrySpaceEntity.setCapacitySeatedmeal(space.getCapacitySeatedmeal());
                            entrySpaceEntity.setCeilingHeight(space.getCeilingHeight());
                            entrySpaceEntity.setIsNaturalLight(space.getIsNaturalLight());
                            entrySpaceEntity.setId(entrySpaceEntityDao.insert(entrySpaceEntity));
                            join.setEntrySpaceEntityId(entrySpaceEntity.getId());
                        }
                        joinEntryEntityWithEntrySpaceEntityDao.insert(join);
                    }
                }

                //enregistrer list closings
                if (current.getListClosings() != null) {
                    for (Closing closing : current.getListClosings()) {
                        List<EntryClosingEntity> list = entryClosingEntityDao.queryRaw("where value = ?", closing.getValue());
                        JoinEntryEntityWithEntryClosingEntity join = new JoinEntryEntityWithEntryClosingEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryClosingEntityId(list.get(0).getId());
                        } else {
                            EntryClosingEntity entryClosingEntity = new EntryClosingEntity();
                            entryClosingEntity.setValue(closing.getValue());
                            entryClosingEntity.setId(entryClosingEntityDao.insert(entryClosingEntity));
                            join.setEntryClosingEntityId(entryClosingEntity.getId());
                        }
                        joinEntryEntityWithEntryClosingEntityDao.insert(join);
                    }
                }

                //enregistrer list groupOptions
                if (current.getListGroupOptions() != null) {
                    for (GroupOption groupOption : current.getListGroupOptions()) {
                        List<EntryGroupOptionEntity> list = entryGroupOptionEntityDao.queryRaw("where value = ?", groupOption.getValue());
                        JoinEntryEntityWithEntryGroupOptionEntity join = new JoinEntryEntityWithEntryGroupOptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryGroupOptionEntityId(list.get(0).getId());
                        } else {
                            EntryGroupOptionEntity entryGroupOptionEntity = new EntryGroupOptionEntity();
                            entryGroupOptionEntity.setValue(groupOption.getValue());
                            entryGroupOptionEntity.setId(entryGroupOptionEntityDao.insert(entryGroupOptionEntity));
                            join.setEntryGroupOptionEntityId(entryGroupOptionEntity.getId());
                        }
                        joinEntryEntityWithEntryGroupOptionEntityDao.insert(join);
                    }
                }

                //enregistrer list familyOptions
                if (current.getListFamilyOptions() != null) {
                    for (FamilyOption familyOption : current.getListFamilyOptions()) {
                        List<EntryFamilyOptionEntity> list = entryFamilyOptionEntityDao.queryRaw("where value = ?", familyOption.getValue());
                        JoinEntryEntityWithEntryFamilyOptionEntity join = new JoinEntryEntityWithEntryFamilyOptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryFamilyOptionEntityId(list.get(0).getId());
                        } else {
                            EntryFamilyOptionEntity entryFamilyOptionEntity = new EntryFamilyOptionEntity();
                            entryFamilyOptionEntity.setValue(familyOption.getValue());
                            entryFamilyOptionEntity.setId(entryFamilyOptionEntityDao.insert(entryFamilyOptionEntity));
                            join.setEntryFamilyOptionEntityId(entryFamilyOptionEntity.getId());
                        }
                        joinEntryEntityWithEntryFamilyOptionEntityDao.insert(join);
                    }
                }

                //enregistrer list openings
                if (current.getListOpenings() != null) {
                    for (Opening opening : current.getListOpenings()) {
                        List<EntryOpeningEntity> list = entryOpeningEntityDao.queryRaw("where opening_start = ? and opening_end = ? and opening_replay = ?",
                                opening.getOpeningStart(),
                                "" + opening.getOpeningEnd(),
                                "" + opening.getOpeningReplay());
                        JoinEntryEntityWithEntryOpeningEntity join = new JoinEntryEntityWithEntryOpeningEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryOpeningEntityId(list.get(0).getId());
                        } else {
                            EntryOpeningEntity entryOpeningEntity = new EntryOpeningEntity();
                            entryOpeningEntity.setOpeningStart(opening.getOpeningStart());
                            entryOpeningEntity.setOpeningEnd(opening.getOpeningEnd());
                            entryOpeningEntity.setOpeningReplay(opening.getOpeningReplay());
                            entryOpeningEntity.setId(entryOpeningEntityDao.insert(entryOpeningEntity));
                            join.setEntryOpeningEntityId(entryOpeningEntity.getId());
                        }
                        joinEntryEntityWithEntryOpeningEntityDao.insert(join);

                        //enregistrer list grids
                        for (Grid grid : opening.getListGrids()) {
                            List<EntryGridEntity> list2 = entryGridEntityDao.queryRaw("where opening_days = ? and opening_hours = ?",
                                    grid.getOpeningDays(),
                                    "" + grid.getOpeningHours());
                            JoinEntryOpeningEntityWithEntryGridEntity join2 = new JoinEntryOpeningEntityWithEntryGridEntity();
                            join2.setEntryOpeningEntityId(entryToSave.getId());
                            if (list.size() > 0) {
                                join2.setEntryGridEntityId(list.get(0).getId());
                            } else {
                                EntryGridEntity entryGridEntity = new EntryGridEntity();
                                entryGridEntity.setOpeningDays(grid.getOpeningDays());
                                entryGridEntity.setOpeningHours(grid.getOpeningHours());
                                entryGridEntity.setId(entryGridEntityDao.insert(entryGridEntity));
                                join2.setEntryGridEntityId(entryGridEntity.getId());
                            }
                            joinEntryOpeningEntityWithEntryGridEntityDao.insert(join2);
                        }

                    }
                }

                //entryEntityDao.insert(entryToSave);
                listEntryEntities.add(entryToSave);
                Log.e("TAG", "Ajout : " + entryToSave.getNameFr());
            } else {
                listEntryEntities.add(listEntriesFound.get(0));
                Log.e("TAG", "Recup : " + listEntriesFound.get(0).getNameFr());
            }
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