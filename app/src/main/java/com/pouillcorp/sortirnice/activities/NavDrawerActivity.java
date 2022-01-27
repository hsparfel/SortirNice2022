package com.pouillcorp.sortirnice.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.dao.*;
import com.pouillcorp.sortirnice.email.SendEmailService;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.DetailEntryEntitySimple;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryActivityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAddressEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAffiliationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAllianceOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCapacityEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryChainEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCommerciaEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryCommonTagEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryContactEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryDescriptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryDisabledOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryFamilyOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryFrpOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryFurnishedRentalEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryGridEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryGroupOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLanguageEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLivingEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryOpeningEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryPoiOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryProfileEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryPublicationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntrySectorEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntrySpaceEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryStandingLevelEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryStationEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryTariffEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryTypeEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryActivityEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAffiliationEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAllianceOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAmenityEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAnimationEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAtmospherEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryChainEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosingEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosureEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCommerciaEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCommonTagEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryContactEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDescriptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDisabledOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFamilyOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFrpOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFurnishedRentalEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryGroupOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLabelEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLanguageEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLocationEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryOpeningEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPaymentEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPoiOptionEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryProfileEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPublicationEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySectorEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryServiceEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySpaceEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStandingLevelEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStationEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryTariffEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryOpeningEntityWithEntryGridEntity;
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
import com.pouillcorp.sortirnice.enumeration.EntriesType;
import com.pouillcorp.sortirnice.enumeration.EvenementTri;
import com.pouillcorp.sortirnice.enumeration.ExclusionEntryActivites;
import com.pouillcorp.sortirnice.enumeration.ExclusionEntryAmenity;
import com.pouillcorp.sortirnice.enumeration.ExclusionEntryCategorie;
import com.pouillcorp.sortirnice.enumeration.ExclusionEntryLieu;
import com.pouillcorp.sortirnice.enumeration.ExclusionEntryService;
import com.pouillcorp.sortirnice.enumeration.ExclusionEventCategorie;
import com.pouillcorp.sortirnice.enumeration.FusionEntryActivite;
import com.pouillcorp.sortirnice.enumeration.FusionEntryCategorie;
import com.pouillcorp.sortirnice.enumeration.FusionEventCategorie;
import com.pouillcorp.sortirnice.modelentries.Activity;
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
import com.pouillcorp.sortirnice.modelentries.Contact;
import com.pouillcorp.sortirnice.modelentries.Description;
import com.pouillcorp.sortirnice.modelentries.DisabledOption;
import com.pouillcorp.sortirnice.modelentries.Entry;
import com.pouillcorp.sortirnice.modelentries.FamilyOption;
import com.pouillcorp.sortirnice.modelentries.FrpOption;
import com.pouillcorp.sortirnice.modelentries.FurnishedRental;
import com.pouillcorp.sortirnice.modelentries.Grid;
import com.pouillcorp.sortirnice.modelentries.GroupOption;
import com.pouillcorp.sortirnice.modelentries.Label;
import com.pouillcorp.sortirnice.modelentries.Language;
import com.pouillcorp.sortirnice.modelentries.Location;
import com.pouillcorp.sortirnice.modelentries.Opening;
import com.pouillcorp.sortirnice.modelentries.Option;
import com.pouillcorp.sortirnice.modelentries.Payment;
import com.pouillcorp.sortirnice.modelentries.PoiOption;
import com.pouillcorp.sortirnice.modelentries.Profile;
import com.pouillcorp.sortirnice.modelentries.Publication;
import com.pouillcorp.sortirnice.modelentries.Sector;
import com.pouillcorp.sortirnice.modelentries.Service;
import com.pouillcorp.sortirnice.modelentries.Space;
import com.pouillcorp.sortirnice.modelentries.StandingLevel;
import com.pouillcorp.sortirnice.modelentries.Station;
import com.pouillcorp.sortirnice.modelentries.Tariff;
import com.pouillcorp.sortirnice.modelevents.Address;
import com.pouillcorp.sortirnice.modelevents.Event;
import com.pouillcorp.sortirnice.modelevents.Image;
import com.pouillcorp.sortirnice.modelevents.RefEntries;
import com.pouillcorp.sortirnice.modelevents.Secto;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEntries;
import com.pouillcorp.sortirnice.recycler.adapter.RecyclerAdapterEvenements;
import com.pouillcorp.sortirnice.utils.ItemClickSupport;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import icepick.Icepick;
import retrofit2.Retrofit;

public class NavDrawerActivity<T> extends AppCompatActivity {

    protected Toolbar toolbar;
    protected DrawerLayout drawerLayout;
    protected BottomNavigationView bottomNavigationView;
    protected DaoSession daoSession;
    protected MenuItem itemEvenementFiltre;
    protected MenuItem itemEvenementTri;
    protected MenuItem itemEntryFiltre;
    protected MenuItem itemEntryType;


    protected EntryEntityDao entryEntityDao;
    protected EntryActivityEntityDao entryActivityEntityDao;
    protected EntryAddressEntityDao entryAddressEntityDao;
    protected EntryAffiliationEntityDao entryAffiliationEntityDao;
    protected EntryAmenityEntityDao entryAmenityEntityDao;
    protected EntryAnimationEntityDao entryAnimationEntityDao;
    protected EntryAtmospherEntityDao entryAtmospherEntityDao;
    protected EntryCapacityEntityDao entryCapacityEntityDao;
    protected EntryCategoryEntityDao entryCategoryEntityDao;
    protected EntryChainEntityDao entryChainEntityDao;
    protected EntryClosingEntityDao entryClosingEntityDao;
    protected EntryClosureEntityDao entryClosureEntityDao;
    protected EntryCommonTagEntityDao entryCommonTagEntityDao;
    protected EntryContactEntityDao entryContactEntityDao;
    protected EntryDescriptionEntityDao entryDescriptionEntityDao;
    protected EntryDisabledOptionEntityDao entryDisabledOptionEntityDao;
    protected EntryFamilyOptionEntityDao entryFamilyOptionEntityDao;
    protected EntryAllianceOptionEntityDao entryAllianceOptionEntityDao;
    protected EntryFurnishedRentalEntityDao entryFurnishedRentalEntityDao;
    protected EntryFrpOptionEntityDao entryFrpOptionEntityDao;
    protected EntryGridEntityDao entryGridEntityDao;
    protected EntryGroupOptionEntityDao entryGroupOptionEntityDao;
    protected EntryImageEntityDao entryImageEntityDao;
    protected EntryLabelEntityDao entryLabelEntityDao;
    protected EntryLanguageEntityDao entryLanguageEntityDao;
    protected EntryLivingEntityDao entryLivingEntityDao;
    protected EntryLocationEntityDao entryLocationEntityDao;
    protected EntryOpeningEntityDao entryOpeningEntityDao;
    protected EntryOptionEntityDao entryOptionEntityDao;
    protected EntryPaymentEntityDao entryPaymentEntityDao;
    protected EntryPoiOptionEntityDao entryPoiOptionEntityDao;
    protected EntryProfileEntityDao entryProfileEntityDao;
    protected EntryPublicationEntityDao entryPublicationEntityDao;
    protected EntrySectorEntityDao entrySectorEntityDao;
    protected EntryServiceEntityDao entryServiceEntityDao;
    protected EntrySpaceEntityDao entrySpaceEntityDao;
    protected EntryStandingLevelEntityDao entryStandingLevelEntityDao;
    protected EntryStationEntityDao entryStationEntityDao;
    protected EntryTariffEntityDao entryTariffEntityDao;
    protected JoinEntryEntityWithEntryActivityEntityDao joinEntryEntityWithEntryActivityEntityDao;
    protected JoinEntryEntityWithEntryAffiliationEntityDao joinEntryEntityWithEntryAffiliationEntityDao;
    protected JoinEntryEntityWithEntryAmenityEntityDao joinEntryEntityWithEntryAmenityEntityDao;
    protected JoinEntryEntityWithEntryAnimationEntityDao joinEntryEntityWithEntryAnimationEntityDao;
    protected JoinEntryEntityWithEntryAtmospherEntityDao joinEntryEntityWithEntryAtmospherEntityDao;
    protected JoinEntryEntityWithEntryCategoryEntityDao joinEntryEntityWithEntryCategoryEntityDao;
    protected JoinEntryEntityWithEntryChainEntityDao joinEntryEntityWithEntryChainEntityDao;
    protected JoinEntryEntityWithEntryClosingEntityDao joinEntryEntityWithEntryClosingEntityDao;
    protected JoinEntryEntityWithEntryClosureEntityDao joinEntryEntityWithEntryClosureEntityDao;
    protected JoinEntryEntityWithEntryCommonTagEntityDao joinEntryEntityWithEntryCommonTagEntityDao;
    protected JoinEntryEntityWithEntryContactEntityDao joinEntryEntityWithEntryContactEntityDao;
    protected JoinEntryEntityWithEntryDescriptionEntityDao joinEntryEntityWithEntryDescriptionEntityDao;
    protected JoinEntryEntityWithEntryDisabledOptionEntityDao joinEntryEntityWithEntryDisabledOptionEntityDao;
    protected JoinEntryEntityWithEntryFamilyOptionEntityDao joinEntryEntityWithEntryFamilyOptionEntityDao;
    protected JoinEntryEntityWithEntryFrpOptionEntityDao joinEntryEntityWithEntryFrpOptionEntityDao;
    protected JoinEntryEntityWithEntryGroupOptionEntityDao joinEntryEntityWithEntryGroupOptionEntityDao;
    protected JoinEntryEntityWithEntryImageEntityDao joinEntryEntityWithEntryImageEntityDao;
    protected JoinEntryEntityWithEntryLabelEntityDao joinEntryEntityWithEntryLabelEntityDao;
    protected JoinEntryEntityWithEntryLanguageEntityDao joinEntryEntityWithEntryLanguageEntityDao;
    protected JoinEntryEntityWithEntryLocationEntityDao joinEntryEntityWithEntryLocationEntityDao;
    protected JoinEntryEntityWithEntryOpeningEntityDao joinEntryEntityWithEntryOpeningEntityDao;
    protected JoinEntryEntityWithEntryOptionEntityDao joinEntryEntityWithEntryOptionEntityDao;
    protected JoinEntryEntityWithEntryPaymentEntityDao joinEntryEntityWithEntryPaymentEntityDao;
    protected JoinEntryEntityWithEntryPoiOptionEntityDao joinEntryEntityWithEntryPoiOptionEntityDao;
    protected JoinEntryEntityWithEntryProfileEntityDao joinEntryEntityWithEntryProfileEntityDao;
    protected JoinEntryEntityWithEntryPublicationEntityDao joinEntryEntityWithEntryPublicationEntityDao;
    protected JoinEntryEntityWithEntrySectorEntityDao joinEntryEntityWithEntrySectorEntityDao;
    protected JoinEntryEntityWithEntryServiceEntityDao joinEntryEntityWithEntryServiceEntityDao;
    protected JoinEntryEntityWithEntrySpaceEntityDao joinEntryEntityWithEntrySpaceEntityDao;
    protected JoinEntryEntityWithEntryStandingLevelEntityDao joinEntryEntityWithEntryStandingLevelEntityDao;
    protected JoinEntryEntityWithEntryStationEntityDao joinEntryEntityWithEntryStationEntityDao;
    protected JoinEntryEntityWithEntryTariffEntityDao joinEntryEntityWithEntryTariffEntityDao;
    protected JoinEntryOpeningEntityWithEntryGridEntityDao joinEntryOpeningEntityWithEntryGridEntityDao;
    protected JoinEntryEntityWithEntryAllianceOptionEntityDao joinEntryEntityWithEntryAllianceOptionEntityDao;
    protected JoinEntryEntityWithEntryFurnishedRentalEntityDao joinEntryEntityWithEntryFurnishedRentalEntityDao;
    protected EntryRentalMonthEntityDao entryRentalMonthEntityDao;
    protected JoinEntryEntityWithEntryRentalMonthEntityDao joinEntryEntityWithEntryRentalMonthEntityDao;
    protected EntrySleepingEntityDao entrySleepingEntityDao;
    protected JoinEntryEntityWithEntrySleepingEntityDao joinEntryEntityWithEntrySleepingEntityDao;
    protected EntryCommerciaEntityDao entryCommerciaEntityDao;
    protected JoinEntryEntityWithEntryCommerciaEntityDao joinEntryEntityWithEntryCommerciaEntityDao;
    protected String newLine = System.getProperty("line.separator");

    protected Menu menuItems;

    protected EvenementEntityDao evenementEntityDao;
    protected EvenementAddressEntityDao evenementAddressEntityDao;
    protected EvenementDescriptionEntityDao evenementDescriptionEntityDao;
    protected EvenementOptionEntityDao evenementOptionEntityDao;
    protected EvenementProfileEntityDao evenementProfileEntityDao;
    protected EvenementRefEntriesEntityDao evenementRefEntriesEntityDao;
    protected EvenementSectoEntityDao evenementSectoEntityDao;
    protected EvenementCategoryEntityDao evenementCategoryEntityDao;
    protected EvenementStationEntityDao evenementStationEntityDao;
    protected JoinEvenementEntityWithEvenementAddressEntityDao joinEvenementEntityWithEvenementAddressEntityDao;
    protected JoinEvenementEntityWithEvenementDescriptionEntityDao joinEvenementEntityWithEvenementDescriptionEntityDao;
    protected JoinEvenementEntityWithEvenementOptionEntityDao joinEvenementEntityWithEvenementOptionEntityDao;
    protected JoinEvenementEntityWithEvenementStationEntityDao joinEvenementEntityWithEvenementStationEntityDao;
    protected JoinEvenementEntityWithEvenementProfileEntityDao joinEvenementEntityWithEvenementProfileEntityDao;
    protected JoinEvenementEntityWithEvenementRefEntriesEntityDao joinEvenementEntityWithEvenementRefEntriesEntityDao;
    protected JoinEvenementEntityWithEvenementSectoEntityDao joinEvenementEntityWithEvenementSectoEntityDao;
    protected JoinEvenementEntityWithEvenementCategoryEntityDao joinEvenementEntityWithEvenementCategoryEntityDao;

    protected DateMajDao dateMajDao;
    //Entry
    protected int nbEntries;
    protected List<Entry> listEntries;
    protected List<EntryEntity> listEntryEntities = new ArrayList<>();
    protected List<EntryEntity> listEntryEntitiesBasique = new ArrayList<>();

    protected String dateDemandeString;
    protected Date dateDemande;

    protected static Retrofit retrofit = null;
    protected final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    protected List<Entry> listEntriesBoutique = new ArrayList<>();
    protected List<Entry> listEntriesHebergement = new ArrayList<>();
    protected List<Entry> listEntriesHotel = new ArrayList<>();
    protected List<Entry> listEntriesRestaurant = new ArrayList<>();
    protected List<Entry> listEntriesUtile = new ArrayList<>();
    protected List<Entry> listEntriesVisite = new ArrayList<>();
    protected List<Entry> listEntriesShopping = new ArrayList<>();
    protected List<Entry> listEntriesSortie = new ArrayList<>();
    protected List<Entry> listEntriesTransport = new ArrayList<>();
    protected int cptrEntriesType;
    protected int compteur = 0;

    @Nullable
    @BindView(R.id.list_recycler_entry)
    RecyclerView list_recycler_entry;
    @Nullable
    @BindView(R.id.simpleProgressBar)
    ProgressBar progressBar;
    @Nullable
    @BindView(R.id.layout_fragment_entry_filtre)
    FrameLayout layoutFragmentEntryFiltre;
    @Nullable
    @BindView(R.id.layout_fragment_entry_type)
    FrameLayout layoutFragmentEntryType;

    protected RecyclerAdapterEntries adapterEntries;
    protected boolean isResponded = false;
    protected int positionScroll = 0;

    protected boolean layoutFiltreAffiche;
    protected boolean layoutTypeAffiche;

    protected List<EntryCategoryEntity> listFiltreEntryCategory = new ArrayList<>();
    protected List<EntryTypeEntity> listEntryType = new ArrayList<>();

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

    protected boolean filtreCategoryDeplie = false;
    protected boolean filtreTypeDeplie = false;

    protected List<MaterialCheckBox> listCheckboxEntryCategory = new ArrayList<>();
    protected List<MaterialCheckBox> listCheckboxEntryType = new ArrayList<>();

    protected List<EntryEntity> listEntryEntityFiltre = new ArrayList<>();
    protected List<EntryEntity> listEntryEntityType = new ArrayList<>();

    protected List<EntryLocationEntity> listFiltreEntryLocation = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreLocation)
    LinearLayout linearLayoutEntryFiltreLocation;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreLocationSelectAll)
    MaterialCheckBox checkboxEntryFiltreLocationSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreLocation)
    MaterialButton buttonEntryFiltreLocation;
    protected boolean filtreLocationDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryLocation = new ArrayList<>();

    protected List<EntryActivityEntity> listFiltreEntryActivity = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreActivity)
    LinearLayout linearLayoutEntryFiltreActivity;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreActivitySelectAll)
    MaterialCheckBox checkboxEntryFiltreActivitySelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreActivity)
    MaterialButton buttonEntryFiltreActivity;
    protected boolean filtreActivityDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryActivity = new ArrayList<>();

    protected List<EntryAmenityEntity> listFiltreEntryAmenity = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreAmenity)
    LinearLayout linearLayoutEntryFiltreAmenity;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreAmenitySelectAll)
    MaterialCheckBox checkboxEntryFiltreAmenitySelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreAmenity)
    MaterialButton buttonEntryFiltreAmenity;
    protected boolean filtreAmenityDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryAmenity = new ArrayList<>();

    protected List<EntryAnimationEntity> listFiltreEntryAnimation = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreAnimation)
    LinearLayout linearLayoutEntryFiltreAnimation;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreAnimationSelectAll)
    MaterialCheckBox checkboxEntryFiltreAnimationSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreAnimation)
    MaterialButton buttonEntryFiltreAnimation;
    protected boolean filtreAnimationDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryAnimation = new ArrayList<>();

    protected List<EntryAtmospherEntity> listFiltreEntryAtmospher = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreAtmospher)
    LinearLayout linearLayoutEntryFiltreAtmospher;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreAtmospherSelectAll)
    MaterialCheckBox checkboxEntryFiltreAtmospherSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreAtmospher)
    MaterialButton buttonEntryFiltreAtmospher;
    protected boolean filtreAtmospherDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryAtmospher = new ArrayList<>();

    protected List<EntryChainEntity> listFiltreEntryChain = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreChain)
    LinearLayout linearLayoutEntryFiltreChain;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreChainSelectAll)
    MaterialCheckBox checkboxEntryFiltreChainSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreChain)
    MaterialButton buttonEntryFiltreChain;
    protected boolean filtreChainDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryChain = new ArrayList<>();

    protected List<EntryFurnishedRentalEntity> listFiltreEntryFurnishedRental = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreFurnishedRental)
    LinearLayout linearLayoutEntryFiltreFurnishedRental;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreFurnishedRentalSelectAll)
    MaterialCheckBox checkboxEntryFiltreFurnishedRentalSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreFurnishedRental)
    MaterialButton buttonEntryFiltreFurnishedRental;
    protected boolean filtreFurnishedRentalDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryFurnishedRental = new ArrayList<>();

    protected List<EntryLabelEntity> listFiltreEntryLabel = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreLabel)
    LinearLayout linearLayoutEntryFiltreLabel;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreLabelSelectAll)
    MaterialCheckBox checkboxEntryFiltreLabelSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreLabel)
    MaterialButton buttonEntryFiltreLabel;
    protected boolean filtreLabelDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryLabel = new ArrayList<>();

    protected List<EntryServiceEntity> listFiltreEntryService = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreService)
    LinearLayout linearLayoutEntryFiltreService;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreServiceSelectAll)
    MaterialCheckBox checkboxEntryFiltreServiceSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreService)
    MaterialButton buttonEntryFiltreService;
    protected boolean filtreServiceDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryService = new ArrayList<>();

    protected List<EntryStandingLevelEntity> listFiltreEntryStandingLevel = new ArrayList<>();
    @Nullable
    @BindView(R.id.linearLayoutEntryFiltreStandingLevel)
    LinearLayout linearLayoutEntryFiltreStandingLevel;
    @Nullable
    @BindView(R.id.checkboxEntryFiltreStandingLevelSelectAll)
    MaterialCheckBox checkboxEntryFiltreStandingLevelSelectAll;
    @Nullable
    @BindView(R.id.buttonEntryFiltreStandingLevel)
    MaterialButton buttonEntryFiltreStandingLevel;
    protected boolean filtreStandingLevelDeplie = false;
    protected List<MaterialCheckBox> listCheckboxEntryStandingLevel = new ArrayList<>();

    @Nullable
    @BindView(R.id.checkboxEntryTypeBoutique)
    MaterialCheckBox checkboxEntryTypeBoutique;
    @Nullable
    @BindView(R.id.checkboxEntryTypeHotel)
    MaterialCheckBox checkboxEntryTypeHotel;
    @Nullable
    @BindView(R.id.checkboxEntryTypeShopping)
    MaterialCheckBox checkboxEntryTypeShopping;
    @Nullable
    @BindView(R.id.checkboxEntryTypeVisite)
    MaterialCheckBox checkboxEntryTypeVisite;
    @Nullable
    @BindView(R.id.checkboxEntryTypeHebergement)
    MaterialCheckBox checkboxEntryTypeHebergement;
    @Nullable
    @BindView(R.id.checkboxEntryTypeUtile)
    MaterialCheckBox checkboxEntryTypeUtile;
    @Nullable
    @BindView(R.id.checkboxEntryTypeSortie)
    MaterialCheckBox checkboxEntryTypeSortie;
    @Nullable
    @BindView(R.id.checkboxEntryTypeTransport)
    MaterialCheckBox checkboxEntryTypeTransport;
    @Nullable
    @BindView(R.id.checkboxEntryTypeRestaurant)
    MaterialCheckBox checkboxEntryTypeRestaurant;

    //Evenement
    protected int nbEvents;
    protected List<Event> listEvents;
    protected List<EvenementEntity> listEventEntities = new ArrayList<>();
    protected List<EvenementEntity> listEventEntitiesBasique = new ArrayList<>();

    @Nullable
    @BindView(R.id.list_recycler_event)
    RecyclerView list_recycler_event;
    @Nullable
    @BindView(R.id.layout_fragment_evenement_tri)
    FrameLayout layoutFragmentEvenementTri;
    @Nullable
    @BindView(R.id.radio_button_evenement_tri_nom)
    MaterialRadioButton rbEvenementTriNom;
    @Nullable
    @BindView(R.id.radio_button_evenement_tri_date)
    MaterialRadioButton rbEvenementTridDate;
    @Nullable
    @BindView(R.id.layout_fragment_evenement_filtre)
    FrameLayout layoutFragmentEvenementFiltre;

    protected  RecyclerAdapterEvenements adapterEvents;

    protected boolean layoutTriAffiche;

    protected EvenementTri triEnCours = EvenementTri.Nom;

    protected List<EvenementAddressEntity> listFiltreEvenementAdresse = new ArrayList<>();
    protected List<EvenementCategoryEntity> listFiltreEvenementCategory = new ArrayList<>();

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

    protected boolean filtreVilleDeplie = false;

    protected List<MaterialCheckBox> listCheckboxEvenementCategory = new ArrayList<>();
    protected List<MaterialCheckBox> listCheckboxEvenementVille = new ArrayList<>();

    protected List<EvenementEntity> listEvenementEntityFiltre = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiserDao();

        dateMajDao = daoSession.getDateMajDao();


        entryEntityDao = daoSession.getEntryEntityDao();
        entryActivityEntityDao = daoSession.getEntryActivityEntityDao();
        entryAddressEntityDao = daoSession.getEntryAddressEntityDao();
        entryAffiliationEntityDao = daoSession.getEntryAffiliationEntityDao();
        entryAmenityEntityDao = daoSession.getEntryAmenityEntityDao();
        entryAnimationEntityDao = daoSession.getEntryAnimationEntityDao();
        entryAtmospherEntityDao = daoSession.getEntryAtmospherEntityDao();
        entryCapacityEntityDao = daoSession.getEntryCapacityEntityDao();
        entryCategoryEntityDao = daoSession.getEntryCategoryEntityDao();
        entryChainEntityDao = daoSession.getEntryChainEntityDao();
        entryClosingEntityDao = daoSession.getEntryClosingEntityDao();
        entryClosureEntityDao = daoSession.getEntryClosureEntityDao();
        entryCommonTagEntityDao = daoSession.getEntryCommonTagEntityDao();
        entryContactEntityDao = daoSession.getEntryContactEntityDao();
        entryDescriptionEntityDao = daoSession.getEntryDescriptionEntityDao();
        entryDisabledOptionEntityDao = daoSession.getEntryDisabledOptionEntityDao();
        entryFamilyOptionEntityDao = daoSession.getEntryFamilyOptionEntityDao();
        entryFrpOptionEntityDao = daoSession.getEntryFrpOptionEntityDao();
        entryGridEntityDao = daoSession.getEntryGridEntityDao();
        entryGroupOptionEntityDao = daoSession.getEntryGroupOptionEntityDao();
        entryImageEntityDao = daoSession.getEntryImageEntityDao();
        entryLabelEntityDao = daoSession.getEntryLabelEntityDao();
        entryLanguageEntityDao = daoSession.getEntryLanguageEntityDao();
        entryLivingEntityDao = daoSession.getEntryLivingEntityDao();
        entryLocationEntityDao = daoSession.getEntryLocationEntityDao();
        entryOpeningEntityDao = daoSession.getEntryOpeningEntityDao();
        entryOptionEntityDao = daoSession.getEntryOptionEntityDao();
        entryPaymentEntityDao = daoSession.getEntryPaymentEntityDao();
        entryPoiOptionEntityDao = daoSession.getEntryPoiOptionEntityDao();
        entryProfileEntityDao = daoSession.getEntryProfileEntityDao();
        entryPublicationEntityDao = daoSession.getEntryPublicationEntityDao();
        entrySectorEntityDao = daoSession.getEntrySectorEntityDao();
        entryServiceEntityDao = daoSession.getEntryServiceEntityDao();
        entrySpaceEntityDao = daoSession.getEntrySpaceEntityDao();
        entryStandingLevelEntityDao = daoSession.getEntryStandingLevelEntityDao();
        entryStationEntityDao = daoSession.getEntryStationEntityDao();
        entryTariffEntityDao = daoSession.getEntryTariffEntityDao();
        entryAllianceOptionEntityDao = daoSession.getEntryAllianceOptionEntityDao();
        entryFurnishedRentalEntityDao = daoSession.getEntryFurnishedRentalEntityDao();
        joinEntryEntityWithEntryActivityEntityDao = daoSession.getJoinEntryEntityWithEntryActivityEntityDao();
        joinEntryEntityWithEntryAffiliationEntityDao = daoSession.getJoinEntryEntityWithEntryAffiliationEntityDao();
        joinEntryEntityWithEntryAmenityEntityDao = daoSession.getJoinEntryEntityWithEntryAmenityEntityDao();
        joinEntryEntityWithEntryAnimationEntityDao = daoSession.getJoinEntryEntityWithEntryAnimationEntityDao();
        joinEntryEntityWithEntryAtmospherEntityDao = daoSession.getJoinEntryEntityWithEntryAtmospherEntityDao();
        joinEntryEntityWithEntryCategoryEntityDao = daoSession.getJoinEntryEntityWithEntryCategoryEntityDao();
        joinEntryEntityWithEntryChainEntityDao = daoSession.getJoinEntryEntityWithEntryChainEntityDao();
        joinEntryEntityWithEntryClosingEntityDao = daoSession.getJoinEntryEntityWithEntryClosingEntityDao();
        joinEntryEntityWithEntryClosureEntityDao = daoSession.getJoinEntryEntityWithEntryClosureEntityDao();
        joinEntryEntityWithEntryCommonTagEntityDao = daoSession.getJoinEntryEntityWithEntryCommonTagEntityDao();
        joinEntryEntityWithEntryContactEntityDao = daoSession.getJoinEntryEntityWithEntryContactEntityDao();
        joinEntryEntityWithEntryDescriptionEntityDao = daoSession.getJoinEntryEntityWithEntryDescriptionEntityDao();
        joinEntryEntityWithEntryDisabledOptionEntityDao = daoSession.getJoinEntryEntityWithEntryDisabledOptionEntityDao();
        joinEntryEntityWithEntryFamilyOptionEntityDao = daoSession.getJoinEntryEntityWithEntryFamilyOptionEntityDao();
        joinEntryEntityWithEntryFrpOptionEntityDao = daoSession.getJoinEntryEntityWithEntryFrpOptionEntityDao();
        joinEntryEntityWithEntryGroupOptionEntityDao = daoSession.getJoinEntryEntityWithEntryGroupOptionEntityDao();
        joinEntryEntityWithEntryImageEntityDao = daoSession.getJoinEntryEntityWithEntryImageEntityDao();
        joinEntryEntityWithEntryLabelEntityDao = daoSession.getJoinEntryEntityWithEntryLabelEntityDao();
        joinEntryEntityWithEntryLanguageEntityDao = daoSession.getJoinEntryEntityWithEntryLanguageEntityDao();
        joinEntryEntityWithEntryLocationEntityDao = daoSession.getJoinEntryEntityWithEntryLocationEntityDao();
        joinEntryEntityWithEntryOpeningEntityDao = daoSession.getJoinEntryEntityWithEntryOpeningEntityDao();
        joinEntryEntityWithEntryOptionEntityDao = daoSession.getJoinEntryEntityWithEntryOptionEntityDao();
        joinEntryEntityWithEntryPaymentEntityDao = daoSession.getJoinEntryEntityWithEntryPaymentEntityDao();
        joinEntryEntityWithEntryPoiOptionEntityDao = daoSession.getJoinEntryEntityWithEntryPoiOptionEntityDao();
        joinEntryEntityWithEntryProfileEntityDao = daoSession.getJoinEntryEntityWithEntryProfileEntityDao();
        joinEntryEntityWithEntryPublicationEntityDao = daoSession.getJoinEntryEntityWithEntryPublicationEntityDao();
        joinEntryEntityWithEntrySectorEntityDao = daoSession.getJoinEntryEntityWithEntrySectorEntityDao();
        joinEntryEntityWithEntryServiceEntityDao = daoSession.getJoinEntryEntityWithEntryServiceEntityDao();
        joinEntryEntityWithEntrySpaceEntityDao = daoSession.getJoinEntryEntityWithEntrySpaceEntityDao();
        joinEntryEntityWithEntryStandingLevelEntityDao = daoSession.getJoinEntryEntityWithEntryStandingLevelEntityDao();
        joinEntryEntityWithEntryStationEntityDao = daoSession.getJoinEntryEntityWithEntryStationEntityDao();
        joinEntryEntityWithEntryTariffEntityDao = daoSession.getJoinEntryEntityWithEntryTariffEntityDao();
        joinEntryOpeningEntityWithEntryGridEntityDao = daoSession.getJoinEntryOpeningEntityWithEntryGridEntityDao();
        joinEntryEntityWithEntryAllianceOptionEntityDao = daoSession.getJoinEntryEntityWithEntryAllianceOptionEntityDao();
        joinEntryEntityWithEntryFurnishedRentalEntityDao = daoSession.getJoinEntryEntityWithEntryFurnishedRentalEntityDao();

        entryRentalMonthEntityDao = daoSession.getEntryRentalMonthEntityDao();
        joinEntryEntityWithEntryRentalMonthEntityDao = daoSession.getJoinEntryEntityWithEntryRentalMonthEntityDao();

        entrySleepingEntityDao = daoSession.getEntrySleepingEntityDao();
        joinEntryEntityWithEntrySleepingEntityDao = daoSession.getJoinEntryEntityWithEntrySleepingEntityDao();

        entryCommerciaEntityDao = daoSession.getEntryCommerciaEntityDao();
        joinEntryEntityWithEntryCommerciaEntityDao = daoSession.getJoinEntryEntityWithEntryCommerciaEntityDao();

        evenementEntityDao = daoSession.getEvenementEntityDao();
        evenementAddressEntityDao = daoSession.getEvenementAddressEntityDao();
        evenementDescriptionEntityDao = daoSession.getEvenementDescriptionEntityDao();
        evenementOptionEntityDao = daoSession.getEvenementOptionEntityDao();
        evenementProfileEntityDao = daoSession.getEvenementProfileEntityDao();
        evenementRefEntriesEntityDao = daoSession.getEvenementRefEntriesEntityDao();
        evenementSectoEntityDao = daoSession.getEvenementSectoEntityDao();
        evenementCategoryEntityDao = daoSession.getEvenementCategoryEntityDao();
        evenementStationEntityDao = daoSession.getEvenementStationEntityDao();
        joinEvenementEntityWithEvenementAddressEntityDao = daoSession.getJoinEvenementEntityWithEvenementAddressEntityDao();
        joinEvenementEntityWithEvenementDescriptionEntityDao = daoSession.getJoinEvenementEntityWithEvenementDescriptionEntityDao();
        joinEvenementEntityWithEvenementOptionEntityDao = daoSession.getJoinEvenementEntityWithEvenementOptionEntityDao();
        joinEvenementEntityWithEvenementStationEntityDao = daoSession.getJoinEvenementEntityWithEvenementStationEntityDao();
        joinEvenementEntityWithEvenementProfileEntityDao = daoSession.getJoinEvenementEntityWithEvenementProfileEntityDao();
        joinEvenementEntityWithEvenementRefEntriesEntityDao = daoSession.getJoinEvenementEntityWithEvenementRefEntriesEntityDao();
        joinEvenementEntityWithEvenementSectoEntityDao = daoSession.getJoinEvenementEntityWithEvenementSectoEntityDao();
        joinEvenementEntityWithEvenementCategoryEntityDao = daoSession.getJoinEvenementEntityWithEvenementCategoryEntityDao();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        menuItems = menu;
        itemEntryType = menuItems.findItem(R.id.menu_activity_main_entry_type);
        itemEntryFiltre = menuItems.findItem(R.id.menu_activity_main_entry_filter);
        itemEvenementFiltre = menuItems.findItem(R.id.menu_activity_main_evenement_filter);
        itemEvenementTri = menuItems.findItem(R.id.menu_activity_main_evenement_tri);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    public void configureBottomView(){
        this.bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_home:
                                ouvrirActiviteSuivante(NavDrawerActivity.this, AccueilActivity.class, true);
                                break;
                            case R.id.bottom_navigation_evenement:
                                ouvrirActiviteSuivante(NavDrawerActivity.this, AfficherEvenementsActivity.class, true);
                                break;
                            case R.id.bottom_navigation_entry:
                                ouvrirActiviteSuivante(NavDrawerActivity.this, AfficherEntriesDiversActivity.class, true);
                                break;
                            case R.id.bottom_navigation_my_datas:
                                ouvrirActiviteSuivante(NavDrawerActivity.this, AfficherFavorisActivity.class, true);
                                break;
                        }
                        return true;
                    }
                });
    }

    public void configureToolBar() {
        this.toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
    }

    public void ouvrirActiviteSuivante(Context context, Class classe, boolean bool) {
        Intent intent = new Intent(context, classe);
        startActivity(intent);
        if (bool) {
            finish();
        }
    }

    public void ouvrirActiviteSuivante(Context context, Class classe, String nomExtra, Long objetIdExtra, boolean bool) {
        Intent intent = new Intent(context, classe);
        intent.putExtra(nomExtra, objetIdExtra);
        startActivity(intent);
        if (bool) {
            finish();
        }
    }

    public void ouvrirActiviteSuivante(Context context, Class classe, String nomExtra, Long objetIdExtra, boolean bool, boolean boolFavori) {
        Intent intent = new Intent(context, classe);
        intent.putExtra(nomExtra, objetIdExtra);
        intent.putExtra("FromFavori",boolFavori);
        startActivity(intent);
        if (bool) {
            finish();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public Executor getMainExecutor() {
        return super.getMainExecutor();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void initialiserDao() {
        AppOpenHelper helper = new AppOpenHelper(this, "sortir_nice_2022_db", null);
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void deleteEntryObsolete(){
        int limiteMaxObsolete = 10;
        List<EntryEntity> listEntriesObsoletes = entryEntityDao.queryRaw("where obsolete_nb > ?",""+limiteMaxObsolete);
        for (EntryEntity current : listEntriesObsoletes) {
            if (!current.isFavori()){
                current.delete();
                Log.e("TAG", "suppression obsolete: "+current.getNameFr()+" - "+current.getEntryType().toString());
            } else {
                Log.e("TAG", "pas suppression obsolete car favori: "+current.getNameFr()+" - "+current.getEntryType().toString());
            }
        }
        Log.e("TAG", "suppression obsolete terminee");
    }

    public void majEntryObsolete(List<EntryEntity> listEntries){
        List<EntryEntity> listEntriesSaved = entryEntityDao.loadAll();
        for (EntryEntity current : listEntriesSaved) {
            if (!listEntries.contains(current)){
                current.setObsoleteNb(current.getObsoleteNb()+1);
                entryEntityDao.save(current);
                Log.e("TAG", "maj obsolete: "+current.getNameFr()+" - "+current.getEntryType().toString()+" - iteration = "+current.getObsoleteNb());
            } else {
                if (current.getObsoleteNb()>0){
                    current.setObsoleteNb(0);
                    entryEntityDao.save(current);
                    Log.e("TAG", "raz obsolete: "+current.getNameFr()+" - "+current.getEntryType().toString());
                }
            }
        }
        Log.e("TAG", "maj obsolete terminee");
    }

    public List<EntryEntity> saveListEntries(List<Entry> listEntries,EntriesType entryType) {
        List<EntryEntity> listEntryEntities = new ArrayList<>();
        for (Entry current : listEntries) {
            List<EntryEntity> listEntriesFound = entryEntityDao.queryRaw("where entry_entity_id = ? and entry_type = ?",""+current.getId(), ""+current.getEntryType().toString());
            if (listEntriesFound.size()==0) {
                EntryEntity entryToSave = new EntryEntity();
                entryToSave.setEntryEntityId(Long.valueOf(current.getId()));
                entryToSave.setEntryType(entryType);
                entryToSave.setNameFr(current.getNameFr());
                entryToSave.setNameFrShort(current.getNameFrShort());
                entryToSave.setObsoleteNb(0);
                EntryAddressEntity entryAddressEntity = new EntryAddressEntity();
                entryAddressEntity.setAddressLine1(current.getAddress().getAddressLine1());
                entryAddressEntity.setAddressLine2(current.getAddress().getAddressLine2());
                entryAddressEntity.setAddressLine3(current.getAddress().getAddressLine3());
                entryAddressEntity.setZip(current.getAddress().getZip());
                entryAddressEntity.setCity(current.getAddress().getCity());
                if (entryAddressEntity.getAddressLine1() != null
                        && entryAddressEntity.getAddressLine2() != null
                        && entryAddressEntity.getAddressLine3() != null
                        && entryAddressEntity.getZip() != null
                        && entryAddressEntity.getCity() != null ) {
                        entryAddressEntity.setId(entryAddressEntityDao.insert(entryAddressEntity));
                        entryToSave.setEntryAddressEntityId(entryAddressEntity.getId());
                    }
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
                //entryToSave.setImage((current.getListImages() != null && current.getListImages().size() > 0) ? current.getListImages().get(0).getUrl() : null);

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
                        boolean aIgnorer = false;
                        for (ExclusionEntryAmenity exclusion : ExclusionEntryAmenity.values()) {
                            if (amenity.getValue().equalsIgnoreCase(exclusion.toString())){
                                aIgnorer = true;
                            }
                        }
                        if (!aIgnorer) {
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
                        boolean aIgnorer = false;
                        for (ExclusionEntryLieu exclusion : ExclusionEntryLieu.values()) {
                            if (location.getValue().equalsIgnoreCase(exclusion.toString())){
                                aIgnorer = true;
                            }
                        }
                        if (!aIgnorer) {
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
                        } else {
                            Log.e("Exclusion Lieu ",location.getValue());
                        }
                    }
                }

                //enregistrer list activities
                if (current.getListActivities() != null) {
                    for (Activity activity : current.getListActivities()) {
                        boolean aIgnorer = false;
                        for (ExclusionEntryActivites exclusion : ExclusionEntryActivites.values()) {
                            if (activity.getValue().equalsIgnoreCase(exclusion.toString())){
                                aIgnorer = true;
                            }
                        }
                        if (!aIgnorer) {
                            for (FusionEntryActivite fusion : FusionEntryActivite.values()){
                                if (fusion.toBis().equalsIgnoreCase(activity.getValue())){
                                    activity.setValue(fusion.toString());
                                }
                            }
                            List<EntryActivityEntity> list = entryActivityEntityDao.queryRaw("where value = ?", activity.getValue());

                            List<JoinEntryEntityWithEntryActivityEntity> listJoin = new ArrayList<>();
                            if (list.size() > 0) {
                                listJoin = joinEntryEntityWithEntryActivityEntityDao.queryRaw("where entry_entity_id = ? and entry_activity_entity_id = ?", entryToSave.getId().toString(), list.get(0).getId().toString());
                            }
                            if (listJoin.size() == 0) {
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
                        } else {
                            Log.e("Exclusion Activite ",activity.getValue());
                        }
                    }
                }

                //enregistrer list categories
                if (current.getListCategories() != null) {
                    for (Category category : current.getListCategories()) {
                        boolean aIgnorer = false;
                        for (ExclusionEntryCategorie exclusion : ExclusionEntryCategorie.values()) {
                            if (category.getValue().equalsIgnoreCase(exclusion.toString())){
                                aIgnorer = true;
                            }
                        }
                        if (!aIgnorer) {
                            for (FusionEntryCategorie fusion : FusionEntryCategorie.values()){
                                if (fusion.toBis().equalsIgnoreCase(category.getValue())){
                                    category.setValue(fusion.toString());
                                }
                            }
                            category.setValue(category.getValue().substring(0, 2).equalsIgnoreCase("- ") ? category.getValue().replace("- ", "") : category.getValue());
                            List<EntryCategoryEntity> list = entryCategoryEntityDao.queryRaw("where value = ?", category.getValue());
                            List<JoinEntryEntityWithEntryCategoryEntity> listJoin = new ArrayList<>();
                            if (list.size() > 0) {
                                listJoin = joinEntryEntityWithEntryCategoryEntityDao.queryRaw("where entry_entity_id = ? and entry_category_entity_id = ?", entryToSave.getId().toString(), list.get(0).getId().toString());
                            }
                            if (listJoin.size() == 0) {
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
                        } else {
                            Log.e("Exclusion Categorie ",category.getValue());
                        }
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
                        boolean aIgnorer = false;
                        for (ExclusionEntryService exclusion : ExclusionEntryService.values()) {
                            if (service.getValue().equalsIgnoreCase(exclusion.toString())){
                                aIgnorer = true;
                            }
                        }
                        if (!aIgnorer) {
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
                        if (description.getLanguage().equalsIgnoreCase("fr")) {
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
                    for (Closures closures : current.getListClosures()) {

                        if (closures.getListClosure() != null) {
                            for (Closure closure : closures.getListClosure()) {
                                List<EntryClosureEntity> list = entryClosureEntityDao.queryRaw("where closure_day = ? and closure_span = ? and date = ?"
                                        , closure.getClosureDay() != null ? closure.getClosureDay() : "",
                                        closure.getClosureSpan()!= null ? closure.getClosureSpan() : "", closure.getDate() != null ? closure.getDate() : "");
                                JoinEntryEntityWithEntryClosureEntity join = new JoinEntryEntityWithEntryClosureEntity();
                                join.setEntryEntityId(entryToSave.getId());
                                if (list.size() > 0) {
                                    join.setEntryClosureEntityId(list.get(0).getId());
                                } else {
                                    EntryClosureEntity entryClosureEntity = new EntryClosureEntity();
                                    entryClosureEntity.setClosureDay(closure.getClosureDay());
                                    entryClosureEntity.setClosureSpan(closure.getClosureSpan());
                                    entryClosureEntity.setDate(closure.getDate());
                                    entryClosureEntity.setId(entryClosureEntityDao.insert(entryClosureEntity));
                                    join.setEntryClosureEntityId(entryClosureEntity.getId());
                                }
                                joinEntryEntityWithEntryClosureEntityDao.insert(join);
                            }
                        }
                    }
                }

                //enregistrer list commercials
                if (current.getListCommercial() != null) {
                    for (Commercia commercia : current.getListCommercial()) {
                                List<EntryCommerciaEntity> list = entryCommerciaEntityDao.queryRaw("where value = ?"
                                        , commercia.getValue());
                                JoinEntryEntityWithEntryCommerciaEntity join = new JoinEntryEntityWithEntryCommerciaEntity();
                                join.setEntryEntityId(entryToSave.getId());
                                if (list.size() > 0) {
                                    join.setEntryCommerciaEntityId(list.get(0).getId());
                                } else {
                                    EntryCommerciaEntity entryCommerciaEntity = new EntryCommerciaEntity();
                                    entryCommerciaEntity.setValue(commercia.getValue());
                                    entryCommerciaEntity.setId(entryCommerciaEntityDao.insert(entryCommerciaEntity));
                                    join.setEntryCommerciaEntityId(entryCommerciaEntity.getId());
                                }
                                joinEntryEntityWithEntryCommerciaEntityDao.insert(join);
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

                //enregistrer list AllianceOptions
                if (current.getListAllianceOptions() != null) {
                    for (AllianceOption allianceOption : current.getListAllianceOptions()) {
                        List<EntryAllianceOptionEntity> list = entryAllianceOptionEntityDao.queryRaw("where value = ?", allianceOption.getValue());
                        JoinEntryEntityWithEntryAllianceOptionEntity join = new JoinEntryEntityWithEntryAllianceOptionEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryAllianceOptionEntityId(list.get(0).getId());
                        } else {
                            EntryAllianceOptionEntity entryAllianceOptionEntity = new EntryAllianceOptionEntity();
                            entryAllianceOptionEntity.setValue(allianceOption.getValue());
                            entryAllianceOptionEntity.setId(entryAllianceOptionEntityDao.insert(entryAllianceOptionEntity));
                            join.setEntryAllianceOptionEntityId(entryAllianceOptionEntity.getId());
                        }
                        joinEntryEntityWithEntryAllianceOptionEntityDao.insert(join);
                    }
                }

                //enregistrer list FurnishedRentals
                if (current.getListFurnishedRentals() != null) {
                    for (FurnishedRental furnishedRental : current.getListFurnishedRentals()) {
                        List<EntryFurnishedRentalEntity> list = entryFurnishedRentalEntityDao.queryRaw("where value = ?", furnishedRental.getValue());
                        JoinEntryEntityWithEntryFurnishedRentalEntity join = new JoinEntryEntityWithEntryFurnishedRentalEntity();
                        join.setEntryEntityId(entryToSave.getId());
                        if (list.size() > 0) {
                            join.setEntryFurnishedRentalEntityId(list.get(0).getId());
                        } else {
                            EntryFurnishedRentalEntity entryFurnishedRentalEntity = new EntryFurnishedRentalEntity();
                            entryFurnishedRentalEntity.setValue(furnishedRental.getValue());
                            entryFurnishedRentalEntity.setId(entryFurnishedRentalEntityDao.insert(entryFurnishedRentalEntity));
                            join.setEntryFurnishedRentalEntityId(entryFurnishedRentalEntity.getId());
                        }
                        joinEntryEntityWithEntryFurnishedRentalEntityDao.insert(join);
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
                        EntryOpeningEntity openingTemp = new EntryOpeningEntity();
                        List<EntryOpeningEntity> list = entryOpeningEntityDao.queryRaw("where opening_start = ? and opening_end = ? and opening_replay = ?",
                                "" + opening.getOpeningStart(),
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
                            openingTemp = entryOpeningEntity;
                        }
                        joinEntryEntityWithEntryOpeningEntityDao.insert(join);

                        //enregistrer list grids
                        if (opening.getListGrids()!= null) {
                            for (Grid grid : opening.getListGrids()) {
                                List<EntryGridEntity> list2 = entryGridEntityDao.queryRaw("where opening_days = ? and opening_hours = ?",
                                        grid.getOpeningDays(),
                                        "" + grid.getOpeningHours());
                                JoinEntryOpeningEntityWithEntryGridEntity join2 = new JoinEntryOpeningEntityWithEntryGridEntity();
                                join2.setEntryOpeningEntityId(openingTemp.getId());
                                if (list2.size() > 0) {
                                    join2.setEntryGridEntityId(list2.get(0).getId());
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
                }

                listEntryEntities.add(entryToSave);
            } else {
                listEntryEntities.add(listEntriesFound.get(0));
            }
        }
        return listEntryEntities;
    }

    protected void envoyerEmailErreur(EntriesType entryType, String erreur) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                SendEmailService.getInstance(getApplicationContext()).sendEmailErreurSynchro(entryType, erreur);
            }
        });
    }

    protected void afficherMessageErreur() {
        new MaterialAlertDialogBuilder(NavDrawerActivity.this)
                .setTitle("Erreur")
                .setMessage("Problème de recupération de données." + "\n"
                        + "L'erreur a été signalé à nos équipes." + "\n"
                        + "\n" + "Vous pouvez verifier le Play Store pour voir si une mise à jour de l'application a déjà corrigée le problème")
                .setPositiveButton("Mise à Jour disponible ?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //todo gerer la mise à jour
                    }
                })
                .setNegativeButton("Non Merci", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ouvrirActiviteSuivante(App.getInstance(), AccueilActivity.class, true);
                    }
                })
                .show();
    }

    protected void gererErreur(EntriesType entryType, String erreur) {
        envoyerEmailErreur(entryType, erreur);
        afficherMessageErreur();
    }

    //Entry
    protected void loadAllEntryFromDB() {
        entryEntityDao.detachAll();
        listEntryEntities = entryEntityDao.loadAll();
        Collections.sort(listEntryEntities);
    }

    protected void masquerFragmentFiltreEntry() {
        layoutFragmentEntryFiltre.setVisibility(View.GONE);
        layoutFiltreAffiche = false;
    }

    protected void afficherFragmentFiltre() {
        layoutFragmentEntryFiltre.setVisibility(View.VISIBLE);
        layoutFiltreAffiche = true;
    }

    protected void masquerFragmentType() {
        layoutFragmentEntryType.setVisibility(View.GONE);
        layoutTypeAffiche = false;
    }

    protected void afficherFragmentType() {
        layoutFragmentEntryType.setVisibility(View.VISIBLE);
        layoutTypeAffiche = true;
    }

    protected void replierEntryTousFiltre() {
        filtreCategoryDeplie = false;
        checkboxEntryFiltreCategorySelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreCategory.setVisibility(View.GONE);
        buttonEntryFiltreCategory.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreLocationDeplie = false;
        checkboxEntryFiltreLocationSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreLocation.setVisibility(View.GONE);
        buttonEntryFiltreLocation.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreActivityDeplie = false;
        checkboxEntryFiltreActivitySelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreActivity.setVisibility(View.GONE);
        buttonEntryFiltreActivity.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreAmenityDeplie = false;
        checkboxEntryFiltreAmenitySelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreAmenity.setVisibility(View.GONE);
        buttonEntryFiltreAmenity.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreAnimationDeplie = false;
        checkboxEntryFiltreAnimationSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreAnimation.setVisibility(View.GONE);
        buttonEntryFiltreAnimation.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreAtmospherDeplie = false;
        checkboxEntryFiltreAtmospherSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreAtmospher.setVisibility(View.GONE);
        buttonEntryFiltreAtmospher.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreChainDeplie = false;
        checkboxEntryFiltreChainSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreChain.setVisibility(View.GONE);
        buttonEntryFiltreChain.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreFurnishedRentalDeplie = false;
        checkboxEntryFiltreFurnishedRentalSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreFurnishedRental.setVisibility(View.GONE);
        buttonEntryFiltreFurnishedRental.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreLabelDeplie = false;
        checkboxEntryFiltreLabelSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreLabel.setVisibility(View.GONE);
        buttonEntryFiltreLabel.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreServiceDeplie = false;
        checkboxEntryFiltreServiceSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreService.setVisibility(View.GONE);
        buttonEntryFiltreService.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreStandingLevelDeplie = false;
        checkboxEntryFiltreStandingLevelSelectAll.setVisibility(View.GONE);
        linearLayoutEntryFiltreStandingLevel.setVisibility(View.GONE);
        buttonEntryFiltreStandingLevel.setIconResource(R.drawable.outline_arrow_right_black_18);

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

    protected boolean verifFiltreEntryActif(List<? extends DetailEntryEntitySimple> list) {
        boolean bool = false;
        for (DetailEntryEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    protected void afficherOuMasquerBoutonEntryFiltre(MaterialButton btn, List<? extends DetailEntryEntitySimple> list) {
        if (list.size() == 0) {
            btn.setVisibility(View.GONE);
        } else {
            btn.setVisibility(View.VISIBLE);
        }
    }

    protected void afficherOuMasquerTousBoutonsEntryFiltre() {
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreActivity, listFiltreEntryActivity);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreAmenity, listFiltreEntryAmenity);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreAnimation, listFiltreEntryAnimation);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreAtmospher, listFiltreEntryAtmospher);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreCategory, listFiltreEntryCategory);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreChain, listFiltreEntryChain);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreFurnishedRental, listFiltreEntryFurnishedRental);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreLabel, listFiltreEntryLabel);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreLocation, listFiltreEntryLocation);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreService, listFiltreEntryService);
        afficherOuMasquerBoutonEntryFiltre(buttonEntryFiltreStandingLevel, listFiltreEntryStandingLevel);
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

    protected void configureRecyclerViewEntry() {
        adapterEntries = new RecyclerAdapterEntries(listEntryEntities, (RecyclerAdapterEntries.Listener) this);
        list_recycler_entry.setAdapter(adapterEntries);
        list_recycler_entry.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerView();
    }

    protected void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(list_recycler_entry, R.layout.recycler_list_entry)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        positionScroll = position;
                        masquerFragmentFiltreEntry();
                        masquerFragmentType();
                        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
                        //bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).setChecked(true);
                        boolean boolFavori = bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).isChecked();
                        ouvrirActiviteSuivante(App.getInstance().getApplicationContext(), AfficherEntryDetailActivity.class, "entryId", listEntryEntities.get(position).getId(), false, boolFavori);
                    }
                });
    }

    private class AsyncTaskRunnerClickValidFiltre extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            masquerFragmentFiltreEntry();
        }

        protected Void doInBackground(Void... voids) {
            reinitListeEntries();
            listEntryEntityFiltre = new ArrayList<>();
            listEntryEntityFiltre.addAll(listEntryEntities);
            boolean boolEntryCategory = verifFiltreEntryActif(listFiltreEntryCategory);
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

            boolean boolEntryLocation = verifFiltreEntryActif(listFiltreEntryLocation);
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

            boolean boolEntryActivity = verifFiltreEntryActif(listFiltreEntryActivity);
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

            boolean boolEntryAmenity = verifFiltreEntryActif(listFiltreEntryAmenity);
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

            boolean boolEntryAnimation = verifFiltreEntryActif(listFiltreEntryAnimation);
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

            boolean boolEntryAtmospher = verifFiltreEntryActif(listFiltreEntryAtmospher);
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

            boolean boolEntryChain = verifFiltreEntryActif(listFiltreEntryChain);
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

            boolean boolEntryFurnishedRental = verifFiltreEntryActif(listFiltreEntryFurnishedRental);
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

            boolean boolEntryLabel = verifFiltreEntryActif(listFiltreEntryLabel);
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

            boolean boolEntryService = verifFiltreEntryActif(listFiltreEntryService);
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

            boolean boolEntryStandingLevel = verifFiltreEntryActif(listFiltreEntryStandingLevel);
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

            return null;
        }

        protected void onPostExecute(Void result) {

            progressBar.setVisibility(View.GONE);
            configureRecyclerViewEntry();
        }
    }

    @Optional
    @OnClick(R.id.fabEntryValiderFiltre)
    protected void fabEntryFiltreClick() {
        AsyncTaskRunnerClickValidFiltre runner = new AsyncTaskRunnerClickValidFiltre();
        runner.execute();
    }

    private class AsyncTaskRunnerClickValidType extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            masquerFragmentType();
        }

        protected Void doInBackground(Void... voids) {
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
            listEntryEntities.clear();
            listEntryEntities.addAll(listEntryEntityType);
            listerFiltreReelEntry();
            initListFiltresEntry();
            initCheckboxesSelectAllClickEntry();

            return null;
        }

        protected void onPostExecute(Void result) {
            itemEntryFiltre.setVisible(true);

            afficherOuMasquerTousBoutonsEntryFiltre();


            progressBar.setVisibility(View.GONE);
            configureRecyclerViewEntry();
        }
    }

    @Optional
    @OnClick(R.id.fabEntryValiderType)
    protected void fabEntryTypeClick() {
        AsyncTaskRunnerClickValidType runner = new AsyncTaskRunnerClickValidType();
        runner.execute();
    }

    private class AsyncTaskRunnerClickRazFiltre extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            masquerFragmentFiltreEntry();
            replierEntryTousFiltre();
        }

        protected Void doInBackground(Void... voids) {
            decocherToutEntry();
            listEntryEntities.clear();
            listEntryEntities.addAll(listEntryEntityType);

            return null;
        }

        protected void onPostExecute(Void result) {
            //itemEntryFiltre.setVisible(false);

            progressBar.setVisibility(View.GONE);
            configureRecyclerViewEntry();
        }
    }

    @Optional
    @OnClick(R.id.fabEntryRazFiltre)
    protected void fabEntryRazFiltreClick() {
        AsyncTaskRunnerClickRazFiltre runner = new AsyncTaskRunnerClickRazFiltre();
        runner.execute();
    }

    private class AsyncTaskRunnerClickRazType extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            masquerFragmentType();
            replierEntryTousFiltre();
        }

        protected Void doInBackground(Void... voids) {

            decocherToutTypeEntry();
            decocherToutEntry();
            listEntryEntities.clear();
            listEntryEntities.addAll(listEntryEntitiesBasique);

            return null;
        }

        protected void onPostExecute(Void result) {
            itemEntryFiltre.setVisible(false);
            progressBar.setVisibility(View.GONE);
            configureRecyclerViewEntry();
        }
    }

    @Optional
    @OnClick(R.id.fabEntryRazType)
    protected void fabEntryRazTypeClick() {
        AsyncTaskRunnerClickRazType runner = new AsyncTaskRunnerClickRazType();
        runner.execute();
    }

    protected void decocherEntryFiltre(List<? extends DetailEntryEntitySimple> list) {
        for (DetailEntryEntitySimple current : list) {
            current.setChecked(false);
        }
    }

    protected void decocherCheckbox(List<MaterialCheckBox> list) {
        for (MaterialCheckBox current : list) {
            current.setChecked(false);
        }
    }

    protected void decocherCheckbox(MaterialCheckBox cb) {
        cb.setChecked(false);
    }

    protected void decocherToutEntry() {
        decocherEntryFiltre(listFiltreEntryCategory);
        decocherCheckbox(listCheckboxEntryCategory);
        decocherCheckbox(checkboxEntryFiltreCategorySelectAll);
        decocherEntryFiltre(listFiltreEntryLocation);
        decocherCheckbox(listCheckboxEntryLocation);
        decocherCheckbox(checkboxEntryFiltreLocationSelectAll);
        decocherEntryFiltre(listFiltreEntryActivity);
        decocherCheckbox(listCheckboxEntryActivity);
        decocherCheckbox(checkboxEntryFiltreActivitySelectAll);
        decocherEntryFiltre(listFiltreEntryAmenity);
        decocherCheckbox(listCheckboxEntryAmenity);
        decocherCheckbox(checkboxEntryFiltreAmenitySelectAll);
        decocherEntryFiltre(listFiltreEntryAnimation);
        decocherCheckbox(listCheckboxEntryAnimation);
        decocherCheckbox(checkboxEntryFiltreAnimationSelectAll);
        decocherEntryFiltre(listFiltreEntryAtmospher);
        decocherCheckbox(listCheckboxEntryAtmospher);
        decocherCheckbox(checkboxEntryFiltreAtmospherSelectAll);
        decocherEntryFiltre(listFiltreEntryChain);
        decocherCheckbox(listCheckboxEntryChain);
        decocherCheckbox(checkboxEntryFiltreChainSelectAll);
        decocherEntryFiltre(listFiltreEntryFurnishedRental);
        decocherCheckbox(listCheckboxEntryFurnishedRental);
        decocherCheckbox(checkboxEntryFiltreFurnishedRentalSelectAll);
        decocherEntryFiltre(listFiltreEntryLabel);
        decocherCheckbox(listCheckboxEntryLabel);
        decocherCheckbox(checkboxEntryFiltreLabelSelectAll);
        decocherEntryFiltre(listFiltreEntryService);
        decocherCheckbox(listCheckboxEntryService);
        decocherCheckbox(checkboxEntryFiltreServiceSelectAll);
        decocherEntryFiltre(listFiltreEntryStandingLevel);
        decocherCheckbox(listCheckboxEntryStandingLevel);
        decocherCheckbox(checkboxEntryFiltreStandingLevelSelectAll);
    }

    protected void decocherToutTypeEntry() {
        decocherEntryFiltre(listEntryType);
        decocherCheckbox(listCheckboxEntryType);
    }

    protected void initTypeEntry(){
        checkboxEntryTypeHebergement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Hebergement.toString()))
                            current.setChecked(true);
                    }

                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Hebergement.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeHotel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Hotel.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Hotel.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeShopping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Shopping.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Shopping.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeBoutique.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Boutique.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Boutique.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeVisite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Visite.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Visite.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeUtile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Utile.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Utile.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeRestaurant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Restaurant.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Restaurant.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeSortie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Sortie.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Sortie.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
        checkboxEntryTypeTransport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Transport.toString()))
                            current.setChecked(true);
                    }
                } else {
                    for (EntryTypeEntity current : listEntryType) {
                        if (current.getValue().equalsIgnoreCase(EntriesType.Transport.toString()))
                            current.setChecked(false);
                    }
                }
            }
        });
    }

    protected void initFiltreEntry(List<? extends DetailEntryEntitySimple> list, LinearLayout ll, List<MaterialCheckBox> listCb, MaterialCheckBox cb) {
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
                        if (!verifSiUnFiltreMinimumEntry(list) && cb != null) {
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

    protected void initListFiltresEntry() {
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
        initTypeEntry();
        initFiltreEntry(listFiltreEntryCategory, linearLayoutEntryFiltreCategory, listCheckboxEntryCategory, checkboxEntryFiltreCategorySelectAll);
        initFiltreEntry(listFiltreEntryLocation, linearLayoutEntryFiltreLocation, listCheckboxEntryLocation, checkboxEntryFiltreLocationSelectAll);
        initFiltreEntry(listFiltreEntryActivity, linearLayoutEntryFiltreActivity, listCheckboxEntryActivity, checkboxEntryFiltreActivitySelectAll);
        initFiltreEntry(listFiltreEntryAmenity, linearLayoutEntryFiltreAmenity, listCheckboxEntryAmenity, checkboxEntryFiltreAmenitySelectAll);
        initFiltreEntry(listFiltreEntryAnimation, linearLayoutEntryFiltreAnimation, listCheckboxEntryAnimation, checkboxEntryFiltreAnimationSelectAll);
        initFiltreEntry(listFiltreEntryAtmospher, linearLayoutEntryFiltreAtmospher, listCheckboxEntryAtmospher, checkboxEntryFiltreAtmospherSelectAll);
        initFiltreEntry(listFiltreEntryChain, linearLayoutEntryFiltreChain, listCheckboxEntryChain, checkboxEntryFiltreChainSelectAll);
        initFiltreEntry(listFiltreEntryFurnishedRental, linearLayoutEntryFiltreFurnishedRental, listCheckboxEntryFurnishedRental, checkboxEntryFiltreFurnishedRentalSelectAll);
        initFiltreEntry(listFiltreEntryLabel, linearLayoutEntryFiltreLabel, listCheckboxEntryLabel, checkboxEntryFiltreLabelSelectAll);
        initFiltreEntry(listFiltreEntryService, linearLayoutEntryFiltreService, listCheckboxEntryService, checkboxEntryFiltreServiceSelectAll);
        initFiltreEntry(listFiltreEntryStandingLevel, linearLayoutEntryFiltreStandingLevel, listCheckboxEntryStandingLevel, checkboxEntryFiltreStandingLevelSelectAll);
    }

    protected boolean verifSiUnFiltreMinimumEntry(List<? extends DetailEntryEntitySimple> list) {
        boolean bool = false;
        for (DetailEntryEntitySimple current : list) {
            if (current.isChecked()) {
                bool = true;
            }
        }
        return bool;
    }

    protected void listerFiltreEntry() {
        listFiltreEntryCategory = entryCategoryEntityDao.loadAll();
        listFiltreEntryLocation = entryLocationEntityDao.loadAll();
        listFiltreEntryActivity = entryActivityEntityDao.loadAll();
        listFiltreEntryAmenity = entryAmenityEntityDao.loadAll();
        listFiltreEntryAnimation = entryAnimationEntityDao.loadAll();
        listFiltreEntryAtmospher = entryAtmospherEntityDao.loadAll();
        listFiltreEntryChain = entryChainEntityDao.loadAll();
        listFiltreEntryFurnishedRental = entryFurnishedRentalEntityDao.loadAll();
        listFiltreEntryLabel = entryLabelEntityDao.loadAll();
        listFiltreEntryService = entryServiceEntityDao.loadAll();
        listFiltreEntryStandingLevel = entryStandingLevelEntityDao.loadAll();
    }

    protected void listerFiltreReelEntry() {
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
        }
        listFiltreEntryCategory.addAll(hashsetCategory);
        if (listFiltreEntryCategory.size() > 0) {
            Collections.sort(listFiltreEntryCategory);
        }

        listFiltreEntryLocation.addAll(hashsetLocation);
        if (listFiltreEntryLocation.size() > 0) {
            Collections.sort(listFiltreEntryLocation);
        }

        listFiltreEntryActivity.addAll(hashsetActivity);
        if (listFiltreEntryActivity.size() > 0) {
            Collections.sort(listFiltreEntryActivity);
        }

        listFiltreEntryAmenity.addAll(hashsetAmenity);
        if (listFiltreEntryAmenity.size() > 0) {
            Collections.sort(listFiltreEntryAmenity);
        }

        listFiltreEntryAnimation.addAll(hashsetAnimation);
        if (listFiltreEntryAnimation.size() > 0) {
            Collections.sort(listFiltreEntryAnimation);
        }

        listFiltreEntryAtmospher.addAll(hashsetAtmospher);
        if (listFiltreEntryAtmospher.size() > 0) {
            Collections.sort(listFiltreEntryAtmospher);
        }

        listFiltreEntryChain.addAll(hashsetChain);
        if (listFiltreEntryChain.size() > 0) {
            Collections.sort(listFiltreEntryChain);
        }

        listFiltreEntryFurnishedRental.addAll(hashsetFurnishedRental);
        if (listFiltreEntryFurnishedRental.size() > 0) {
            Collections.sort(listFiltreEntryFurnishedRental);
        }

        listFiltreEntryLabel.addAll(hashsetLabel);
        if (listFiltreEntryLabel.size() > 0) {
            Collections.sort(listFiltreEntryLabel);
        }

        listFiltreEntryService.addAll(hashsetService);
        if (listFiltreEntryService.size() > 0) {
            Collections.sort(listFiltreEntryService);
        }

        listFiltreEntryStandingLevel.addAll(hashsetStandingLevel);
        if (listFiltreEntryStandingLevel.size() > 0) {
            Collections.sort(listFiltreEntryStandingLevel);
        }
    }

    protected void initCheckboxesSelectAllClickEntry() {
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

    //Evenement

    @Optional
    @OnClick(R.id.radio_button_evenement_tri_nom)
    protected void rbEvenementTriNomClick() {
        triEnCours = EvenementTri.Nom;
        triSelonParametre(listEventEntities);
        configureRecyclerView();
        masquerFragmentTri();
    }

    @Optional
    @OnClick(R.id.radio_button_evenement_tri_date)
    protected void rbEvenementTriDateClick() {
        triEnCours = EvenementTri.Date;
        triSelonParametre(listEventEntities);
        configureRecyclerView();
        masquerFragmentTri();
    }

    protected void loadAllEvenementFromDB() {
        evenementEntityDao.detachAll();
        listEventEntities = evenementEntityDao.loadAll();
        triSelonParametre(listEventEntities);
    }

    protected void masquerFragmentTri() {
        layoutFragmentEvenementTri.setVisibility(View.GONE);
        layoutTriAffiche = false;
    }

    protected void afficherFragmentTri() {
        layoutFragmentEvenementTri.setVisibility(View.VISIBLE);
        layoutTriAffiche = true;
        rbEvenementTriNom.setText(EvenementTri.Nom.getNom());
        rbEvenementTridDate.setText(EvenementTri.Date.getNom());
    }

    protected void masquerFragmentFiltreEvent() {
        layoutFragmentEvenementFiltre.setVisibility(View.GONE);
        layoutFiltreAffiche = false;
    }

    protected void afficherFragmentFiltreEvent() {
        layoutFragmentEvenementFiltre.setVisibility(View.VISIBLE);
        layoutFiltreAffiche = true;
    }

    protected boolean isEvenementEntityToujoursExistant(EvenementEntity evenementEntity) {
        for (Event current : listEvents) {
            if (isEventAndEvenementEntityIdentique(current, evenementEntity)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isEventAndEvenementEntityIdentique(Event event, EvenementEntity eventEntity) {
        if (event.getId() != eventEntity.getEvenementEntityId()) {
            return false;
        }

        //verif ListAdress
        boolean boolAdress1 = false;
        boolean boolAdress2 = false;
        if (event.getListAddresses() != null && eventEntity.getListAddresses() != null) {
            for (Address current : event.getListAddresses()) {
                for (EvenementAddressEntity current2 : eventEntity.getListAddresses()) {
                    if (current.getType().equalsIgnoreCase(current2.getType()) && current.getAddressContent().equalsIgnoreCase(current2.getAddressContent())
                            && current.getCity().equalsIgnoreCase(current2.getCity()) && current.getZip().equalsIgnoreCase(current2.getZip())) {
                        boolAdress1 = true;
                    }
                }
            }
            for (EvenementAddressEntity current : eventEntity.getListAddresses()) {
                for (Address current2 : event.getListAddresses()) {
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
            for (com.pouillcorp.sortirnice.modelevents.Category current : event.getListCategories()) {
                for (EvenementCategoryEntity current2 : eventEntity.getListCategories()) {
                    for (FusionEventCategorie enumeration : FusionEventCategorie.values()){
                        if (current.getValue().equalsIgnoreCase(enumeration.toBis())){
                            current.setValue(enumeration.toString());
                        }
                    }
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolCategories1 = true;
                    }
                }
            }
            for (EvenementCategoryEntity current : eventEntity.getListCategories()) {
                for (com.pouillcorp.sortirnice.modelevents.Category current2 : event.getListCategories()) {
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
            for (com.pouillcorp.sortirnice.modelevents.Description current : event.getListDescriptions()) {
                for (EvenementDescriptionEntity current2 : eventEntity.getListDescriptions()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolDescriptions1 = true;
                    }
                }
            }
            for (EvenementDescriptionEntity current : eventEntity.getListDescriptions()) {
                for (com.pouillcorp.sortirnice.modelevents.Description current2 : event.getListDescriptions()) {
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
            for (com.pouillcorp.sortirnice.modelevents.Option current : event.getListOptions()) {
                for (EvenementOptionEntity current2 : eventEntity.getListOptions()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolOptions1 = true;
                    }
                }
            }
            for (EvenementOptionEntity current : eventEntity.getListOptions()) {
                for (com.pouillcorp.sortirnice.modelevents.Option current2 : event.getListOptions()) {
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
            for (com.pouillcorp.sortirnice.modelevents.Profile current : event.getListProfiles()) {
                for (EvenementProfileEntity current2 : eventEntity.getListProfiles()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolProfiles1 = true;
                    }
                }
            }
            for (EvenementProfileEntity current : eventEntity.getListProfiles()) {
                for (com.pouillcorp.sortirnice.modelevents.Profile current2 : event.getListProfiles()) {
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
            for (com.pouillcorp.sortirnice.modelevents.Station current : event.getListStations()) {
                for (EvenementStationEntity current2 : eventEntity.getListStations()) {
                    if (current.getValue().equalsIgnoreCase(current2.getValue())) {
                        boolStations1 = true;
                    }
                }
            }
            for (EvenementStationEntity current : eventEntity.getListStations()) {
                for (com.pouillcorp.sortirnice.modelevents.Station current2 : event.getListStations()) {
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

    protected void saveListEvents() {
        List<EvenementEntity> listEventsNonFavoris = evenementEntityDao.queryRaw("where favori = 0");
        for (EvenementEntity current : listEventsNonFavoris) {
            if (!isEvenementEntityToujoursExistant(current)) {
                evenementEntityDao.delete(current);
                Log.e("TAG", "suppression evenement obsolete - " + current.getNameFr());
            }
        }

        for (Event current : listEvents) {
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
                    for (com.pouillcorp.sortirnice.modelevents.Profile profile : current.getListProfiles()) {
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
                    for (com.pouillcorp.sortirnice.modelevents.Station station : current.getListStations()) {
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
                    for (com.pouillcorp.sortirnice.modelevents.Category category : current.getListCategories()) {
                        boolean aIgnorer = false;
                        for (ExclusionEventCategorie exclusion : ExclusionEventCategorie.values()) {
                            if (category.getValue().equalsIgnoreCase(exclusion.toString())){
                                aIgnorer = true;
                            }
                        }
                        if (!aIgnorer) {
                            for (FusionEventCategorie fusion : FusionEventCategorie.values()){
                                if (fusion.toBis().equalsIgnoreCase(category.getValue())){
                                    category.setValue(fusion.toString());
                                }
                            }
                            List<EvenementCategoryEntity> list = evenementCategoryEntityDao.queryRaw("where value = ?", category.getValue());
                            List<JoinEvenementEntityWithEvenementCategoryEntity> listJoin = new ArrayList<>();
                            if (list.size() > 0) {
                                listJoin = joinEvenementEntityWithEvenementCategoryEntityDao.queryRaw("where evenement_entity_id = ? and evenement_category_entity_id = ?", evenementToSave.getId().toString(), list.get(0).getId().toString());
                            }
                            if (listJoin.size() == 0) {
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
                    }
                }
                //enregistrer list Options
                if (current.getListOptions() != null) {
                    for (com.pouillcorp.sortirnice.modelevents.Option option : current.getListOptions()) {
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
                    for (com.pouillcorp.sortirnice.modelevents.Description description : current.getListDescriptions()) {
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
                Log.e("TAG", "Ajout " + evenementToSave.getNameFr());
                listEventEntities.add(evenementToSave);
            } else {
            }
        }
    }

    protected void configureOnClickRecyclerViewEvent() {
        ItemClickSupport.addTo(list_recycler_event, R.layout.recycler_list_event)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        positionScroll = position;
                        masquerFragmentTri();
                        masquerFragmentFiltreEvent();
                        //masquerFragmentType();
                        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
                        //bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).setChecked(true);
                        boolean boolFavori = bottomNavigationViewMenu.findItem(R.id.bottom_navigation_my_datas).isChecked();
                        ouvrirActiviteSuivante(App.getInstance().getApplicationContext(), AfficherEvenementDetailActivity.class, "eventId", listEventEntities.get(position).getId(), false, boolFavori);
                    }
                });
    }

    protected void configureRecyclerView() {
        adapterEvents = new RecyclerAdapterEvenements(listEventEntities, (RecyclerAdapterEvenements.Listener) this);
        list_recycler_event.setAdapter(adapterEvents);
        list_recycler_event.setLayoutManager(new LinearLayoutManager(this));
        configureOnClickRecyclerViewEvent();
    }

    protected void replierEventTousFiltre() {
        filtreCategoryDeplie = false;
        checkboxEvenementFiltreCategorySelectAll.setVisibility(View.GONE);
        linearLayoutEvenementFiltreCategory.setVisibility(View.GONE);
        buttonEvenementFiltreCategory.setIconResource(R.drawable.outline_arrow_right_black_18);
        filtreVilleDeplie = false;
        checkboxEvenementFiltreVilleSelectAll.setVisibility(View.GONE);
        linearLayoutEvenementFiltreVille.setVisibility(View.GONE);
        buttonEvenementFiltreVille.setIconResource(R.drawable.outline_arrow_right_black_18);
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
    protected void fabEvenementFiltreClick() {
        reinitListeEvents();
        masquerFragmentFiltreEvent();
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
    protected void fabEvenementRazFiltreClick() {
        decocherTout();
        replierEventTousFiltre();
        masquerFragmentFiltreEvent();
        listEventEntities.clear();
        listEventEntities.addAll(listEventEntitiesBasique);
        triSelonParametre(listEventEntities);
        configureRecyclerView();
    }

    protected void decocherFiltre(List<? extends DetailEvenementEntitySimple> list) {
        for (DetailEvenementEntitySimple current : list) {
            current.setChecked(false);
        }
    }

    protected void decocherFiltreAdresse(List<EvenementAddressEntity> list) {
        for (EvenementAddressEntity current : list) {
            current.setChecked(false);
        }
    }

    protected void decocherTout() {
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

    protected void listerFiltre() {
        listFiltreEvenementCategory = evenementCategoryEntityDao.loadAll();
        listFiltreEvenementAdresse = evenementAddressEntityDao.loadAll();
    }

    protected void initCheckboxesSelectAllClick() {
        initCheckboxSelectAllClick(checkboxEvenementFiltreCategorySelectAll, listCheckboxEvenementCategory);
        initCheckboxSelectAllClick(checkboxEvenementFiltreVilleSelectAll, listCheckboxEvenementVille);
    }
}