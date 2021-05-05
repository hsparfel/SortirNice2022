package com.pouillos.sortirnice.activities;

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
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillos.sortirnice.App;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.entities.entry.EntryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFurnishedRentalEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryGridEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOpeningEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryRentalMonthEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySleepingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStandingLevelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStationEntity;
import com.pouillos.sortirnice.enumeration.EntriesType;
import com.pouillos.sortirnice.modelentries.Amenity;
import com.pouillos.sortirnice.modelentries.Animation;
import com.pouillos.sortirnice.modelentries.Atmospher;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Closing;
import com.pouillos.sortirnice.modelentries.Closure;
import com.pouillos.sortirnice.modelentries.Closures;
import com.pouillos.sortirnice.modelentries.Entry;
import com.pouillos.sortirnice.modelentries.FurnishedRental;
import com.pouillos.sortirnice.modelentries.Grid;
import com.pouillos.sortirnice.modelentries.Label;
import com.pouillos.sortirnice.modelentries.Location;
import com.pouillos.sortirnice.modelentries.Opening;
import com.pouillos.sortirnice.modelentries.Option;
import com.pouillos.sortirnice.modelentries.Payment;
import com.pouillos.sortirnice.modelentries.RentalMonth;
import com.pouillos.sortirnice.modelentries.Service;
import com.pouillos.sortirnice.modelentries.Sleeping;
import com.pouillos.sortirnice.modelentries.StandingLevel;
import com.pouillos.sortirnice.modelentries.Station;
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
import retrofit2.Retrofit;

public class NavDrawerEntryActivity extends NavDrawerActivity {


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
    @BindView(R.id.name_fr)
    TextView nameFr;
    @BindView(R.id.description)
    TextView description;
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
    @BindView(R.id.layout_station)
    LinearLayout layoutStation;
    @BindView(R.id.layout_pratique)
    LinearLayout layoutPratique;

    @BindView(R.id.layout_standing)
    LinearLayout layoutStanding;
    @BindView(R.id.standing)
    TextView standing;

    @BindView(R.id.layout_meuble)
    LinearLayout layoutMeuble;
    @BindView(R.id.meuble)
    TextView meuble;

    @BindView(R.id.layout_periode)
    LinearLayout layoutPeriode;
    @BindView(R.id.periode)
    TextView periode;

    @BindView(R.id.couchage)
    TextView couchage;

    @BindView(R.id.room_count)
    TextView roomCount;
    @BindView(R.id.room_bath_count)
    TextView roomBathCount;
    @BindView(R.id.room_shower_count)
    TextView roomShowerCount;
    @BindView(R.id.suite_count)
    TextView suiteCount;
    @BindView(R.id.studio_count)
    TextView studioCount;
    @BindView(R.id.apartment_count)
    TextView apartmentCount;
    @BindView(R.id.room_accessible_count)
    TextView roomAccessibleCount;
    @BindView(R.id.single_count)
    TextView singleCount;
    @BindView(R.id.double_count)
    TextView doubleCount;
    @BindView(R.id.triple_count)
    TextView tripleCount;
    @BindView(R.id.twins_count)
    TextView twinsCount;
    @BindView(R.id.family_count)
    TextView familyCount;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.floor)
    TextView floor;
    @BindView(R.id.bedroom_count)
    TextView bedroomCount;
    @BindView(R.id.sleeps_count)
    TextView sleepsCount;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listEntries = new ArrayList<>();
        nbEntries = 0;
        dateDemande = new Date();
        dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
        myUrl += dateDemandeString+"/";

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

                        afficherDetail(true);
                    }
                });
    }

    public void afficherDetail(boolean bool) {
        scrollView.fullScroll(View.FOCUS_UP);
        if (bool) {
            scrollView.fullScroll(View.FOCUS_UP);
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
        if (entryTransmis.getListClosures() == null){
            //for (EntryClosureEntity closures : entryTransmis.getListClosures()){
               // if (closures.getListClosure() == null || closures.getListClosure().size() == 0) {
                    closure.setVisibility(View.GONE);
                } else {
                    closure.setVisibility(View.VISIBLE);
                }
           // }
        //}
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



}
