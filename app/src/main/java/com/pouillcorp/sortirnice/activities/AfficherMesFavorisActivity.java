package com.pouillcorp.sortirnice.activities;


import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.DetailEntryEntitySimple;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAddressEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryChainEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryFamilyOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryFurnishedRentalEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryGridEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryGroupOptionEntity;
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
import com.pouillcorp.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillcorp.sortirnice.modelentries.Address;
import com.pouillcorp.sortirnice.modelentries.Amenity;
import com.pouillcorp.sortirnice.modelentries.Animation;
import com.pouillcorp.sortirnice.modelentries.Atmospher;
import com.pouillcorp.sortirnice.modelentries.Category;
import com.pouillcorp.sortirnice.modelentries.Chain;
import com.pouillcorp.sortirnice.modelentries.Closing;
import com.pouillcorp.sortirnice.modelentries.Closure;
import com.pouillcorp.sortirnice.modelentries.Closures;
import com.pouillcorp.sortirnice.modelentries.DetailEntrySimple;
import com.pouillcorp.sortirnice.modelentries.Entries;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.modelentries.FamilyOption;
import com.pouillcorp.sortirnice.modelentries.FurnishedRental;
import com.pouillcorp.sortirnice.modelentries.Grid;
import com.pouillcorp.sortirnice.modelentries.GroupOption;
import com.pouillcorp.sortirnice.modelentries.Label;
import com.pouillcorp.sortirnice.modelentries.Location;
import com.pouillcorp.sortirnice.modelentries.Opening;
import com.pouillcorp.sortirnice.modelentries.Option;
import com.pouillcorp.sortirnice.modelentries.Payment;
import com.pouillcorp.sortirnice.modelentries.RentalMonth;
import com.pouillcorp.sortirnice.modelentries.Service;
import com.pouillcorp.sortirnice.modelentries.Sleeping;
import com.pouillcorp.sortirnice.modelentries.StandingLevel;
import com.pouillcorp.sortirnice.modelentries.Station;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntriesSauvegarde;
import com.pouillcorp.sortirnice.utils.DateUtils;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.Collections;
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

public class AfficherMesFavorisActivity extends NavDrawerEntryActivity implements RecyclerAdapterEntriesSauvegarde.Listener {

    //private EntriesType entryType = EntriesType.Boutique;
    List<EntryEntity> listEntriesFiltres = new ArrayList<>();
    EntryEntity selectedEntry;
    List<EntryEntity> listEntries = new ArrayList<>();

    @Nullable
    @BindView(R.id.radio_button_entries)
    MaterialRadioButton rbEntries;

    @Nullable
    @BindView(R.id.radio_button_events)
    MaterialRadioButton rbEvents;

    @Nullable
    @BindView(R.id.chipGroup)
    ChipGroup chipGroup;

    @Nullable
    @BindView(R.id.chip_visit)
    Chip chipVisit;
    @Nullable
    @BindView(R.id.chip_boutique)
    Chip chipBoutique;
    @Nullable
    @BindView(R.id.chip_hebergement)
    Chip chipHebergement;
    @Nullable
    @BindView(R.id.chip_hotel)
    Chip chipHotel;
    @Nullable
    @BindView(R.id.chip_transport)
    Chip chipTransport;
    @Nullable
    @BindView(R.id.chip_utile)
    Chip chipUtile;
    @Nullable
    @BindView(R.id.chip_shopping)
    Chip chipShopping;
    @Nullable
    @BindView(R.id.chip_sortie)
    Chip chipSortie;
    @Nullable
    @BindView(R.id.chip_restaurant)
    Chip chipRestaurant;

    List<Chip> listChips = new ArrayList<>();
    List<EntryEntity> listEntriesChipFiltred = new ArrayList<>();
    List<EntryEntity> listEntriesFiltresAndChipFiltred = new ArrayList<>();

    @Nullable
    @BindView(R.id.list_recycler_event)
    RecyclerView recyclerView;

    @Nullable
    @BindView(R.id.btn_afficher_type_entries)
    ImageView btnAfficherTypeEntries;

    List<EntryAmenityEntity> listFiltresAmenity = new ArrayList<>();
    List<EntryAnimationEntity> listFiltresAnimation = new ArrayList<>();
    List<EntryAtmospherEntity> listFiltresAtmospher = new ArrayList<>();
    List<EntryCategoryEntity> listFiltresCategory = new ArrayList<>();
    List<EntryChainEntity> listFiltresChain = new ArrayList<>();
    List<EntryFamilyOptionEntity> listFiltresFamilyOption = new ArrayList<>();
    List<EntryFurnishedRentalEntity> listFiltresFurnishedRental = new ArrayList<>();
    List<EntryAddressEntity> listFiltresCity = new ArrayList<>();
    List<EntryGroupOptionEntity> listFiltresGroupOption = new ArrayList<>();
    List<EntryLabelEntity> listFiltresLabel = new ArrayList<>();


    List<EntryLocationEntity> listFiltresLocation = new ArrayList<>();
    List<EntryRentalMonthEntity> listFiltresRentalMonth = new ArrayList<>();

    List<EntryServiceEntity> listFiltresService = new ArrayList<>();
    List<EntrySleepingEntity> listFiltresSleeping = new ArrayList<>();
    List<EntryStandingLevelEntity> listFiltresStandingLevel = new ArrayList<>();
    List<EntryStationEntity> listFiltresStation = new ArrayList<>();

//todo creer des filtres pour events
// (Cinéma, Conférence, Danse, Divers, Exposition, Fêtes et animations, Musique classique, Musique,
// Musiques autres, Salon professionnel, Salon, Spectacle, Sport, Théâtre)




    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_mes_favoris);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        setTitle("Mes Favoris");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).setChecked(true);


        //connectAndGetApiData(myUrl);
        progressBar.setVisibility(View.VISIBLE);
        AsyncTaskRunnerBD runnerBD = new AsyncTaskRunnerBD();
        runnerBD.execute();
        Log.e("verif menuItem", "menuItem : "+menuItems);
        Log.e("verif item", "item : "+item);
        //item = menuItems.findItem(R.id.menu_activity_main_filter);
        //item.setVisible(true);
        btnAfficherTypeEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAfficherTypeEntries.setVisibility(View.VISIBLE);
                if (chipGroup.isShown()){
                    btnAfficherTypeEntries.setImageResource(R.drawable.outline_arrow_drop_down_black_24);
                    chipGroup.setVisibility(View.GONE);
                } else {
                    btnAfficherTypeEntries.setImageResource(R.drawable.outline_arrow_drop_up_black_24);
                    chipGroup.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void fillAllFields() {

        //todo verif si null
        if (selectedEntry.getLiving() != null ) {
            roomCount.setText("Nb Chambre: " + selectedEntry.getLiving().getRoomCount());
            roomBathCount.setText("Nb Chambre avec Sdb: " + selectedEntry.getLiving().getRoomBathCount());
            roomShowerCount.setText("Nb Chambre avec Douche: " + selectedEntry.getLiving().getRoomShowerCount());
            suiteCount.setText("Nb Chambre Suite: " + selectedEntry.getLiving().getSuiteCount());
            studioCount.setText("Nb Studio: " + selectedEntry.getLiving().getStudioCount());
            apartmentCount.setText("Nb Appart: " + selectedEntry.getLiving().getApartmentCount());
            roomAccessibleCount.setText("Nb Chambre Accessible: " + selectedEntry.getLiving().getRoomAccessibleCount());
            singleCount.setText("Nb Chambre Simple: " + selectedEntry.getLiving().getSingleCount());
            doubleCount.setText("Nb Chambre Double: " + selectedEntry.getLiving().getDoubleCount());
            tripleCount.setText("Nb Chambre Triple: " + selectedEntry.getLiving().getTripleCount());
            twinsCount.setText("Nb Chambre Twin: " + selectedEntry.getLiving().getTwinsCount());
            familyCount.setText("Nb Chambre Famille: " + selectedEntry.getLiving().getFamilyCount());
            area.setText("Surface: " + selectedEntry.getLiving().getArea() + " m²");
            type.setText("Type: " + selectedEntry.getLiving().getType());
            floor.setText("Etage: " + selectedEntry.getLiving().getFloor());
            bedroomCount.setText("Nb Chambre: " + selectedEntry.getLiving().getBedroomCount());
            sleepsCount.setText("Nb Couchage: " + selectedEntry.getLiving().getSleepsCount());
            furnishedRoomCount.setText("Nb Chambre Meuble: " + selectedEntry.getLiving().getFurnishedRoomCount());
        }

        String standingString = "";
        if (selectedEntry.getListStandingLevels()!=null) {
            int i = 1;
            for (EntryStandingLevelEntity current : selectedEntry.getListStandingLevels()) {
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
            for (EntryFurnishedRentalEntity current : selectedEntry.getListFurnishedRentals()) {
                meubleString += current.getValue();
                if (i < selectedEntry.getListFurnishedRentals().size()) {
                    meubleString += newLine;
                }
                i++;
            }
        }
        meuble.setText(meubleString);

        String periodeString = "";
        if (selectedEntry.getListRentalMonths()!=null) {
            int i = 1;
            for (EntryRentalMonthEntity current : selectedEntry.getListRentalMonths()) {
                periodeString += current.getValue();
                if (i < selectedEntry.getListRentalMonths().size()) {
                    periodeString += newLine;
                }
                i++;
            }
        }
        periode.setText(periodeString);

        String couchageString = "";
        if (selectedEntry.getListSleepings()!=null) {
            int i = 1;
            for (EntrySleepingEntity current : selectedEntry.getListSleepings()) {
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
            //if (selectedEntry.getListDescriptions().get(0).getLanguage().equalsIgnoreCase("fr") &&
             //       selectedEntry.getListDescriptions().get(0).getType().equalsIgnoreCase("Publique")) {
                description.setText(selectedEntry.getListDescriptions().get(0).getValue());
           // }
        }

        String paymentString = "";
        if (selectedEntry.getListPayments()!=null) {
            int i = 1;
            for (EntryPaymentEntity current : selectedEntry.getListPayments()) {
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
            for (EntryAmenityEntity current : selectedEntry.getListAmenities()) {
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
            for (EntryLocationEntity current : selectedEntry.getListLocations()) {
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


        //todo revoir la closure en liste comme dans l'entry de base
        String closureString = "";
        if (selectedEntry.getListClosures()!=null) {
            int i = 1;
            for (EntryClosureEntity closures : selectedEntry.getListClosures()) {
                //if (closures.get() != null) {
                    //for (Closure current : closures.getListClosure()) {
                        if (closures.getClosureDay() != null && closures.getClosureSpan() != null) {
                            closureString += closures.getClosureDay() + " - " + closures.getClosureSpan();
                        } else if (closures.getDate()!=null){
                            closureString += closures.getDate();
                        }
                        if (i < selectedEntry.getListClosures().size()) {
                            closureString += newLine;
                        }
                        i++;
                   // }
               // }
            }
        }
        closure.setText(closureString);

        String labelString = "";
        if (selectedEntry.getListLabels()!=null) {
            int i = 1;
            for (EntryLabelEntity current : selectedEntry.getListLabels()) {
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
            for (EntryOptionEntity current : selectedEntry.getListOptions()) {
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
            for (EntryOpeningEntity current : selectedEntry.getListOpenings()) {
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
            for (EntryClosingEntity current : selectedEntry.getListClosings()) {
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
            for (EntryServiceEntity current : selectedEntry.getListServices()) {
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
            for (EntryStationEntity current : selectedEntry.getListStations()) {
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
            for (EntryAnimationEntity current : selectedEntry.getListAnimations()) {
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
            for (EntryCategoryEntity current : selectedEntry.getListCategories()) {
                if (current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.toute_boutique))
                        || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.sortir_a_nice))
                        || current.getValue().equalsIgnoreCase(App.getRes().getString(R.string.infos_pratiques))) {
                    w++;
                }
            }
            for (EntryCategoryEntity current : selectedEntry.getListCategories()) {
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
            for (EntryAtmospherEntity current : selectedEntry.getListAtmosphere()) {
                atmosphereString += current.getValue();
                if (i < selectedEntry.getListAtmosphere().size()) {
                    atmosphereString += " / ";
                }
                i++;
            }
        }
        atmosphere.setText(atmosphereString);
    }

    @Override
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
        if (selectedEntry.getListRentalMonths() == null || selectedEntry.getListRentalMonths().size() == 0) {
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
        if (selectedEntry.getAddress() != null && selectedEntry.getAddress().getAddressLine1() == null
                && selectedEntry.getAddress().getAddressLine2() == null
                && selectedEntry.getAddress().getAddressLine3() == null
                && selectedEntry.getAddress().getZip() == null
                && selectedEntry.getAddress().getCity() == null) {
            boutonsMapWaze.setVisibility(View.GONE);
        } else {
            boutonsMapWaze.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress() != null && selectedEntry.getAddress().getAddressLine1() == null) {
            addressLine1.setVisibility(View.GONE);
        } else {
            addressLine1.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress() != null && selectedEntry.getAddress().getAddressLine2() == null) {
            addressLine2.setVisibility(View.GONE);
        } else {
            addressLine2.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress() != null && selectedEntry.getAddress().getAddressLine3() == null) {
            addressLine3.setVisibility(View.GONE);
        } else {
            addressLine3.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress() != null && selectedEntry.getAddress().getZip() == null) {
            addressZip.setVisibility(View.GONE);
        } else {
            addressZip.setVisibility(View.VISIBLE);
        }
        if (selectedEntry.getAddress() != null && selectedEntry.getAddress().getCity() == null) {
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
            for (EntryClosureEntity closures : selectedEntry.getListClosures()){
                if (closures.getClosureDay() == null && closures.getClosureSpan() == null && closures.getDate() == null) {
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

    @Override
    protected void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        //ouvrirActiviteSuivante(AfficherEntriesBoutiqueActivity.this, AfficherEntryBoutiqueDetailActivity.class,"entryId",listEntryEntities.get(position).getId(),false);
                        Log.e("TAG", "Position : "+position);
                        if (rbEntries.isChecked()){
                            if (listEntriesFiltresAndChipFiltred.size()>0){
                                selectedEntry = listEntriesFiltresAndChipFiltred.get(position);
                            } else if (listEntriesFiltres.size()>0){
                                selectedEntry = listEntriesFiltres.get(position);
                            } else if (listEntriesChipFiltred.size()>0){
                                selectedEntry = listEntriesChipFiltred.get(position);
                            } else {
                                selectedEntry = listEntries.get(position);
                            }
                        }

                        /*if (listEntriesFiltres.size()>0){
                            selectedEntry = listEntriesFiltres.get(position);
                        } else {
                            selectedEntry = listEntries.get(position);
                        }*/
                        scrollView.fullScroll(View.FOCUS_UP);
                        fillAllFields();
                        hideFields();
                        AsyncTaskRunnerImage runnerImage = new AsyncTaskRunnerImage();
                        runnerImage.execute();
                        item = menuItems.findItem(R.id.menu_activity_main_entry_filter);
                        item.setVisible(false);
                        afficherDetail(true);
                        fabSave.hide();
                    }
                });
    }



    public void initMasquerFiltreSiScroll(){
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                //if (dy > 0)
                if (dy > 0 ||dy<0 && chipGroup.isShown())
                {
                    chipGroup.setVisibility(View.GONE);

                }

            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
            {
                if (newState == RecyclerView.SCROLL_STATE_IDLE)
                {
                    chipGroup.setVisibility(View.GONE);
                    btnAfficherTypeEntries.setVisibility(View.VISIBLE);
                    btnAfficherTypeEntries.setImageResource(R.drawable.outline_arrow_drop_down_black_24);
                }

                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    public void initListChips() {
        chipBoutique.setVisibility(View.GONE);
        chipShopping.setVisibility(View.GONE);
        chipSortie.setVisibility(View.GONE);
        chipRestaurant.setVisibility(View.GONE);
        chipTransport.setVisibility(View.GONE);
        chipHebergement.setVisibility(View.GONE);
        chipHotel.setVisibility(View.GONE);
        chipUtile.setVisibility(View.GONE);
        chipVisit.setVisibility(View.GONE);

        for (EntryEntity current : listEntries){
            EntriesType entryType = current.getEntryType();
            switch (entryType) {
                case Boutique:
                    chipBoutique.setVisibility(View.VISIBLE);
                    break;
                case Shopping:
                    chipShopping.setVisibility(View.VISIBLE);
                    break;
                case Sortie:
                    chipSortie.setVisibility(View.VISIBLE);
                    break;
                case Restaurant:
                    chipRestaurant.setVisibility(View.VISIBLE);
                    break;
                case Transport:
                    chipTransport.setVisibility(View.VISIBLE);
                    break;
                case Hebergement:
                    chipHebergement.setVisibility(View.VISIBLE);
                    break;
                case Hotel:
                    chipHotel.setVisibility(View.VISIBLE);
                    break;
                case Utile:
                    chipUtile.setVisibility(View.VISIBLE);
                    break;
                case Visite:
                    chipVisit.setVisibility(View.VISIBLE);
                    break;

            }
        }



        listChips.add(chipVisit);
        listChips.add(chipHebergement);
        listChips.add(chipHotel);
        listChips.add(chipTransport);
        listChips.add(chipUtile);
        listChips.add(chipSortie);
        listChips.add(chipRestaurant);
        listChips.add(chipShopping);
        listChips.add(chipBoutique);
    }

    public void majChipFiltre(){
        listEntriesChipFiltred.clear();
        listEntriesFiltresAndChipFiltred.clear();
        for (Chip current : listChips) {
            if (current.isChecked()){
                for (EntryEntity current2 : listEntries){
                    if (current == chipVisit && current2.getEntryType()== entryType.Visite) {
                        listEntriesChipFiltred.add(current2);
                    }
//todo faire les 8 autrs
                    if (current == chipBoutique && current2.getEntryType()==entryType.Boutique) {
                        listEntriesChipFiltred.add(current2);
                    }
                    if (current == chipHebergement && current2.getEntryType()==entryType.Hebergement) {
                        listEntriesChipFiltred.add(current2);
                    }
                    if (current == chipHotel && current2.getEntryType()==entryType.Hotel) {
                        listEntriesChipFiltred.add(current2);
                    }
                    if (current == chipShopping && current2.getEntryType()==entryType.Shopping) {
                        listEntriesChipFiltred.add(current2);
                    }
                    if (current == chipSortie && current2.getEntryType()==entryType.Sortie) {
                        listEntriesChipFiltred.add(current2);
                    }
                    if (current == chipTransport && current2.getEntryType()==entryType.Transport) {
                        listEntriesChipFiltred.add(current2);
                    }
                    if (current == chipUtile && current2.getEntryType()==entryType.Utile) {
                        listEntriesChipFiltred.add(current2);
                    }
                    if (current == chipRestaurant && current2.getEntryType()==entryType.Restaurant) {
                        listEntriesChipFiltred.add(current2);
                    }
                }
            }
        }
        for (EntryEntity current : listEntriesChipFiltred) {
            if (listEntriesFiltres.contains(current)){
                listEntriesFiltresAndChipFiltred.add(current);
            }
        }
        boolean isOneChipSelected = false;
        for (Chip current : listChips) {
            if (current.isChecked()) {
                isOneChipSelected = true;
            }
        }
        if (isOneChipSelected) {
            if (listEntriesFiltresAndChipFiltred.size()>0){
                configureRecyclerView2(listEntriesFiltresAndChipFiltred);
            } else {
                configureRecyclerView2(listEntriesChipFiltred);
            }
        } else {
           // if (listEntriesFiltres.size()>0){
           //     configureRecyclerView2(listEntriesFiltres);
           // } else {
                configureRecyclerView2(listEntries);
                decocherTout();
          //  }
        }
    }

    public void initRadioButtonsClick(){
        rbEntries.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbEntries.setChecked(true);
                    rbEvents.setChecked(false);
                    chipGroup.setVisibility(View.VISIBLE);
                    majChipFiltre();
                    item = menuItems.findItem(R.id.menu_activity_main_entry_filter);
                    item.setVisible(true);
                    listEntriesChipFiltred.clear();
                    listEntriesFiltres.clear();
                    listEntriesFiltresAndChipFiltred.clear();
                } else {
                    rbEntries.setChecked(false);
                    chipGroup.setVisibility(View.GONE);
                }
            }
        });

        rbEvents.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rbEvents.setChecked(true);
                    rbEntries.setChecked(false);
                    chipGroup.setVisibility(View.GONE);
                } else {
                    rbEvents.setChecked(false);
                    chipGroup.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void initAllChipsClick() {
        for (Chip current : listChips){
            initChipsClick(current);
        }
    }

    public void initChipsClick(Chip chip){
        chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chip.setChecked(true);
                    //chipGroup.setVisibility(View.VISIBLE);
                } else {
                    chip.setChecked(false);
                    //chipGroup.setVisibility(View.GONE);
                }
                majChipFiltre();
            }
        });
    }

    private class AsyncTaskRunnerBD extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            //listEvents = eventSauvegardeEntityDao.loadAll();
            listEntries = entryEntityDao.loadAll();

            return null;
        }

        protected void onPostExecute(Void result) {
            //traiterIntent();
            configureRecyclerView();
            initListChips();
            initRadioButtonsClick();
            initAllChipsClick();
            initMasquerFiltreSiScroll();
            listerFiltre();
            initListFiltres();
            afficherFiltreNonVide();
            initCheckboxesTitreClick();
            initCheckboxesSelectAllClick();
            progressBar.setVisibility(View.GONE);
            //item = menuItems.findItem(R.id.menu_activity_main_filter);
            //item.setVisible(true);
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }

    protected void initFiltre2(List<? extends DetailEntryEntitySimple> list, LinearLayout ll, List<MaterialCheckBox> listCb, MaterialCheckBox cb) {
        Collections.sort(list);
        for (DetailEntryEntitySimple current : list) {
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
                        if (!verifSiUnFiltreMinimum2(list)){
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

    @Override
    protected void addElementIfNotExist(List<?> list, Object object) {
        //for (Object current : list){
        boolean bool = false;
        if (object instanceof EntryAmenityEntity) {
            for (EntryAmenityEntity current : (List<EntryAmenityEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryAmenityEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresAmenity.add((EntryAmenityEntity) object);
            }
        } else if (object instanceof EntryAnimationEntity) {
            for (EntryAnimationEntity current : (List<EntryAnimationEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryAnimationEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresAnimation.add((EntryAnimationEntity) object);
            }
        } else if (object instanceof EntryAtmospherEntity) {
            for (EntryAtmospherEntity current : (List<EntryAtmospherEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryAtmospherEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresAtmospher.add((EntryAtmospherEntity) object);
            }
        } else if (object instanceof EntryCategoryEntity) {
            for (EntryCategoryEntity current : (List<EntryCategoryEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryCategoryEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresCategory.add((EntryCategoryEntity) object);
            }
        } else if (object instanceof EntryChainEntity) {
            for (EntryChainEntity current : (List<EntryChainEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryChainEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresChain.add((EntryChainEntity) object);
            }
        } else if (object instanceof EntryAddressEntity) {
            for (EntryAddressEntity current : (List<EntryAddressEntity>) list) {
                if (current.getCity().equalsIgnoreCase(((EntryAddressEntity) object).getCity())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresCity.add((EntryAddressEntity) object);
            }
        } else if (object instanceof EntryFamilyOptionEntity) {
            for (EntryFamilyOptionEntity current : (List<EntryFamilyOptionEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryFamilyOptionEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresFamilyOption.add((EntryFamilyOptionEntity) object);
            }
        } else if (object instanceof EntryFurnishedRentalEntity) {
            for (EntryFurnishedRentalEntity current : (List<EntryFurnishedRentalEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryFurnishedRentalEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresFurnishedRental.add((EntryFurnishedRentalEntity) object);
            }
        } else if (object instanceof EntryGroupOptionEntity) {
            for (EntryGroupOptionEntity current : (List<EntryGroupOptionEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryGroupOptionEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresGroupOption.add((EntryGroupOptionEntity) object);
            }
        } else if (object instanceof EntryLabelEntity) {
            for (EntryLabelEntity current : (List<EntryLabelEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryLabelEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresLabel.add((EntryLabelEntity) object);
            }
        } else if (object instanceof EntryLocationEntity) {
            for (EntryLocationEntity current : (List<EntryLocationEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryLocationEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresLocation.add((EntryLocationEntity) object);
            }
        } else if (object instanceof EntryRentalMonthEntity) {
            for (EntryRentalMonthEntity current : (List<EntryRentalMonthEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryRentalMonthEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresRentalMonth.add((EntryRentalMonthEntity) object);
            }
        } else if (object instanceof EntryServiceEntity) {
            for (EntryServiceEntity current : (List<EntryServiceEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryServiceEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresService.add((EntryServiceEntity) object);
            }
        } else if (object instanceof EntrySleepingEntity) {
            for (EntrySleepingEntity current : (List<EntrySleepingEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntrySleepingEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresSleeping.add((EntrySleepingEntity) object);
            }
        } else if (object instanceof EntryStandingLevelEntity) {
            for (EntryStandingLevelEntity current : (List<EntryStandingLevelEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryStandingLevelEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresStandingLevel.add((EntryStandingLevelEntity) object);
            }
        } else if (object instanceof EntryStationEntity) {
            for (EntryStationEntity current : (List<EntryStationEntity>) list) {
                if (current.getValue().equalsIgnoreCase(((EntryStationEntity) object).getValue())) {
                    bool = true;
                    return;
                }
            }
            if (!bool) {
                listFiltresStation.add((EntryStationEntity) object);
            }
        }
    }

    @Override
    @OnClick(R.id.fabFiltre)
    public void fabFiltreClick() {
        scrollViewFiltre.setVisibility(View.GONE);
        fabFiltre.setVisibility(View.GONE);
        fabRazFiltre.setVisibility(View.GONE);
        item = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        item.setVisible(true);


        //menu_activity_main_filter.setVisible(true);
        //Set<Entry> setEntryFiltre = new HashSet<>();
        //List<Entry> listEntriesFiltres = new ArrayList<>();
        listEntriesFiltres = new ArrayList<>();
        if (listEntriesChipFiltred.size()>0){
            listEntriesFiltres.addAll(listEntriesChipFiltred);
        } else {
            listEntriesFiltres.addAll(listEntries);
        }
        boolean boolAmenity = verifFiltreActif2(listFiltresAmenity);
        boolean boolAnimation = verifFiltreActif2(listFiltresAnimation);
        boolean boolAtmospher = verifFiltreActif2(listFiltresAtmospher);
        boolean boolCategory = verifFiltreActif2(listFiltresCategory);
        boolean boolChain = verifFiltreActif2(listFiltresChain);
        boolean boolFamilyOption = verifFiltreActif2(listFiltresFamilyOption);

        boolean boolFurnishedRental = verifFiltreActif2(listFiltresFurnishedRental);
        boolean boolGroupOption = verifFiltreActif2(listFiltresGroupOption);
        boolean boolLabel = verifFiltreActif2(listFiltresLabel);
        boolean boolLocation = verifFiltreActif2(listFiltresLocation);

        boolean boolRentalMonth = verifFiltreActif2(listFiltresRentalMonth);

        boolean boolService = verifFiltreActif2(listFiltresService);
        boolean boolSleeping = verifFiltreActif2(listFiltresSleeping);
        boolean boolStandingLevel = verifFiltreActif2(listFiltresStandingLevel);
        boolean boolStation = verifFiltreActif2(listFiltresStation);

        boolean boolCity = false;
        for (EntryAddressEntity filtre : listFiltresCity) {
            if (filtre.isChecked()) {
                boolCity = true;
            }
        }


        for (EntryEntity current : listEntries) {

            if (boolAmenity && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryAmenityEntity filtre : listFiltresAmenity) {
                    if (filtre.isChecked() && current.getListAmenities()!=null){
                        for (EntryAmenityEntity current2 : current.getListAmenities()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolAnimation && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryAnimationEntity filtre : listFiltresAnimation) {
                    if (filtre.isChecked() && current.getListAnimations()!=null){
                        for (EntryAnimationEntity current2 : current.getListAnimations()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolAtmospher && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryAtmospherEntity filtre : listFiltresAtmospher) {
                    if (filtre.isChecked() && current.getListAtmosphere()!=null){
                        for (EntryAtmospherEntity current2 : current.getListAtmosphere()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolCategory && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryCategoryEntity filtre : listFiltresCategory) {
                    if (filtre.isChecked() && current.getListCategories()!=null){
                        for (EntryCategoryEntity current2 : current.getListCategories()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolChain && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryChainEntity filtre : listFiltresChain) {
                    if (filtre.isChecked() && current.getListChains()!=null){
                        for (EntryChainEntity current2 : current.getListChains()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolFamilyOption && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryFamilyOptionEntity filtre : listFiltresFamilyOption) {
                    if (filtre.isChecked() && current.getListFamilyOptions()!=null){
                        for (EntryFamilyOptionEntity current2 : current.getListFamilyOptions()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }



            if (boolFurnishedRental && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryFurnishedRentalEntity filtre : listFiltresFurnishedRental) {
                    if (filtre.isChecked() && current.getListFurnishedRentals()!=null){
                        for (EntryFurnishedRentalEntity current2 : current.getListFurnishedRentals()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolGroupOption && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryGroupOptionEntity filtre : listFiltresGroupOption) {
                    if (filtre.isChecked() && current.getListGroupOptions()!=null){
                        for (EntryGroupOptionEntity current2 : current.getListGroupOptions()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolLabel && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryLabelEntity filtre : listFiltresLabel) {
                    if (filtre.isChecked() && current.getListLabels()!=null){
                        for (EntryLabelEntity current2 : current.getListLabels()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolLocation && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryLocationEntity filtre : listFiltresLocation) {
                    if (filtre.isChecked() && current.getListLocations()!=null){
                        for (EntryLocationEntity current2 : current.getListLocations()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }







            if (boolRentalMonth && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryRentalMonthEntity filtre : listFiltresRentalMonth) {
                    if (filtre.isChecked() && current.getListRentalMonths()!=null){
                        for (EntryRentalMonthEntity current2 : current.getListRentalMonths()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }


            if (boolService && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryServiceEntity filtre : listFiltresService) {
                    if (filtre.isChecked() && current.getListServices()!=null){
                        for (EntryServiceEntity current2 : current.getListServices()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolSleeping && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntrySleepingEntity filtre : listFiltresSleeping) {
                    if (filtre.isChecked() && current.getListSleepings()!=null){
                        for (EntrySleepingEntity current2 : current.getListSleepings()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolStandingLevel && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryStandingLevelEntity filtre : listFiltresStandingLevel) {
                    if (filtre.isChecked() && current.getListStandingLevels()!=null){
                        for (EntryStandingLevelEntity current2 : current.getListStandingLevels()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }

            if (boolStation && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryStationEntity filtre : listFiltresStation) {
                    if (filtre.isChecked() && current.getListStations()!=null){
                        for (EntryStationEntity current2 : current.getListStations()){
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())){
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }



            if (boolCity && listEntriesFiltres.contains(current)) {
                boolean isFiltered = false;
                for (EntryAddressEntity filtre : listFiltresCity) {
                    if (filtre.isChecked() && current.getAddress()!=null && current.getAddress().getCity()!=null){
                        if (current.getAddress().getCity().equalsIgnoreCase(filtre.getCity())){
                            isFiltered = true;
                        }
                    }
                }
                if (!isFiltered) {
                    listEntriesFiltres.remove(current);
                }
            }
        }

        Collections.sort(listEntriesFiltres);

        configureRecyclerView2(listEntriesFiltres);

    }

    public void configureRecyclerView2(List<EntryEntity> list) {
        adapterEntriesSauvegarde = new RecyclerAdapterEntriesSauvegarde(list, this);
        list_recycler_event.setAdapter(adapterEntriesSauvegarde);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    @Override
    @OnClick(R.id.fabRazFiltre)
    public void fabRazFiltreClick() {
        scrollViewFiltre.setVisibility(View.GONE);
        fabFiltre.setVisibility(View.GONE);
        fabRazFiltre.setVisibility(View.GONE);
        //menu_activity_main_filter.setVisible(true);
        item = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        item.setVisible(true);
        decocherTout();
        listEntriesFiltres = new ArrayList<>();
        if (listEntriesChipFiltred.size()>0){
            configureRecyclerView2(listEntriesChipFiltred);
        } else {
            configureRecyclerView();
        }





    }

    @Override
    public void listerFiltre() {
        for (EntryEntity current : listEntries){
            if (current.getListAmenities()!=null) {
                for (EntryAmenityEntity current2 : current.getListAmenities()) {
                    addElementIfNotExist(listFiltresAmenity, current2);
                }
            }
            if (current.getListAnimations()!=null) {
                for (EntryAnimationEntity current2 : current.getListAnimations()) {
                    addElementIfNotExist(listFiltresAnimation, current2);
                }
            }
            if (current.getListAtmosphere()!=null) {
                for (EntryAtmospherEntity current2 : current.getListAtmosphere()) {
                    addElementIfNotExist(listFiltresAtmospher, current2);
                }
            }
            if (current.getListCategories()!=null) {
                for (EntryCategoryEntity current2 : current.getListCategories()) {
                    addElementIfNotExist(listFiltresCategory, current2);
                }
            }
            if (current.getListChains()!=null) {
                for (EntryChainEntity current2 : current.getListChains()) {
                    addElementIfNotExist(listFiltresChain, current2);
                }
            }
            //attention ici viser la city
            if (current.getAddress()!=null && current.getAddress().getCity()!=null) {
                addElementIfNotExist(listFiltresCity, current.getAddress());
            }
            if (current.getListFamilyOptions()!=null) {
                for (EntryFamilyOptionEntity current2 : current.getListFamilyOptions()) {
                    addElementIfNotExist(listFiltresFamilyOption, current2);
                }
            }

            if (current.getListFurnishedRentals()!=null) {
                for (EntryFurnishedRentalEntity current2 : current.getListFurnishedRentals()) {
                    addElementIfNotExist(listFiltresFurnishedRental, current2);
                }
            }
            if (current.getListGroupOptions()!=null) {
                for (EntryGroupOptionEntity current2 : current.getListGroupOptions()) {
                    addElementIfNotExist(listFiltresGroupOption, current2);
                }
            }
            if (current.getListLabels()!=null) {
                for (EntryLabelEntity current2 : current.getListLabels()) {
                    addElementIfNotExist(listFiltresLabel, current2);
                }
            }
            if (current.getListLocations()!=null) {
                for (EntryLocationEntity current2 : current.getListLocations()) {
                    addElementIfNotExist(listFiltresLocation, current2);
                }
            }

            if (current.getListRentalMonths()!=null) {
                for (EntryRentalMonthEntity current2 : current.getListRentalMonths()) {
                    addElementIfNotExist(listFiltresRentalMonth, current2);
                }
            }

            if (current.getListServices()!=null) {
                for (EntryServiceEntity current2 : current.getListServices()) {
                    addElementIfNotExist(listFiltresService, current2);
                }
            }
            if (current.getListSleepings()!=null) {
                for (EntrySleepingEntity current2 : current.getListSleepings()) {
                    addElementIfNotExist(listFiltresSleeping, current2);
                }
            }
            if (current.getListStandingLevels()!=null) {
                for (EntryStandingLevelEntity current2 : current.getListStandingLevels()) {
                    addElementIfNotExist(listFiltresStandingLevel, current2);
                }
            }
            if (current.getListStations()!=null) {
                for (EntryStationEntity current2 : current.getListStations()) {
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

    @Override
    protected void initListFiltres() {
        initFiltre2(listFiltresAmenity,linearLayoutAmenities,listCheckboxAmenity,checkboxFiltreAmenitiesSelectAll);
        initFiltre2(listFiltresAnimation,linearLayoutAnimations,listCheckboxAnimation,checkboxFiltreAnimationsSelectAll);
        initFiltre2(listFiltresAtmospher,linearLayoutAtmosphere,listCheckboxAtmospher,checkboxFiltreAtmosphereSelectAll);
        initFiltre2(listFiltresCategory,linearLayoutCategory,listCheckboxCategory,checkboxFiltreCategorySelectAll);
        initFiltre2(listFiltresChain,linearLayoutChains,listCheckboxChain,checkboxFiltreChainsSelectAll);
        //conserver car city n'est pas comme les autres
        Collections.sort(listFiltresCity);
        for (EntryAddressEntity current : listFiltresCity) {
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
                        for (EntryAddressEntity current : listFiltresCity) {
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
        initFiltre2(listFiltresFamilyOption,linearLayoutFamilyOptions,listCheckboxFamilyOption,checkboxFiltreFamilyOptionsSelectAll);

        initFiltre2(listFiltresFurnishedRental,linearLayoutFurnishedRentals,listCheckboxFurnishedRental,checkboxFiltreFurnishedRentalsSelectAll);
        initFiltre2(listFiltresGroupOption,linearLayoutGroupOptions,listCheckboxGroupOption,checkboxFiltreGroupOptionsSelectAll);
        initFiltre2(listFiltresLabel,linearLayoutLabels,listCheckboxLabel,checkboxFiltreLabelsSelectAll);
        initFiltre2(listFiltresLocation,linearLayoutLocations,listCheckboxLocation,checkboxFiltreLocationsSelectAll);
        initFiltre2(listFiltresRentalMonth,linearLayoutRentalMonthes,listCheckboxRentalMonth,checkboxFiltreRentalMonthesSelectAll);
        initFiltre2(listFiltresService,linearLayoutServices,listCheckboxService,checkboxFiltreServicesSelectAll);
        initFiltre2(listFiltresSleeping,linearLayoutSleepings,listCheckboxSleeping,checkboxFiltreSleepingsSelectAll);
        initFiltre2(listFiltresStandingLevel,linearLayoutStandingLevels,listCheckboxStandingLevels,checkboxFiltreStandingLevelsSelectAll);
        initFiltre2(listFiltresStation,linearLayoutStations,listCheckboxStation,checkboxFiltreStationsSelectAll);

    }

    protected boolean verifSiUnFiltreMinimum2(List<? extends DetailEntryEntitySimple> list){
        boolean bool = false;
        for (DetailEntryEntitySimple current : list) {
            if (current.isChecked()){
                bool = true;
            }
        }
        return bool;
    }

    @Override
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

    @Override
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

    public void decocherFiltre2(List<? extends DetailEntryEntitySimple> list){
        for (DetailEntryEntitySimple current : list) {
            current.setChecked(false);
        }
    }

    @Override
    public void decocherCheckbox(List<MaterialCheckBox> list){
        for (MaterialCheckBox current : list){
            current.setChecked(false);
        }
    }

    @Override
    public void decocherCheckbox(MaterialCheckBox cb){
        cb.setChecked(false);
    }

    @Override
    public void decocherTout(){
        decocherFiltre2(listFiltresAmenity);
        decocherFiltre2(listFiltresAnimation);
        decocherFiltre2(listFiltresAtmospher);
        decocherFiltre2(listFiltresCategory);
        decocherFiltre2(listFiltresChain);
        decocherFiltre2(listFiltresFamilyOption);

        decocherFiltre2(listFiltresFurnishedRental);
        decocherFiltre2(listFiltresGroupOption);
        decocherFiltre2(listFiltresLabel);
        decocherFiltre2(listFiltresLocation);

        decocherFiltre2(listFiltresRentalMonth);

        decocherFiltre2(listFiltresService);
        decocherFiltre2(listFiltresSleeping);
        decocherFiltre2(listFiltresStandingLevel);
        decocherFiltre2(listFiltresStation);

        for (EntryAddressEntity current : listFiltresCity) {
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

    @Override
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

    @Override
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

    @Override
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


    private boolean verifFiltreActif2(List<? extends DetailEntryEntitySimple> list){
        boolean bool = false;
        for (DetailEntryEntitySimple current : list){
            if(current.isChecked()){
                bool = true;
            }
        }
        return bool;
    }
}