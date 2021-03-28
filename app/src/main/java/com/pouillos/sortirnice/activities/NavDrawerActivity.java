package com.pouillos.sortirnice.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pouillos.sortirnice.R;
import com.pouillos.sortirnice.dao.AppOpenHelper;
import com.pouillos.sortirnice.dao.DaoMaster;
import com.pouillos.sortirnice.dao.DaoSession;
import com.pouillos.sortirnice.dao.EntryActivityEntityDao;
import com.pouillos.sortirnice.dao.EntryAddressEntityDao;
import com.pouillos.sortirnice.dao.EntryAffiliationEntityDao;
import com.pouillos.sortirnice.dao.EntryAllianceOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryAmenityEntityDao;
import com.pouillos.sortirnice.dao.EntryAnimationEntityDao;
import com.pouillos.sortirnice.dao.EntryAtmospherEntityDao;
import com.pouillos.sortirnice.dao.EntryCapacityEntityDao;
import com.pouillos.sortirnice.dao.EntryCategoryEntityDao;
import com.pouillos.sortirnice.dao.EntryChainEntityDao;
import com.pouillos.sortirnice.dao.EntryClosingEntityDao;
import com.pouillos.sortirnice.dao.EntryClosureEntityDao;
import com.pouillos.sortirnice.dao.EntryCommerciaEntityDao;
import com.pouillos.sortirnice.dao.EntryCommonTagEntityDao;
import com.pouillos.sortirnice.dao.EntryContactEntityDao;
import com.pouillos.sortirnice.dao.EntryDescriptionEntityDao;
import com.pouillos.sortirnice.dao.EntryDisabledOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryEntityDao;
import com.pouillos.sortirnice.dao.EntryFamilyOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryFrpOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryFurnishedRentalEntityDao;
import com.pouillos.sortirnice.dao.EntryGridEntityDao;
import com.pouillos.sortirnice.dao.EntryGroupOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryImageEntityDao;
import com.pouillos.sortirnice.dao.EntryLabelEntityDao;
import com.pouillos.sortirnice.dao.EntryLanguageEntityDao;
import com.pouillos.sortirnice.dao.EntryLivingEntityDao;
import com.pouillos.sortirnice.dao.EntryLocationEntityDao;
import com.pouillos.sortirnice.dao.EntryOpeningEntityDao;
import com.pouillos.sortirnice.dao.EntryOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryPaymentEntityDao;
import com.pouillos.sortirnice.dao.EntryPoiOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryProfileEntityDao;
import com.pouillos.sortirnice.dao.EntryPublicationEntityDao;
import com.pouillos.sortirnice.dao.EntryRentalMonthEntityDao;
import com.pouillos.sortirnice.dao.EntrySectorEntityDao;
import com.pouillos.sortirnice.dao.EntryServiceEntityDao;
import com.pouillos.sortirnice.dao.EntrySleepingEntityDao;
import com.pouillos.sortirnice.dao.EntrySpaceEntityDao;
import com.pouillos.sortirnice.dao.EntryStandingLevelEntityDao;
import com.pouillos.sortirnice.dao.EntryStationEntityDao;
import com.pouillos.sortirnice.dao.EntryTariffEntityDao;
import com.pouillos.sortirnice.dao.EpisodeDao;
import com.pouillos.sortirnice.dao.EventEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryActivityEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryAffiliationEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryAllianceOptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryAmenityEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryAnimationEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryAtmospherEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryCategoryEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryChainEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryClosingEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryClosureEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryCommerciaEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryCommonTagEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryContactEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryDescriptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryDisabledOptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryFamilyOptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryFrpOptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryFurnishedRentalEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryGroupOptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryImageEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryLabelEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryLanguageEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryLocationEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryOpeningEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryOptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryPaymentEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryPoiOptionEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryProfileEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryPublicationEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryRentalMonthEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntrySectorEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryServiceEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntrySleepingEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntrySpaceEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryStandingLevelEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryStationEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryEntityWithEntryTariffEntityDao;
import com.pouillos.sortirnice.dao.JoinEntryOpeningEntityWithEntryGridEntityDao;
import com.pouillos.sortirnice.dao.SaisonDao;
import com.pouillos.sortirnice.dao.SerieDao;
import com.pouillos.sortirnice.entities.entry.EntryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryActivityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAddressEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAffiliationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAllianceOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCapacityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryChainEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCommerciaEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCommonTagEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryContactEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDescriptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDisabledOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFrpOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFurnishedRentalEntity;
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
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAllianceOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryChainEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCommerciaEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCommonTagEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryContactEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDescriptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDisabledOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFrpOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFurnishedRentalEntity;
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
import com.pouillos.sortirnice.modelentries.Activity;
import com.pouillos.sortirnice.modelentries.Affiliation;
import com.pouillos.sortirnice.modelentries.AllianceOption;
import com.pouillos.sortirnice.modelentries.Amenity;
import com.pouillos.sortirnice.modelentries.Animation;
import com.pouillos.sortirnice.modelentries.Atmospher;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Chain;
import com.pouillos.sortirnice.modelentries.Closing;
import com.pouillos.sortirnice.modelentries.Closure;
import com.pouillos.sortirnice.modelentries.Closures;
import com.pouillos.sortirnice.modelentries.Commercia;
import com.pouillos.sortirnice.modelentries.CommonTag;
import com.pouillos.sortirnice.modelentries.Contact;
import com.pouillos.sortirnice.modelentries.Description;
import com.pouillos.sortirnice.modelentries.DisabledOption;
import com.pouillos.sortirnice.modelentries.Entry;
import com.pouillos.sortirnice.modelentries.FamilyOption;
import com.pouillos.sortirnice.modelentries.FrpOption;
import com.pouillos.sortirnice.modelentries.FurnishedRental;
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

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import icepick.Icepick;

public class NavDrawerActivity<T> extends AppCompatActivity {
    //FOR DESIGN
    protected Toolbar toolbar;
    protected DrawerLayout drawerLayout;
    protected BottomNavigationView bottomNavigationView;
    protected DaoSession daoSession;
    protected SerieDao serieDao;
    protected SaisonDao saisonDao;
    protected EpisodeDao episodeDao;
    protected EventEntityDao eventEntityDao;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiserDao();
        serieDao = daoSession.getSerieDao();
        saisonDao = daoSession.getSaisonDao();
        episodeDao = daoSession.getEpisodeDao();
        eventEntityDao = daoSession.getEventEntityDao();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
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
        Intent myProfilActivity;
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
                            case R.id.bottom_navigation_add_serie:
                                ouvrirActiviteSuivante(NavDrawerActivity.this, EnregistrerSerieActivity.class, true);
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    protected <T> void buildDropdownMenu(List<T> listObj, Context context, AutoCompleteTextView textView) {
        List<String> listString = new ArrayList<>();
        String[] listDeroulante;
        listDeroulante = new String[listObj.size()];
        for (T object : listObj) {
            listString.add(object.toString());
        }
        listString.toArray(listDeroulante);
        ArrayAdapter adapter = new ArrayAdapter(context, R.layout.list_item, listDeroulante);
        textView.setAdapter(adapter);
    }

    @Override
    public Executor getMainExecutor() {
        return super.getMainExecutor();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void initialiserDao() {
        AppOpenHelper helper = new AppOpenHelper(this, "sortir_nice_db", null);
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

    public List<EntryEntity> saveListEntries(List<Entry> listEntries) {
        //entryEntityDao.deleteAll();
        List<EntryEntity> listEntryEntities = new ArrayList<>();
        for (Entry current : listEntries) {
            List<EntryEntity> listEntriesFound = entryEntityDao.queryRaw("where entry_entity_id = ?",""+current.getId());
            if (listEntriesFound.size()==0) {
                EntryEntity entryToSave = new EntryEntity();
                entryToSave.setEntryEntityId(Long.valueOf(current.getId()));
                entryToSave.setEntryType(EntriesType.Sortie);
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
                //entryToSave.setCommercial(current.getListCommercial());
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

                //entryEntityDao.insert(entryToSave);
                listEntryEntities.add(entryToSave);
                Log.e("TAG", "Ajout : " + entryToSave.getNameFr());
            } else {
                listEntryEntities.add(listEntriesFound.get(0));
                Log.e("TAG", "Recup : " + listEntriesFound.get(0).getNameFr());
            }
        }
        return listEntryEntities;
    }

    public void saveEntry(Entry entry) {
            List<EntryEntity> listEntriesFound = entryEntityDao.queryRaw("where entry_entity_id = ?",""+entry.getId());
        EntryEntity entryToSave = new EntryEntity();
            if (listEntriesFound.size() != 0) {
                entryToSave = listEntriesFound.get(0);
        }
                entryToSave.setEntryEntityId(Long.valueOf(entry.getId()));
                entryToSave.setEntryType(EntriesType.Sortie);
                entryToSave.setNameFr(entry.getNameFr());
                entryToSave.setNameFrShort(entry.getNameFrShort());

                //enregistrer address
                EntryAddressEntity entryAddressEntity = new EntryAddressEntity();
                entryAddressEntity.setAddressLine1(entry.getAddress().getAddressLine1());
                entryAddressEntity.setAddressLine2(entry.getAddress().getAddressLine2());
                entryAddressEntity.setAddressLine3(entry.getAddress().getAddressLine3());
                entryAddressEntity.setZip(entry.getAddress().getZip());
                entryAddressEntity.setCity(entry.getAddress().getCity());
                entryAddressEntity.setId(entryAddressEntityDao.insert(entryAddressEntity));
                entryToSave.setEntryAddressEntityId(entryAddressEntity.getId());

                entryToSave.setPhone(entry.getPhone());
                entryToSave.setFax(entry.getFax());
                entryToSave.setEmail(entry.getEmail());
                entryToSave.setWebsite(entry.getWebsite());
                entryToSave.setWebsiteReservation(entry.getWebsiteReservation());
                entryToSave.setFacebook(entry.getFacebook());
                entryToSave.setTwitter(entry.getTwitter());

                //enregistrer living
                EntryLivingEntity entryLivingEntity = new EntryLivingEntity();
                entryLivingEntity.setRoomCount(entry.getLiving().getRoomCount());
                entryLivingEntity.setRoomBathCount(entry.getLiving().getRoomBathCount());
                entryLivingEntity.setRoomShowerCount(entry.getLiving().getRoomShowerCount());
                entryLivingEntity.setRoomNoSmokingCount(entry.getLiving().getRoomNoSmokingCount());
                entryLivingEntity.setSuiteCount(entry.getLiving().getSuiteCount());
                entryLivingEntity.setStudioCount(entry.getLiving().getStudioCount());
                entryLivingEntity.setApartmentCount(entry.getLiving().getApartmentCount());
                entryLivingEntity.setRoomAccessibleCount(entry.getLiving().getRoomAccessibleCount());
                entryLivingEntity.setSingleCount(entry.getLiving().getSingleCount());
                entryLivingEntity.setDoubleCount(entry.getLiving().getDoubleCount());
                entryLivingEntity.setTripleCount(entry.getLiving().getTripleCount());
                entryLivingEntity.setTwinsCount(entry.getLiving().getTwinsCount());
                entryLivingEntity.setFamilyCount(entry.getLiving().getFamilyCount());
                entryLivingEntity.setArea(entry.getLiving().getArea());
                entryLivingEntity.setType(entry.getLiving().getType());
                entryLivingEntity.setFloor(entry.getLiving().getFloor());
                entryLivingEntity.setBedroomCount(entry.getLiving().getBedroomCount());
                entryLivingEntity.setSleepsCount(entry.getLiving().getSleepsCount());
                entryLivingEntity.setFurnishedRoomCount(entry.getLiving().getFurnishedRoomCount());
                entryLivingEntity.setId(entryLivingEntityDao.insert(entryLivingEntity));
                entryToSave.setEntryLivingEntityId(entryLivingEntity.getId());

                //enregistrer Capacity
                EntryCapacityEntity entryCapacityEntity = new EntryCapacityEntity();
                entryCapacityEntity.setTotal(entry.getCapacity().getTotal());
                entryCapacityEntity.setIndoor(entry.getCapacity().getIndoor());
                entryCapacityEntity.setOutdoor(entry.getCapacity().getOutdoor());
                entryCapacityEntity.setSeated(entry.getCapacity().getSeated());
                entryCapacityEntity.setCocktail(entry.getCapacity().getCocktail());
                entryCapacityEntity.setGroup(entry.getCapacity().getGroup());
                entryCapacityEntity.setRoomCount(entry.getCapacity().getRoomCount());
                entryCapacityEntity.setDisabledCount(entry.getCapacity().getDisabledCount());
                entryCapacityEntity.setId(entryCapacityEntityDao.insert(entryCapacityEntity));
                entryToSave.setEntryCapacityEntityId(entryCapacityEntity.getId());

                entryToSave.setOpening(entry.getOpening());
                //entryToSave.setCommercial(entry.getCommercial());
                entryToSave.setClosing(entry.getClosing());
                entryToSave.setLatitude(entry.getLatitude());
                entryToSave.setLongitude(entry.getLongitude());
                entryToSave.setLocation_map(entry.getLocationMap());
                entryToSave.setNote(entry.getNote());
                entryToSave.setStart(entry.getStart());
                entryToSave.setNiceresId(entry.getNiceresId());
                entryToSave.setNiceresAvailability(entry.isNiceresAvailability());
                entryToSave.setCreated(entry.getCreated());
                entryToSave.setUpdated(entry.getUpdated());

                //enregistrer Entry pour recup id pour join + plus tard
        if (listEntriesFound.size() == 0) {
            entryToSave.setId(entryEntityDao.insert(entryToSave));
        } else {
            entryEntityDao.update(entryToSave);
        }

                //enregistrer list contacts
                if (entry.getListContacts() != null) {
                    for (Contact contact : entry.getListContacts()) {
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
                if (entry.getListPayments() != null) {
                    for (Payment payment : entry.getListPayments()) {
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
                if (entry.getListLanguages() != null) {
                    for (Language language : entry.getListLanguages()) {
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
                if (entry.getListLabels() != null) {
                    for (Label label : entry.getListLabels()) {
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
                if (entry.getListAmenities() != null) {
                    for (Amenity amenity : entry.getListAmenities()) {
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
                if (entry.getListProfiles() != null) {
                    for (Profile profile : entry.getListProfiles()) {
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
                if (entry.getListLocations() != null) {
                    for (Location location : entry.getListLocations()) {
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

                if (entry.getListActivities() != null) {
                    for (Activity activity : entry.getListActivities()) {
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
                if (entry.getListCategories() != null) {
                    for (Category category : entry.getListCategories()) {
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
                if (entry.getListAtmosphere() != null) {
                    for (Atmospher atmospher : entry.getListAtmosphere()) {
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
                if (entry.getListAnimations() != null) {
                    for (Animation animation : entry.getListAnimations()) {
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
                if (entry.getListAffiliations() != null) {
                    for (Affiliation affiliation : entry.getListAffiliations()) {
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
                if (entry.getListStations() != null) {
                    for (Station station : entry.getListStations()) {
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
                if (entry.getListStandingLevels() != null) {
                    for (StandingLevel standingLevel : entry.getListStandingLevels()) {
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
                if (entry.getListChains() != null) {
                    for (Chain chain : entry.getListChains()) {
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
                if (entry.getListServices() != null) {
                    for (Service service : entry.getListServices()) {
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
                if (entry.getListOptions() != null) {
                    for (Option option : entry.getListOptions()) {
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
                if (entry.getListDisabledOptions() != null) {
                    for (DisabledOption disabledOption : entry.getListDisabledOptions()) {
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
                if (entry.getListFrpOptions() != null) {
                    for (FrpOption frpOption : entry.getListFrpOptions()) {
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
                if (entry.getListPoiOptions() != null) {
                    for (PoiOption poiOption : entry.getListPoiOptions()) {
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
                if (entry.getListPublications() != null) {
                    for (Publication publication : entry.getListPublications()) {
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
                if (entry.getListCommonTags() != null) {
                    for (CommonTag commonTag : entry.getListCommonTags()) {
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
                if (entry.getListSectors() != null) {
                    for (Sector sector : entry.getListSectors()) {
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
                if (entry.getListDescriptions() != null) {
                    for (Description description : entry.getListDescriptions()) {
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
                if (entry.getListImages() != null) {
                    for (Image image : entry.getListImages()) {
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
                if (entry.getListTariffs() != null) {
                    for (Tariff tariff : entry.getListTariffs()) {
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
                if (entry.getListClosures() != null) {
                    for (Closures closures : entry.getListClosures()) {

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

                //enregistrer list spaces
                if (entry.getListSpaces() != null) {
                    for (Space space : entry.getListSpaces()) {
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
                if (entry.getListClosings() != null) {
                    for (Closing closing : entry.getListClosings()) {
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
                if (entry.getListGroupOptions() != null) {
                    for (GroupOption groupOption : entry.getListGroupOptions()) {
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
                if (entry.getListAllianceOptions() != null) {
                    for (AllianceOption allianceOption : entry.getListAllianceOptions()) {
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
                if (entry.getListFurnishedRentals() != null) {
                    for (FurnishedRental furnishedRental : entry.getListFurnishedRentals()) {
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
                if (entry.getListFamilyOptions() != null) {
                    for (FamilyOption familyOption : entry.getListFamilyOptions()) {
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
                if (entry.getListOpenings() != null) {
                    for (Opening opening : entry.getListOpenings()) {
                        EntryOpeningEntity openingTemp = new EntryOpeningEntity();
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
    }

}
