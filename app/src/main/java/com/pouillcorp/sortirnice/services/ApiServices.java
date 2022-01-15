package com.pouillcorp.sortirnice.services;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.pouillcorp.sortirnice.App;
import com.pouillcorp.sortirnice.activities.AccueilActivity;
import com.pouillcorp.sortirnice.activities.AfficherChoixEnregistrementActivity;
import com.pouillcorp.sortirnice.activities.NavDrawerEntryActivity;
import com.pouillcorp.sortirnice.dao.AppOpenHelper;
import com.pouillcorp.sortirnice.dao.DaoMaster;
import com.pouillcorp.sortirnice.dao.DaoSession;
import com.pouillcorp.sortirnice.dao.EntryActivityEntityDao;
import com.pouillcorp.sortirnice.dao.EntryAddressEntityDao;
import com.pouillcorp.sortirnice.dao.EntryAffiliationEntityDao;
import com.pouillcorp.sortirnice.dao.EntryAllianceOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryAmenityEntityDao;
import com.pouillcorp.sortirnice.dao.EntryAnimationEntityDao;
import com.pouillcorp.sortirnice.dao.EntryAtmospherEntityDao;
import com.pouillcorp.sortirnice.dao.EntryCapacityEntityDao;
import com.pouillcorp.sortirnice.dao.EntryCategoryEntityDao;
import com.pouillcorp.sortirnice.dao.EntryChainEntityDao;
import com.pouillcorp.sortirnice.dao.EntryClosingEntityDao;
import com.pouillcorp.sortirnice.dao.EntryClosureEntityDao;
import com.pouillcorp.sortirnice.dao.EntryCommerciaEntityDao;
import com.pouillcorp.sortirnice.dao.EntryCommonTagEntityDao;
import com.pouillcorp.sortirnice.dao.EntryContactEntityDao;
import com.pouillcorp.sortirnice.dao.EntryDescriptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryDisabledOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryEntityDao;
import com.pouillcorp.sortirnice.dao.EntryFamilyOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryFrpOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryFurnishedRentalEntityDao;
import com.pouillcorp.sortirnice.dao.EntryGridEntityDao;
import com.pouillcorp.sortirnice.dao.EntryGroupOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryImageEntityDao;
import com.pouillcorp.sortirnice.dao.EntryLabelEntityDao;
import com.pouillcorp.sortirnice.dao.EntryLanguageEntityDao;
import com.pouillcorp.sortirnice.dao.EntryLivingEntityDao;
import com.pouillcorp.sortirnice.dao.EntryLocationEntityDao;
import com.pouillcorp.sortirnice.dao.EntryOpeningEntityDao;
import com.pouillcorp.sortirnice.dao.EntryOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryPaymentEntityDao;
import com.pouillcorp.sortirnice.dao.EntryPoiOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EntryProfileEntityDao;
import com.pouillcorp.sortirnice.dao.EntryPublicationEntityDao;
import com.pouillcorp.sortirnice.dao.EntryRentalMonthEntityDao;
import com.pouillcorp.sortirnice.dao.EntrySectorEntityDao;
import com.pouillcorp.sortirnice.dao.EntryServiceEntityDao;
import com.pouillcorp.sortirnice.dao.EntrySleepingEntityDao;
import com.pouillcorp.sortirnice.dao.EntrySpaceEntityDao;
import com.pouillcorp.sortirnice.dao.EntryStandingLevelEntityDao;
import com.pouillcorp.sortirnice.dao.EntryStationEntityDao;
import com.pouillcorp.sortirnice.dao.EntryTariffEntityDao;
import com.pouillcorp.sortirnice.dao.EventEntityDao;
import com.pouillcorp.sortirnice.dao.EventSauvegardeEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryActivityEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryAffiliationEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryAllianceOptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryAmenityEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryAnimationEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryAtmospherEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryCategoryEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryChainEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryClosingEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryClosureEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryCommerciaEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryCommonTagEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryContactEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryDescriptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryDisabledOptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryFamilyOptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryFrpOptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryFurnishedRentalEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryGroupOptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryImageEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryLabelEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryLanguageEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryLocationEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryOpeningEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryOptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryPaymentEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryPoiOptionEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryProfileEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryPublicationEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryRentalMonthEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntrySectorEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryServiceEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntrySleepingEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntrySpaceEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryStandingLevelEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryStationEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryEntityWithEntryTariffEntityDao;
import com.pouillcorp.sortirnice.dao.JoinEntryOpeningEntityWithEntryGridEntityDao;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
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
import com.pouillcorp.sortirnice.utils.DateUtils;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiServices {

    int compteur = 0;
    int cptrEntriesType;


    protected String dateVeilleString;
    protected Date dateDemande  = new Date();
    protected String dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
    protected Date dateVeille;

    protected static final String BASE_URL = "http://opendata.nicecotedazur.org/data/storage/f/DIRECTORY/talend/";
    protected String myUrl = BASE_URL;
    protected static Retrofit retrofit = null;
    protected final static String API_KEY = "dae3988a-a667-40a6-a74c-42df34b5aff9";

    protected int nbEntries;
    protected List<Entry> listEntries;
    protected List<EntryEntity> listEntryEntities = new ArrayList<>();
    List<Entry> listEntryFiltre = new ArrayList<>();

    protected static final String TAG = NavDrawerEntryActivity.class.getSimpleName();

    private static ApiServices apiService = new ApiServices();
    List<Entry> listEntriesBoutique = new ArrayList<>();
    List<Entry> listEntriesHebergement = new ArrayList<>();
    List<Entry> listEntriesHotel = new ArrayList<>();
    List<Entry> listEntriesRestaurant = new ArrayList<>();
    List<Entry> listEntriesUtile = new ArrayList<>();
    List<Entry> listEntriesVisite = new ArrayList<>();
    List<Entry> listEntriesShopping = new ArrayList<>();
    List<Entry> listEntriesSortie = new ArrayList<>();
    List<Entry> listEntriesTransport = new ArrayList<>();
    //public List<Entry> listEntries;

    protected DaoSession daoSession;

    protected EventEntityDao eventEntityDao;
    protected EventSauvegardeEntityDao eventSauvegardeEntityDao;
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

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void initialiserDao() {
        AppOpenHelper helper = new AppOpenHelper(App.getInstance(), "sortir_nice_2022_db", null);
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public  void creerDao() {
        initialiserDao();

        eventEntityDao = daoSession.getEventEntityDao();
        eventSauvegardeEntityDao = daoSession.getEventSauvegardeEntityDao();
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
    }

    //public  ApiServices getInstance( )
    public static ApiServices getInstance( )
    {
        //creerDao();
        return apiService;
    }

    public void connectAndGetApiDataEntries(String url, EntriesType entryType) {

        listEntries = new ArrayList<>();

        //progressBar.setVisibility(View.VISIBLE);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Call<Entries> call;
        switch (entryType) {
            case Boutique:
                EntriesBoutiqueApiService entriesBoutiqueApiService = retrofit.create(EntriesBoutiqueApiService.class);
                call = entriesBoutiqueApiService.getEntries();
                break;
            case Hebergement:
                EntriesHebergementApiService entriesHebergementApiService = retrofit.create(EntriesHebergementApiService.class);
                call = entriesHebergementApiService.getEntries();
                break;
            case Hotel:
                EntriesHotelApiService entriesHotelApiService = retrofit.create(EntriesHotelApiService.class);
                call = entriesHotelApiService.getEntries();
                break;
            case Restaurant:
                EntriesRestaurantApiService entriesRestaurantApiService = retrofit.create(EntriesRestaurantApiService.class);
                call = entriesRestaurantApiService.getEntries();
                break;
            case Shopping:
                EntriesShoppingApiService entriesShoppingApiService = retrofit.create(EntriesShoppingApiService.class);
                call = entriesShoppingApiService.getEntries();
                break;
            case Sortie:
                EntriesSortieApiService entriesSortieApiService = retrofit.create(EntriesSortieApiService.class);
                call = entriesSortieApiService.getEntries();
                break;
            case Transport:
                EntriesTransportApiService entriesTransportApiService = retrofit.create(EntriesTransportApiService.class);
                call = entriesTransportApiService.getEntries();
                break;
            case Utile:
                EntriesUtileApiService entriesUtileApiService = retrofit.create(EntriesUtileApiService.class);
                call = entriesUtileApiService.getEntries();
                break;
            case Visite:
                EntriesVisiteApiService entriesVisiteApiService = retrofit.create(EntriesVisiteApiService.class);
                call = entriesVisiteApiService.getEntries();
                break;
            default:
                call = null;
        }
        /*if (call != null) {
            try {
                Log.e(TAG, "type: " + entryType.toString());
                listEntries.addAll(call.execute().body().getListEntries());
                Log.e(TAG, "type: " + entryType.toString());
                Log.e(TAG, "Number of entries received: " + listEntries.size());
            } catch (Exception e){
                Log.e(TAG, "exception execute: " + e);
                if (entryType != EntriesType.Shopping) {
                    dateDemande = DateUtils.calculerVeille(dateDemande);
                    dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                    Log.e("TAG", "date rch : " + dateDemandeString);
                    myUrl = BASE_URL + dateDemandeString + "/";
                } else {
                    if (compteur < 15) {
                        dateDemande = DateUtils.calculerVeille(dateDemande);
                        dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                        compteur++;
                    } else {
                        dateDemandeString = "20160726";
                    }
                    Log.e("TAG", "date rch : " + dateDemandeString);
                    myUrl = BASE_URL + dateDemandeString + "/";

                }
                connectAndGetApiDataEntries(myUrl, entryType);
            }*/
            call.enqueue(new Callback<Entries>() {
                             @Override
                             public void onResponse(Call<Entries> call, Response<Entries> response) {
                                 if (response.code() == 200) {
                                     cptrEntriesType ++;
                                     for (Entry current : response.body().getListEntries()) {
                                         current.setEntryType(entryType);
                                     }
                                     //listEntries.addAll(response.body().getListEntries());
                                     switch (entryType) {
                                         case Boutique:
                                             listEntriesBoutique.addAll(response.body().getListEntries());
                                             break;
                                         case Hebergement:
                                             listEntriesHebergement.addAll(response.body().getListEntries());
                                             break;
                                         case Hotel:
                                             listEntriesHotel.addAll(response.body().getListEntries());
                                             break;
                                         case Restaurant:
                                             listEntriesRestaurant.addAll(response.body().getListEntries());
                                             break;
                                         case Shopping:
                                             listEntriesShopping.addAll(response.body().getListEntries());
                                             break;
                                         case Sortie:
                                             listEntriesSortie.addAll(response.body().getListEntries());
                                             break;
                                         case Transport:
                                             listEntriesTransport.addAll(response.body().getListEntries());
                                             break;
                                         case Utile:
                                             listEntriesUtile.addAll(response.body().getListEntries());
                                             break;
                                         case Visite:
                                             listEntriesVisite.addAll(response.body().getListEntries());
                                             break;
                                         default:
                                     }

                                     //si recherche sur un seul type d'entry penser à maj le compteur à 8
                                     if (cptrEntriesType == 9) {
                                         if (listEntriesBoutique != null && listEntriesBoutique.size()>0) {
                                             listEntries.addAll(listEntriesBoutique);
                                         }
                                         if (listEntriesHotel != null && listEntriesHotel.size()>0) {
                                             listEntries.addAll(listEntriesHotel);
                                         }
                                         if (listEntriesHebergement != null && listEntriesHebergement.size()>0) {
                                             listEntries.addAll(listEntriesHebergement);
                                         }
                                         if (listEntriesShopping != null && listEntriesShopping.size()>0) {
                                             listEntries.addAll(listEntriesShopping);
                                         }
                                         if (listEntriesVisite != null && listEntriesVisite.size()>0) {
                                             listEntries.addAll(listEntriesVisite);
                                         }
                                         if (listEntriesTransport != null && listEntriesTransport.size()>0) {
                                             listEntries.addAll(listEntriesTransport);
                                         }
                                         if (listEntriesUtile != null && listEntriesUtile.size()>0) {
                                             listEntries.addAll(listEntriesUtile);
                                         }
                                         if (listEntriesSortie != null && listEntriesSortie.size()>0) {
                                             listEntries.addAll(listEntriesSortie);
                                         }
                                         if (listEntriesRestaurant != null && listEntriesRestaurant.size()>0) {
                                             listEntries.addAll(listEntriesRestaurant);
                                         }

                                         //configureRecyclerView();
                                     }
                                     //configureRecyclerView();
                                     //isResponded = true;
                                     //Log.e(TAG, "type: " + entryType.toString());
                                     //Log.e(TAG, "Number of entries received: " + listEntries.size());
                                     //progressBar.setVisibility(View.GONE);
                                 } else {
                                     if (entryType != EntriesType.Shopping) {
                                         dateDemande = DateUtils.calculerVeille(dateDemande);
                                         dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                         //Log.e("TAG", "date rch : " + dateDemandeString);
                                         myUrl = BASE_URL + dateDemandeString + "/";
                                     } else {
                                         if (compteur < 15) {
                                             dateDemande = DateUtils.calculerVeille(dateDemande);
                                             dateDemandeString = DateUtils.formatDateYYYY_MM_DD(dateDemande);
                                             compteur++;
                                         } else {
                                             dateDemandeString = "20160726";
                                         }
                                         //Log.e("TAG", "date rch : " + dateDemandeString);
                                         myUrl = BASE_URL + dateDemandeString + "/";

                                     }
                                     connectAndGetApiDataEntries(myUrl, entryType);
                                     //connectAndGetApiData(myUrl, entryType,true);

                                 }
                             }


                             @Override
                             public void onFailure(Call<Entries> call, Throwable throwable) {
                                 Log.e(TAG, throwable.toString());
                                 //progressBar.setVisibility(View.GONE);
                                 //Snackbar.make(bottomNavigationView, "Erreur de modele", Snackbar.LENGTH_LONG).show();
                                 //envoyerEmailErreur(entryType);
                             }
                         }
            );
        /*} else {
            Log.e(TAG, "call null (hors des 9 entriesType");
        }*/
    }


    private void lancerRechercheGlobale(){
        AsyncTaskRunnerRechercheBoutique runnerBoutique = new AsyncTaskRunnerRechercheBoutique();
        runnerBoutique.execute();
        AsyncTaskRunnerRechercheHebergement runnerHebergement = new AsyncTaskRunnerRechercheHebergement();
        runnerHebergement.execute();
        AsyncTaskRunnerRechercheHotel runnerHotel = new AsyncTaskRunnerRechercheHotel();
        runnerHotel.execute();
        AsyncTaskRunnerRechercheRestaurant runnerRestaurant = new AsyncTaskRunnerRechercheRestaurant();
        runnerRestaurant.execute();
        AsyncTaskRunnerRechercheShopping runnerShopping = new AsyncTaskRunnerRechercheShopping();
        runnerShopping.execute();
        AsyncTaskRunnerRechercheSortie runnerSortie = new AsyncTaskRunnerRechercheSortie();
        runnerSortie.execute();
        AsyncTaskRunnerRechercheTransport runnerTransport = new AsyncTaskRunnerRechercheTransport();
        runnerTransport.execute();
        AsyncTaskRunnerRechercheUtile runnerUtile = new AsyncTaskRunnerRechercheUtile();
        runnerUtile.execute();
        AsyncTaskRunnerRechercheVisite runnerVisite = new AsyncTaskRunnerRechercheVisite();
        runnerVisite.execute();
    }

    private class AsyncTaskRunnerRechercheBoutique extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Boutique);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheBoutique fini");
            Log.e(TAG, "type: Boutique");
            Log.e(TAG, "Number of entries received: " + listEntriesBoutique.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheHebergement extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Hebergement);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheHebergement fini");
            Log.e(TAG, "type: Hebergement");
            Log.e(TAG, "Number of entries received: " + listEntriesHebergement.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheHotel extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Hotel);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheHotel fini");
            Log.e(TAG, "type: Hotel");
            Log.e(TAG, "Number of entries received: " + listEntriesHotel.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheRestaurant extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Restaurant);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheRestaurant fini");
            Log.e(TAG, "type: Restaurant");
            Log.e(TAG, "Number of entries received: " + listEntriesRestaurant.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheShopping extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Shopping);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheShopping fini");
            Log.e(TAG, "type: Shopping");
            Log.e(TAG, "Number of entries received: " + listEntriesShopping.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheSortie extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Sortie);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheSortie fini");
            Log.e(TAG, "type: Sortie");
            Log.e(TAG, "Number of entries received: " + listEntriesSortie.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheTransport extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Transport);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheTransport fini");
            Log.e(TAG, "type: Transport");
            Log.e(TAG, "Number of entries received: " + listEntriesTransport.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheUtile extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Utile);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheUtile fini");
            Log.e(TAG, "type: Utile");
            Log.e(TAG, "Number of entries received: " + listEntriesUtile.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
    private class AsyncTaskRunnerRechercheVisite extends AsyncTask<Void, Integer, Void> {

        protected Void doInBackground(Void...voids) {
            connectAndGetApiDataEntries(myUrl,EntriesType.Visite);
            //listEvents = eventSauvegardeEntityDao.loadAll();
            //listEntries = entryEntityDao.loadAll();
            return null;
        }

        protected void onPostExecute(Void result) {
            Log.e(TAG, "AsyncTaskRunnerRechercheVisite fini");
            Log.e(TAG, "type: Visite");
            Log.e(TAG, "Number of entries received: " + listEntriesVisite.size());
            //traiterIntent();
        }

            /*@RequiresApi(api = Build.VERSION_CODES.N)
            protected void onProgressUpdate(Integer... integer) {
                //progressBar.setProgress(integer[0],true);
            }*/
    }
}
