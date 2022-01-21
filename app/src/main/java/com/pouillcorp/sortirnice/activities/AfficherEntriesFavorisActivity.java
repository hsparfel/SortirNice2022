package com.pouillcorp.sortirnice.activities;


import android.os.AsyncTask;
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
import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.DetailEntryEntitySimple;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryActivityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryChainEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryFurnishedRentalEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryStandingLevelEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryTypeEntity;
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.interfaces.EntriesBoutiqueApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesHebergementApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesHotelApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesRestaurantApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesShoppingApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesSortieApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesTransportApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesUtileApiService;
import com.pouillcorp.sortirnice.interfaces.EntriesVisiteApiService;
import com.pouillcorp.sortirnice.modelentries.Entries;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.utils.DateUtils;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
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

public class AfficherEntriesFavorisActivity extends NavDrawerActivity implements RecyclerAdapterEntries.Listener {

    int nbEntries;
    List<Entry> listEntries;
    List<EntryEntity> listEntryEntities = new ArrayList<>();
    List<EntryEntity> listEntryEntitiesBasique = new ArrayList<>();

    private static final String TAG = AfficherEntriesFavorisActivity.class.getSimpleName();
    private final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    @BindView(R.id.list_recycler_entry)
    RecyclerView list_recycler_entry;
    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;

    @BindView(R.id.layout_fragment_entry_filtre)
    FrameLayout layoutFragmentEntryFiltre;
    @BindView(R.id.layout_fragment_entry_type)
    FrameLayout layoutFragmentEntryType;

    private RecyclerAdapterEntries adapterEntries;

    int positionScroll = 0;

    boolean layoutFiltreAffiche;
    boolean layoutTypeAffiche;

    List<EntryCategoryEntity> listFiltreEntryCategory = new ArrayList<>();
    List<EntryTypeEntity> listEntryType = new ArrayList<>();

    @Nullable
    @BindView(R.id.fabEntryValiderFiltre)
    FloatingActionButton fabEntryValiderFiltre;
    @Nullable
    @BindView(R.id.fabEntryRazFiltre)
    FloatingActionButton fabEntryRazFiltre;

    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreCategory)
    LinearLayout linearLayoutEntryFiltreCategory;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreCategorySelectAll)
    MaterialCheckBox checkboxEntryFiltreCategorySelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreCategory)
    MaterialButton buttonEntryFiltreCategory;

    @Nullable
    @BindView(R.id.linearLayoutEntryType)
    LinearLayout linearLayoutEntryType;

    boolean filtreCategoryDeplie = false;

    List<MaterialCheckBox> listCheckboxEntryCategory = new ArrayList<>();
    List<MaterialCheckBox> listCheckboxEntryType = new ArrayList<>();

    List<EntryEntity> listEntryEntityFiltre = new ArrayList<>();
    List<EntryEntity> listEntryEntityType = new ArrayList<>();

    List<EntryLocationEntity> listFiltreEntryLocation = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreLocation)
    LinearLayout linearLayoutEntryFiltreLocation;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreLocationSelectAll)
    MaterialCheckBox checkboxEntryFiltreLocationSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreLocation)
    MaterialButton buttonEntryFiltreLocation;
    boolean filtreLocationDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryLocation = new ArrayList<>();

    List<EntryActivityEntity> listFiltreEntryActivity = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreActivity)
    LinearLayout linearLayoutEntryFiltreActivity;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreActivitySelectAll)
    MaterialCheckBox checkboxEntryFiltreActivitySelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreActivity)
    MaterialButton buttonEntryFiltreActivity;
    boolean filtreActivityDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryActivity = new ArrayList<>();

    List<EntryAmenityEntity> listFiltreEntryAmenity = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreAmenity)
    LinearLayout linearLayoutEntryFiltreAmenity;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreAmenitySelectAll)
    MaterialCheckBox checkboxEntryFiltreAmenitySelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreAmenity)
    MaterialButton buttonEntryFiltreAmenity;
    boolean filtreAmenityDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryAmenity = new ArrayList<>();

    List<EntryAnimationEntity> listFiltreEntryAnimation = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreAnimation)
    LinearLayout linearLayoutEntryFiltreAnimation;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreAnimationSelectAll)
    MaterialCheckBox checkboxEntryFiltreAnimationSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreAnimation)
    MaterialButton buttonEntryFiltreAnimation;
    boolean filtreAnimationDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryAnimation = new ArrayList<>();

    List<EntryAtmospherEntity> listFiltreEntryAtmospher = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreAtmospher)
    LinearLayout linearLayoutEntryFiltreAtmospher;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreAtmospherSelectAll)
    MaterialCheckBox checkboxEntryFiltreAtmospherSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreAtmospher)
    MaterialButton buttonEntryFiltreAtmospher;
    boolean filtreAtmospherDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryAtmospher = new ArrayList<>();

    List<EntryChainEntity> listFiltreEntryChain = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreChain)
    LinearLayout linearLayoutEntryFiltreChain;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreChainSelectAll)
    MaterialCheckBox checkboxEntryFiltreChainSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreChain)
    MaterialButton buttonEntryFiltreChain;
    boolean filtreChainDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryChain = new ArrayList<>();

    List<EntryFurnishedRentalEntity> listFiltreEntryFurnishedRental = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreFurnishedRental)
    LinearLayout linearLayoutEntryFiltreFurnishedRental;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreFurnishedRentalSelectAll)
    MaterialCheckBox checkboxEntryFiltreFurnishedRentalSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreFurnishedRental)
    MaterialButton buttonEntryFiltreFurnishedRental;
    boolean filtreFurnishedRentalDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryFurnishedRental = new ArrayList<>();

    List<EntryLabelEntity> listFiltreEntryLabel = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreLabel)
    LinearLayout linearLayoutEntryFiltreLabel;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreLabelSelectAll)
    MaterialCheckBox checkboxEntryFiltreLabelSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreLabel)
    MaterialButton buttonEntryFiltreLabel;
    boolean filtreLabelDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryLabel = new ArrayList<>();

    List<EntryServiceEntity> listFiltreEntryService = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreService)
    LinearLayout linearLayoutEntryFiltreService;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreServiceSelectAll)
    MaterialCheckBox checkboxEntryFiltreServiceSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreService)
    MaterialButton buttonEntryFiltreService;
    boolean filtreServiceDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryService = new ArrayList<>();

    List<EntryStandingLevelEntity> listFiltreEntryStandingLevel = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreStandingLevel)
    LinearLayout linearLayoutEntryFiltreStandingLevel;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreStandingLevelSelectAll)
    MaterialCheckBox checkboxEntryFiltreStandingLevelSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreStandingLevel)
    MaterialButton buttonEntryFiltreStandingLevel;
    boolean filtreStandingLevelDeplie = false;
    List<MaterialCheckBox> listCheckboxEntryStandingLevel = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_entry_various);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        Log.e(TAG, "on create method");
        listEntries = new ArrayList<>();
        nbEntries = 0;

        setTitle("Entries Favoris");
        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_entry).setChecked(true);

        //chargerTous();

        loadAllEntryFavorisFromDB();
        listEntryEntitiesBasique.addAll(listEntryEntities);
        configureRecyclerView();
        /*itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
        itemEntryType.setVisible(true);
        itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        itemEntryFiltre.setVisible(false);*/
        listerFiltre();
        initListFiltres();
        initCheckboxesSelectAllClick();
        progressBar.setVisibility(View.GONE);


        masquerFragmentFiltre();
        masquerFragmentType();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
        itemEntryType.setVisible(true);
        itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        itemEntryFiltre.setVisible(false);
        return true;
    }

    private void loadAllEntryFavorisFromDB() {
        entryEntityDao.detachAll();
        listEntryEntities = entryEntityDao.queryRaw("where favori = 1");
        Collections.sort(listEntryEntities);
    }

    private void masquerFragmentFiltre() {
        layoutFragmentEntryFiltre.setVisibility(View.GONE);
        layoutFiltreAffiche = false;
    }

    private void afficherFragmentFiltre() {
        layoutFragmentEntryFiltre.setVisibility(View.VISIBLE);
        layoutFiltreAffiche = true;
    }

    private void masquerFragmentType() {
        layoutFragmentEntryType.setVisibility(View.GONE);
        layoutTypeAffiche = false;
    }

    private void afficherFragmentType() {
        layoutFragmentEntryType.setVisibility(View.VISIBLE);
        layoutTypeAffiche = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (EntryEntity current : listEntryEntities) {
            current.refresh();
        }
        configureRecyclerView();
        list_recycler_entry.scrollToPosition(positionScroll);
        Log.e(TAG, "on resume method");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_activity_main_entry_type:
                Log.e(TAG, "click sur type entry");
                if (layoutTypeAffiche) {
                    masquerFragmentType();
                } else {
                    afficherFragmentType();
                }
                masquerFragmentFiltre();
                break;
            case R.id.menu_activity_main_entry_filter:
                Log.e(TAG, "click sur filtre entry");
                if (layoutFiltreAffiche) {
                    masquerFragmentFiltre();
                } else {
                    afficherFragmentFiltre();
                }
                masquerFragmentType();
                break;
        }
        return true;
    }

    private void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(list_recycler_entry, R.layout.recycler_list_entry)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        positionScroll = position;
                        ouvrirActiviteSuivante(AfficherEntriesFavorisActivity.this, AfficherEntryDetailActivity.class, "entryId", listEntryEntities.get(position).getId(), false);
                        Log.e("TAG", "Position : " + position);
                    }
                });
    }

    public void configureRecyclerView() {
        adapterEntries = new RecyclerAdapterEntries(listEntryEntities, this);
        list_recycler_entry.setAdapter(adapterEntries);
        list_recycler_entry.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    @Override
    public void onClickEntriesButton(int position) {
    }

    public void afficherListCbEntryFiltreCategory(View view) {
        if (!filtreCategoryDeplie) {
            filtreCategoryDeplie = true;
            checkboxEntryFiltreCategorySelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreCategory.setVisibility(View.VISIBLE);
            buttonEntryFiltreCategory.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreCategoryDeplie = false;
            checkboxEntryFiltreCategorySelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreCategory.setVisibility(View.GONE);
            buttonEntryFiltreCategory.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreLocation(View view) {
        if (!filtreLocationDeplie) {
            filtreLocationDeplie = true;
            checkboxEntryFiltreLocationSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreLocation.setVisibility(View.VISIBLE);
            buttonEntryFiltreLocation.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreLocationDeplie = false;
            checkboxEntryFiltreLocationSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreLocation.setVisibility(View.GONE);
            buttonEntryFiltreLocation.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreActivity(View view) {
        if (!filtreActivityDeplie) {
            filtreActivityDeplie = true;
            checkboxEntryFiltreActivitySelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreActivity.setVisibility(View.VISIBLE);
            buttonEntryFiltreActivity.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreActivityDeplie = false;
            checkboxEntryFiltreActivitySelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreActivity.setVisibility(View.GONE);
            buttonEntryFiltreActivity.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreAmenity(View view) {
        if (!filtreAmenityDeplie) {
            filtreAmenityDeplie = true;
            checkboxEntryFiltreAmenitySelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreAmenity.setVisibility(View.VISIBLE);
            buttonEntryFiltreAmenity.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreAmenityDeplie = false;
            checkboxEntryFiltreAmenitySelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreAmenity.setVisibility(View.GONE);
            buttonEntryFiltreAmenity.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreAnimation(View view) {
        if (!filtreAnimationDeplie) {
            filtreAnimationDeplie = true;
            checkboxEntryFiltreAnimationSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreAnimation.setVisibility(View.VISIBLE);
            buttonEntryFiltreAnimation.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreAnimationDeplie = false;
            checkboxEntryFiltreAnimationSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreAnimation.setVisibility(View.GONE);
            buttonEntryFiltreAnimation.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreAtmospher(View view) {
        if (!filtreAtmospherDeplie) {
            filtreAtmospherDeplie = true;
            checkboxEntryFiltreAtmospherSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreAtmospher.setVisibility(View.VISIBLE);
            buttonEntryFiltreAtmospher.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreAtmospherDeplie = false;
            checkboxEntryFiltreAtmospherSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreAtmospher.setVisibility(View.GONE);
            buttonEntryFiltreAtmospher.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreChain(View view) {
        if (!filtreChainDeplie) {
            filtreChainDeplie = true;
            checkboxEntryFiltreChainSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreChain.setVisibility(View.VISIBLE);
            buttonEntryFiltreChain.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreChainDeplie = false;
            checkboxEntryFiltreChainSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreChain.setVisibility(View.GONE);
            buttonEntryFiltreChain.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreFurnishedRental(View view) {
        if (!filtreFurnishedRentalDeplie) {
            filtreFurnishedRentalDeplie = true;
            checkboxEntryFiltreFurnishedRentalSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreFurnishedRental.setVisibility(View.VISIBLE);
            buttonEntryFiltreFurnishedRental.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreFurnishedRentalDeplie = false;
            checkboxEntryFiltreFurnishedRentalSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreFurnishedRental.setVisibility(View.GONE);
            buttonEntryFiltreFurnishedRental.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreLabel(View view) {
        if (!filtreLabelDeplie) {
            filtreLabelDeplie = true;
            checkboxEntryFiltreLabelSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreLabel.setVisibility(View.VISIBLE);
            buttonEntryFiltreLabel.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreLabelDeplie = false;
            checkboxEntryFiltreLabelSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreLabel.setVisibility(View.GONE);
            buttonEntryFiltreLabel.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreService(View view) {
        if (!filtreServiceDeplie) {
            filtreServiceDeplie = true;
            checkboxEntryFiltreServiceSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreService.setVisibility(View.VISIBLE);
            buttonEntryFiltreService.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreServiceDeplie = false;
            checkboxEntryFiltreServiceSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreService.setVisibility(View.GONE);
            buttonEntryFiltreService.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    public void afficherListCbEntryFiltreStandingLevel(View view) {
        if (!filtreStandingLevelDeplie) {
            filtreStandingLevelDeplie = true;
            checkboxEntryFiltreStandingLevelSelectAll.setVisibility(View.VISIBLE);
            linearLayoutEntryFiltreStandingLevel.setVisibility(View.VISIBLE);
            buttonEntryFiltreStandingLevel.setIconResource(R.drawable.outline_arrow_drop_down_black_18);
        } else {
            filtreStandingLevelDeplie = false;
            checkboxEntryFiltreStandingLevelSelectAll.setVisibility(View.GONE);
            linearLayoutEntryFiltreStandingLevel.setVisibility(View.GONE);
            buttonEntryFiltreStandingLevel.setIconResource(R.drawable.outline_arrow_right_black_18);
        }
    }

    protected boolean verifFiltreActif(List<? extends DetailEntryEntitySimple> list) {
        boolean bool = false;
        for (DetailEntryEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    protected void afficherOuMasquerBoutonFiltre(MaterialButton btn, List<? extends DetailEntryEntitySimple> list) {
        if (list.size() == 0) {
            btn.setVisibility(View.GONE);
        } else {
            btn.setVisibility(View.VISIBLE);
        }
    }

    protected void afficherOuMasquerTousBoutonsFiltre() {
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreActivity, listFiltreEntryActivity);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreAmenity, listFiltreEntryAmenity);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreAnimation, listFiltreEntryAnimation);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreAtmospher, listFiltreEntryAtmospher);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreCategory, listFiltreEntryCategory);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreChain, listFiltreEntryChain);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreFurnishedRental, listFiltreEntryFurnishedRental);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreLabel, listFiltreEntryLabel);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreLocation, listFiltreEntryLocation);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreService, listFiltreEntryService);
        afficherOuMasquerBoutonFiltre(buttonEntryFiltreStandingLevel, listFiltreEntryStandingLevel);
    }

    protected void reinitListeEntries() {
        listEntryEntities.clear();
        listEntryEntities.addAll(listEntryEntitiesBasique);
        Collections.sort(listEntryEntities);
        listEntryEntityType = new ArrayList<>();
        listEntryEntityType.addAll(listEntryEntities);
        for (EntryEntity current : listEntryEntities) {
            if (listEntryEntityType.contains(current)) {
                boolean isFiltered = false;
                for (EntryTypeEntity filtre : listEntryType) {
                    if (filtre.isChecked()) {
                        if (current.getEntryType().toString().equalsIgnoreCase(filtre.getValue())) {
                            isFiltered = true;
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityType.remove(current);
                }
            }
        }
        listEntryEntities.clear();
        listEntryEntities.addAll(listEntryEntityType);
    }

    @Optional
    @OnClick(R.id.fabEntryValiderFiltre)
    public void fabEntryFiltreClick() {
        progressBar.setVisibility(View.VISIBLE);
        reinitListeEntries();
        masquerFragmentFiltre();
        listEntryEntityFiltre = new ArrayList<>();
        listEntryEntityFiltre.addAll(listEntryEntities);
        boolean boolEntryCategory = verifFiltreActif(listFiltreEntryCategory);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryCategory && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryCategoryEntity filtre : listFiltreEntryCategory) {
                    if (filtre.isChecked() && current.getListCategories() != null) {
                        for (EntryCategoryEntity current2 : current.getListCategories()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryLocation = verifFiltreActif(listFiltreEntryLocation);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryLocation && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryLocationEntity filtre : listFiltreEntryLocation) {
                    if (filtre.isChecked() && current.getListLocations() != null) {
                        for (EntryLocationEntity current2 : current.getListLocations()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryActivity = verifFiltreActif(listFiltreEntryActivity);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryActivity && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryActivityEntity filtre : listFiltreEntryActivity) {
                    if (filtre.isChecked() && current.getListActivities() != null) {
                        for (EntryActivityEntity current2 : current.getListActivities()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryAmenity = verifFiltreActif(listFiltreEntryAmenity);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryAmenity && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryAmenityEntity filtre : listFiltreEntryAmenity) {
                    if (filtre.isChecked() && current.getListAmenities() != null) {
                        for (EntryAmenityEntity current2 : current.getListAmenities()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryAnimation = verifFiltreActif(listFiltreEntryAnimation);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryAnimation && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryAnimationEntity filtre : listFiltreEntryAnimation) {
                    if (filtre.isChecked() && current.getListAnimations() != null) {
                        for (EntryAnimationEntity current2 : current.getListAnimations()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryAtmospher = verifFiltreActif(listFiltreEntryAtmospher);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryAtmospher && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryAtmospherEntity filtre : listFiltreEntryAtmospher) {
                    if (filtre.isChecked() && current.getListAtmosphere() != null) {
                        for (EntryAtmospherEntity current2 : current.getListAtmosphere()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryChain = verifFiltreActif(listFiltreEntryChain);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryChain && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryChainEntity filtre : listFiltreEntryChain) {
                    if (filtre.isChecked() && current.getListChains() != null) {
                        for (EntryChainEntity current2 : current.getListChains()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryFurnishedRental = verifFiltreActif(listFiltreEntryFurnishedRental);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryFurnishedRental && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryFurnishedRentalEntity filtre : listFiltreEntryFurnishedRental) {
                    if (filtre.isChecked() && current.getListFurnishedRentals() != null) {
                        for (EntryFurnishedRentalEntity current2 : current.getListFurnishedRentals()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryLabel = verifFiltreActif(listFiltreEntryLabel);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryLabel && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryLabelEntity filtre : listFiltreEntryLabel) {
                    if (filtre.isChecked() && current.getListLabels() != null) {
                        for (EntryLabelEntity current2 : current.getListLabels()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryService = verifFiltreActif(listFiltreEntryService);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryService && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryServiceEntity filtre : listFiltreEntryService) {
                    if (filtre.isChecked() && current.getListServices() != null) {
                        for (EntryServiceEntity current2 : current.getListServices()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }

        boolean boolEntryStandingLevel = verifFiltreActif(listFiltreEntryStandingLevel);
        for (EntryEntity current : listEntryEntities) {
            if (boolEntryStandingLevel && listEntryEntityFiltre.contains(current)) {
                boolean isFiltered = false;
                for (EntryStandingLevelEntity filtre : listFiltreEntryStandingLevel) {
                    if (filtre.isChecked() && current.getListStandingLevels() != null) {
                        for (EntryStandingLevelEntity current2 : current.getListStandingLevels()) {
                            if (current2.getValue().equalsIgnoreCase(filtre.getValue())) {
                                isFiltered = true;
                            }
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityFiltre.remove(current);
                }
            }
        }
        listEntryEntities.clear();
        listEntryEntities.addAll(listEntryEntityFiltre);
        configureRecyclerView();
        progressBar.setVisibility(View.GONE);
    }

    @Optional
    @OnClick(R.id.fabEntryValiderType)
    public void fabEntryTypeClick() {
     //   Log.e(TAG, "Time 1: " + new Date());
        masquerFragmentType();
        reinitListeEntries();
        listEntryEntityType = new ArrayList<>();
        listEntryEntityType.addAll(listEntryEntities);
        for (EntryEntity current : listEntryEntities) {
            if (listEntryEntityType.contains(current)) {
                boolean isFiltered = false;
                for (EntryTypeEntity filtre : listEntryType) {
                    if (filtre.isChecked()) {
                        if (current.getEntryType().toString().equalsIgnoreCase(filtre.getValue())) {
                            isFiltered = true;
                        }
                    }
                }
                if (!isFiltered) {
                    listEntryEntityType.remove(current);
                }
            }
        }
     //   Log.e(TAG, "Time 2: " + new Date());
        listEntryEntities.clear();
        listEntryEntities.addAll(listEntryEntityType);
        itemEntryFiltre.setVisible(true);
        listerFiltreReel();
      //  Log.e(TAG, "Time 3: " + new Date());
        afficherOuMasquerTousBoutonsFiltre();
        initListFiltres();
     //   Log.e(TAG, "Time 4: " + new Date());
        initCheckboxesSelectAllClick();
        configureRecyclerView();
   //     Log.e(TAG, "Time 5: " + new Date());
    }

    @Optional
    @OnClick(R.id.fabEntryRazFiltre)
    public void fabEntryRazFiltreClick() {
        progressBar.setVisibility(View.VISIBLE);
        decocherTout();
        masquerFragmentFiltre();
        itemEntryFiltre.setVisible(false);
        listEntryEntities.clear();
        listEntryEntities.addAll(listEntryEntityType);
        configureRecyclerView();
        progressBar.setVisibility(View.GONE);
    }

    @Optional
    @OnClick(R.id.fabEntryRazType)
    public void fabEntryRazTypeClick() {
        progressBar.setVisibility(View.VISIBLE);
        decocherToutType();
        fabEntryRazFiltreClick();
        masquerFragmentType();
        listEntryEntities.clear();
        listEntryEntities.addAll(listEntryEntitiesBasique);
        configureRecyclerView();
        progressBar.setVisibility(View.GONE);
    }

    public void decocherFiltre(List<? extends DetailEntryEntitySimple> list) {
        for (DetailEntryEntitySimple current : list) {
            current.setChecked(false);
        }
    }

    public void decocherCheckbox(List<MaterialCheckBox> list) {
        for (MaterialCheckBox current : list) {
            current.setChecked(false);
        }
    }

    public void decocherCheckbox(MaterialCheckBox cb) {
        cb.setChecked(false);
    }

    public void decocherTout() {
        decocherFiltre(listFiltreEntryCategory);
        decocherCheckbox(listCheckboxEntryCategory);
        decocherCheckbox(checkboxEntryFiltreCategorySelectAll);
        decocherFiltre(listFiltreEntryLocation);
        decocherCheckbox(listCheckboxEntryLocation);
        decocherCheckbox(checkboxEntryFiltreLocationSelectAll);
        decocherFiltre(listFiltreEntryActivity);
        decocherCheckbox(listCheckboxEntryActivity);
        decocherCheckbox(checkboxEntryFiltreActivitySelectAll);
        decocherFiltre(listFiltreEntryAmenity);
        decocherCheckbox(listCheckboxEntryAmenity);
        decocherCheckbox(checkboxEntryFiltreAmenitySelectAll);
        decocherFiltre(listFiltreEntryAnimation);
        decocherCheckbox(listCheckboxEntryAnimation);
        decocherCheckbox(checkboxEntryFiltreAnimationSelectAll);
        decocherFiltre(listFiltreEntryAtmospher);
        decocherCheckbox(listCheckboxEntryAtmospher);
        decocherCheckbox(checkboxEntryFiltreAtmospherSelectAll);
        decocherFiltre(listFiltreEntryChain);
        decocherCheckbox(listCheckboxEntryChain);
        decocherCheckbox(checkboxEntryFiltreChainSelectAll);
        decocherFiltre(listFiltreEntryFurnishedRental);
        decocherCheckbox(listCheckboxEntryFurnishedRental);
        decocherCheckbox(checkboxEntryFiltreFurnishedRentalSelectAll);
        decocherFiltre(listFiltreEntryLabel);
        decocherCheckbox(listCheckboxEntryLabel);
        decocherCheckbox(checkboxEntryFiltreLabelSelectAll);
        decocherFiltre(listFiltreEntryService);
        decocherCheckbox(listCheckboxEntryService);
        decocherCheckbox(checkboxEntryFiltreServiceSelectAll);
        decocherFiltre(listFiltreEntryStandingLevel);
        decocherCheckbox(listCheckboxEntryStandingLevel);
        decocherCheckbox(checkboxEntryFiltreStandingLevelSelectAll);
    }

    public void decocherToutType() {
        decocherFiltre(listEntryType);
        decocherCheckbox(listCheckboxEntryType);
    }

    protected void initFiltre(List<? extends DetailEntryEntitySimple> list, LinearLayout ll, List<MaterialCheckBox> listCb, MaterialCheckBox cb) {
        ll.removeAllViews();
        listCb.clear();
        Collections.sort(list);
        for (DetailEntryEntitySimple current : list) {
            MaterialCheckBox checkBox = new MaterialCheckBox(this);
            checkBox.setText(current.getValue());
            checkBox.setChecked(current.isChecked());
            checkBox.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        current.setChecked(true);
                    } else {
                        current.setChecked(false);
                        if (!verifSiUnFiltreMinimum(list) && cb != null) {
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

    protected void initListFiltres() {
        boolean boolTypeBoutique = false;
        boolean boolTypeHebergement = false;
        boolean boolTypeHotel = false;
        boolean boolTypeRestaurant = false;
        boolean boolTypeShopping = false;
        boolean boolTypeSortie = false;
        boolean boolTypeTransport = false;
        boolean boolTypeUtile = false;
        boolean boolTypeVisite = false;

        for (EntryTypeEntity current : listEntryType) {
            if (current.isChecked()) {
                if (current.getValue().equalsIgnoreCase(EntriesType.Boutique.toString())) {
                    boolTypeBoutique = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Restaurant.toString())) {
                    boolTypeRestaurant = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Transport.toString())) {
                    boolTypeTransport = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Hebergement.toString())) {
                    boolTypeHebergement = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Hotel.toString())) {
                    boolTypeHotel = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Shopping.toString())) {
                    boolTypeShopping = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Visite.toString())) {
                    boolTypeVisite = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Utile.toString())) {
                    boolTypeUtile = true;
                } else if (current.getValue().equalsIgnoreCase(EntriesType.Sortie.toString())) {
                    boolTypeSortie = true;
                }
            }
        }

        listEntryType.clear();
        for (EntriesType current : EntriesType.values()) {

            EntryTypeEntity entryTypeEntity = new EntryTypeEntity();

            entryTypeEntity.setValue(current.toString());
            if (boolTypeBoutique && current.toString().equalsIgnoreCase(EntriesType.Boutique.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeRestaurant && current.toString().equalsIgnoreCase(EntriesType.Restaurant.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeTransport && current.toString().equalsIgnoreCase(EntriesType.Transport.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeHebergement && current.toString().equalsIgnoreCase(EntriesType.Hebergement.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeHotel && current.toString().equalsIgnoreCase(EntriesType.Hotel.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeShopping && current.toString().equalsIgnoreCase(EntriesType.Shopping.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeVisite && current.toString().equalsIgnoreCase(EntriesType.Visite.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeUtile && current.toString().equalsIgnoreCase(EntriesType.Utile.toString())) {
                entryTypeEntity.setChecked(true);
            }
            if (boolTypeSortie && current.toString().equalsIgnoreCase(EntriesType.Sortie.toString())) {
                entryTypeEntity.setChecked(true);
            }
            listEntryType.add(entryTypeEntity);
        }
        initFiltre(listEntryType, linearLayoutEntryType, listCheckboxEntryType, null);
        initFiltre(listFiltreEntryCategory, linearLayoutEntryFiltreCategory, listCheckboxEntryCategory, checkboxEntryFiltreCategorySelectAll);
        initFiltre(listFiltreEntryLocation, linearLayoutEntryFiltreLocation, listCheckboxEntryLocation, checkboxEntryFiltreLocationSelectAll);
        initFiltre(listFiltreEntryActivity, linearLayoutEntryFiltreActivity, listCheckboxEntryActivity, checkboxEntryFiltreActivitySelectAll);
        initFiltre(listFiltreEntryAmenity, linearLayoutEntryFiltreAmenity, listCheckboxEntryAmenity, checkboxEntryFiltreAmenitySelectAll);
        initFiltre(listFiltreEntryAnimation, linearLayoutEntryFiltreAnimation, listCheckboxEntryAnimation, checkboxEntryFiltreAnimationSelectAll);
        initFiltre(listFiltreEntryAtmospher, linearLayoutEntryFiltreAtmospher, listCheckboxEntryAtmospher, checkboxEntryFiltreAtmospherSelectAll);
        initFiltre(listFiltreEntryChain, linearLayoutEntryFiltreChain, listCheckboxEntryChain, checkboxEntryFiltreChainSelectAll);
        initFiltre(listFiltreEntryFurnishedRental, linearLayoutEntryFiltreFurnishedRental, listCheckboxEntryFurnishedRental, checkboxEntryFiltreFurnishedRentalSelectAll);
        initFiltre(listFiltreEntryLabel, linearLayoutEntryFiltreLabel, listCheckboxEntryLabel, checkboxEntryFiltreLabelSelectAll);
        initFiltre(listFiltreEntryService, linearLayoutEntryFiltreService, listCheckboxEntryService, checkboxEntryFiltreServiceSelectAll);
        initFiltre(listFiltreEntryStandingLevel, linearLayoutEntryFiltreStandingLevel, listCheckboxEntryStandingLevel, checkboxEntryFiltreStandingLevelSelectAll);
    }

    protected boolean verifSiUnFiltreMinimum(List<? extends DetailEntryEntitySimple> list) {
        boolean bool = false;
        for (DetailEntryEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    public void listerFiltre() {
        listFiltreEntryCategory = entryCategoryEntityDao.loadAll();
    //    Log.e(TAG, "Number of Category received: " + listFiltreEntryCategory.size());
        listFiltreEntryLocation = entryLocationEntityDao.loadAll();
   //     Log.e(TAG, "Number of Location received: " + listFiltreEntryLocation.size());
        listFiltreEntryActivity = entryActivityEntityDao.loadAll();
   //     Log.e(TAG, "Number of Activity received: " + listFiltreEntryActivity.size());
        listFiltreEntryAmenity = entryAmenityEntityDao.loadAll();
   //     Log.e(TAG, "Number of Amenity received: " + listFiltreEntryAmenity.size());
        listFiltreEntryAnimation = entryAnimationEntityDao.loadAll();
    //    Log.e(TAG, "Number of Animation received: " + listFiltreEntryAnimation.size());
        listFiltreEntryAtmospher = entryAtmospherEntityDao.loadAll();
     //   Log.e(TAG, "Number of Atmospher received: " + listFiltreEntryAtmospher.size());
        listFiltreEntryChain = entryChainEntityDao.loadAll();
     //   Log.e(TAG, "Number of Chain received: " + listFiltreEntryChain.size());
        listFiltreEntryFurnishedRental = entryFurnishedRentalEntityDao.loadAll();
    //    Log.e(TAG, "Number of FurnishedRental received: " + listFiltreEntryFurnishedRental.size());
        listFiltreEntryLabel = entryLabelEntityDao.loadAll();
      //  Log.e(TAG, "Number of Label received: " + listFiltreEntryLabel.size());
        listFiltreEntryService = entryServiceEntityDao.loadAll();
      //  Log.e(TAG, "Number of Service received: " + listFiltreEntryService.size());
        listFiltreEntryStandingLevel = entryStandingLevelEntityDao.loadAll();
      //  Log.e(TAG, "Number of StandingLevel received: " + listFiltreEntryStandingLevel.size());
    }

    public void listerFiltreReel() {
        HashSet<EntryCategoryEntity> hashsetCategory = new HashSet<>();
        listFiltreEntryCategory = new ArrayList<>();
        HashSet<EntryLocationEntity> hashsetLocation = new HashSet<>();
        listFiltreEntryLocation = new ArrayList<>();
        HashSet<EntryAmenityEntity> hashsetAmenity = new HashSet<>();
        listFiltreEntryAmenity = new ArrayList<>();
        HashSet<EntryActivityEntity> hashsetActivity = new HashSet<>();
        listFiltreEntryActivity = new ArrayList<>();
        HashSet<EntryAnimationEntity> hashsetAnimation = new HashSet<>();
        listFiltreEntryAnimation = new ArrayList<>();
        HashSet<EntryAtmospherEntity> hashsetAtmospher = new HashSet<>();
        listFiltreEntryAtmospher = new ArrayList<>();
        HashSet<EntryChainEntity> hashsetChain = new HashSet<>();
        listFiltreEntryChain = new ArrayList<>();
        HashSet<EntryFurnishedRentalEntity> hashsetFurnishedRental = new HashSet<>();
        listFiltreEntryFurnishedRental = new ArrayList<>();
        HashSet<EntryLabelEntity> hashsetLabel = new HashSet<>();
        listFiltreEntryLabel = new ArrayList<>();
        HashSet<EntryServiceEntity> hashsetService = new HashSet<>();
        listFiltreEntryService = new ArrayList<>();
        HashSet<EntryStandingLevelEntity> hashsetStandingLevel = new HashSet<>();
        listFiltreEntryStandingLevel = new ArrayList<>();
      //  Log.e(TAG, "Time A: " + new Date());
        for (EntryEntity current : listEntryEntities) {
            if (current.getListCategories().size() > 0) {
                hashsetCategory.addAll(current.getListCategories());
            }
            if (current.getListLocations().size() > 0) {
                hashsetLocation.addAll(current.getListLocations());
            }
            if (current.getListActivities().size() > 0) {
                hashsetActivity.addAll(current.getListActivities());
            }
            if (current.getListAmenities().size() > 0) {
                hashsetAmenity.addAll(current.getListAmenities());
            }
            if (current.getListAnimations().size() > 0) {
                hashsetAnimation.addAll(current.getListAnimations());
            }
            if (current.getListChains().size() > 0) {
                hashsetChain.addAll(current.getListChains());
            }
            if (current.getListAtmosphere().size() > 0) {
                hashsetAtmospher.addAll(current.getListAtmosphere());
            }
            if (current.getListFurnishedRentals().size() > 0) {
                hashsetFurnishedRental.addAll(current.getListFurnishedRentals());
            }
            if (current.getListLabels().size() > 0) {
                hashsetLabel.addAll(current.getListLabels());
            }
            if (current.getListStandingLevels().size() > 0) {
                hashsetStandingLevel.addAll(current.getListStandingLevels());
            }
            if (current.getListServices().size() > 0) {
                hashsetService.addAll(current.getListServices());
            }
       //     Log.e(TAG, "Time B (boucle): " + new Date());
        }
        listFiltreEntryCategory.addAll(hashsetCategory);
        if (listFiltreEntryCategory.size() > 0) {
            Collections.sort(listFiltreEntryCategory);
        }
       // Log.e(TAG, "Number of Category reçu: " + listFiltreEntryCategory.size());

        listFiltreEntryLocation.addAll(hashsetLocation);
        if (listFiltreEntryLocation.size() > 0) {
            Collections.sort(listFiltreEntryLocation);
        }
      //  Log.e(TAG, "Number of Location reçu: " + listFiltreEntryLocation.size());

        listFiltreEntryActivity.addAll(hashsetActivity);
        if (listFiltreEntryActivity.size() > 0) {
            Collections.sort(listFiltreEntryActivity);
        }
    //    Log.e(TAG, "Number of Activity reçu: " + listFiltreEntryActivity.size());

        listFiltreEntryAmenity.addAll(hashsetAmenity);
        if (listFiltreEntryAmenity.size() > 0) {
            Collections.sort(listFiltreEntryAmenity);
        }
     //   Log.e(TAG, "Number of Amenity reçu: " + listFiltreEntryAmenity.size());

        listFiltreEntryAnimation.addAll(hashsetAnimation);
        if (listFiltreEntryAnimation.size() > 0) {
            Collections.sort(listFiltreEntryAnimation);
        }
    //    Log.e(TAG, "Number of Animation reçu: " + listFiltreEntryAnimation.size());

        listFiltreEntryAtmospher.addAll(hashsetAtmospher);
        if (listFiltreEntryAtmospher.size() > 0) {
            Collections.sort(listFiltreEntryAtmospher);
        }
    //    Log.e(TAG, "Number of Atmospher reçu: " + listFiltreEntryAtmospher.size());

        listFiltreEntryChain.addAll(hashsetChain);
        if (listFiltreEntryChain.size() > 0) {
            Collections.sort(listFiltreEntryChain);
        }
     //   Log.e(TAG, "Number of Chain reçu: " + listFiltreEntryChain.size());

        listFiltreEntryFurnishedRental.addAll(hashsetFurnishedRental);
        if (listFiltreEntryFurnishedRental.size() > 0) {
            Collections.sort(listFiltreEntryFurnishedRental);
        }
    //    Log.e(TAG, "Number of FurnishedRental reçu: " + listFiltreEntryFurnishedRental.size());

        listFiltreEntryLabel.addAll(hashsetLabel);
        if (listFiltreEntryLabel.size() > 0) {
            Collections.sort(listFiltreEntryLabel);
        }
    //    Log.e(TAG, "Number of Label reçu: " + listFiltreEntryLabel.size());

        listFiltreEntryService.addAll(hashsetService);
        if (listFiltreEntryService.size() > 0) {
            Collections.sort(listFiltreEntryService);
        }
       // Log.e(TAG, "Number of Service reçu: " + listFiltreEntryService.size());

        listFiltreEntryStandingLevel.addAll(hashsetStandingLevel);
        if (listFiltreEntryStandingLevel.size() > 0) {
            Collections.sort(listFiltreEntryStandingLevel);
        }
        //Log.e(TAG, "Number of StandingLevel reçu: " + listFiltreEntryStandingLevel.size());
    }

    protected void initCheckboxesSelectAllClick() {
        initCheckboxSelectAllClick(checkboxEntryFiltreCategorySelectAll, listCheckboxEntryCategory);
        initCheckboxSelectAllClick(checkboxEntryFiltreLocationSelectAll, listCheckboxEntryLocation);
        initCheckboxSelectAllClick(checkboxEntryFiltreActivitySelectAll, listCheckboxEntryActivity);
        initCheckboxSelectAllClick(checkboxEntryFiltreAmenitySelectAll, listCheckboxEntryAmenity);
        initCheckboxSelectAllClick(checkboxEntryFiltreAnimationSelectAll, listCheckboxEntryAnimation);
        initCheckboxSelectAllClick(checkboxEntryFiltreAtmospherSelectAll, listCheckboxEntryAtmospher);
        initCheckboxSelectAllClick(checkboxEntryFiltreChainSelectAll, listCheckboxEntryChain);
        initCheckboxSelectAllClick(checkboxEntryFiltreFurnishedRentalSelectAll, listCheckboxEntryFurnishedRental);
        initCheckboxSelectAllClick(checkboxEntryFiltreLabelSelectAll, listCheckboxEntryLabel);
        initCheckboxSelectAllClick(checkboxEntryFiltreServiceSelectAll, listCheckboxEntryService);
        initCheckboxSelectAllClick(checkboxEntryFiltreStandingLevelSelectAll, listCheckboxEntryStandingLevel);
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


}