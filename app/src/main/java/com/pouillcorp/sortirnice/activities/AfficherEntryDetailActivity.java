package com.pouillcorp.sortirnice.activities;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.DetailEntryEntitySimple;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAddressEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryDescriptionEntity;
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
import com.pouillcorp.sortirnice.enumeration.EntryAdresseDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherEntryDetailActivity extends NavDrawerActivity {

    EntryEntity entryTransmis;

    @BindView(R.id.name_fr)
    TextView nameFr;
    @BindView(R.id.category)
    TextView category;

    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.bloc_standing)
    LinearLayout blocStanding;
    @BindView(R.id.standing)
    TextView standing;
    @BindView(R.id.bloc_meuble)
    LinearLayout blocMeuble;
    @BindView(R.id.meuble)
    TextView meuble;
    @BindView(R.id.bloc_periode)
    LinearLayout blocPeriode;
    @BindView(R.id.periode)
    TextView periode;
    @BindView(R.id.couchage)
    TextView couchage;

    @BindView(R.id.bloc_couchage)
    LinearLayout blocCouchage;
    @BindView(R.id.bloc_chambre)
    LinearLayout blocChambre;
    @BindView(R.id.bloc_chambre_accessible)
    LinearLayout blocChambreAccessible;
    @BindView(R.id.bloc_chambre_appartement)
    LinearLayout blocChambreAppartement;
    @BindView(R.id.bloc_chambre_double)
    LinearLayout blocChambreDouble;
    @BindView(R.id.bloc_chambre_douche)
    LinearLayout blocChambreDouche;
    @BindView(R.id.bloc_chambre_etage)
    LinearLayout blocChambreEtage;
    @BindView(R.id.bloc_chambre_famille)
    LinearLayout blocChambreFamille;
    @BindView(R.id.bloc_chambre_sdb)
    LinearLayout blocChambreSdb;
    @BindView(R.id.bloc_chambre_single)
    LinearLayout blocChambreSingle;
    @BindView(R.id.bloc_chambre_studio)
    LinearLayout blocChambreStudio;
    @BindView(R.id.bloc_chambre_suite)
    LinearLayout blocChambreSuite;
    @BindView(R.id.bloc_chambre_surface)
    LinearLayout blocChambreSurface;
    @BindView(R.id.bloc_chambre_total)
    LinearLayout blocChambreTotal;
    @BindView(R.id.bloc_chambre_triple)
    LinearLayout blocChambreTriple;
    @BindView(R.id.bloc_chambre_twin)
    LinearLayout blocChambreTwin;
    @BindView(R.id.bloc_chambre_type)
    LinearLayout blocChambreType;

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
    @BindView(R.id.atmosphere)
    TextView atmosphere;
    @BindView(R.id.bloc_atmosphere)
    LinearLayout blocAtmosphere;
    @BindView(R.id.bloc_service)
    LinearLayout blocService;
    @BindView(R.id.service)
    TextView service;
    @BindView(R.id.bloc_address)
    LinearLayout blocAddress;
    @BindView(R.id.address_line1)
    TextView addressLine1;
    @BindView(R.id.address_line2)
    TextView addressLine2;
    @BindView(R.id.address_line3)
    TextView addressLine3;
    @BindView(R.id.adress_zip)
    TextView adressZip;
    @BindView(R.id.adress_city)
    TextView adressCity;
    @BindView(R.id.boutons_map_waze)
    LinearLayout boutonsMapWaze;
    @BindView(R.id.bloc_station)
    LinearLayout blocStation;
    @BindView(R.id.station)
    TextView station;
    @BindView(R.id.bloc_phone)
    LinearLayout blocPhone;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.bloc_fax)
    LinearLayout blocFax;
    @BindView(R.id.fax)
    TextView fax;
    @BindView(R.id.bloc_email)
    LinearLayout blocEmail;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.bloc_website)
    LinearLayout blocWebsite;
    @BindView(R.id.website)
    TextView website;
    @BindView(R.id.bloc_facebook)
    LinearLayout blocFacebook;
    @BindView(R.id.facebook)
    TextView facebook;
    @BindView(R.id.bloc_twitter)
    LinearLayout blocTwitter;
    @BindView(R.id.twitter)
    TextView twitter;
    @BindView(R.id.bloc_payment)
    LinearLayout blocPayment;
    @BindView(R.id.payment)
    TextView payment;
    @BindView(R.id.bloc_ouvert)
    LinearLayout blocOuvert;
    @BindView(R.id.opening)
    TextView opening;
    @BindView(R.id.openings)
    TextView openings;
    @BindView(R.id.bloc_ferme)
    LinearLayout blocFerme;
    @BindView(R.id.closure)
    TextView closure;
    @BindView(R.id.closing)
    TextView closing;
    @BindView(R.id.closings)
    TextView closings;
    @BindView(R.id.bloc_label)
    LinearLayout blocLabel;
    @BindView(R.id.label)
    TextView label;
    @BindView(R.id.bloc_animation)
    LinearLayout blocAnimation;
    @BindView(R.id.animation)
    TextView animation;
    @BindView(R.id.bloc_option)
    LinearLayout blocOption;
    @BindView(R.id.option)
    TextView option;
    @BindView(R.id.bloc_amenity)
    LinearLayout blocAmenity;
    @BindView(R.id.amenity)
    TextView amenity;
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
    @BindView(R.id.bloc_capacity)
    LinearLayout blocCapacity;
    @BindView(R.id.bloc_capacity_assis)
    LinearLayout blocCapacityAssis;
    @BindView(R.id.bloc_capacity_debout)
    LinearLayout blocCapacityDebout;
    @BindView(R.id.bloc_capacity_exterieur)
    LinearLayout blocCapacityExterieur;
    @BindView(R.id.bloc_capacity_group)
    LinearLayout blocCapacityGroup;
    @BindView(R.id.bloc_capacity_interieur)
    LinearLayout blocCapacityInterieur;
    @BindView(R.id.bloc_capacity_salle)
    LinearLayout blocCapacitySalle;
    @BindView(R.id.bloc_capacity_total)
    LinearLayout blocCapacityTotal;
    @BindView(R.id.bloc_sector)
    LinearLayout blocSector;
    @BindView(R.id.secto)
    TextView secto;

    Bitmap bitmap = null;

    @BindView(R.id.fabExit)
    FloatingActionButton fabExit;
    @BindView(R.id.fabFavoriAdd)
    FloatingActionButton fabFavoriAdd;
    @BindView(R.id.fabFavoriSuppr)
    FloatingActionButton fabFavoriSuppr;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    boolean isSauvegarde;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_detail_entry);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);


        setTitle("Detail Entry");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_entry).setChecked(true);
        traiterIntent();
    }

    public void changerCouleur() {
        if (entryTransmis.getFavori()) {
            scrollView.setBackgroundColor(getResources().getColor(R.color.favori));
        } else {
            scrollView.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("entryId")) {
            isSauvegarde = false;
            Long entryId = intent.getLongExtra("entryId", 0);
            entryTransmis = entryEntityDao.load(entryId);
            fillAllFields();
            hideFields();
            changerCouleur();
            //itemEntryType.setVisible(false);
        }
        if (intent.hasExtra("FromFavori") && intent.getBooleanExtra("FromFavori",false)) {
            Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
            bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).setChecked(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
        itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
        itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
        itemEntryType.setVisible(false);
        return true;
    }

    private void hideFields() {
            if (entryTransmis.getNameFr() == null) {
                nameFr.setVisibility(View.GONE);
            }
            if (entryTransmis.getListCategories() == null || entryTransmis.getListCategories().size() == 0) {
                category.setVisibility(View.GONE);
            }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomCount() == 0) {
            blocChambreTotal.setVisibility(View.GONE);
        } else {
            blocChambreTotal.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomBathCount() == 0) {
            blocChambreSdb.setVisibility(View.GONE);
        } else {
            blocChambreSdb.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomShowerCount() == 0) {
            blocChambreDouche.setVisibility(View.GONE);
        } else {
            blocChambreDouche.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getSuiteCount() == 0) {
            blocChambreSuite.setVisibility(View.GONE);
        } else {
            blocChambreSuite.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getStudioCount() == 0) {
            blocChambreStudio.setVisibility(View.GONE);
        } else {
            blocChambreStudio.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getApartmentCount() == 0) {
            blocChambreAppartement.setVisibility(View.GONE);
        } else {
            blocChambreAppartement.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getRoomAccessibleCount() == 0) {
            blocChambreAccessible.setVisibility(View.GONE);
        } else {
            blocChambreAccessible.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getSingleCount() == 0) {
            blocChambreSingle.setVisibility(View.GONE);
        } else {
            blocChambreSingle.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getDoubleCount() == 0) {
            blocChambreDouble.setVisibility(View.GONE);
        } else {
            blocChambreDouble.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getTripleCount() == 0) {
            blocChambreTriple.setVisibility(View.GONE);
        } else {
            blocChambreTriple.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getTwinsCount() == 0) {
            blocChambreTwin.setVisibility(View.GONE);
        } else {
            blocChambreTwin.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getFamilyCount() == 0) {
            blocChambreFamille.setVisibility(View.GONE);
        } else {
            blocChambreFamille.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getArea() == 0f) {
            blocChambreSurface.setVisibility(View.GONE);
        } else {
            blocChambreSurface.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getType() == null) {
            blocChambreType.setVisibility(View.GONE);
        } else {
            blocChambreType.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getLiving() == null || entryTransmis.getLiving().getFloor() == 0) {
            blocChambreEtage.setVisibility(View.GONE);
        } else {
            blocChambreEtage.setVisibility(View.VISIBLE);
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

        if (blocChambreTotal.getVisibility() == View.GONE && blocChambreSdb.getVisibility() == View.GONE && blocChambreDouche.getVisibility() == View.GONE
                && blocChambreSuite.getVisibility() == View.GONE && blocChambreStudio.getVisibility() == View.GONE && blocChambreAppartement.getVisibility() == View.GONE
                && blocChambreAccessible.getVisibility() == View.GONE && blocChambreSingle.getVisibility() == View.GONE && blocChambreDouble.getVisibility() == View.GONE
                && blocChambreTriple.getVisibility() == View.GONE && blocChambreTwin.getVisibility() == View.GONE && blocChambreFamille.getVisibility() == View.GONE
                && blocChambreType.getVisibility() == View.GONE && blocChambreEtage.getVisibility() == View.GONE) {
            blocChambre.setVisibility(View.GONE);
        } else {
            blocChambre.setVisibility(View.VISIBLE);
        }




        if (entryTransmis.getListStandingLevels() == null || entryTransmis.getListStandingLevels().size() == 0) {
            blocStanding.setVisibility(View.GONE);
        } else {
            blocStanding.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListFurnishedRentals() == null || entryTransmis.getListFurnishedRentals().size() == 0) {
            blocMeuble.setVisibility(View.GONE);
        } else {
            blocMeuble.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListRentalMonths() == null || entryTransmis.getListRentalMonths().size() == 0) {
            blocPeriode.setVisibility(View.GONE);
        } else {
            blocPeriode.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListSleepings() == null || entryTransmis.getListSleepings().size() == 0) {
            blocCouchage.setVisibility(View.GONE);
        } else {
            blocCouchage.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListDescriptions() == null || entryTransmis.getListDescriptions().size() == 0) {
            description.setVisibility(View.GONE);
        } else {
            description.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListAtmosphere() == null || entryTransmis.getListAtmosphere().size() == 0) {
            blocAtmosphere.setVisibility(View.GONE);
        } else {
            blocAtmosphere.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListServices() == null || entryTransmis.getListServices().size() == 0) {
            blocService.setVisibility(View.GONE);
        } else {
            blocService.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListLocations() == null || entryTransmis.getListLocations().size() == 0) {
            location.setVisibility(View.GONE);
        } else {
            location.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null && location.getVisibility() == View.GONE && (entryTransmis.getListStations() == null || entryTransmis.getListStations().size() == 0)) {
            blocAddress.setVisibility(View.GONE);
        } else {
            blocAddress.setVisibility(View.VISIBLE);
        }
        if ((entryTransmis.getAddress() == null || (entryTransmis.getAddress().getAddressLine1() == null
                && entryTransmis.getAddress().getAddressLine2() == null
                && entryTransmis.getAddress().getAddressLine3() == null
                && entryTransmis.getAddress().getZip() == null
                && entryTransmis.getAddress().getCity() == null)) && entryTransmis.getLongitude() == 0 && entryTransmis.getLatitude() == 0
                ) {
            boutonsMapWaze.setVisibility(View.GONE);
        } else {
            boutonsMapWaze.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null || entryTransmis.getAddress().getAddressLine1() == null) {
            addressLine1.setVisibility(View.GONE);
        } else {
            addressLine1.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null || entryTransmis.getAddress().getAddressLine2() == null) {
            addressLine2.setVisibility(View.GONE);
        } else {
            addressLine2.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null || entryTransmis.getAddress().getAddressLine3() == null) {
            addressLine3.setVisibility(View.GONE);
        } else {
            addressLine3.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null || entryTransmis.getAddress().getZip() == null) {
            adressZip.setVisibility(View.GONE);
        } else {
            adressZip.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getAddress() == null || entryTransmis.getAddress().getCity() == null) {
            adressCity.setVisibility(View.GONE);
        } else {
            adressCity.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListStations() == null || entryTransmis.getListStations().size() == 0) {
            blocStation.setVisibility(View.GONE);
        } else {
            blocStation.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getPhone() == null) {
            blocPhone.setVisibility(View.GONE);
        } else {
            blocPhone.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getFax() == null) {
            blocFax.setVisibility(View.GONE);
        } else {
            blocFax.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getEmail() == null) {
            blocEmail.setVisibility(View.GONE);
        } else {
            blocEmail.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getWebsite() == null) {
            blocWebsite.setVisibility(View.GONE);
        } else {
            blocWebsite.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getFacebook() == null) {
            blocFacebook.setVisibility(View.GONE);
        } else {
            blocFacebook.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getTwitter() == null) {
            blocTwitter.setVisibility(View.GONE);
        } else {
            blocTwitter.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListPayments() == null || entryTransmis.getListPayments().size() == 0) {
            blocPayment.setVisibility(View.GONE);
        } else {
            blocPayment.setVisibility(View.VISIBLE);
        }
        if ((entryTransmis.getListOpenings() == null || entryTransmis.getListOpenings().size() == 0) && entryTransmis.getOpening() == null) {
            blocOuvert.setVisibility(View.GONE);
        } else {
            blocOuvert.setVisibility(View.VISIBLE);
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
            blocLabel.setVisibility(View.GONE);
        } else {
            blocLabel.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListAnimations() == null || entryTransmis.getListAnimations().size() == 0) {
            blocAnimation.setVisibility(View.GONE);
        } else {
            blocAnimation.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListOptions() == null || entryTransmis.getListOptions().size() == 0) {
            blocOption.setVisibility(View.GONE);
        } else {
            blocOption.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getListAmenities() == null || entryTransmis.getListAmenities().size() == 0) {
            blocAmenity.setVisibility(View.GONE);
        } else {
            blocAmenity.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getGroup() == 0) {
            blocCapacityGroup.setVisibility(View.GONE);
        } else {
            blocCapacityGroup.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getCocktail() == 0) {
            blocCapacityDebout.setVisibility(View.GONE);
        } else {
            blocCapacityDebout.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getSeated() == 0) {
            blocCapacityAssis.setVisibility(View.GONE);
        } else {
            blocCapacityAssis.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getOutdoor() == 0) {
            blocCapacityExterieur.setVisibility(View.GONE);
        } else {
            blocCapacityExterieur.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getIndoor() == 0) {
            blocCapacityInterieur.setVisibility(View.GONE);
        } else {
            blocCapacityInterieur.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getTotal() == 0) {
            blocCapacityTotal.setVisibility(View.GONE);
        } else {
            blocCapacityTotal.setVisibility(View.VISIBLE);
        }
        if (entryTransmis.getCapacity() == null || entryTransmis.getCapacity().getRoomCount() == 0) {
            blocCapacitySalle.setVisibility(View.GONE);
        } else {
            blocCapacitySalle.setVisibility(View.VISIBLE);
        }
        if (blocCapacityGroup.getVisibility() == View.GONE && blocCapacityDebout.getVisibility() == View.GONE
                 && blocCapacityAssis.getVisibility() == View.GONE && blocCapacityExterieur.getVisibility() == View.GONE
                    && blocCapacityInterieur.getVisibility() == View.GONE && blocCapacityTotal.getVisibility() == View.GONE) {
            blocCapacity.setVisibility(View.GONE);
        } else {
            blocCapacity.setVisibility(View.VISIBLE);
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
        if (entryTransmis.getListClosures() != null){
            for (EntryClosureEntity closures : entryTransmis.getListClosures()){
                if (closures.getDate() == null && closures.getClosureSpan() == null && closures.getClosureDay() == null) {
                    closure.setVisibility(View.GONE);
                } else {
                    closure.setVisibility(View.VISIBLE);
                }
            }
        }
        if (closings.getVisibility() == View.GONE && closing.getVisibility() == View.GONE
                && closure.getVisibility() == View.GONE) {
            blocFerme.setVisibility(View.GONE);
        } else {
            blocFerme.setVisibility(View.VISIBLE);
        }
            if (entryTransmis.getListSectors() == null || entryTransmis.getListSectors().size() == 0) {
                blocSector.setVisibility(View.GONE);
            }
        if (entryTransmis.getFavori()) {
            fabFavoriAdd.setVisibility(View.GONE);
        } else {
            fabFavoriSuppr.setVisibility(View.GONE);
        }
    }

    private String getAdresseRenseignee(EntryAddressEntity adresse, EntryAdresseDetail detail) {
        if (adresse != null) {
                    if (detail.toString().equalsIgnoreCase(EntryAdresseDetail.Adresse1.toString())){
                        if (adresse.getAddressLine1() != null && !adresse.getAddressLine1().equalsIgnoreCase("")){
                            return adresse.getAddressLine1();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EntryAdresseDetail.Adresse2.toString())){
                        if (adresse.getAddressLine2() != null && !adresse.getAddressLine2().equalsIgnoreCase("")){
                            return adresse.getAddressLine2();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EntryAdresseDetail.Adresse3.toString())){
                        if (adresse.getAddressLine3() != null && !adresse.getAddressLine3().equalsIgnoreCase("")){
                            return adresse.getAddressLine3();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EntryAdresseDetail.Zip.toString())){
                        if (adresse.getZip() != null && !adresse.getZip().equalsIgnoreCase("")){
                            return adresse.getZip();
                        }
                    } else if (detail.toString().equalsIgnoreCase(EntryAdresseDetail.Ville.toString())){
                        if (adresse.getCity() != null && !adresse.getCity().equalsIgnoreCase("")){
                            return adresse.getCity();
                        }
                    }
        }
        return null;
    }

    private String getDetailListe(List<? extends DetailEntryEntitySimple> list) {
        String reponse = "";
        int cptr = 0;
        if (list != null && list.size() > 0) {
            for (DetailEntryEntitySimple current : list) {
                if (cptr == 0) {
                    reponse += current.getValue();
                    cptr++;
                } else {
                    reponse += " / "+current.getValue();
                }
            }
            return reponse;
        }
        return null;
    }

    private void fillAllFields() {
        roomCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getRoomCount() : null));
        roomBathCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getRoomBathCount() : null));
        roomShowerCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getRoomShowerCount() : null));
        suiteCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getSuiteCount() : null));
        studioCount.setText("Nb Studio: "+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getStudioCount() : null));
        apartmentCount.setText("Nb Appart: "+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getApartmentCount() : null));
        roomAccessibleCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getRoomAccessibleCount() : null));
        singleCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getSingleCount() : null));
        doubleCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getDoubleCount() : null));
        tripleCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getTripleCount() : null));
        twinsCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getTwinsCount() : null));
        familyCount.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getFamilyCount() : null));
        area.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getArea() : null)+" m²");
        type.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getType() : null));
        floor.setText(""+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getFloor() : null));
        bedroomCount.setText("Chambre: "+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getBedroomCount() : null));
        sleepsCount.setText("Couchage: "+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getSleepsCount() : null));
        furnishedRoomCount.setText("Chambre Meuble: "+(entryTransmis.getLiving() != null ? entryTransmis.getLiving().getFurnishedRoomCount() : null));

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
        addressLine1.setText(entryTransmis.getAddress() != null ? entryTransmis.getAddress().getAddressLine1() : null);
        addressLine2.setText(entryTransmis.getAddress() != null ? entryTransmis.getAddress().getAddressLine2() : null);
        addressLine3.setText(entryTransmis.getAddress() != null ? entryTransmis.getAddress().getAddressLine3() : null);
        adressZip.setText(entryTransmis.getAddress() != null ? entryTransmis.getAddress().getZip() : null);
        adressCity.setText(entryTransmis.getAddress() != null ? entryTransmis.getAddress().getCity() : null);
        phone.setText(entryTransmis.getPhone());
        fax.setText(entryTransmis.getFax());
        email.setText(entryTransmis.getEmail());
        website.setText(entryTransmis.getWebsite());
        facebook.setText(entryTransmis.getFacebook());
        twitter.setText(entryTransmis.getTwitter());
        opening.setText(entryTransmis.getOpening());
        closing.setText(entryTransmis.getClosing());
        capacityTotal.setText(""+(entryTransmis.getCapacity() != null ? entryTransmis.getCapacity().getTotal()  : null));
        capacityInterieur.setText(""+(entryTransmis.getCapacity() != null ? entryTransmis.getCapacity().getIndoor()  : null));
        capacityExterieur.setText(""+(entryTransmis.getCapacity() != null ? entryTransmis.getCapacity().getOutdoor()  : null));
        capacityAssis.setText(""+(entryTransmis.getCapacity() != null ? entryTransmis.getCapacity().getSeated()  : null));
        capacityDebout.setText(""+(entryTransmis.getCapacity() != null ? entryTransmis.getCapacity().getCocktail()  : null));
        capacityGroup.setText(""+(entryTransmis.getCapacity() != null ? entryTransmis.getCapacity().getGroup()  : null));
        capacitySalle.setText(""+(entryTransmis.getCapacity() != null ? entryTransmis.getCapacity().getRoomCount()  : null));

        String descriptionString = "";
        if (entryTransmis.getListDescriptions()!=null) {
            int i = 1;
            for (EntryDescriptionEntity current : entryTransmis.getListDescriptions()) {
                descriptionString += current.getValue();
                if (i < entryTransmis.getListDescriptions().size()) {
                    descriptionString += newLine;
                }
                i++;
            }
        }
        description.setText(descriptionString);

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
            for (EntryClosureEntity closure : entryTransmis.getListClosures()) {
                        if (closure.getClosureDay() != null && closure.getClosureSpan() != null) {
                            closureString += closure.getClosureDay() + " - " + closure.getClosureSpan();
                        } else if (closure.getDate()!=null){
                            closureString += closure.getDate();
                        }
                        if (i < entryTransmis.getListClosures().size()) {
                            closureString += newLine;
                        }
                        i++;
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

    public void exit(View view) {
        finish();
    }

    public void favoriAdd(View view) {
        entryTransmis.setFavori(true);
        entryEntityDao.update(entryTransmis);
        fabFavoriAdd.setVisibility(View.GONE);
        fabFavoriSuppr.setVisibility(View.VISIBLE);
        changerCouleur();
    }

    public void favoriDelete(View view) {
        entryTransmis.setFavori(false);
        entryEntityDao.update(entryTransmis);
        fabFavoriAdd.setVisibility(View.VISIBLE);
        fabFavoriSuppr.setVisibility(View.GONE);
        changerCouleur();
    }

    public void launchGoogleMap(View view) {
        String url = "geo:";
        String addr = "";
        if (entryTransmis.getLatitude() != 0 && entryTransmis.getLongitude() != 0) {
            url += entryTransmis.getLatitude()+","+entryTransmis.getLongitude();
            url += "?q="+entryTransmis.getLatitude()+","+entryTransmis.getLongitude();
        } else if (getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse1) != null
                || getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse2) != null
                || getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse3) != null
                    || getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Zip) != null
                    || getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Ville) != null) {
            url += "0,0?q=";
            addr += Uri.parse(getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse1)
                                +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse2)
                                +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse3)
                                +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Zip)
                                +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Ville));
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
            if (entryTransmis.getLatitude() !=0d && entryTransmis.getLongitude()!=0d) {
                url = "https://waze.com/ul?ll=";
                url += entryTransmis.getLatitude()+","+entryTransmis.getLongitude()+"&navigate=yes";
            } else {
                url = "https://waze.com/ul?q=";
                url += getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse1)
                        +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse2)
                        +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Adresse3)
                        +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Zip)
                        +" "+ getAdresseRenseignee(entryTransmis.getAddress(), EntryAdresseDetail.Ville);
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
                    +entryTransmis.getLatitude()
                    +"&dest_lon="
                    +entryTransmis.getLongitude()
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