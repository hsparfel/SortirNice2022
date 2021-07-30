package com.pouillcorp.sortirnice.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryFurnishedRentalEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryGridEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryOpeningEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryRentalMonthEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntrySleepingEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryStandingLevelEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryStationEntity;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.modelentries.Address;
import com.pouillcorp.sortirnice.modelentries.Affiliation;
import com.pouillcorp.sortirnice.modelentries.AllianceOption;
import com.pouillcorp.sortirnice.modelentries.Amenity;
import com.pouillcorp.sortirnice.modelentries.Animation;
import com.pouillcorp.sortirnice.modelentries.Atmospher;
import com.pouillcorp.sortirnice.modelentries.Category;
import com.pouillcorp.sortirnice.modelentries.Chain;
import com.pouillcorp.sortirnice.modelentries.Closing;
import com.pouillcorp.sortirnice.modelentries.Closure;
import com.pouillcorp.sortirnice.modelentries.Closures;
import com.pouillcorp.sortirnice.modelentries.Commercia;
import com.pouillcorp.sortirnice.modelentries.CommonTag;
import com.pouillcorp.sortirnice.modelentries.DetailEntrySimple;
import com.pouillcorp.sortirnice.modelentries.DisabledOption;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.modelentries.FamilyOption;
import com.pouillcorp.sortirnice.modelentries.FrpOption;
import com.pouillcorp.sortirnice.modelentries.FurnishedRental;
import com.pouillcorp.sortirnice.modelentries.Grid;
import com.pouillcorp.sortirnice.modelentries.GroupOption;
import com.pouillcorp.sortirnice.modelentries.Label;
import com.pouillcorp.sortirnice.modelentries.Location;
import com.pouillcorp.sortirnice.modelentries.Opening;
import com.pouillcorp.sortirnice.modelentries.Option;
import com.pouillcorp.sortirnice.modelentries.Payment;
import com.pouillcorp.sortirnice.modelentries.PoiOption;
import com.pouillcorp.sortirnice.modelentries.Profile;
import com.pouillcorp.sortirnice.modelentries.Publication;
import com.pouillcorp.sortirnice.modelentries.RentalMonth;
import com.pouillcorp.sortirnice.modelentries.Sector;
import com.pouillcorp.sortirnice.modelentries.Service;
import com.pouillcorp.sortirnice.modelentries.Sleeping;
import com.pouillcorp.sortirnice.modelentries.StandingLevel;
import com.pouillcorp.sortirnice.modelentries.Station;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.utils.DateUtils;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Retrofit;

public class NavDrawerEntryActivity extends NavDrawerActivity implements RecyclerAdapterEntries.Listener {


    protected static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    protected String myUrl = BASE_URL;
    protected static Retrofit retrofit = null;
    protected final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    protected int nbEntries;
    protected List<Entry> listEntries;
    protected List<EntryEntity> listEntryEntities = new ArrayList<>();

    @Nullable
    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    @Nullable
    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;

    protected String dateDemandeString;
    protected String dateVeilleString;
    protected Date dateDemande;
    protected Date dateVeille;

    protected boolean isResponded = false;

    @Nullable
    @BindView(R.id.image)
    ImageView image;
    @Nullable
    @BindView(R.id.name_fr)
    TextView nameFr;
    @Nullable
    @BindView(R.id.description)
    TextView description;
    @Nullable
    @BindView(R.id.category)
    TextView category;
    @Nullable
    @BindView(R.id.address_line1)
    TextView addressLine1;
    @Nullable
    @BindView(R.id.address_line2)
    TextView addressLine2;
    @Nullable
    @BindView(R.id.address_line3)
    TextView addressLine3;
    @Nullable
    @BindView(R.id.address_zip)
    TextView addressZip;
    @Nullable
    @BindView(R.id.address_city)
    TextView addressCity;
    @Nullable
    @BindView(R.id.phone)
    TextView phone;
    @Nullable
    @BindView(R.id.fax)
    TextView fax;
    @Nullable
    @BindView(R.id.email)
    TextView email;
    @Nullable
    @BindView(R.id.website)
    TextView website;
    @Nullable
    @BindView(R.id.facebook)
    TextView facebook;
    @Nullable
    @BindView(R.id.twitter)
    TextView twitter;
    @Nullable
    @BindView(R.id.station)
    TextView station;
    @Nullable
    @BindView(R.id.option)
    TextView option;
    @Nullable
    @BindView(R.id.payment)
    TextView payment;
    @Nullable
    @BindView(R.id.amenity)
    TextView amenity;
    @Nullable
    @BindView(R.id.location)
    TextView location;
    @Nullable
    @BindView(R.id.closure)
    TextView closure;
    @Nullable
    @BindView(R.id.label)
    TextView label;
    @Nullable
    @BindView(R.id.service)
    TextView service;
    @Nullable
    @BindView(R.id.opening)
    TextView opening;
    @Nullable
    @BindView(R.id.closing)
    TextView closing;
    @Nullable
    @BindView(R.id.openings)
    TextView openings;
    @Nullable
    @BindView(R.id.closings)
    TextView closings;
    @Nullable
    @BindView(R.id.animation)
    TextView animation;
    @Nullable
    @BindView(R.id.atmosphere)
    TextView atmosphere;
    @Nullable
    @BindView(R.id.capacity_total)
    TextView capacityTotal;
    @Nullable
    @BindView(R.id.capacity_interieur)
    TextView capacityInterieur;
    @Nullable
    @BindView(R.id.capacity_exterieur)
    TextView capacityExterieur;
    @Nullable
    @BindView(R.id.capacity_assis)
    TextView capacityAssis;
    @Nullable
    @BindView(R.id.capacity_debout)
    TextView capacityDebout;
    @Nullable
    @BindView(R.id.capacity_group)
    TextView capacityGroup;
    @Nullable
    @BindView(R.id.capacity_salle)
    TextView capacitySalle;
    @Nullable
    @BindView(R.id.layout_address)
    LinearLayout layoutAddress;
    @Nullable
    @BindView(R.id.boutons_map_waze)
    LinearLayout boutonsMapWaze;
    @Nullable
    @BindView(R.id.ouvert)
    LinearLayout ouvert;
    @Nullable
    @BindView(R.id.ferme)
    LinearLayout ferme;
    @Nullable
    @BindView(R.id.layout_payment)
    LinearLayout layoutPayment;
    @Nullable
    @BindView(R.id.layout_label)
    LinearLayout layoutLabel;
    @Nullable
    @BindView(R.id.layout_animation)
    LinearLayout layoutAnimation;
    @Nullable
    @BindView(R.id.layout_station)
    LinearLayout layoutStation;
    @Nullable
    @BindView(R.id.layout_pratique)
    LinearLayout layoutPratique;
    @Nullable
    @BindView(R.id.layout_standing)
    LinearLayout layoutStanding;
    @Nullable
    @BindView(R.id.standing)
    TextView standing;
    @Nullable
    @BindView(R.id.layout_meuble)
    LinearLayout layoutMeuble;
    @Nullable
    @BindView(R.id.meuble)
    TextView meuble;
    @Nullable
    @BindView(R.id.layout_periode)
    LinearLayout layoutPeriode;
    @Nullable
    @BindView(R.id.periode)
    TextView periode;
    @Nullable
    @BindView(R.id.couchage)
    TextView couchage;
    @Nullable
    @BindView(R.id.room_count)
    TextView roomCount;
    @Nullable
    @BindView(R.id.room_bath_count)
    TextView roomBathCount;
    @Nullable
    @BindView(R.id.room_shower_count)
    TextView roomShowerCount;
    @Nullable
    @BindView(R.id.suite_count)
    TextView suiteCount;
    @Nullable
    @BindView(R.id.studio_count)
    TextView studioCount;
    @Nullable
    @BindView(R.id.apartment_count)
    TextView apartmentCount;
    @Nullable
    @BindView(R.id.room_accessible_count)
    TextView roomAccessibleCount;
    @Nullable
    @BindView(R.id.single_count)
    TextView singleCount;
    @Nullable
    @BindView(R.id.double_count)
    TextView doubleCount;
    @Nullable
    @BindView(R.id.triple_count)
    TextView tripleCount;
    @Nullable
    @BindView(R.id.twins_count)
    TextView twinsCount;
    @Nullable
    @BindView(R.id.family_count)
    TextView familyCount;
    @Nullable
    @BindView(R.id.area)
    TextView area;
    @Nullable
    @BindView(R.id.type)
    TextView type;
    @Nullable
    @BindView(R.id.floor)
    TextView floor;
    @Nullable
    @BindView(R.id.bedroom_count)
    TextView bedroomCount;
    @Nullable
    @BindView(R.id.sleeps_count)
    TextView sleepsCount;
    @Nullable
    @BindView(R.id.furnished_room_count)
    TextView furnishedRoomCount;

    Bitmap bitmap = null;
    String newLine = System.getProperty("line.separator");

    Entry selectedEntry = new Entry();
    EntryEntity entryTransmis = new EntryEntity();
    @Nullable
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @Nullable
    @BindView(R.id.fabExit)
    FloatingActionButton fabExit;
    @Nullable
    @BindView(R.id.fabSave)
    FloatingActionButton fabSave;

    List<Amenity> listFiltresAmenity = new ArrayList<>();
    List<Animation> listFiltresAnimation = new ArrayList<>();
    List<Atmospher> listFiltresAtmospher = new ArrayList<>();
    List<Category> listFiltresCategory = new ArrayList<>();
    List<Chain> listFiltresChain = new ArrayList<>();
    List<FamilyOption> listFiltresFamilyOption = new ArrayList<>();
    List<FurnishedRental> listFiltresFurnishedRental = new ArrayList<>();
    List<Address> listFiltresCity = new ArrayList<>();
    List<GroupOption> listFiltresGroupOption = new ArrayList<>();
    List<Label> listFiltresLabel = new ArrayList<>();


    List<Location> listFiltresLocation = new ArrayList<>();
    List<RentalMonth> listFiltresRentalMonth = new ArrayList<>();

    List<Service> listFiltresService = new ArrayList<>();
    List<Sleeping> listFiltresSleeping = new ArrayList<>();
    List<StandingLevel> listFiltresStandingLevel = new ArrayList<>();
    List<Station> listFiltresStation = new ArrayList<>();

    @Nullable
    @BindView(R.id.scrollView_filtre)
    ScrollView scrollViewFiltre;

    @Nullable
    @BindView(R.id.linearLayoutAmenities)
    LinearLayout linearLayoutAmenities;
    @Nullable
    @BindView(R.id.checkboxFiltreAmenities)
    MaterialCheckBox checkboxFiltreAmenities;

    @Nullable
    @BindView(R.id.linearLayoutAnimations)
    LinearLayout linearLayoutAnimations;
    @Nullable
    @BindView(R.id.checkboxFiltreAnimations)
    MaterialCheckBox checkboxFiltreAnimations;

    @Nullable
    @BindView(R.id.linearLayoutAtmosphere)
    LinearLayout linearLayoutAtmosphere;
    @Nullable
    @BindView(R.id.checkboxFiltreAtmosphere)
    MaterialCheckBox checkboxFiltreAtmosphere;

    @Nullable
    @BindView(R.id.linearLayoutCategory)
    LinearLayout linearLayoutCategory;
    @Nullable
    @BindView(R.id.checkboxFiltreCategory)
    MaterialCheckBox checkboxFiltreCategory;

    @Nullable
    @BindView(R.id.linearLayoutChains)
    LinearLayout linearLayoutChains;
    @Nullable
    @BindView(R.id.checkboxFiltreChains)
    MaterialCheckBox checkboxFiltreChains;

    @Nullable
    @BindView(R.id.linearLayoutCity)
    LinearLayout linearLayoutCity;
    @Nullable
    @BindView(R.id.checkboxFiltreCity)
    MaterialCheckBox checkboxFiltreCity;

    @Nullable
    @BindView(R.id.linearLayoutFamilyOptions)
    LinearLayout linearLayoutFamilyOptions;
    @Nullable
    @BindView(R.id.checkboxFiltreFamilyOptions)
    MaterialCheckBox checkboxFiltreFamilyOptions;



    @Nullable
    @BindView(R.id.linearLayoutFurnishedRentals)
    LinearLayout linearLayoutFurnishedRentals;
    @Nullable
    @BindView(R.id.checkboxFiltreFurnishedRentals)
    MaterialCheckBox checkboxFiltreFurnishedRentals;

    @Nullable
    @BindView(R.id.linearLayoutGroupOptions)
    LinearLayout linearLayoutGroupOptions;
    @Nullable
    @BindView(R.id.checkboxFiltreGroupOptions)
    MaterialCheckBox checkboxFiltreGroupOptions;

    @Nullable
    @BindView(R.id.linearLayoutLabels)
    LinearLayout linearLayoutLabels;
    @Nullable
    @BindView(R.id.checkboxFiltreLabels)
    MaterialCheckBox checkboxFiltreLabels;

    @Nullable
    @BindView(R.id.linearLayoutLocations)
    LinearLayout linearLayoutLocations;
    @Nullable
    @BindView(R.id.checkboxFiltreLocations)
    MaterialCheckBox checkboxFiltreLocations;



    @Nullable
    @BindView(R.id.linearLayoutRentalMonthes)
    LinearLayout linearLayoutRentalMonthes;
    @Nullable
    @BindView(R.id.checkboxFiltreRentalMonthes)
    MaterialCheckBox checkboxFiltreRentalMonthes;



    @Nullable
    @BindView(R.id.linearLayoutServices)
    LinearLayout linearLayoutServices;
    @Nullable
    @BindView(R.id.checkboxFiltreServices)
    MaterialCheckBox checkboxFiltreServices;

    @Nullable
    @BindView(R.id.linearLayoutSleepings)
    LinearLayout linearLayoutSleepings;
    @Nullable
    @BindView(R.id.checkboxFiltreSleepings)
    MaterialCheckBox checkboxFiltreSleepings;

    @Nullable
    @BindView(R.id.linearLayoutStandingLevels)
    LinearLayout linearLayoutStandingLevels;
    @Nullable
    @BindView(R.id.checkboxFiltreStandingLevels)
    MaterialCheckBox checkboxFiltreStandingLevels;

    @Nullable
    @BindView(R.id.linearLayoutStations)
    LinearLayout linearLayoutStations;
    @Nullable
    @BindView(R.id.checkboxFiltreStations)
    MaterialCheckBox checkboxFiltreStations;

    @Nullable
    @BindView(R.id.checkboxFiltreAmenitiesSelectAll)
    MaterialCheckBox checkboxFiltreAmenitiesSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreAnimationsSelectAll)
    MaterialCheckBox checkboxFiltreAnimationsSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreAtmosphereSelectAll)
    MaterialCheckBox checkboxFiltreAtmosphereSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreCategorySelectAll)
    MaterialCheckBox checkboxFiltreCategorySelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreChainsSelectAll)
    MaterialCheckBox checkboxFiltreChainsSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreCitySelectAll)
    MaterialCheckBox checkboxFiltreCitySelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreFamilyOptionsSelectAll)
    MaterialCheckBox checkboxFiltreFamilyOptionsSelectAll;

    @Nullable
    @BindView(R.id.checkboxFiltreFurnishedRentalsSelectAll)
    MaterialCheckBox checkboxFiltreFurnishedRentalsSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreGroupOptionsSelectAll)
    MaterialCheckBox checkboxFiltreGroupOptionsSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreLabelsSelectAll)
    MaterialCheckBox checkboxFiltreLabelsSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreLocationsSelectAll)
    MaterialCheckBox checkboxFiltreLocationsSelectAll;


    @Nullable
    @BindView(R.id.checkboxFiltreRentalMonthesSelectAll)
    MaterialCheckBox checkboxFiltreRentalMonthesSelectAll;

    @Nullable
    @BindView(R.id.checkboxFiltreServicesSelectAll)
    MaterialCheckBox checkboxFiltreServicesSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreSleepingsSelectAll)
    MaterialCheckBox checkboxFiltreSleepingsSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreStandingLevelsSelectAll)
    MaterialCheckBox checkboxFiltreStandingLevelsSelectAll;
    @Nullable
    @BindView(R.id.checkboxFiltreStationsSelectAll)
    MaterialCheckBox checkboxFiltreStationsSelectAll;

    List<MaterialCheckBox> listCheckboxAmenity = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxAnimation = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxAtmospher = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxCategory = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxChain = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxFamilyOption = new ArrayList<>();

    List<MaterialCheckBox> listCheckboxFurnishedRental = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxGroupOption = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxLabel = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxLocation = new ArrayList<>();


    List<MaterialCheckBox> listCheckboxRentalMonth = new ArrayList<>();

    List<MaterialCheckBox> listCheckboxSleeping = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxStandingLevels = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxStation = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxService = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxCity = new ArrayList<>();

    private RecyclerAdapterEntries adapterEntries;

    @Nullable
    @BindView(R.id.fabFiltre)
    FloatingActionButton fabFiltre;

    @Nullable
    @BindView(R.id.fabRazFiltre)
    FloatingActionButton fabRazFiltre;

    protected EntriesType entryType;

    MenuItem item;

    protected static final String TAG = NavDrawerEntryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listEntries = new ArrayList<>();
        nbEntries = 0;
        dateDemande = new Date();
        dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
        myUrl += dateDemandeString+"/";


    }



    protected void afficherFiltreNonVide() {

        if (listFiltresAmenity.size()>0) {
            checkboxFiltreAmenities.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreAmenities.setVisibility(View.GONE);
        }

        if (listFiltresAnimation.size()>0) {
            checkboxFiltreAnimations.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreAnimations.setVisibility(View.GONE);
        }
        if (listFiltresAtmospher.size()>0) {
            checkboxFiltreAtmosphere.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreAtmosphere.setVisibility(View.GONE);
        }

        if (listFiltresCategory.size()>0) {
            checkboxFiltreCategory.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreCategory.setVisibility(View.GONE);
        }

        if (listFiltresChain.size()>0) {
            checkboxFiltreChains.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreChains.setVisibility(View.GONE);
        }

        if (listFiltresCity.size()>0) {
            checkboxFiltreCity.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreCity.setVisibility(View.GONE);
        }

        if (listFiltresFamilyOption.size()>0) {
            checkboxFiltreFamilyOptions.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreFamilyOptions.setVisibility(View.GONE);
        }



        if (listFiltresFurnishedRental.size()>0) {
            checkboxFiltreFurnishedRentals.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreFurnishedRentals.setVisibility(View.GONE);
        }

        if (listFiltresGroupOption.size()>0) {
            checkboxFiltreGroupOptions.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreGroupOptions.setVisibility(View.GONE);
        }

        if (listFiltresLabel.size()>0) {
            checkboxFiltreLabels.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreLabels.setVisibility(View.GONE);
        }

        if (listFiltresLocation.size()>0) {
            checkboxFiltreLocations.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreLocations.setVisibility(View.GONE);
        }





        if (listFiltresRentalMonth.size()>0) {
            checkboxFiltreRentalMonthes.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreRentalMonthes.setVisibility(View.GONE);
        }



        if (listFiltresService.size()>0) {
            checkboxFiltreServices.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreServices.setVisibility(View.GONE);
        }

        if (listFiltresSleeping.size()>0) {
            checkboxFiltreSleepings.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreSleepings.setVisibility(View.GONE);
        }

        if (listFiltresStandingLevel.size()>0) {
            checkboxFiltreStandingLevels.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreStandingLevels.setVisibility(View.GONE);
        }

        if (listFiltresStation.size()>0) {
            checkboxFiltreStations.setVisibility(View.VISIBLE);
        } else {
            checkboxFiltreStations.setVisibility(View.GONE);
        }

    }

    protected void initCheckboxTitreClick(MaterialCheckBox cb, MaterialCheckBox cb2, LinearLayout ll){
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cb.setChecked(true);
                    cb2.setVisibility(View.VISIBLE);
                    ll.setVisibility(View.VISIBLE);
                } else {
                    cb.setChecked(false);
                    cb2.setVisibility(View.GONE);
                    ll.setVisibility(View.GONE);
                }
            }
        });
    }

    protected void initCheckboxesTitreClick(){
        initCheckboxTitreClick(checkboxFiltreAtmosphere,checkboxFiltreAtmosphereSelectAll,linearLayoutAtmosphere);
        initCheckboxTitreClick(checkboxFiltreAmenities,checkboxFiltreAmenitiesSelectAll,linearLayoutAmenities);
        initCheckboxTitreClick(checkboxFiltreAnimations,checkboxFiltreAnimationsSelectAll,linearLayoutAnimations);
        initCheckboxTitreClick(checkboxFiltreCategory,checkboxFiltreCategorySelectAll,linearLayoutCategory);
        initCheckboxTitreClick(checkboxFiltreChains,checkboxFiltreChainsSelectAll,linearLayoutChains);
        initCheckboxTitreClick(checkboxFiltreCity,checkboxFiltreCitySelectAll,linearLayoutCity);
        initCheckboxTitreClick(checkboxFiltreFurnishedRentals,checkboxFiltreFurnishedRentalsSelectAll,linearLayoutFurnishedRentals);
        initCheckboxTitreClick(checkboxFiltreFamilyOptions,checkboxFiltreFamilyOptionsSelectAll,linearLayoutFamilyOptions);

        initCheckboxTitreClick(checkboxFiltreGroupOptions,checkboxFiltreGroupOptionsSelectAll,linearLayoutGroupOptions);
        initCheckboxTitreClick(checkboxFiltreLocations,checkboxFiltreLocationsSelectAll,linearLayoutLocations);
        initCheckboxTitreClick(checkboxFiltreLabels,checkboxFiltreLabelsSelectAll,linearLayoutLabels);
        initCheckboxTitreClick(checkboxFiltreRentalMonthes,checkboxFiltreRentalMonthesSelectAll,linearLayoutRentalMonthes);
        initCheckboxTitreClick(checkboxFiltreStations,checkboxFiltreStationsSelectAll,linearLayoutStations);
        initCheckboxTitreClick(checkboxFiltreStandingLevels,checkboxFiltreStandingLevelsSelectAll,linearLayoutStandingLevels);
        initCheckboxTitreClick(checkboxFiltreSleepings,checkboxFiltreSleepingsSelectAll,linearLayoutSleepings);
        initCheckboxTitreClick(checkboxFiltreServices,checkboxFiltreServicesSelectAll,linearLayoutServices);

    }

    private boolean verifFiltreActif(List<? extends DetailEntrySimple> list){
        boolean bool = false;
        for (DetailEntrySimple current : list){
            if(current.isChecked()){
                bool = true;
            }
        }
        return bool;
    }

    @OnClick(R.id.fabFiltre)
    public void fabFiltreClick() {
        scrollViewFiltre.setVisibility(View.GONE);
        fabFiltre.setVisibility(View.GONE);
        fabRazFiltre.setVisibility(View.GONE);
        item = menuItems.findItem(R.id.menu_activity_main_filter);
        item.setVisible(true);


        //menu_activity_main_filter.setVisible(true);
        //Set<Entry> setEntryFiltre = new HashSet<>();
        //List<Entry> listEntryFiltre = new ArrayList<>();
        List<Entry> listEntryFiltre = new ArrayList<>();
        listEntryFiltre.addAll(listEntries);

        boolean boolAmenity = verifFiltreActif(listFiltresAmenity);
        boolean boolAnimation = verifFiltreActif(listFiltresAnimation);
        boolean boolAtmospher = verifFiltreActif(listFiltresAtmospher);
        boolean boolCategory = verifFiltreActif(listFiltresCategory);
        boolean boolChain = verifFiltreActif(listFiltresChain);
        boolean boolFamilyOption = verifFiltreActif(listFiltresFamilyOption);

        boolean boolFurnishedRental = verifFiltreActif(listFiltresFurnishedRental);
        boolean boolGroupOption = verifFiltreActif(listFiltresGroupOption);
        boolean boolLabel = verifFiltreActif(listFiltresLabel);
        boolean boolLocation = verifFiltreActif(listFiltresLocation);

        boolean boolRentalMonth = verifFiltreActif(listFiltresRentalMonth);

        boolean boolService = verifFiltreActif(listFiltresService);
        boolean boolSleeping = verifFiltreActif(listFiltresSleeping);
        boolean boolStandingLevel = verifFiltreActif(listFiltresStandingLevel);
        boolean boolStation = verifFiltreActif(listFiltresStation);

        boolean boolCity = false;
        for (Address filtre : listFiltresCity) {
            if (filtre.isChecked()) {
                boolCity = true;
            }
        }


        for (Entry current : listEntries) {

            if (boolAmenity && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Amenity filtre : listFiltresAmenity) {
                    if (filtre.isChecked() && current.getListAmenities()!=null){
                        for (Amenity current2 : current.getListAmenities()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolAnimation && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Animation filtre : listFiltresAnimation) {
                    if (filtre.isChecked() && current.getListAnimations()!=null){
                        for (Animation current2 : current.getListAnimations()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolAtmospher && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Atmospher filtre : listFiltresAtmospher) {
                    if (filtre.isChecked() && current.getListAtmosphere()!=null){
                        for (Atmospher current2 : current.getListAtmosphere()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolCategory && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Category filtre : listFiltresCategory) {
                    if (filtre.isChecked() && current.getListCategories()!=null){
                        for (Category current2 : current.getListCategories()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolChain && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Chain filtre : listFiltresChain) {
                    if (filtre.isChecked() && current.getListChains()!=null){
                        for (Chain current2 : current.getListChains()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolFamilyOption && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (FamilyOption filtre : listFiltresFamilyOption) {
                    if (filtre.isChecked() && current.getListFamilyOptions()!=null){
                        for (FamilyOption current2 : current.getListFamilyOptions()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }



            if (boolFurnishedRental && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (FurnishedRental filtre : listFiltresFurnishedRental) {
                    if (filtre.isChecked() && current.getListFurnishedRentals()!=null){
                        for (FurnishedRental current2 : current.getListFurnishedRentals()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolGroupOption && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (GroupOption filtre : listFiltresGroupOption) {
                    if (filtre.isChecked() && current.getListGroupOptions()!=null){
                        for (GroupOption current2 : current.getListGroupOptions()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolLabel && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Label filtre : listFiltresLabel) {
                    if (filtre.isChecked() && current.getListLabels()!=null){
                        for (Label current2 : current.getListLabels()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolLocation && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Location filtre : listFiltresLocation) {
                    if (filtre.isChecked() && current.getListLocations()!=null){
                        for (Location current2 : current.getListLocations()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }







            if (boolRentalMonth && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (RentalMonth filtre : listFiltresRentalMonth) {
                    if (filtre.isChecked() && current.getListRentalMonthes()!=null){
                        for (RentalMonth current2 : current.getListRentalMonthes()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }


            if (boolService && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Service filtre : listFiltresService) {
                    if (filtre.isChecked() && current.getListServices()!=null){
                        for (Service current2 : current.getListServices()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolSleeping && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Sleeping filtre : listFiltresSleeping) {
                    if (filtre.isChecked() && current.getListSleepings()!=null){
                        for (Sleeping current2 : current.getListSleepings()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolStandingLevel && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (StandingLevel filtre : listFiltresStandingLevel) {
                    if (filtre.isChecked() && current.getListStandingLevels()!=null){
                        for (StandingLevel current2 : current.getListStandingLevels()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }

            if (boolStation && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Station filtre : listFiltresStation) {
                    if (filtre.isChecked() && current.getListStations()!=null){
                        for (Station current2 : current.getListStations()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }



            if (boolCity && listEntryFiltre.contains(current)) {
                boolean isFiltered = false;
                for (Address filtre : listFiltresCity) {
                    if (filtre.isChecked() && current.getAddress()!=null && current.getAddress().getCity()!=null){
                        if (current.getAddress().getCity().equalsIgnoreCase(filtre.getCity())){
                            isFiltered = true;
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryFiltre.remove(current);
                }
            }
        }

        Collections.sort(listEntryFiltre);

        configureRecyclerView(listEntryFiltre);

    }

    @OnClick(R.id.fabRazFiltre)
    public void fabRazFiltreClick() {
        scrollViewFiltre.setVisibility(View.GONE);
        fabFiltre.setVisibility(View.GONE);
        fabRazFiltre.setVisibility(View.GONE);
        //menu_activity_main_filter.setVisible(true);
        item = menuItems.findItem(R.id.menu_activity_main_filter);
        item.setVisible(true);
        decocherTout();
        configureRecyclerView();

    }

    public void decocherFiltre(List<? extends DetailEntrySimple> list){
        for (DetailEntrySimple current : list) {
            current.setChecked(false);
        }
    }

    public void decocherCheckbox(List<MaterialCheckBox> list){
        for (MaterialCheckBox current : list){
            current.setChecked(false);
        }
    }

    public void decocherCheckbox(MaterialCheckBox cb){
        cb.setChecked(false);
    }

    public void decocherTout(){
        decocherFiltre(listFiltresAmenity);
        decocherFiltre(listFiltresAnimation);
        decocherFiltre(listFiltresAtmospher);
        decocherFiltre(listFiltresCategory);
        decocherFiltre(listFiltresChain);
        decocherFiltre(listFiltresFamilyOption);

        decocherFiltre(listFiltresFurnishedRental);
        decocherFiltre(listFiltresGroupOption);
        decocherFiltre(listFiltresLabel);
        decocherFiltre(listFiltresLocation);

        decocherFiltre(listFiltresRentalMonth);

        decocherFiltre(listFiltresService);
        decocherFiltre(listFiltresSleeping);
        decocherFiltre(listFiltresStandingLevel);
        decocherFiltre(listFiltresStation);

        for (Address current : listFiltresCity) {
            current.setChecked(false);
        }

        decocherCheckbox(listCheckboxAmenity);
        decocherCheckbox(listCheckboxAnimation);
        decocherCheckbox(listCheckboxAtmospher);
        decocherCheckbox(listCheckboxCategory);
        decocherCheckbox(listCheckboxChain);
        decocherCheckbox(listCheckboxCity);
        decocherCheckbox(listCheckboxFamilyOption);

        decocherCheckbox(listCheckboxFurnishedRental);
        decocherCheckbox(listCheckboxGroupOption);
        decocherCheckbox(listCheckboxLabel);
        decocherCheckbox(listCheckboxLocation);

        decocherCheckbox(listCheckboxRentalMonth);

        decocherCheckbox(listCheckboxService);
        decocherCheckbox(listCheckboxSleeping);
        decocherCheckbox(listCheckboxStandingLevels);
        decocherCheckbox(listCheckboxStation);

        decocherCheckbox(checkboxFiltreAmenitiesSelectAll);
        decocherCheckbox(checkboxFiltreAnimationsSelectAll);
        decocherCheckbox(checkboxFiltreAtmosphereSelectAll);
        decocherCheckbox(checkboxFiltreCategorySelectAll);
        decocherCheckbox(checkboxFiltreChainsSelectAll);
        decocherCheckbox(checkboxFiltreCitySelectAll);
        decocherCheckbox(checkboxFiltreFamilyOptionsSelectAll);

        decocherCheckbox(checkboxFiltreFurnishedRentalsSelectAll);
        decocherCheckbox(checkboxFiltreGroupOptionsSelectAll);
        decocherCheckbox(checkboxFiltreLabelsSelectAll);
        decocherCheckbox(checkboxFiltreLocationsSelectAll);

        decocherCheckbox(checkboxFiltreRentalMonthesSelectAll);

        decocherCheckbox(checkboxFiltreServicesSelectAll);
        decocherCheckbox(checkboxFiltreSleepingsSelectAll);
        decocherCheckbox(checkboxFiltreStandingLevelsSelectAll);
        decocherCheckbox(checkboxFiltreStationsSelectAll);


        decocherCheckbox(checkboxFiltreAmenities);
        decocherCheckbox(checkboxFiltreAnimations);
        decocherCheckbox(checkboxFiltreAtmosphere);
        decocherCheckbox(checkboxFiltreCategory);
        decocherCheckbox(checkboxFiltreChains);
        decocherCheckbox(checkboxFiltreCity);
        decocherCheckbox(checkboxFiltreFamilyOptions);

        decocherCheckbox(checkboxFiltreFurnishedRentals);
        decocherCheckbox(checkboxFiltreGroupOptions);
        decocherCheckbox(checkboxFiltreLabels);
        decocherCheckbox(checkboxFiltreLocations);

        decocherCheckbox(checkboxFiltreRentalMonthes);

        decocherCheckbox(checkboxFiltreServices);
        decocherCheckbox(checkboxFiltreSleepings);
        decocherCheckbox(checkboxFiltreStandingLevels);
        decocherCheckbox(checkboxFiltreStations);


    }

    public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntries(listEntries, this);
        list_recycler_event.setAdapter(adapterEntries);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    public void configureRecyclerView(List<Entry> list) {
        adapterEntries = new RecyclerAdapterEntries(list, this);
        list_recycler_event.setAdapter(adapterEntries);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    protected void initCheckboxSelectAllClick(MaterialCheckBox cbSelectAll, List<MaterialCheckBox> list) {
        cbSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (MaterialCheckBox current : list) {
                    if (isChecked) {
                        current.setChecked(true);
                    } else {
                        current.setChecked(false);
                    }
                }
            }
        });
    }

    protected void initCheckboxesSelectAllClick(){

        initCheckboxSelectAllClick(checkboxFiltreAmenitiesSelectAll,listCheckboxAmenity);
        initCheckboxSelectAllClick(checkboxFiltreAnimationsSelectAll,listCheckboxAnimation);
        initCheckboxSelectAllClick(checkboxFiltreAtmosphereSelectAll,listCheckboxAtmospher);
        initCheckboxSelectAllClick(checkboxFiltreCategorySelectAll,listCheckboxCategory);
        initCheckboxSelectAllClick(checkboxFiltreChainsSelectAll,listCheckboxChain);
        initCheckboxSelectAllClick(checkboxFiltreCitySelectAll,listCheckboxCity);
        initCheckboxSelectAllClick(checkboxFiltreFamilyOptionsSelectAll,listCheckboxFamilyOption);

        initCheckboxSelectAllClick(checkboxFiltreFurnishedRentalsSelectAll,listCheckboxFurnishedRental);
        initCheckboxSelectAllClick(checkboxFiltreGroupOptionsSelectAll,listCheckboxGroupOption);
        initCheckboxSelectAllClick(checkboxFiltreLabelsSelectAll,listCheckboxLabel);
        initCheckboxSelectAllClick(checkboxFiltreLocationsSelectAll,listCheckboxLocation);

        initCheckboxSelectAllClick(checkboxFiltreRentalMonthesSelectAll,listCheckboxRentalMonth);

        initCheckboxSelectAllClick(checkboxFiltreServicesSelectAll,listCheckboxService);
        initCheckboxSelectAllClick(checkboxFiltreSleepingsSelectAll,listCheckboxSleeping);
        initCheckboxSelectAllClick(checkboxFiltreStandingLevelsSelectAll,listCheckboxStandingLevels);
        initCheckboxSelectAllClick(checkboxFiltreStationsSelectAll,listCheckboxStation);

    }

    protected boolean verifSiUnFiltreMinimum(List<? extends DetailEntrySimple> list){
        boolean bool = false;
        for (DetailEntrySimple current : list) {
            if (current.isChecked()){
                bool = true;
            }
        }
        return bool;
    }

    protected void initFiltre(List<? extends DetailEntrySimple> list, LinearLayout ll, List<MaterialCheckBox> listCb,MaterialCheckBox cb) {
        Collections.sort(list);
        for (DetailEntrySimple current : list) {
            MaterialCheckBox checkBox = new MaterialCheckBox(this);
            checkBox.setText(current.getValue());
            checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        current.setChecked(true);
                    } else {
                        current.setChecked(false);
                        if (!verifSiUnFiltreMinimum(list)){
                            cb.setChecked(false);
                        }
                    }
                }
            });
            // Add Checkbox to LinearLayout
            if (ll != null) {
                ll.addView(checkBox);
            }
            listCb.add(checkBox);

        }
    }

    protected void initListFiltres() {

        initFiltre(listFiltresAmenity,linearLayoutAmenities,listCheckboxAmenity,checkboxFiltreAmenitiesSelectAll);
        initFiltre(listFiltresAnimation,linearLayoutAnimations,listCheckboxAnimation,checkboxFiltreAnimationsSelectAll);
        initFiltre(listFiltresAtmospher,linearLayoutAtmosphere,listCheckboxAtmospher,checkboxFiltreAtmosphereSelectAll);
        initFiltre(listFiltresCategory,linearLayoutCategory,listCheckboxCategory,checkboxFiltreCategorySelectAll);
        initFiltre(listFiltresChain,linearLayoutChains,listCheckboxChain,checkboxFiltreChainsSelectAll);
        //conserver car city n'est pas comme les autres
        for (Address current : listFiltresCity) {
            MaterialCheckBox checkBox = new MaterialCheckBox(this);
            checkBox.setText(current.getCity());
            checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        current.setChecked(true);
                    } else {
                        current.setChecked(false);


                        boolean bool = false;
                        for (Address current : listFiltresCity) {
                            if (current.isChecked()){
                                bool = true;
                            }
                        }
                        if (!bool){
                            checkboxFiltreCitySelectAll.setChecked(false);
                        }


                    }
                }
            });
            // Add Checkbox to LinearLayout
            if (linearLayoutCity != null) {
                linearLayoutCity.addView(checkBox);
            }
            listCheckboxCity.add(checkBox);
        }
        initFiltre(listFiltresFamilyOption,linearLayoutFamilyOptions,listCheckboxFamilyOption,checkboxFiltreFamilyOptionsSelectAll);

        initFiltre(listFiltresFurnishedRental,linearLayoutFurnishedRentals,listCheckboxFurnishedRental,checkboxFiltreFurnishedRentalsSelectAll);
        initFiltre(listFiltresGroupOption,linearLayoutGroupOptions,listCheckboxGroupOption,checkboxFiltreGroupOptionsSelectAll);
        initFiltre(listFiltresLabel,linearLayoutLabels,listCheckboxLabel,checkboxFiltreLabelsSelectAll);
        initFiltre(listFiltresLocation,linearLayoutLocations,listCheckboxLocation,checkboxFiltreLocationsSelectAll);
        initFiltre(listFiltresRentalMonth,linearLayoutRentalMonthes,listCheckboxRentalMonth,checkboxFiltreRentalMonthesSelectAll);
        initFiltre(listFiltresService,linearLayoutServices,listCheckboxService,checkboxFiltreServicesSelectAll);
        initFiltre(listFiltresSleeping,linearLayoutSleepings,listCheckboxSleeping,checkboxFiltreSleepingsSelectAll);
        initFiltre(listFiltresStandingLevel,linearLayoutStandingLevels,listCheckboxStandingLevels,checkboxFiltreStandingLevelsSelectAll);
        initFiltre(listFiltresStation,linearLayoutStations,listCheckboxStation,checkboxFiltreStationsSelectAll);
        
    }

    @Override
    public void onClickEntriesButton(int position) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_filter:
                Log.d(TAG, "click sur filtre");
                scrollViewFiltre.setVisibility(View.VISIBLE);
                fabFiltre.setVisibility(View.VISIBLE);
                fabRazFiltre.setVisibility(View.VISIBLE);
                item.setVisible(false);
                break;
        }
        return true;
    }




    public void connectAndGetApiData(String url) {}


    protected void addElementIfNotExist(List<?> list, Object object) {
        //for (Object current : list){
        boolean bool = false;
        if (object instanceof Amenity) {
            for (Amenity current : (List<Amenity>) list) {
                if (current.getValue().equalsIgnoreCase(((Amenity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresAmenity.add((Amenity) object);
            }
        } else if (object instanceof Animation) {
            for (Animation current : (List<Animation>) list) {
                if (current.getValue().equalsIgnoreCase(((Animation) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresAnimation.add((Animation) object);
            }
        } else if (object instanceof Atmospher) {
            for (Atmospher current : (List<Atmospher>) list) {
                if (current.getValue().equalsIgnoreCase(((Atmospher) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresAtmospher.add((Atmospher) object);
            }
        } else if (object instanceof Category) {
            for (Category current : (List<Category>) list) {
                if (current.getValue().equalsIgnoreCase(((Category) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresCategory.add((Category) object);
            }
        } else if (object instanceof Chain) {
            for (Chain current : (List<Chain>) list) {
                if (current.getValue().equalsIgnoreCase(((Chain) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresChain.add((Chain) object);
            }
        } else if (object instanceof Address) {
            for (Address current : (List<Address>) list) {
                if (current.getCity().equalsIgnoreCase(((Address) object).getCity())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresCity.add((Address) object);
            }
        } else if (object instanceof FamilyOption) {
            for (FamilyOption current : (List<FamilyOption>) list) {
                if (current.getValue().equalsIgnoreCase(((FamilyOption) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresFamilyOption.add((FamilyOption) object);
            }
        } else if (object instanceof FurnishedRental) {
            for (FurnishedRental current : (List<FurnishedRental>) list) {
                if (current.getValue().equalsIgnoreCase(((FurnishedRental) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresFurnishedRental.add((FurnishedRental) object);
            }
        } else if (object instanceof GroupOption) {
            for (GroupOption current : (List<GroupOption>) list) {
                if (current.getValue().equalsIgnoreCase(((GroupOption) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresGroupOption.add((GroupOption) object);
            }
        } else if (object instanceof Label) {
            for (Label current : (List<Label>) list) {
                if (current.getValue().equalsIgnoreCase(((Label) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresLabel.add((Label) object);
            }
        } else if (object instanceof Location) {
            for (Location current : (List<Location>) list) {
                if (current.getValue().equalsIgnoreCase(((Location) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresLocation.add((Location) object);
            }
        } else if (object instanceof RentalMonth) {
            for (RentalMonth current : (List<RentalMonth>) list) {
                if (current.getValue().equalsIgnoreCase(((RentalMonth) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresRentalMonth.add((RentalMonth) object);
            }
        } else if (object instanceof Service) {
            for (Service current : (List<Service>) list) {
                if (current.getValue().equalsIgnoreCase(((Service) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresService.add((Service) object);
            }
        } else if (object instanceof Sleeping) {
            for (Sleeping current : (List<Sleeping>) list) {
                if (current.getValue().equalsIgnoreCase(((Sleeping) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresSleeping.add((Sleeping) object);
            }
        } else if (object instanceof StandingLevel) {
            for (StandingLevel current : (List<StandingLevel>) list) {
                if (current.getValue().equalsIgnoreCase(((StandingLevel) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresStandingLevel.add((StandingLevel) object);
            }
        } else if (object instanceof Station) {
            for (Station current : (List<Station>) list) {
                if (current.getValue().equalsIgnoreCase(((Station) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresStation.add((Station) object);
            }
        }
    }







    protected void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        //ouvrirActiviteSuivante(AfficherEntriesBoutiqueActivity.this, AfficherEntryBoutiqueDetailActivity.class,"entryId",listEntryEntities.get(position).getId(),false);
                        Log.e("TAG", "Position : "+position);
                        selectedEntry = listEntries.get(position);
                        scrollView.fullScroll(View.FOCUS_UP);
                        fillAllFields();
                        hideFields();
                        AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
                        runnerImage.execute();
                        item.setVisible(false);
                        afficherDetail(true);
                    }
                });
    }

    public void afficherDetail(boolean bool) {
        scrollView.fullScroll(View.FOCUS_UP);
        if (bool) {
            scrollView.fullScroll(View.FOCUS_UP);
            scrollView.setVisibility(View.VISIBLE);
            fabExit.show();
            List<EntryEntity> listEntriesFound = entryEntityDao.queryRaw("where entry_entity_id = ?",""+selectedEntry.getId());
            if (listEntriesFound.size() == 0) {
                fabSave.show();
            } else {
                fabSave.hide();
            }
        } else {
            scrollView.setVisibility(View.GONE);
            fabExit.hide();
            fabSave.hide();
        }
    }

    protected void hideFields() {

        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getRoomCount() == 0) {
            roomCount.setVisibility(View.GONE);
        } else {
            roomCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getRoomBathCount() == 0) {
            roomBathCount.setVisibility(View.GONE);
        } else {
            roomBathCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getRoomShowerCount() == 0) {
            roomShowerCount.setVisibility(View.GONE);
        } else {
            roomShowerCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getSuiteCount() == 0) {
            suiteCount.setVisibility(View.GONE);
        } else {
            suiteCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getStudioCount() == 0) {
            studioCount.setVisibility(View.GONE);
        } else {
            studioCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getApartmentCount() == 0) {
            apartmentCount.setVisibility(View.GONE);
        } else {
            apartmentCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getRoomAccessibleCount() == 0) {
            roomCount.setVisibility(View.GONE);
        } else {
            roomCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getRoomCount() == 0) {
            roomAccessibleCount.setVisibility(View.GONE);
        } else {
            roomAccessibleCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getSingleCount() == 0) {
            singleCount.setVisibility(View.GONE);
        } else {
            singleCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getDoubleCount() == 0) {
            doubleCount.setVisibility(View.GONE);
        } else {
            doubleCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getTripleCount() == 0) {
            tripleCount.setVisibility(View.GONE);
        } else {
            tripleCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getTwinsCount() == 0) {
            twinsCount.setVisibility(View.GONE);
        } else {
            twinsCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getFamilyCount() == 0) {
            familyCount.setVisibility(View.GONE);
        } else {
            familyCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getArea() == 0f) {
            area.setVisibility(View.GONE);
        } else {
            area.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getType() == null) {
            type.setVisibility(View.GONE);
        } else {
            type.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getFloor() == 0) {
            floor.setVisibility(View.GONE);
        } else {
            floor.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getBedroomCount() == 0) {
            bedroomCount.setVisibility(View.GONE);
        } else {
            bedroomCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getSleepsCount() == 0) {
            sleepsCount.setVisibility(View.GONE);
        } else {
            sleepsCount.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getLiving() == null || selectedEntry.getLiving().getFurnishedRoomCount() == 0) {
            furnishedRoomCount.setVisibility(View.GONE);
        } else {
            furnishedRoomCount.setVisibility(View.VISIBLE);
        }











        if (selectedEntry.getListStandingLevels() == null || selectedEntry.getListStandingLevels().size() == 0) {
            layoutStanding.setVisibility(View.GONE);
        } else {
            layoutStanding.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListFurnishedRentals() == null || selectedEntry.getListFurnishedRentals().size() == 0) {
            layoutMeuble.setVisibility(View.GONE);
        } else {
            layoutMeuble.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListRentalMonthes() == null || selectedEntry.getListRentalMonthes().size() == 0) {
            layoutPeriode.setVisibility(View.GONE);
        } else {
            layoutPeriode.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListSleepings() == null || selectedEntry.getListSleepings().size() == 0) {
            couchage.setVisibility(View.GONE);
        } else {
            couchage.setVisibility(View.VISIBLE);
        }




        if (selectedEntry.getNameFr() == null) {
            nameFr.setVisibility(View.GONE);
        } else {
            nameFr.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getListDescriptions() == null || selectedEntry.getListDescriptions().size() == 0) {
            description.setVisibility(View.GONE);
        } else {
            description.setVisibility(View.VISIBLE);
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
            layoutStation.setVisibility(View.GONE);
        } else {
            layoutStation.setVisibility(View.VISIBLE);
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
            layoutPratique.setVisibility(View.GONE);
        } else {
            layoutPratique.setVisibility(View.VISIBLE);
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

    protected void fillAllFields() {

        roomCount.setText("Nb Chambre: "+selectedEntry.getLiving().getRoomCount());
        roomBathCount.setText("Nb Chambre avec Sdb: "+selectedEntry.getLiving().getRoomBathCount());
        roomShowerCount.setText("Nb Chambre avec Douche: "+selectedEntry.getLiving().getRoomShowerCount());
        suiteCount.setText("Nb Chambre Suite: "+selectedEntry.getLiving().getSuiteCount());
        studioCount.setText("Nb Studio: "+selectedEntry.getLiving().getStudioCount());
        apartmentCount.setText("Nb Appart: "+selectedEntry.getLiving().getApartmentCount());
        roomAccessibleCount.setText("Nb Chambre Accessible: "+selectedEntry.getLiving().getRoomAccessibleCount());
        singleCount.setText("Nb Chambre Simple: "+selectedEntry.getLiving().getSingleCount());
        doubleCount.setText("Nb Chambre Double: "+selectedEntry.getLiving().getDoubleCount());
        tripleCount.setText("Nb Chambre Triple: "+selectedEntry.getLiving().getTripleCount());
        twinsCount.setText("Nb Chambre Twin: "+selectedEntry.getLiving().getTwinsCount());
        familyCount.setText("Nb Chambre Famille: "+selectedEntry.getLiving().getFamilyCount());
        area.setText("Surface: "+selectedEntry.getLiving().getArea()+" m²");
        type.setText("Type: "+selectedEntry.getLiving().getType());
        floor.setText("Etage: "+selectedEntry.getLiving().getFloor());
        bedroomCount.setText("Nb Chambre: "+selectedEntry.getLiving().getBedroomCount());
        sleepsCount.setText("Nb Couchage: "+selectedEntry.getLiving().getSleepsCount());
        furnishedRoomCount.setText("Nb Chambre Meuble: "+selectedEntry.getLiving().getFurnishedRoomCount());


        String standingString = "";
        if (selectedEntry.getListStandingLevels()!=null) {
            int i = 1;
            for (StandingLevel current : selectedEntry.getListStandingLevels()) {
                standingString += current.getValue();
                if (i < selectedEntry.getListStandingLevels().size()) {
                    standingString += newLine;
                }
                i++;
            }
        }
        standing.setText(standingString);

        String meubleString = "";
        if (selectedEntry.getListFurnishedRentals()!=null) {
            int i = 1;
            for (FurnishedRental current : selectedEntry.getListFurnishedRentals()) {
                meubleString += current.getValue();
                if (i < selectedEntry.getListFurnishedRentals().size()) {
                    meubleString += newLine;
                }
                i++;
            }
        }
        meuble.setText(meubleString);

        String periodeString = "";
        if (selectedEntry.getListRentalMonthes()!=null) {
            int i = 1;
            for (RentalMonth current : selectedEntry.getListRentalMonthes()) {
                periodeString += current.getValue();
                if (i < selectedEntry.getListRentalMonthes().size()) {
                    periodeString += newLine;
                }
                i++;
            }
        }
        periode.setText(periodeString);

        String couchageString = "";
        if (selectedEntry.getListSleepings()!=null) {
            int i = 1;
            for (Sleeping current : selectedEntry.getListSleepings()) {
                couchageString += current.getValue();
                if (i < selectedEntry.getListSleepings().size()) {
                    couchageString += newLine;
                }
                i++;
            }
        }
        couchage.setText(couchageString);


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

        if (selectedEntry.getListDescriptions()!= null && selectedEntry.getListDescriptions().size()>0) {
            if (selectedEntry.getListDescriptions().get(0).getLanguage().equalsIgnoreCase("fr") &&
                    selectedEntry.getListDescriptions().get(0).getType().equalsIgnoreCase("Publique")) {
                description.setText(selectedEntry.getListDescriptions().get(0).getValue());
            }
        }

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
                    amenityString += newLine;
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
                        if (current.getClosureDay() != null && current.getClosureSpan() != null) {
                            closureString += current.getClosureDay() + " - " + current.getClosureSpan();
                        } else if (current.getDate()!=null){
                            closureString += current.getDate();
                        }
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
                    labelString += newLine;
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
                        openingString += currentGrid.getOpeningDays() + " au " + currentGrid.getOpeningHours();
                        if (j < current.getListGrids().size()) {
                            openingString += newLine;
                        }
                        j++;
                    }
                }
                if (i < selectedEntry.getListOpenings().size()) {
                    openingString += newLine;
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
                    stationString += newLine;
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
            int w = 0;
            for (Category current : selectedEntry.getListCategories()) {
                if (current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))
                        || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
                        || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.infos_pratiques))) {
                    w++;
                }
            }
            for (Category current : selectedEntry.getListCategories()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
                    && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))
                        && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.infos_pratiques))) {
                    categoryString += current.getValue();
                    if (i < selectedEntry.getListCategories().size()-w) {
                        categoryString += " / ";
                    }
                    i++;
                }

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

    protected class AsyncTaskRunnerImage extends AsyncTask<Void, Integer, Void> {

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

    protected void traiterIntentDetail() {
        Intent intent = getIntent();
        if (intent.hasExtra("entryId")) {
            Long entryId = intent.getLongExtra("entryId", 0);
            entryTransmis = entryEntityDao.load(entryId);
            fillAllFieldsDetail();
            hideFieldsDetail();
            AsyncTaskRunnerImageDetail runnerImage = new AsyncTaskRunnerImageDetail();
            runnerImage.execute();
        }
    }

    protected void hideFieldsDetail() {

        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomCount() == 0) {
            roomCount.setVisibility(View.GONE);
        } else {
            roomCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomBathCount() == 0) {
            roomBathCount.setVisibility(View.GONE);
        } else {
            roomBathCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomShowerCount() == 0) {
            roomShowerCount.setVisibility(View.GONE);
        } else {
            roomShowerCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getSuiteCount() == 0) {
            suiteCount.setVisibility(View.GONE);
        } else {
            suiteCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getStudioCount() == 0) {
            studioCount.setVisibility(View.GONE);
        } else {
            studioCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getApartmentCount() == 0) {
            apartmentCount.setVisibility(View.GONE);
        } else {
            apartmentCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomAccessibleCount() == 0) {
            roomCount.setVisibility(View.GONE);
        } else {
            roomCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomCount() == 0) {
            roomAccessibleCount.setVisibility(View.GONE);
        } else {
            roomAccessibleCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getSingleCount() == 0) {
            singleCount.setVisibility(View.GONE);
        } else {
            singleCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getDoubleCount() == 0) {
            doubleCount.setVisibility(View.GONE);
        } else {
            doubleCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getTripleCount() == 0) {
            tripleCount.setVisibility(View.GONE);
        } else {
            tripleCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getTwinsCount() == 0) {
            twinsCount.setVisibility(View.GONE);
        } else {
            twinsCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getFamilyCount() == 0) {
            familyCount.setVisibility(View.GONE);
        } else {
            familyCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getArea() == 0f) {
            area.setVisibility(View.GONE);
        } else {
            area.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getType() == null) {
            type.setVisibility(View.GONE);
        } else {
            type.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getFloor() == 0) {
            floor.setVisibility(View.GONE);
        } else {
            floor.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getBedroomCount() == 0) {
            bedroomCount.setVisibility(View.GONE);
        } else {
            bedroomCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getSleepsCount() == 0) {
            sleepsCount.setVisibility(View.GONE);
        } else {
            sleepsCount.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getFurnishedRoomCount() == 0) {
            furnishedRoomCount.setVisibility(View.GONE);
        } else {
            furnishedRoomCount.setVisibility(View.VISIBLE);
        }











        if (entryTransmis.getListStandingLevels() == null || entryTransmis.getListStandingLevels().size() == 0) {
            layoutStanding.setVisibility(View.GONE);
        } else {
            layoutStanding.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListFurnishedRentals() == null || entryTransmis.getListFurnishedRentals().size() == 0) {
            layoutMeuble.setVisibility(View.GONE);
        } else {
            layoutMeuble.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListRentalMonths() == null || entryTransmis.getListRentalMonths().size() == 0) {
            layoutPeriode.setVisibility(View.GONE);
        } else {
            layoutPeriode.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListSleepings() == null || entryTransmis.getListSleepings().size() == 0) {
            couchage.setVisibility(View.GONE);
        } else {
            couchage.setVisibility(View.VISIBLE);
        }




        if (entryTransmis.getNameFr() == null) {
            nameFr.setVisibility(View.GONE);
        } else {
            nameFr.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListDescriptions() == null || entryTransmis.getListDescriptions().size() == 0) {
            description.setVisibility(View.GONE);
        } else {
            description.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListCategories() == null || entryTransmis.getListCategories().size() == 0) {
            category.setVisibility(View.GONE);
        } else {
            category.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListLocations() == null || entryTransmis.getListLocations().size() == 0) {
            location.setVisibility(View.GONE);
        } else {
            location.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListAtmosphere() == null || entryTransmis.getListAtmosphere().size() == 0) {
            atmosphere.setVisibility(View.GONE);
        } else {
            atmosphere.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListServices() == null || entryTransmis.getListServices().size() == 0) {
            service.setVisibility(View.GONE);
        } else {
            service.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null && (entryTransmis.getListStations() == null || entryTransmis.getListStations().size() == 0)) {
            layoutAddress.setVisibility(View.GONE);
        } else {
            layoutAddress.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null) {
            boutonsMapWaze.setVisibility(View.GONE);
        } else {
            boutonsMapWaze.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress().getAddressLine1() == null) {
            addressLine1.setVisibility(View.GONE);
        } else {
            addressLine1.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress().getAddressLine2() == null) {
            addressLine2.setVisibility(View.GONE);
        } else {
            addressLine2.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress().getAddressLine3() == null) {
            addressLine3.setVisibility(View.GONE);
        } else {
            addressLine3.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress().getZip() == null) {
            addressZip.setVisibility(View.GONE);
        } else {
            addressZip.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress().getCity() == null) {
            addressCity.setVisibility(View.GONE);
        } else {
            addressCity.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListStations() == null || entryTransmis.getListStations().size() == 0) {
            layoutStation.setVisibility(View.GONE);
        } else {
            layoutStation.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getPhone() == null) {
            phone.setVisibility(View.GONE);
        } else {
            phone.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getFax() == null) {
            fax.setVisibility(View.GONE);
        } else {
            fax.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getEmail() == null) {
            email.setVisibility(View.GONE);
        } else {
            email.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getWebsite() == null) {
            website.setVisibility(View.GONE);
        } else {
            website.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getFacebook() == null) {
            facebook.setVisibility(View.GONE);
        } else {
            facebook.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getTwitter() == null) {
            twitter.setVisibility(View.GONE);
        } else {
            twitter.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListPayments() == null || entryTransmis.getListPayments().size() == 0) {
            layoutPayment.setVisibility(View.GONE);
        } else {
            layoutPayment.setVisibility(View.VISIBLE);
        }
        if ((entryTransmis.getListOpenings() == null || entryTransmis.getListOpenings().size() == 0) && entryTransmis.getOpening() == null) {
            ouvert.setVisibility(View.GONE);
        } else {
            ouvert.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListOpenings() == null|| entryTransmis.getListOpenings().size() == 0) {
            openings.setVisibility(View.GONE);
        } else {
            openings.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getOpening() == null) {
            opening.setVisibility(View.GONE);
        } else {
            opening.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListLabels() == null || entryTransmis.getListLabels().size() == 0) {
            layoutLabel.setVisibility(View.GONE);
        } else {
            layoutLabel.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListAnimations() == null || entryTransmis.getListAnimations().size() == 0) {
            layoutAnimation.setVisibility(View.GONE);
        } else {
            layoutAnimation.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListOptions() == null || entryTransmis.getListOptions().size() == 0) {
            option.setVisibility(View.GONE);
        } else {
            option.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListAmenities() == null || entryTransmis.getListAmenities().size() == 0) {
            layoutPratique.setVisibility(View.GONE);
        } else {
            layoutPratique.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getGroup() == 0) {
            capacityGroup.setVisibility(View.GONE);
        } else {
            capacityGroup.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getCocktail() == 0) {
            capacityDebout.setVisibility(View.GONE);
        } else {
            capacityDebout.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getSeated() == 0) {
            capacityAssis.setVisibility(View.GONE);
        } else {
            capacityAssis.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getOutdoor() == 0) {
            capacityExterieur.setVisibility(View.GONE);
        } else {
            capacityExterieur.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getIndoor() == 0) {
            capacityInterieur.setVisibility(View.GONE);
        } else {
            capacityInterieur.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getTotal() == 0) {
            capacityTotal.setVisibility(View.GONE);
        } else {
            capacityTotal.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getRoomCount() == 0) {
            capacitySalle.setVisibility(View.GONE);
        } else {
            capacitySalle.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListClosings() == null || entryTransmis.getListClosings().size() == 0) {
            closings.setVisibility(View.GONE);
        } else {
            closings.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getClosing() == null) {
            closing.setVisibility(View.GONE);
        } else {
            closing.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListClosures() == null || entryTransmis.getListClosures().size() == 0) {
            closure.setVisibility(View.GONE);
        } else {
            closure.setVisibility(View.VISIBLE);
        }
        if (closings.getVisibility() == View.GONE && closing.getVisibility() == View.GONE
                && closure.getVisibility() == View.GONE) {
            ferme.setVisibility(View.GONE);
        } else {
            ferme.setVisibility(View.VISIBLE);
        }
    }

    protected void fillAllFieldsDetail() {

        roomCount.setText("Nb Chambre: "+entryTransmis.getLiving().getRoomCount());
        roomBathCount.setText("Nb Chambre avec Sdb: "+entryTransmis.getLiving().getRoomBathCount());
        roomShowerCount.setText("Nb Chambre avec Douche: "+entryTransmis.getLiving().getRoomShowerCount());
        suiteCount.setText("Nb Chambre Suite: "+entryTransmis.getLiving().getSuiteCount());
        studioCount.setText("Nb Studio: "+entryTransmis.getLiving().getStudioCount());
        apartmentCount.setText("Nb Appart: "+entryTransmis.getLiving().getApartmentCount());
        roomAccessibleCount.setText("Nb Chambre Accessible: "+entryTransmis.getLiving().getRoomAccessibleCount());
        singleCount.setText("Nb Chambre Simple: "+entryTransmis.getLiving().getSingleCount());
        doubleCount.setText("Nb Chambre Double: "+entryTransmis.getLiving().getDoubleCount());
        tripleCount.setText("Nb Chambre Triple: "+entryTransmis.getLiving().getTripleCount());
        twinsCount.setText("Nb Chambre Twin: "+entryTransmis.getLiving().getTwinsCount());
        familyCount.setText("Nb Chambre Famille: "+entryTransmis.getLiving().getFamilyCount());
        area.setText("Surface: "+entryTransmis.getLiving().getArea()+" m²");
        type.setText("Type: "+entryTransmis.getLiving().getType());
        floor.setText("Etage: "+entryTransmis.getLiving().getFloor());
        bedroomCount.setText("Nb Chambre: "+entryTransmis.getLiving().getBedroomCount());
        sleepsCount.setText("Nb Couchage: "+entryTransmis.getLiving().getSleepsCount());
        furnishedRoomCount.setText("Nb Chambre Meuble: "+entryTransmis.getLiving().getFurnishedRoomCount());


        String standingString = "";
        if (entryTransmis.getListStandingLevels()!=null) {
            int i = 1;
            for (EntryStandingLevelEntity current : entryTransmis.getListStandingLevels()) {
                standingString += current.getValue();
                if (i < entryTransmis.getListStandingLevels().size()) {
                    standingString += newLine;
                }
                i++;
            }
        }
        standing.setText(standingString);

        String meubleString = "";
        if (entryTransmis.getListFurnishedRentals()!=null) {
            int i = 1;
            for (EntryFurnishedRentalEntity current : entryTransmis.getListFurnishedRentals()) {
                meubleString += current.getValue();
                if (i < entryTransmis.getListFurnishedRentals().size()) {
                    meubleString += newLine;
                }
                i++;
            }
        }
        meuble.setText(meubleString);

        String periodeString = "";
        if (entryTransmis.getListRentalMonths()!=null) {
            int i = 1;
            for (EntryRentalMonthEntity current : entryTransmis.getListRentalMonths()) {
                periodeString += current.getValue();
                if (i < entryTransmis.getListRentalMonths().size()) {
                    periodeString += newLine;
                }
                i++;
            }
        }
        periode.setText(periodeString);

        String couchageString = "";
        if (entryTransmis.getListSleepings()!=null) {
            int i = 1;
            for (EntrySleepingEntity current : entryTransmis.getListSleepings()) {
                couchageString += current.getValue();
                if (i < entryTransmis.getListSleepings().size()) {
                    couchageString += newLine;
                }
                i++;
            }
        }
        couchage.setText(couchageString);


        nameFr.setText(entryTransmis.getNameFr());
        addressLine1.setText(entryTransmis.getAddress().getAddressLine1());
        addressLine2.setText(entryTransmis.getAddress().getAddressLine2());
        addressLine3.setText(entryTransmis.getAddress().getAddressLine3());
        addressZip.setText(entryTransmis.getAddress().getZip());
        addressCity.setText(entryTransmis.getAddress().getCity());
        phone.setText("Tel: "+entryTransmis.getPhone());
        fax.setText("Fax: "+entryTransmis.getFax());
        email.setText("Email: "+entryTransmis.getEmail());
        website.setText("Site: "+entryTransmis.getWebsite());
        facebook.setText("Fb: "+entryTransmis.getFacebook());
        twitter.setText("Twitter: "+entryTransmis.getTwitter());
        opening.setText(entryTransmis.getOpening());
        closing.setText(entryTransmis.getClosing());
        capacityTotal.setText("Cap. Total: "+entryTransmis.getCapacity().getTotal()+" pers");
        capacityInterieur.setText("Cap. Intérieur: "+entryTransmis.getCapacity().getIndoor()+" pers");
        capacityExterieur.setText("Cap. Extérieur: "+entryTransmis.getCapacity().getOutdoor()+" pers");
        capacityAssis.setText("Cap. Assis: "+entryTransmis.getCapacity().getSeated()+" pers");
        capacityDebout.setText("Cap. Debout: "+entryTransmis.getCapacity().getCocktail()+" pers");
        capacityGroup.setText("Cap. Group: "+entryTransmis.getCapacity().getGroup()+" pers");
        capacitySalle.setText("Nb Salle: "+entryTransmis.getCapacity().getRoomCount());

        if (entryTransmis.getListDescriptions()!= null && entryTransmis.getListDescriptions().size()>0) {
           // if (entryTransmis.getListDescriptions().get(0).get().equalsIgnoreCase("fr") &&
             //       entryTransmis.getListDescriptions().get(0).getType().equalsIgnoreCase("Publique")) {
                description.setText(entryTransmis.getListDescriptions().get(0).getValue());
            //}
        }

        String paymentString = "";
        if (entryTransmis.getListPayments()!=null) {
            int i = 1;
            for (EntryPaymentEntity current : entryTransmis.getListPayments()) {
                paymentString += current.getValue();
                if (i < entryTransmis.getListPayments().size()) {
                    paymentString += " / ";
                }
                i++;
            }
        }
        payment.setText(paymentString);

        String amenityString = "";
        if (entryTransmis.getListAmenities()!=null) {
            int i = 1;
            for (EntryAmenityEntity current : entryTransmis.getListAmenities()) {
                amenityString += current.getValue();
                if (i < entryTransmis.getListAmenities().size()) {
                    amenityString += newLine;
                }
                i++;
            }
        }
        amenity.setText(amenityString);

        String locationString = "";
        if (entryTransmis.getListLocations()!=null) {
            int i = 1;
            for (EntryLocationEntity current : entryTransmis.getListLocations()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.metropole))) {
                    locationString += current.getValue();
                    if (i < entryTransmis.getListLocations().size()) {
                        locationString += " / ";
                    }
                }
                i++;
            }
        }
        location.setText(locationString);

        String closureString = "";
        if (entryTransmis.getListClosures()!=null) {
            int i = 1;
            for (EntryClosureEntity closures : entryTransmis.getListClosures()) {
                //if (closures.getListClosure() != null) {
                    //for (Closure current : closures.getListClosure()) {
                        if (closures.getClosureDay() != null && closures.getClosureSpan() != null) {
                            closureString += closures.getClosureDay() + " - " + closures.getClosureSpan();
                        } else if (closures.getDate()!=null){
                            closureString += closures.getDate();
                        }
                        if (i < entryTransmis.getListClosures().size()) {
                            closureString += newLine;
                        }
                        i++;
                    //}
                //}
            }
        }
        closure.setText(closureString);

        String labelString = "";
        if (entryTransmis.getListLabels()!=null) {
            int i = 1;
            for (EntryLabelEntity current : entryTransmis.getListLabels()) {
                labelString += current.getValue();
                if (i < entryTransmis.getListLabels().size()) {
                    labelString += newLine;
                }
                i++;
            }
        }
        label.setText(labelString);

        String optionString = "";
        if (entryTransmis.getListOptions()!=null) {
            int i = 1;
            for (EntryOptionEntity current : entryTransmis.getListOptions()) {
                optionString += current.getValue();
                if (i < entryTransmis.getListOptions().size()) {
                    optionString += " / ";
                }
                i++;
            }
        }
        option.setText(optionString);

        String openingString = "";
        if (entryTransmis.getListOpenings()!=null) {
            int i = 1;
            int j = 1;
            for (EntryOpeningEntity current : entryTransmis.getListOpenings()) {
                openingString += current.getOpeningStart() + " - "+current.getOpeningEnd()+newLine;
                if (current.getListGrids() != null) {
                    for (EntryGridEntity currentGrid : current.getListGrids()) {
                        openingString += currentGrid.getOpeningDays() + " au " + currentGrid.getOpeningHours();
                        if (j < current.getListGrids().size()) {
                            openingString += newLine;
                        }
                        j++;
                    }
                }
                if (i < entryTransmis.getListOpenings().size()) {
                    openingString += newLine;
                }
                i++;
            }
        }
        openings.setText(openingString);

        String closingString = "";
        if (entryTransmis.getListClosings()!=null) {
            int i = 1;
            for (EntryClosingEntity current : entryTransmis.getListClosings()) {
                closingString += current.getValue();
                if (i < entryTransmis.getListClosings().size()) {
                    closingString += " / ";
                }
                i++;
            }
        }
        closings.setText(closingString);

        String serviceString = "";
        if (entryTransmis.getListServices()!=null) {
            int i = 1;
            for (EntryServiceEntity current : entryTransmis.getListServices()) {
                serviceString += current.getValue();
                if (i < entryTransmis.getListServices().size()) {
                    serviceString += " / ";
                }
                i++;
            }
        }
        service.setText(serviceString);

        String stationString = "";
        if (entryTransmis.getListStations()!=null) {
            int i = 1;
            for (EntryStationEntity current : entryTransmis.getListStations()) {
                stationString += current.getValue();
                if (i < entryTransmis.getListStations().size()) {
                    stationString += newLine;
                }
                i++;
            }
        }
        station.setText(stationString);

        String animationString = "";
        if (entryTransmis.getListAnimations()!=null) {
            int i = 1;
            for (EntryAnimationEntity current : entryTransmis.getListAnimations()) {
                animationString += current.getValue();
                if (i < entryTransmis.getListAnimations().size()) {
                    animationString += " / ";
                }
                i++;
            }
        }
        animation.setText(animationString);

        String categoryString = "";
        if (entryTransmis.getListCategories()!=null) {
            int i = 1;
            int w = 0;
            for (EntryCategoryEntity current : entryTransmis.getListCategories()) {
                if (current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))
                        || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
                        || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.infos_pratiques))) {
                    w++;
                }
            }
            for (EntryCategoryEntity current : entryTransmis.getListCategories()) {
                if (!current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
                        && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))
                        && !current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.infos_pratiques))) {
                    categoryString += current.getValue();
                    if (i < entryTransmis.getListCategories().size()-w) {
                        categoryString += " / ";
                    }
                    i++;
                }

            }
        }
        category.setText(categoryString);

        String atmosphereString = "";
        if (entryTransmis.getListAtmosphere()!=null) {
            int i = 1;
            for (EntryAtmospherEntity current : entryTransmis.getListAtmosphere()) {
                atmosphereString += current.getValue();
                if (i < entryTransmis.getListAtmosphere().size()) {
                    atmosphereString += " / ";
                }
                i++;
            }
        }
        atmosphere.setText(atmosphereString);
    }

    private class AsyncTaskRunnerImageDetail extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            URL url = null;
            bitmap = null;
            if (entryTransmis.getListImages()!= null) {
                if (entryTransmis.getListImages().size()>0 && entryTransmis.getListImages().get(0).getUrl().length() > 0) {
                    try {
                        url = new URL(entryTransmis.getListImages().get(0).getUrl());
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
        scrollView.fullScroll(View.FOCUS_UP);
        afficherDetail(false);
        item.setVisible(true);
        //fabSave.show();
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

    public void launchMoovIt(View view) {
        try {
            PackageManager pm = App.getInstance().getApplicationContext().getPackageManager();
            pm.getPackageInfo("com.tranzmate", PackageManager.GET_ACTIVITIES);


            String uri ="moovit://directions?dest_lat="
                            +selectedEntry.getLatitude()
                            +"&dest_lon="
                            +selectedEntry.getLongitude()
                            +"&auto_run=true";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(uri));
            startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            String url = "http://app.appsflyer.com/com.tranzmate?pid=DL&c=";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        saveEntry(selectedEntry, entryType);
        //fabExit.performClick();
        fabSave.hide();
        item.setVisible(false);
    }

    public void listerFiltre() {
        for (Entry current : listEntries){
            if (current.getListAmenities()!=null) {
                for (Amenity current2 : current.getListAmenities()) {
                    addElementIfNotExist(listFiltresAmenity, current2);
                }
            }
            if (current.getListAnimations()!=null) {
                for (Animation current2 : current.getListAnimations()) {
                    addElementIfNotExist(listFiltresAnimation, current2);
                }
            }
            if (current.getListAtmosphere()!=null) {
                for (Atmospher current2 : current.getListAtmosphere()) {
                    addElementIfNotExist(listFiltresAtmospher, current2);
                }
            }
            if (current.getListCategories()!=null) {
                for (Category current2 : current.getListCategories()) {
                    addElementIfNotExist(listFiltresCategory, current2);
                }
            }
            if (current.getListChains()!=null) {
                for (Chain current2 : current.getListChains()) {
                    addElementIfNotExist(listFiltresChain, current2);
                }
            }
            //attention ici viser la city
            if (current.getAddress()!=null && current.getAddress().getCity()!=null) {
                addElementIfNotExist(listFiltresCity, current.getAddress());
            }
            if (current.getListFamilyOptions()!=null) {
                for (FamilyOption current2 : current.getListFamilyOptions()) {
                    addElementIfNotExist(listFiltresFamilyOption, current2);
                }
            }

            if (current.getListFurnishedRentals()!=null) {
                for (FurnishedRental current2 : current.getListFurnishedRentals()) {
                    addElementIfNotExist(listFiltresFurnishedRental, current2);
                }
            }
            if (current.getListGroupOptions()!=null) {
                for (GroupOption current2 : current.getListGroupOptions()) {
                    addElementIfNotExist(listFiltresGroupOption, current2);
                }
            }
            if (current.getListLabels()!=null) {
                for (Label current2 : current.getListLabels()) {
                    addElementIfNotExist(listFiltresLabel, current2);
                }
            }
            if (current.getListLocations()!=null) {
                for (Location current2 : current.getListLocations()) {
                    addElementIfNotExist(listFiltresLocation, current2);
                }
            }

            if (current.getListRentalMonthes()!=null) {
                for (RentalMonth current2 : current.getListRentalMonthes()) {
                    addElementIfNotExist(listFiltresRentalMonth, current2);
                }
            }

            if (current.getListServices()!=null) {
                for (Service current2 : current.getListServices()) {
                    addElementIfNotExist(listFiltresService, current2);
                }
            }
            if (current.getListSleepings()!=null) {
                for (Sleeping current2 : current.getListSleepings()) {
                    addElementIfNotExist(listFiltresSleeping, current2);
                }
            }
            if (current.getListStandingLevels()!=null) {
                for (StandingLevel current2 : current.getListStandingLevels()) {
                    addElementIfNotExist(listFiltresStandingLevel, current2);
                }
            }
            if (current.getListStations()!=null) {
                for (Station current2 : current.getListStations()) {
                    addElementIfNotExist(listFiltresStation, current2);
                }
            }

        }

        Log.d(TAG, "Number of Amenity received: " + listFiltresAmenity.size());
        Log.d(TAG, "Number of Animation received: " + listFiltresAnimation.size());
        Log.d(TAG, "Number of Atmospher received: " + listFiltresAtmospher.size());
        Log.d(TAG, "Number of Category received: " + listFiltresCategory.size());
        Log.d(TAG, "Number of Chain received: " + listFiltresChain.size());
        Log.d(TAG, "Number of City received: " + listFiltresCity.size());
        Log.d(TAG, "Number of FamilyOption received: " + listFiltresFamilyOption.size());
        Log.d(TAG, "Number of FurnishedRental received: " + listFiltresFurnishedRental.size());
        Log.d(TAG, "Number of GroupOption received: " + listFiltresGroupOption.size());
        Log.d(TAG, "Number of Label received: " + listFiltresLabel.size());
        Log.d(TAG, "Number of Location received: " + listFiltresLocation.size());

        Log.d(TAG, "Number of RentalMonth received: " + listFiltresRentalMonth.size());

        Log.d(TAG, "Number of Service received: " + listFiltresService.size());
        Log.d(TAG, "Number of Sleeping received: " + listFiltresSleeping.size());
        Log.d(TAG, "Number of StandingLevel received: " + listFiltresStandingLevel.size());
        Log.d(TAG, "Number of Station received: " + listFiltresStation.size());
    }

}
