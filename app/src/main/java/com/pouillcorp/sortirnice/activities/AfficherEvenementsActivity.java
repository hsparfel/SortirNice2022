package com.pouillcorp.sortirnice.activities;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.entities.event.detail.DetailEvenementEntitySimple;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementAddressEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementCategoryEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementDescriptionEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementOptionEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementProfileEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementRefEntriesEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementSectoEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementStationEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementAddressEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementCategoryEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementDescriptionEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementOptionEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementProfileEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementRefEntriesEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementSectoEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementStationEntity;
import com.pouillcorp.sortirnice.enumeration.EvenementTri;
import com.pouillcorp.sortirnice.interfaces.EventsApiService;
import com.pouillcorp.sortirnice.modelevents.Address;
import com.pouillcorp.sortirnice.modelevents.Category;
import com.pouillcorp.sortirnice.modelevents.Description;
import com.pouillcorp.sortirnice.modelevents.Event;
import com.pouillcorp.sortirnice.modelevents.Events;
import com.pouillcorp.sortirnice.modelevents.Image;
import com.pouillcorp.sortirnice.modelevents.Option;
import com.pouillcorp.sortirnice.modelevents.Profile;
import com.pouillcorp.sortirnice.modelevents.RefEntries;
import com.pouillcorp.sortirnice.modelevents.Secto;
import com.pouillcorp.sortirnice.modelevents.Station;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvenements;
import com.pouillcorp.sortirnice.utils.DateUtils;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import icepick.Icepick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class AfficherEvenementsActivity extends NavDrawerActivity implements RecyclerAdapterEvenements.Listener {

    int nbEvents;
    List<Event> listEvents;
    List<EvenementEntity> listEventEntities = new ArrayList<>();
    List<EvenementEntity> listEventEntitiesBasique = new ArrayList<>();

    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;

    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;

    @BindView(R.id.layout_fragment_evenement_tri)
    FrameLayout layoutFragmentEvenementTri;
    @BindView(R.id.radio_button_evenement_tri_nom)
    MaterialRadioButton rbEvenementTriNom;
    @BindView(R.id.radio_button_evenement_tri_date)
    MaterialRadioButton rbEvenementTridDate;

    @BindView(R.id.layout_fragment_evenement_filtre)
    FrameLayout layoutFragmentEvenementFiltre;

    private RecyclerAdapterEvenements adapterEvents;

    private static final String TAG = AfficherEvenementsActivity.class.getSimpleName();
    public static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    public String myUrl = BASE_URL;
    private static Retrofit retrofit = null;
    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    private String dateDemandeString;
    private Date dateDemande;

    boolean isResponded = false;

    int positionScroll = 0;

    boolean layoutTriAffiche;
    boolean layoutFiltreAffiche;

    EvenementTri triEnCours = EvenementTri.Nom;

    List<EvenementAddressEntity> listFiltreEvenementAdresse = new ArrayList<>();
    List<EvenementCategoryEntity> listFiltreEvenementCategory = new ArrayList<>();

    @Nullable
    @BindView(R.id.fabEvenementValiderFiltre)
    FloatingActionButton fabEvenementValiderFiltre;
    @Nullable
    @BindView(R.id.fabEvenementRazFiltre)
    FloatingActionButton fabEvenementRazFiltre;

    @Nullable
    @BindView(R.id.linearLayoutEvenementFiltreCategory)
    LinearLayout linearLayoutEvenementFiltreCategory;
    @Nullable
    @BindView(R.id.checkboxEvenementFiltreCategorySelectAll)
    MaterialCheckBox checkboxEvenementFiltreCategorySelectAll;
    @Nullable
    @BindView(R.id.linearLayoutEvenementFiltreVille)
    LinearLayout linearLayoutEvenementFiltreVille;
    @Nullable
    @BindView(R.id.checkboxEvenementFiltreVilleSelectAll)
    MaterialCheckBox checkboxEvenementFiltreVilleSelectAll;
    @Nullable
    @BindView(R.id.buttonEvenementFiltreCategory)
    MaterialButton buttonEvenementFiltreCategory;
    @Nullable
    @BindView(R.id.buttonEvenementFiltreVille)
    MaterialButton buttonEvenementFiltreVille;

    boolean filtreCategoryDeplie = false;
    boolean filtreVilleDeplie = false;

    List<MaterialCheckBox> listCheckboxEvenementCategory = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxEvenementVille = new ArrayList<>();

    List<EvenementEntity> listEvenementEntityFiltre = new ArrayList<>();

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

        myUrl += dateDemandeString + "/";

        connectAndGetApiData(myUrl);

        masquerFragmentTri();
        masquerFragmentFiltreEvent();
    }

    @OnClick(R.id.radio_button_evenement_tri_nom)
    public void rbEvenementTriNomClick() {
        Log.e("TAG", "click sur Tri Nom");
        triEnCours = EvenementTri.Nom;
        triSelonParametre(listEventEntities);
        configureRecyclerView();
        masquerFragmentTri();
    }

    @OnClick(R.id.radio_button_evenement_tri_date)
    public void rbEvenementTriDateClick() {
        Log.e("TAG", "click sur Tri Date");
        triEnCours = EvenementTri.Date;
        triSelonParametre(listEventEntities);
        configureRecyclerView();
        masquerFragmentTri();
    }

    private void loadAllEvenementFromDB() {
        evenementEntityDao.detachAll();
        listEventEntities = evenementEntityDao.loadAll();
        triSelonParametre(listEventEntities);
    }

    private void masquerFragmentTri() {
        layoutFragmentEvenementTri.setVisibility(View.GONE);
        layoutTriAffiche = false;
    }

    private void afficherFragmentTri() {
        layoutFragmentEvenementTri.setVisibility(View.VISIBLE);
        layoutTriAffiche = true;
        rbEvenementTriNom.setText(EvenementTri.Nom.getNom());
        rbEvenementTridDate.setText(EvenementTri.Date.getNom());
    }

    private void masquerFragmentFiltreEvent() {
        layoutFragmentEvenementFiltre.setVisibility(View.GONE);
        layoutFiltreAffiche = false;
    }

    private void afficherFragmentFiltreEvent() {
        layoutFragmentEvenementFiltre.setVisibility(View.VISIBLE);
        layoutFiltreAffiche = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (EvenementEntity current : listEventEntities) {
            current.refresh();
        }
        configureRecyclerView();
        list_recycler_event.scrollToPosition(positionScroll);
        Log.e(TAG, "on resume method");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_evenement_tri:
                Log.e(TAG, "click sur tri evenement");
                if (layoutTriAffiche) {
                    masquerFragmentTri();
                } else {
                    afficherFragmentTri();
                }
                masquerFragmentFiltreEvent();
                break;
            case R.id.menu_activity_main_evenement_filter:
                Log.e(TAG, "click sur filtre evenement");
                if (layoutFiltreAffiche) {
                    masquerFragmentFiltreEvent();
                } else {
                    afficherFragmentFiltreEvent();
                }
                masquerFragmentTri();
                break;
        }
        return true;
    }

    public void connectAndGetApiData(String url) {

        retrofit = new Retrofit.Builder()
                // .baseUrl(BASE_URL+"/"+dateString)
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        EventsApiService eventApiService = retrofit.create(EventsApiService.class);
        Call<Events> call = eventApiService.getEvents();
        call.enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                if (response.code() == 200) {
                    listEvents = response.body().getListEvents();
                    saveListEvents();
                    isResponded = true;
                    //Log.e(TAG, "Number of events received: " + listEvents.size());
                    loadAllEvenementFromDB();
                    listEventEntitiesBasique.addAll(listEventEntities);
                    configureRecyclerView();
                    itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
                    itemEvenementFiltre.setVisible(true);
                    itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
                    itemEvenementTri.setVisible(true);

                    listerFiltre();
                    initListFiltres();
                    initCheckboxesSelectAllClick();

                    progressBar.setVisibility(View.GONE);
                } else {

                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    myUrl = BASE_URL + dateDemandeString + "/";
                    connectAndGetApiData(myUrl);
                    Log.e(TAG, dateDemandeString + " : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Events> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
                progressBar.setVisibility(View.GONE);
                Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                gererErreur(null, throwable.toString());
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private boolean isEvenementEntityToujoursExistant(EvenementEntity evenementEntity) {
        for (Event current : listEvents) {
            if (isEventAndEvenementEntityIdentique(current, evenementEntity)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEventAndEvenementEntityIdentique(Event event, EvenementEntity eventEntity) {
        if (event.getId() != eventEntity.getEvenementEntityId()) {
            return false;
        }

        //verif ListAdress
        boolean boolAdress1 = false;
        boolean boolAdress2 = false;
        if (event.getListAddresses() != null && eventEntity.getListAddresses() != null) {
            for (Address current : event.getListAddresses()) {
                for (EvenementAddressEntity current2 : eventEntity.getListAddresses()) {
                    //boolean boolTemp = false;
                    if (current.getType().equalsIgnoreCase(current2.getType()) && current.getAddressContent().equalsIgnoreCase(current2.getAddressContent())
                            && current.getCity().equalsIgnoreCase(current2.getCity()) && current.getZip().equalsIgnoreCase(current2.getZip())) {
                        boolAdress1 = true;
                    }
                }
            }
            for (EvenementAddressEntity current : eventEntity.getListAddresses()) {
                for (Address current2 : event.getListAddresses()) {
                    //boolean boolTemp = false;
                    if (current.getType().equalsIgnoreCase(current2.getType()) && current.getAddressContent().equalsIgnoreCase(current2.getAddressContent())
                            && current.getCity().equalsIgnoreCase(current2.getCity()) && current.getZip().equalsIgnoreCase(current2.getZip())) {
                        boolAdress2 = true;
                    }
                }
            }
            if (!boolAdress1 || !boolAdress2) {
                return false;
            }
        }

        //verif ListCategories
        boolean boolCategories1 = false;
        boolean boolCategories2 = false;
        if (event.getListCategories() != null && eventEntity.getListCategories() != null) {
            for (Category current : event.getListCategories()) {
                for (EvenementCategoryEntity current2 : eventEntity.getListCategories()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolCategories1 = true;
                    }
                }
            }
            for (EvenementCategoryEntity current : eventEntity.getListCategories()) {
                for (Category current2 : event.getListCategories()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolCategories2 = true;
                    }
                }
            }
            if (!boolCategories1 || !boolCategories2) {
                return false;
            }
        }

        //verif ListDescriptions
        boolean boolDescriptions1 = false;
        boolean boolDescriptions2 = false;
        if (event.getListDescriptions() != null && eventEntity.getListDescriptions() != null) {
            for (Description current : event.getListDescriptions()) {
                for (EvenementDescriptionEntity current2 : eventEntity.getListDescriptions()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolDescriptions1 = true;
                    }
                }
            }
            for (EvenementDescriptionEntity current : eventEntity.getListDescriptions()) {
                for (Description current2 : event.getListDescriptions()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolDescriptions2 = true;
                    }
                }
            }
            if (!boolDescriptions1 || !boolDescriptions2) {
                return false;
            }
        }

        if (event.getListImages() != null && event.getListImages().size() > 0) {
            boolean bool = false;
            for (Image current : event.getListImages()) {
                if (current.getUrl().equalsIgnoreCase(eventEntity.getImage())) {
                    bool = true;
                }
            }
            if (!bool) {
                return false;
            }
        }

        //verif ListOptions
        boolean boolOptions1 = false;
        boolean boolOptions2 = false;
        if (event.getListOptions() != null && eventEntity.getListOptions() != null) {
            for (Option current : event.getListOptions()) {
                for (EvenementOptionEntity current2 : eventEntity.getListOptions()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolOptions1 = true;
                    }
                }
            }
            for (EvenementOptionEntity current : eventEntity.getListOptions()) {
                for (Option current2 : event.getListOptions()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolOptions2 = true;
                    }
                }
            }
            if (!boolOptions1 || !boolOptions2) {
                return false;
            }
        }

        //verif ListProfiles
        boolean boolProfiles1 = false;
        boolean boolProfiles2 = false;
        if (event.getListProfiles() != null && eventEntity.getListProfiles() != null) {
            for (Profile current : event.getListProfiles()) {
                for (EvenementProfileEntity current2 : eventEntity.getListProfiles()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolProfiles1 = true;
                    }
                }
            }
            for (EvenementProfileEntity current : eventEntity.getListProfiles()) {
                for (Profile current2 : event.getListProfiles()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolProfiles2 = true;
                    }
                }
            }
            if (!boolProfiles1 || !boolProfiles2) {
                return false;
            }
        }

        //verif ListSectors
        boolean boolSectors1 = false;
        boolean boolSectors2 = false;
        if (event.getListSectors() != null && eventEntity.getListSectos() != null) {
            for (Secto current : event.getListSectors()) {
                for (EvenementSectoEntity current2 : eventEntity.getListSectos()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolSectors1 = true;
                    }
                }
            }
            for (EvenementSectoEntity current : eventEntity.getListSectos()) {
                for (Secto current2 : event.getListSectors()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolSectors2 = true;
                    }
                }
            }
            if (!boolSectors1 || !boolSectors2) {
                return false;
            }
        }

        //verif ListStations
        boolean boolStations1 = false;
        boolean boolStations2 = false;
        if (event.getListStations() != null && eventEntity.getListStations() != null) {
            for (Station current : event.getListStations()) {
                for (EvenementStationEntity current2 : eventEntity.getListStations()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolStations1 = true;
                    }
                }
            }
            for (EvenementStationEntity current : eventEntity.getListStations()) {
                for (Station current2 : event.getListStations()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolStations2 = true;
                    }
                }
            }
            if (!boolStations1 || !boolStations2) {
                return false;
            }
        }

        if (event.getWebsiteMap() != null && event.getWebsiteMap().get("situation") != null && event.getWebsiteMap().get("principal") != null) {
            if (!event.getWebsiteMap().get("situation").equalsIgnoreCase(eventEntity.getWebsiteSituation()) || !event.getWebsiteMap().get("principal").equalsIgnoreCase(eventEntity.getWebsitePrincipal())) {
                return false;
            }

        }
        if (event.getCreated() != null && eventEntity.getCreated() != null && !event.getCreated().equalsIgnoreCase(eventEntity.getCreated())) {
            return false;
        }
        if (event.getEmail() != null && eventEntity.getEmail() != null && !event.getEmail().equalsIgnoreCase(eventEntity.getEmail())) {
            return false;
        }
        if (event.getEnd() != null && eventEntity.getEnd() != null && !event.getEnd().equalsIgnoreCase(eventEntity.getEnd())) {
            return false;
        }
        if (event.getLatitude() != eventEntity.getLatitude()) {
            return false;
        }

        if (event.getLongitude() != eventEntity.getLongitude()) {
            return false;
        }
        if (event.getNameFr() != null && eventEntity.getNameFr() != null && !event.getNameFr().equalsIgnoreCase(eventEntity.getNameFr())) {
            return false;
        }
        if (event.getNote() != eventEntity.getNote()) {
            return false;
        }
        if (event.getPhone() != null && eventEntity.getPhone() != null && !event.getPhone().equalsIgnoreCase(eventEntity.getPhone())) {
            return false;
        }
        if (event.getStart() != null && eventEntity.getStart() != null && !event.getStart().equalsIgnoreCase(eventEntity.getStart())) {
            return false;
        }
        if (event.getUpdated() != null && eventEntity.getUpdated() != null && !event.getUpdated().equalsIgnoreCase(eventEntity.getUpdated())) {
            return false;
        }
        return true;
    }

    private void saveListEvents() {
        //eventEntityDao.deleteAll();
        List<EvenementEntity> listEventsNonFavoris = evenementEntityDao.queryRaw("where favori = 0");
        int nbTotalEvensNonFavoris = listEventsNonFavoris.size();
        long nbTotalEvents = eventEntityDao.count();


        for (EvenementEntity current : listEventsNonFavoris) {
            if (!isEvenementEntityToujoursExistant(current)) {
                evenementEntityDao.delete(current);
                Log.e("TAG", "suppression evenement obsolete - " + current.getNameFr());
            }
        }

        for (Event current : listEvents) {

            //rechercher si un existant deja
            //chercher à partir de l'id et verifier si parfaitmeent similaire sinon l'enregistrer quand même
            List<EvenementEntity> listEvenemenEntity = evenementEntityDao.loadAll();
            boolean isPresentEnBaseDonnees = false;
            for (EvenementEntity evenementEntity : listEvenemenEntity) {
                if (evenementEntity.getEvenementEntityId() == current.getId()) {
                    isPresentEnBaseDonnees = true;
                }
            }

            if (!isPresentEnBaseDonnees) {
                EvenementEntity evenementToSave = new EvenementEntity();
                evenementToSave.setEvenementEntityId(Long.valueOf(current.getId()));
                evenementToSave.setNameFr(current.getNameFr());
                evenementToSave.setStart(current.getStart());
                evenementToSave.setEnd(current.getEnd());
                evenementToSave.setPhone(current.getPhone());
                evenementToSave.setEmail(current.getEmail());
                evenementToSave.setWebsiteSituation(current.getWebsiteMap().get("situation"));
                evenementToSave.setWebsitePrincipal(current.getWebsiteMap().get("principal"));
                evenementToSave.setImage((current.getListImages() != null && current.getListImages().size() > 0) ? current.getListImages().get(0).getUrl() : null);
                evenementToSave.setLatitude(current.getLatitude());
                evenementToSave.setLongitude(current.getLongitude());
                evenementToSave.setNote(current.getNote());
                evenementToSave.setCreated(current.getCreated());
                evenementToSave.setUpdated(current.getUpdated());
                evenementToSave.setId(evenementEntityDao.insert(evenementToSave));
                //enregistrer list Addresses
                if (current.getListAddresses() != null) {
                    for (Address address : current.getListAddresses()) {
                        List<EvenementAddressEntity> list = evenementAddressEntityDao.queryRaw("where address_content = ? and city = ? and type = ? and zip = ?", address.getAddressContent(), address.getCity(), address.getType(), address.getZip());
                        JoinEvenementEntityWithEvenementAddressEntity join = new JoinEvenementEntityWithEvenementAddressEntity();
                        join.setEvenementEntityId(evenementToSave.getId());
                        if (list.size() > 0) {
                            join.setEvenementAddressEntityId(list.get(0).getId());
                        } else {
                            EvenementAddressEntity evenementAddressEntity = new EvenementAddressEntity();
                            evenementAddressEntity.setAddressContent(address.getAddressContent());
                            evenementAddressEntity.setCity(address.getCity());
                            evenementAddressEntity.setType(address.getType());
                            evenementAddressEntity.setZip(address.getZip());
                            evenementAddressEntity.setId(evenementAddressEntityDao.insert(evenementAddressEntity));
                            join.setEvenementAddressEntityId(evenementAddressEntity.getId());
                        }
                        joinEvenementEntityWithEvenementAddressEntityDao.insert(join);
                    }
                }
                //enregistrer list Profiles
                if (current.getListProfiles() != null) {
                    for (Profile profile : current.getListProfiles()) {
                        List<EvenementProfileEntity> list = evenementProfileEntityDao.queryRaw("where value = ?", profile.getValue());
                        JoinEvenementEntityWithEvenementProfileEntity join = new JoinEvenementEntityWithEvenementProfileEntity();
                        join.setEvenementEntityId(evenementToSave.getId());
                        if (list.size() > 0) {
                            join.setEvenementProfileEntityId(list.get(0).getId());
                        } else {
                            EvenementProfileEntity evenementProfileEntity = new EvenementProfileEntity();
                            evenementProfileEntity.setValue(profile.getValue());
                            evenementProfileEntity.setId(evenementProfileEntityDao.insert(evenementProfileEntity));
                            join.setEvenementProfileEntityId(evenementProfileEntity.getId());
                        }
                        joinEvenementEntityWithEvenementProfileEntityDao.insert(join);
                    }
                }
                //enregistrer list Stations
                if (current.getListStations() != null) {
                    for (Station station : current.getListStations()) {
                        List<EvenementStationEntity> list = evenementStationEntityDao.queryRaw("where value = ?", station.getValue());
                        JoinEvenementEntityWithEvenementStationEntity join = new JoinEvenementEntityWithEvenementStationEntity();
                        join.setEvenementEntityId(evenementToSave.getId());
                        if (list.size() > 0) {
                            join.setEvenementStationEntityId(list.get(0).getId());
                        } else {
                            EvenementStationEntity evenementStationEntity = new EvenementStationEntity();
                            evenementStationEntity.setValue(station.getValue());
                            evenementStationEntity.setId(evenementStationEntityDao.insert(evenementStationEntity));
                            join.setEvenementStationEntityId(evenementStationEntity.getId());
                        }
                        joinEvenementEntityWithEvenementStationEntityDao.insert(join);
                    }
                }
                //enregistrer list Categories
                if (current.getListCategories() != null) {
                    for (Category category : current.getListCategories()) {
                        List<EvenementCategoryEntity> list = evenementCategoryEntityDao.queryRaw("where value = ?", category.getValue());
                        JoinEvenementEntityWithEvenementCategoryEntity join = new JoinEvenementEntityWithEvenementCategoryEntity();
                        join.setEvenementEntityId(evenementToSave.getId());
                        if (list.size() > 0) {
                            join.setEvenementCategoryEntityId(list.get(0).getId());
                        } else {
                            EvenementCategoryEntity evenementCategoryEntity = new EvenementCategoryEntity();
                            evenementCategoryEntity.setValue(category.getValue());
                            evenementCategoryEntity.setId(evenementCategoryEntityDao.insert(evenementCategoryEntity));
                            join.setEvenementCategoryEntityId(evenementCategoryEntity.getId());
                        }
                        joinEvenementEntityWithEvenementCategoryEntityDao.insert(join);
                    }
                }
                //enregistrer list Options
                if (current.getListOptions() != null) {
                    for (Option option : current.getListOptions()) {
                        List<EvenementOptionEntity> list = evenementOptionEntityDao.queryRaw("where value = ?", option.getValue());
                        JoinEvenementEntityWithEvenementOptionEntity join = new JoinEvenementEntityWithEvenementOptionEntity();
                        join.setEvenementEntityId(evenementToSave.getId());
                        if (list.size() > 0) {
                            join.setEvenementOptionEntityId(list.get(0).getId());
                        } else {
                            EvenementOptionEntity evenementOptionEntity = new EvenementOptionEntity();
                            evenementOptionEntity.setValue(option.getValue());
                            evenementOptionEntity.setId(evenementOptionEntityDao.insert(evenementOptionEntity));
                            join.setEvenementOptionEntityId(evenementOptionEntity.getId());
                        }
                        joinEvenementEntityWithEvenementOptionEntityDao.insert(join);
                    }
                }
                //enregistrer list Sectos
                if (current.getListSectors() != null) {
                    for (Secto secto : current.getListSectors()) {
                        List<EvenementSectoEntity> list = evenementSectoEntityDao.queryRaw("where value = ?", secto.getValue());
                        JoinEvenementEntityWithEvenementSectoEntity join = new JoinEvenementEntityWithEvenementSectoEntity();
                        join.setEvenementEntityId(evenementToSave.getId());
                        if (list.size() > 0) {
                            join.setEvenementSectoEntityId(list.get(0).getId());
                        } else {
                            EvenementSectoEntity evenementSectoEntity = new EvenementSectoEntity();
                            evenementSectoEntity.setValue(secto.getValue());
                            evenementSectoEntity.setId(evenementSectoEntityDao.insert(evenementSectoEntity));
                            join.setEvenementSectoEntityId(evenementSectoEntity.getId());
                        }
                        joinEvenementEntityWithEvenementSectoEntityDao.insert(join);
                    }
                }
                //enregistrer list Descriptions
                if (current.getListDescriptions() != null) {
                    for (Description description : current.getListDescriptions()) {
                        List<EvenementDescriptionEntity> list = evenementDescriptionEntityDao.queryRaw("where language = ? and value = ? and type = ?", description.getLanguage(), description.getValue(), description.getType());
                        JoinEvenementEntityWithEvenementDescriptionEntity join = new JoinEvenementEntityWithEvenementDescriptionEntity();
                        join.setEvenementEntityId(evenementToSave.getId());
                        if (list.size() > 0) {
                            join.setEvenementDescriptionEntityId(list.get(0).getId());
                        } else {
                            EvenementDescriptionEntity evenementDescriptionEntity = new EvenementDescriptionEntity();
                            evenementDescriptionEntity.setLanguage(description.getLanguage());
                            evenementDescriptionEntity.setType(description.getType());
                            evenementDescriptionEntity.setValue(description.getValue());
                            evenementDescriptionEntity.setId(evenementDescriptionEntityDao.insert(evenementDescriptionEntity));
                            join.setEvenementDescriptionEntityId(evenementDescriptionEntity.getId());
                        }
                        joinEvenementEntityWithEvenementDescriptionEntityDao.insert(join);
                    }
                }
                //enregistrer list RefEntries
                if (current.getListRefEntries() != null) {
                    for (RefEntries refEntries : current.getListRefEntries()) {
                        if (refEntries.getRefEntryId() != null && refEntries.getRefEntryName() != null) {
                            List<EvenementRefEntriesEntity> list = evenementRefEntriesEntityDao.queryRaw("where ref_entry_id = ? and ref_entry_name = ?", refEntries.getRefEntryId(), refEntries.getRefEntryName());

                            JoinEvenementEntityWithEvenementRefEntriesEntity join = new JoinEvenementEntityWithEvenementRefEntriesEntity();
                            join.setEvenementEntityId(evenementToSave.getId());
                            if (list.size() > 0) {
                                join.setEvenementRefEntriesEntityId(list.get(0).getId());
                            } else {
                                EvenementRefEntriesEntity evenementRefEntriesEntity = new EvenementRefEntriesEntity();
                                evenementRefEntriesEntity.setRefEntryId(refEntries.getRefEntryId());
                                evenementRefEntriesEntity.setRefEntryName(refEntries.getRefEntryName());
                                evenementRefEntriesEntity.setId(evenementRefEntriesEntityDao.insert(evenementRefEntriesEntity));
                                join.setEvenementRefEntriesEntityId(evenementRefEntriesEntity.getId());
                            }
                            joinEvenementEntityWithEvenementRefEntriesEntityDao.insert(join);
                        }
                    }
                }
                //evenementEntityDao.update(evenementToSave);
                Log.e(TAG, "Ajout " + evenementToSave.getNameFr());
                listEventEntities.add(evenementToSave);
            } else {
                //Log.e(TAG, "Recup " + current.getNameFr());
            }
        }
    }

    private void configureOnClickRecyclerViewEvent() {
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        positionScroll = position;
                        masquerFragmentTri();
                        ouvrirActiviteSuivante(AfficherEvenementsActivity.this, AfficherEvenementDetailActivity.class, "eventId", listEventEntities.get(position).getId(), false);
                        //Log.e("TAG", "Position : " + position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEvents = new RecyclerAdapterEvenements(listEventEntities, this);
        list_recycler_event.setAdapter(adapterEvents);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerViewEvent();
    }

    @Override
    public void onClickEventsButton(int position) {
        //  ouvrirActiviteSuivante(this,AfficherEventDetailActivity.class,"eventId",listEventEntities.get(position).getId(),false);
    }

    public void afficherListCbEvenementFiltreCategory(View view) {
        if (!filtreCategoryDeplie) {
            filtreCategoryDeplie = true;
            checkboxEvenementFiltreCategorySelectAll.setVisibility(View.VISIBLE);
            linearLayoutEvenementFiltreCategory.setVisibility(View.VISIBLE);
            buttonEvenementFiltreCategory.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreCategoryDeplie = false;
            checkboxEvenementFiltreCategorySelectAll.setVisibility(View.GONE);
            linearLayoutEvenementFiltreCategory.setVisibility(View.GONE);
            buttonEvenementFiltreCategory.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEvenementFiltreVille(View view) {
        if (!filtreVilleDeplie) {
            filtreVilleDeplie = true;
            checkboxEvenementFiltreVilleSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEvenementFiltreVille.setVisibility(View.VISIBLE);
            buttonEvenementFiltreVille.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreVilleDeplie = false;
            checkboxEvenementFiltreVilleSelectAll.setVisibility(View.GONE);
            linearLayoutEvenementFiltreVille.setVisibility(View.GONE);
            buttonEvenementFiltreVille.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    protected boolean verifFiltreActif(List<? extends DetailEvenementEntitySimple> list) {
        boolean bool = false;
        for (DetailEvenementEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    protected boolean verifFiltreAdresseActif(List<EvenementAddressEntity> list) {
        boolean bool = false;
        for (EvenementAddressEntity current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    protected void reinitListeEvents() {
        listEventEntities.clear();
        listEventEntities.addAll(listEventEntitiesBasique);
    }

    @Optional
    @OnClick(R.id.fabEvenementValiderFiltre)
    public void fabEvenementFiltreClick() {
        //fabEvenementValiderFiltre.setVisibility(View.GONE);
        //fabEvenementRazFiltre.setVisibility(View.GONE);
        reinitListeEvents();
        layoutFragmentEvenementFiltre.setVisibility(View.GONE);
        listEvenementEntityFiltre = new ArrayList<>();
        listEvenementEntityFiltre.addAll(listEventEntities);
        boolean boolEvenementCategory = verifFiltreActif(listFiltreEvenementCategory);
        for (EvenementEntity current : listEventEntities) {
            if (boolEvenementCategory && listEvenementEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EvenementCategoryEntity filtre : listFiltreEvenementCategory) {
                    if (filtre.isChecked() && current.getListCategories() != null) {
                        for (EvenementCategoryEntity current2 : current.getListCategories()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEvenementEntityFiltre.remove(current);
                }
            }
        }
        boolean boolEvenementVille = verifFiltreAdresseActif(listFiltreEvenementAdresse);
        for (EvenementEntity current : listEventEntities) {
            if (boolEvenementVille && listEvenementEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EvenementAddressEntity filtre : listFiltreEvenementAdresse) {
                    if (filtre.isChecked() && current.getListAddresses() != null) {
                        for (EvenementAddressEntity current2 : current.getListAddresses()) {
                            if (current2.getCity().equalsIgnoreCase(filtre.getCity())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEvenementEntityFiltre.remove(current);
                }
            }
        }
        triSelonParametre(listEvenementEntityFiltre);
        listEventEntities.clear();
        listEventEntities.addAll(listEvenementEntityFiltre);
        configureRecyclerView();
    }

    protected void triSelonParametre(List<EvenementEntity> list) {
        if (triEnCours == EvenementTri.Nom) {
            Collections.sort(list);
        } else if (triEnCours == EvenementTri.Date) {
            Collections.sort(list, EvenementEntity.ComparatorDate);
        }
    }

    @Optional
    @OnClick(R.id.fabEvenementRazFiltre)
    public void fabEvenementRazFiltreClick() {
        decocherTout();
        layoutFragmentEvenementFiltre.setVisibility(View.GONE);
        //listEvenementEntityFiltre = new ArrayList<>();
        listEventEntities.clear();
        listEventEntities.addAll(listEventEntitiesBasique);
        triSelonParametre(listEventEntities);
        configureRecyclerView();
    }

    public void decocherFiltre(List<? extends DetailEvenementEntitySimple> list) {
        for (DetailEvenementEntitySimple current : list) {
            current.setChecked(false);
        }
    }

    public void decocherFiltreAdresse(List<EvenementAddressEntity> list) {
        for (EvenementAddressEntity current : list) {
            current.setChecked(false);
        }
    }

    /*public void decocherCheckbox(List<MaterialCheckBox> list) {
        for (MaterialCheckBox current : list) {
            current.setChecked(false);
        }
    }*/

    /*public void decocherCheckbox(MaterialCheckBox cb) {
        cb.setChecked(false);
    }*/

    public void decocherTout() {
        decocherFiltre(listFiltreEvenementCategory);
        decocherFiltreAdresse(listFiltreEvenementAdresse);
        for (EvenementAddressEntity current : listFiltreEvenementAdresse) {
            current.setChecked(false);
        }
        decocherCheckbox(listCheckboxEvenementCategory);
        decocherCheckbox(listCheckboxEvenementVille);
        decocherCheckbox(checkboxEvenementFiltreCategorySelectAll);
        decocherCheckbox(checkboxEvenementFiltreVilleSelectAll);
    }

    protected void initFiltre(List<? extends DetailEvenementEntitySimple> list, LinearLayout ll, List<MaterialCheckBox> listCb, MaterialCheckBox cb) {
        Collections.sort(list);
        for (DetailEvenementEntitySimple current : list) {
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
                        if (!verifSiUnFiltreMinimum(list)) {
                            cb.setChecked(false);
                        }
                    }
                }
            });
            if (ll != null) {
                ll.addView(checkBox);
            }
            listCb.add(checkBox);
        }
    }

    protected List<EvenementAddressEntity> supprimerDoublonVille(List<EvenementAddressEntity> list) {
        List<EvenementAddressEntity> listTemp = new ArrayList<>();
        EvenementAddressEntity previous = null;
        for (EvenementAddressEntity current : list) {
            if (previous == null) {
                listTemp.add(current);
            } else if (!current.getCity().equalsIgnoreCase(previous.getCity())) {
                listTemp.add(current);
            }
            previous = current;
        }
        return listTemp;
    }

    protected void initListFiltres() {
        initFiltre(listFiltreEvenementCategory, linearLayoutEvenementFiltreCategory, listCheckboxEvenementCategory, checkboxEvenementFiltreCategorySelectAll);
        Collections.sort(listFiltreEvenementAdresse);
        listFiltreEvenementAdresse = supprimerDoublonVille(listFiltreEvenementAdresse);
        for (EvenementAddressEntity current : listFiltreEvenementAdresse) {
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
                        for (EvenementAddressEntity current : listFiltreEvenementAdresse) {
                            if (current.isChecked()) {
                                bool = true;
                            }
                        }
                        if (!bool) {
                            checkboxEvenementFiltreVilleSelectAll.setChecked(false);
                        }
                    }
                }
            });
            if (linearLayoutEvenementFiltreVille != null) {
                linearLayoutEvenementFiltreVille.addView(checkBox);
            }
            listCheckboxEvenementVille.add(checkBox);
        }
    }

    protected boolean verifSiUnFiltreMinimum(List<? extends DetailEvenementEntitySimple> list) {
        boolean bool = false;
        for (DetailEvenementEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    public void listerFiltre() {
        listFiltreEvenementCategory = evenementCategoryEntityDao.loadAll();
        listFiltreEvenementAdresse = evenementAddressEntityDao.loadAll();
        //Log.d(TAG, "Number of Category received: " + listFiltreEvenementCategory.size());
        //Log.d(TAG, "Number of City received: " + listFiltreEvenementAdresse.size());
    }

    protected void initCheckboxesSelectAllClick() {
        initCheckboxSelectAllClick(checkboxEvenementFiltreCategorySelectAll, listCheckboxEvenementCategory);
        initCheckboxSelectAllClick(checkboxEvenementFiltreVilleSelectAll, listCheckboxEvenementVille);
    }

    /*protected void initCheckboxSelectAllClick(MaterialCheckBox cbSelectAll, List<MaterialCheckBox> list) {
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
    }*/
}