package com.pouillos.sortirnice.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

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
import com.pouillos.sortirnice.entities.entry.detail.EntryRentalMonthEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySectorEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySleepingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySpaceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStandingLevelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryTariffEntity;
import com.pouillos.sortirnice.entities.entry.EntryEntity;
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
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryRentalMonthEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySectorEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySleepingEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySpaceEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStandingLevelEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryTariffEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryOpeningEntityWithEntryGridEntity;
import com.pouillos.sortirnice.entities.event.EventEntity;

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
import com.pouillos.sortirnice.dao.EntryEntityDao;
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
import com.pouillos.sortirnice.dao.EventEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig entryActivityEntityDaoConfig;
    private final DaoConfig entryAddressEntityDaoConfig;
    private final DaoConfig entryAffiliationEntityDaoConfig;
    private final DaoConfig entryAllianceOptionEntityDaoConfig;
    private final DaoConfig entryAmenityEntityDaoConfig;
    private final DaoConfig entryAnimationEntityDaoConfig;
    private final DaoConfig entryAtmospherEntityDaoConfig;
    private final DaoConfig entryCapacityEntityDaoConfig;
    private final DaoConfig entryCategoryEntityDaoConfig;
    private final DaoConfig entryChainEntityDaoConfig;
    private final DaoConfig entryClosingEntityDaoConfig;
    private final DaoConfig entryClosureEntityDaoConfig;
    private final DaoConfig entryCommerciaEntityDaoConfig;
    private final DaoConfig entryCommonTagEntityDaoConfig;
    private final DaoConfig entryContactEntityDaoConfig;
    private final DaoConfig entryDescriptionEntityDaoConfig;
    private final DaoConfig entryDisabledOptionEntityDaoConfig;
    private final DaoConfig entryFamilyOptionEntityDaoConfig;
    private final DaoConfig entryFrpOptionEntityDaoConfig;
    private final DaoConfig entryFurnishedRentalEntityDaoConfig;
    private final DaoConfig entryGridEntityDaoConfig;
    private final DaoConfig entryGroupOptionEntityDaoConfig;
    private final DaoConfig entryImageEntityDaoConfig;
    private final DaoConfig entryLabelEntityDaoConfig;
    private final DaoConfig entryLanguageEntityDaoConfig;
    private final DaoConfig entryLivingEntityDaoConfig;
    private final DaoConfig entryLocationEntityDaoConfig;
    private final DaoConfig entryOpeningEntityDaoConfig;
    private final DaoConfig entryOptionEntityDaoConfig;
    private final DaoConfig entryPaymentEntityDaoConfig;
    private final DaoConfig entryPoiOptionEntityDaoConfig;
    private final DaoConfig entryProfileEntityDaoConfig;
    private final DaoConfig entryPublicationEntityDaoConfig;
    private final DaoConfig entryRentalMonthEntityDaoConfig;
    private final DaoConfig entrySectorEntityDaoConfig;
    private final DaoConfig entryServiceEntityDaoConfig;
    private final DaoConfig entrySleepingEntityDaoConfig;
    private final DaoConfig entrySpaceEntityDaoConfig;
    private final DaoConfig entryStandingLevelEntityDaoConfig;
    private final DaoConfig entryStationEntityDaoConfig;
    private final DaoConfig entryTariffEntityDaoConfig;
    private final DaoConfig entryEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryActivityEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryAffiliationEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryAllianceOptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryAmenityEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryAnimationEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryAtmospherEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryCategoryEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryChainEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryClosingEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryClosureEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryCommerciaEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryCommonTagEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryContactEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryDescriptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryDisabledOptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryFamilyOptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryFrpOptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryFurnishedRentalEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryGroupOptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryImageEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryLabelEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryLanguageEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryLocationEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryOpeningEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryOptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryPaymentEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryPoiOptionEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryProfileEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryPublicationEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryRentalMonthEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntrySectorEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryServiceEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntrySleepingEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntrySpaceEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryStandingLevelEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryStationEntityDaoConfig;
    private final DaoConfig joinEntryEntityWithEntryTariffEntityDaoConfig;
    private final DaoConfig joinEntryOpeningEntityWithEntryGridEntityDaoConfig;
    private final DaoConfig eventEntityDaoConfig;

    private final EntryActivityEntityDao entryActivityEntityDao;
    private final EntryAddressEntityDao entryAddressEntityDao;
    private final EntryAffiliationEntityDao entryAffiliationEntityDao;
    private final EntryAllianceOptionEntityDao entryAllianceOptionEntityDao;
    private final EntryAmenityEntityDao entryAmenityEntityDao;
    private final EntryAnimationEntityDao entryAnimationEntityDao;
    private final EntryAtmospherEntityDao entryAtmospherEntityDao;
    private final EntryCapacityEntityDao entryCapacityEntityDao;
    private final EntryCategoryEntityDao entryCategoryEntityDao;
    private final EntryChainEntityDao entryChainEntityDao;
    private final EntryClosingEntityDao entryClosingEntityDao;
    private final EntryClosureEntityDao entryClosureEntityDao;
    private final EntryCommerciaEntityDao entryCommerciaEntityDao;
    private final EntryCommonTagEntityDao entryCommonTagEntityDao;
    private final EntryContactEntityDao entryContactEntityDao;
    private final EntryDescriptionEntityDao entryDescriptionEntityDao;
    private final EntryDisabledOptionEntityDao entryDisabledOptionEntityDao;
    private final EntryFamilyOptionEntityDao entryFamilyOptionEntityDao;
    private final EntryFrpOptionEntityDao entryFrpOptionEntityDao;
    private final EntryFurnishedRentalEntityDao entryFurnishedRentalEntityDao;
    private final EntryGridEntityDao entryGridEntityDao;
    private final EntryGroupOptionEntityDao entryGroupOptionEntityDao;
    private final EntryImageEntityDao entryImageEntityDao;
    private final EntryLabelEntityDao entryLabelEntityDao;
    private final EntryLanguageEntityDao entryLanguageEntityDao;
    private final EntryLivingEntityDao entryLivingEntityDao;
    private final EntryLocationEntityDao entryLocationEntityDao;
    private final EntryOpeningEntityDao entryOpeningEntityDao;
    private final EntryOptionEntityDao entryOptionEntityDao;
    private final EntryPaymentEntityDao entryPaymentEntityDao;
    private final EntryPoiOptionEntityDao entryPoiOptionEntityDao;
    private final EntryProfileEntityDao entryProfileEntityDao;
    private final EntryPublicationEntityDao entryPublicationEntityDao;
    private final EntryRentalMonthEntityDao entryRentalMonthEntityDao;
    private final EntrySectorEntityDao entrySectorEntityDao;
    private final EntryServiceEntityDao entryServiceEntityDao;
    private final EntrySleepingEntityDao entrySleepingEntityDao;
    private final EntrySpaceEntityDao entrySpaceEntityDao;
    private final EntryStandingLevelEntityDao entryStandingLevelEntityDao;
    private final EntryStationEntityDao entryStationEntityDao;
    private final EntryTariffEntityDao entryTariffEntityDao;
    private final EntryEntityDao entryEntityDao;
    private final JoinEntryEntityWithEntryActivityEntityDao joinEntryEntityWithEntryActivityEntityDao;
    private final JoinEntryEntityWithEntryAffiliationEntityDao joinEntryEntityWithEntryAffiliationEntityDao;
    private final JoinEntryEntityWithEntryAllianceOptionEntityDao joinEntryEntityWithEntryAllianceOptionEntityDao;
    private final JoinEntryEntityWithEntryAmenityEntityDao joinEntryEntityWithEntryAmenityEntityDao;
    private final JoinEntryEntityWithEntryAnimationEntityDao joinEntryEntityWithEntryAnimationEntityDao;
    private final JoinEntryEntityWithEntryAtmospherEntityDao joinEntryEntityWithEntryAtmospherEntityDao;
    private final JoinEntryEntityWithEntryCategoryEntityDao joinEntryEntityWithEntryCategoryEntityDao;
    private final JoinEntryEntityWithEntryChainEntityDao joinEntryEntityWithEntryChainEntityDao;
    private final JoinEntryEntityWithEntryClosingEntityDao joinEntryEntityWithEntryClosingEntityDao;
    private final JoinEntryEntityWithEntryClosureEntityDao joinEntryEntityWithEntryClosureEntityDao;
    private final JoinEntryEntityWithEntryCommerciaEntityDao joinEntryEntityWithEntryCommerciaEntityDao;
    private final JoinEntryEntityWithEntryCommonTagEntityDao joinEntryEntityWithEntryCommonTagEntityDao;
    private final JoinEntryEntityWithEntryContactEntityDao joinEntryEntityWithEntryContactEntityDao;
    private final JoinEntryEntityWithEntryDescriptionEntityDao joinEntryEntityWithEntryDescriptionEntityDao;
    private final JoinEntryEntityWithEntryDisabledOptionEntityDao joinEntryEntityWithEntryDisabledOptionEntityDao;
    private final JoinEntryEntityWithEntryFamilyOptionEntityDao joinEntryEntityWithEntryFamilyOptionEntityDao;
    private final JoinEntryEntityWithEntryFrpOptionEntityDao joinEntryEntityWithEntryFrpOptionEntityDao;
    private final JoinEntryEntityWithEntryFurnishedRentalEntityDao joinEntryEntityWithEntryFurnishedRentalEntityDao;
    private final JoinEntryEntityWithEntryGroupOptionEntityDao joinEntryEntityWithEntryGroupOptionEntityDao;
    private final JoinEntryEntityWithEntryImageEntityDao joinEntryEntityWithEntryImageEntityDao;
    private final JoinEntryEntityWithEntryLabelEntityDao joinEntryEntityWithEntryLabelEntityDao;
    private final JoinEntryEntityWithEntryLanguageEntityDao joinEntryEntityWithEntryLanguageEntityDao;
    private final JoinEntryEntityWithEntryLocationEntityDao joinEntryEntityWithEntryLocationEntityDao;
    private final JoinEntryEntityWithEntryOpeningEntityDao joinEntryEntityWithEntryOpeningEntityDao;
    private final JoinEntryEntityWithEntryOptionEntityDao joinEntryEntityWithEntryOptionEntityDao;
    private final JoinEntryEntityWithEntryPaymentEntityDao joinEntryEntityWithEntryPaymentEntityDao;
    private final JoinEntryEntityWithEntryPoiOptionEntityDao joinEntryEntityWithEntryPoiOptionEntityDao;
    private final JoinEntryEntityWithEntryProfileEntityDao joinEntryEntityWithEntryProfileEntityDao;
    private final JoinEntryEntityWithEntryPublicationEntityDao joinEntryEntityWithEntryPublicationEntityDao;
    private final JoinEntryEntityWithEntryRentalMonthEntityDao joinEntryEntityWithEntryRentalMonthEntityDao;
    private final JoinEntryEntityWithEntrySectorEntityDao joinEntryEntityWithEntrySectorEntityDao;
    private final JoinEntryEntityWithEntryServiceEntityDao joinEntryEntityWithEntryServiceEntityDao;
    private final JoinEntryEntityWithEntrySleepingEntityDao joinEntryEntityWithEntrySleepingEntityDao;
    private final JoinEntryEntityWithEntrySpaceEntityDao joinEntryEntityWithEntrySpaceEntityDao;
    private final JoinEntryEntityWithEntryStandingLevelEntityDao joinEntryEntityWithEntryStandingLevelEntityDao;
    private final JoinEntryEntityWithEntryStationEntityDao joinEntryEntityWithEntryStationEntityDao;
    private final JoinEntryEntityWithEntryTariffEntityDao joinEntryEntityWithEntryTariffEntityDao;
    private final JoinEntryOpeningEntityWithEntryGridEntityDao joinEntryOpeningEntityWithEntryGridEntityDao;
    private final EventEntityDao eventEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        entryActivityEntityDaoConfig = daoConfigMap.get(EntryActivityEntityDao.class).clone();
        entryActivityEntityDaoConfig.initIdentityScope(type);

        entryAddressEntityDaoConfig = daoConfigMap.get(EntryAddressEntityDao.class).clone();
        entryAddressEntityDaoConfig.initIdentityScope(type);

        entryAffiliationEntityDaoConfig = daoConfigMap.get(EntryAffiliationEntityDao.class).clone();
        entryAffiliationEntityDaoConfig.initIdentityScope(type);

        entryAllianceOptionEntityDaoConfig = daoConfigMap.get(EntryAllianceOptionEntityDao.class).clone();
        entryAllianceOptionEntityDaoConfig.initIdentityScope(type);

        entryAmenityEntityDaoConfig = daoConfigMap.get(EntryAmenityEntityDao.class).clone();
        entryAmenityEntityDaoConfig.initIdentityScope(type);

        entryAnimationEntityDaoConfig = daoConfigMap.get(EntryAnimationEntityDao.class).clone();
        entryAnimationEntityDaoConfig.initIdentityScope(type);

        entryAtmospherEntityDaoConfig = daoConfigMap.get(EntryAtmospherEntityDao.class).clone();
        entryAtmospherEntityDaoConfig.initIdentityScope(type);

        entryCapacityEntityDaoConfig = daoConfigMap.get(EntryCapacityEntityDao.class).clone();
        entryCapacityEntityDaoConfig.initIdentityScope(type);

        entryCategoryEntityDaoConfig = daoConfigMap.get(EntryCategoryEntityDao.class).clone();
        entryCategoryEntityDaoConfig.initIdentityScope(type);

        entryChainEntityDaoConfig = daoConfigMap.get(EntryChainEntityDao.class).clone();
        entryChainEntityDaoConfig.initIdentityScope(type);

        entryClosingEntityDaoConfig = daoConfigMap.get(EntryClosingEntityDao.class).clone();
        entryClosingEntityDaoConfig.initIdentityScope(type);

        entryClosureEntityDaoConfig = daoConfigMap.get(EntryClosureEntityDao.class).clone();
        entryClosureEntityDaoConfig.initIdentityScope(type);

        entryCommerciaEntityDaoConfig = daoConfigMap.get(EntryCommerciaEntityDao.class).clone();
        entryCommerciaEntityDaoConfig.initIdentityScope(type);

        entryCommonTagEntityDaoConfig = daoConfigMap.get(EntryCommonTagEntityDao.class).clone();
        entryCommonTagEntityDaoConfig.initIdentityScope(type);

        entryContactEntityDaoConfig = daoConfigMap.get(EntryContactEntityDao.class).clone();
        entryContactEntityDaoConfig.initIdentityScope(type);

        entryDescriptionEntityDaoConfig = daoConfigMap.get(EntryDescriptionEntityDao.class).clone();
        entryDescriptionEntityDaoConfig.initIdentityScope(type);

        entryDisabledOptionEntityDaoConfig = daoConfigMap.get(EntryDisabledOptionEntityDao.class).clone();
        entryDisabledOptionEntityDaoConfig.initIdentityScope(type);

        entryFamilyOptionEntityDaoConfig = daoConfigMap.get(EntryFamilyOptionEntityDao.class).clone();
        entryFamilyOptionEntityDaoConfig.initIdentityScope(type);

        entryFrpOptionEntityDaoConfig = daoConfigMap.get(EntryFrpOptionEntityDao.class).clone();
        entryFrpOptionEntityDaoConfig.initIdentityScope(type);

        entryFurnishedRentalEntityDaoConfig = daoConfigMap.get(EntryFurnishedRentalEntityDao.class).clone();
        entryFurnishedRentalEntityDaoConfig.initIdentityScope(type);

        entryGridEntityDaoConfig = daoConfigMap.get(EntryGridEntityDao.class).clone();
        entryGridEntityDaoConfig.initIdentityScope(type);

        entryGroupOptionEntityDaoConfig = daoConfigMap.get(EntryGroupOptionEntityDao.class).clone();
        entryGroupOptionEntityDaoConfig.initIdentityScope(type);

        entryImageEntityDaoConfig = daoConfigMap.get(EntryImageEntityDao.class).clone();
        entryImageEntityDaoConfig.initIdentityScope(type);

        entryLabelEntityDaoConfig = daoConfigMap.get(EntryLabelEntityDao.class).clone();
        entryLabelEntityDaoConfig.initIdentityScope(type);

        entryLanguageEntityDaoConfig = daoConfigMap.get(EntryLanguageEntityDao.class).clone();
        entryLanguageEntityDaoConfig.initIdentityScope(type);

        entryLivingEntityDaoConfig = daoConfigMap.get(EntryLivingEntityDao.class).clone();
        entryLivingEntityDaoConfig.initIdentityScope(type);

        entryLocationEntityDaoConfig = daoConfigMap.get(EntryLocationEntityDao.class).clone();
        entryLocationEntityDaoConfig.initIdentityScope(type);

        entryOpeningEntityDaoConfig = daoConfigMap.get(EntryOpeningEntityDao.class).clone();
        entryOpeningEntityDaoConfig.initIdentityScope(type);

        entryOptionEntityDaoConfig = daoConfigMap.get(EntryOptionEntityDao.class).clone();
        entryOptionEntityDaoConfig.initIdentityScope(type);

        entryPaymentEntityDaoConfig = daoConfigMap.get(EntryPaymentEntityDao.class).clone();
        entryPaymentEntityDaoConfig.initIdentityScope(type);

        entryPoiOptionEntityDaoConfig = daoConfigMap.get(EntryPoiOptionEntityDao.class).clone();
        entryPoiOptionEntityDaoConfig.initIdentityScope(type);

        entryProfileEntityDaoConfig = daoConfigMap.get(EntryProfileEntityDao.class).clone();
        entryProfileEntityDaoConfig.initIdentityScope(type);

        entryPublicationEntityDaoConfig = daoConfigMap.get(EntryPublicationEntityDao.class).clone();
        entryPublicationEntityDaoConfig.initIdentityScope(type);

        entryRentalMonthEntityDaoConfig = daoConfigMap.get(EntryRentalMonthEntityDao.class).clone();
        entryRentalMonthEntityDaoConfig.initIdentityScope(type);

        entrySectorEntityDaoConfig = daoConfigMap.get(EntrySectorEntityDao.class).clone();
        entrySectorEntityDaoConfig.initIdentityScope(type);

        entryServiceEntityDaoConfig = daoConfigMap.get(EntryServiceEntityDao.class).clone();
        entryServiceEntityDaoConfig.initIdentityScope(type);

        entrySleepingEntityDaoConfig = daoConfigMap.get(EntrySleepingEntityDao.class).clone();
        entrySleepingEntityDaoConfig.initIdentityScope(type);

        entrySpaceEntityDaoConfig = daoConfigMap.get(EntrySpaceEntityDao.class).clone();
        entrySpaceEntityDaoConfig.initIdentityScope(type);

        entryStandingLevelEntityDaoConfig = daoConfigMap.get(EntryStandingLevelEntityDao.class).clone();
        entryStandingLevelEntityDaoConfig.initIdentityScope(type);

        entryStationEntityDaoConfig = daoConfigMap.get(EntryStationEntityDao.class).clone();
        entryStationEntityDaoConfig.initIdentityScope(type);

        entryTariffEntityDaoConfig = daoConfigMap.get(EntryTariffEntityDao.class).clone();
        entryTariffEntityDaoConfig.initIdentityScope(type);

        entryEntityDaoConfig = daoConfigMap.get(EntryEntityDao.class).clone();
        entryEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryActivityEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryActivityEntityDao.class).clone();
        joinEntryEntityWithEntryActivityEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryAffiliationEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryAffiliationEntityDao.class).clone();
        joinEntryEntityWithEntryAffiliationEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryAllianceOptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryAllianceOptionEntityDao.class).clone();
        joinEntryEntityWithEntryAllianceOptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryAmenityEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryAmenityEntityDao.class).clone();
        joinEntryEntityWithEntryAmenityEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryAnimationEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryAnimationEntityDao.class).clone();
        joinEntryEntityWithEntryAnimationEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryAtmospherEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryAtmospherEntityDao.class).clone();
        joinEntryEntityWithEntryAtmospherEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryCategoryEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryCategoryEntityDao.class).clone();
        joinEntryEntityWithEntryCategoryEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryChainEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryChainEntityDao.class).clone();
        joinEntryEntityWithEntryChainEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryClosingEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryClosingEntityDao.class).clone();
        joinEntryEntityWithEntryClosingEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryClosureEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryClosureEntityDao.class).clone();
        joinEntryEntityWithEntryClosureEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryCommerciaEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryCommerciaEntityDao.class).clone();
        joinEntryEntityWithEntryCommerciaEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryCommonTagEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryCommonTagEntityDao.class).clone();
        joinEntryEntityWithEntryCommonTagEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryContactEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryContactEntityDao.class).clone();
        joinEntryEntityWithEntryContactEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryDescriptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryDescriptionEntityDao.class).clone();
        joinEntryEntityWithEntryDescriptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryDisabledOptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryDisabledOptionEntityDao.class).clone();
        joinEntryEntityWithEntryDisabledOptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryFamilyOptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryFamilyOptionEntityDao.class).clone();
        joinEntryEntityWithEntryFamilyOptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryFrpOptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryFrpOptionEntityDao.class).clone();
        joinEntryEntityWithEntryFrpOptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryFurnishedRentalEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryFurnishedRentalEntityDao.class).clone();
        joinEntryEntityWithEntryFurnishedRentalEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryGroupOptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryGroupOptionEntityDao.class).clone();
        joinEntryEntityWithEntryGroupOptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryImageEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryImageEntityDao.class).clone();
        joinEntryEntityWithEntryImageEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryLabelEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryLabelEntityDao.class).clone();
        joinEntryEntityWithEntryLabelEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryLanguageEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryLanguageEntityDao.class).clone();
        joinEntryEntityWithEntryLanguageEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryLocationEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryLocationEntityDao.class).clone();
        joinEntryEntityWithEntryLocationEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryOpeningEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryOpeningEntityDao.class).clone();
        joinEntryEntityWithEntryOpeningEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryOptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryOptionEntityDao.class).clone();
        joinEntryEntityWithEntryOptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryPaymentEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryPaymentEntityDao.class).clone();
        joinEntryEntityWithEntryPaymentEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryPoiOptionEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryPoiOptionEntityDao.class).clone();
        joinEntryEntityWithEntryPoiOptionEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryProfileEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryProfileEntityDao.class).clone();
        joinEntryEntityWithEntryProfileEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryPublicationEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryPublicationEntityDao.class).clone();
        joinEntryEntityWithEntryPublicationEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryRentalMonthEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryRentalMonthEntityDao.class).clone();
        joinEntryEntityWithEntryRentalMonthEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntrySectorEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntrySectorEntityDao.class).clone();
        joinEntryEntityWithEntrySectorEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryServiceEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryServiceEntityDao.class).clone();
        joinEntryEntityWithEntryServiceEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntrySleepingEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntrySleepingEntityDao.class).clone();
        joinEntryEntityWithEntrySleepingEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntrySpaceEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntrySpaceEntityDao.class).clone();
        joinEntryEntityWithEntrySpaceEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryStandingLevelEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryStandingLevelEntityDao.class).clone();
        joinEntryEntityWithEntryStandingLevelEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryStationEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryStationEntityDao.class).clone();
        joinEntryEntityWithEntryStationEntityDaoConfig.initIdentityScope(type);

        joinEntryEntityWithEntryTariffEntityDaoConfig = daoConfigMap.get(JoinEntryEntityWithEntryTariffEntityDao.class).clone();
        joinEntryEntityWithEntryTariffEntityDaoConfig.initIdentityScope(type);

        joinEntryOpeningEntityWithEntryGridEntityDaoConfig = daoConfigMap.get(JoinEntryOpeningEntityWithEntryGridEntityDao.class).clone();
        joinEntryOpeningEntityWithEntryGridEntityDaoConfig.initIdentityScope(type);

        eventEntityDaoConfig = daoConfigMap.get(EventEntityDao.class).clone();
        eventEntityDaoConfig.initIdentityScope(type);

        entryActivityEntityDao = new EntryActivityEntityDao(entryActivityEntityDaoConfig, this);
        entryAddressEntityDao = new EntryAddressEntityDao(entryAddressEntityDaoConfig, this);
        entryAffiliationEntityDao = new EntryAffiliationEntityDao(entryAffiliationEntityDaoConfig, this);
        entryAllianceOptionEntityDao = new EntryAllianceOptionEntityDao(entryAllianceOptionEntityDaoConfig, this);
        entryAmenityEntityDao = new EntryAmenityEntityDao(entryAmenityEntityDaoConfig, this);
        entryAnimationEntityDao = new EntryAnimationEntityDao(entryAnimationEntityDaoConfig, this);
        entryAtmospherEntityDao = new EntryAtmospherEntityDao(entryAtmospherEntityDaoConfig, this);
        entryCapacityEntityDao = new EntryCapacityEntityDao(entryCapacityEntityDaoConfig, this);
        entryCategoryEntityDao = new EntryCategoryEntityDao(entryCategoryEntityDaoConfig, this);
        entryChainEntityDao = new EntryChainEntityDao(entryChainEntityDaoConfig, this);
        entryClosingEntityDao = new EntryClosingEntityDao(entryClosingEntityDaoConfig, this);
        entryClosureEntityDao = new EntryClosureEntityDao(entryClosureEntityDaoConfig, this);
        entryCommerciaEntityDao = new EntryCommerciaEntityDao(entryCommerciaEntityDaoConfig, this);
        entryCommonTagEntityDao = new EntryCommonTagEntityDao(entryCommonTagEntityDaoConfig, this);
        entryContactEntityDao = new EntryContactEntityDao(entryContactEntityDaoConfig, this);
        entryDescriptionEntityDao = new EntryDescriptionEntityDao(entryDescriptionEntityDaoConfig, this);
        entryDisabledOptionEntityDao = new EntryDisabledOptionEntityDao(entryDisabledOptionEntityDaoConfig, this);
        entryFamilyOptionEntityDao = new EntryFamilyOptionEntityDao(entryFamilyOptionEntityDaoConfig, this);
        entryFrpOptionEntityDao = new EntryFrpOptionEntityDao(entryFrpOptionEntityDaoConfig, this);
        entryFurnishedRentalEntityDao = new EntryFurnishedRentalEntityDao(entryFurnishedRentalEntityDaoConfig, this);
        entryGridEntityDao = new EntryGridEntityDao(entryGridEntityDaoConfig, this);
        entryGroupOptionEntityDao = new EntryGroupOptionEntityDao(entryGroupOptionEntityDaoConfig, this);
        entryImageEntityDao = new EntryImageEntityDao(entryImageEntityDaoConfig, this);
        entryLabelEntityDao = new EntryLabelEntityDao(entryLabelEntityDaoConfig, this);
        entryLanguageEntityDao = new EntryLanguageEntityDao(entryLanguageEntityDaoConfig, this);
        entryLivingEntityDao = new EntryLivingEntityDao(entryLivingEntityDaoConfig, this);
        entryLocationEntityDao = new EntryLocationEntityDao(entryLocationEntityDaoConfig, this);
        entryOpeningEntityDao = new EntryOpeningEntityDao(entryOpeningEntityDaoConfig, this);
        entryOptionEntityDao = new EntryOptionEntityDao(entryOptionEntityDaoConfig, this);
        entryPaymentEntityDao = new EntryPaymentEntityDao(entryPaymentEntityDaoConfig, this);
        entryPoiOptionEntityDao = new EntryPoiOptionEntityDao(entryPoiOptionEntityDaoConfig, this);
        entryProfileEntityDao = new EntryProfileEntityDao(entryProfileEntityDaoConfig, this);
        entryPublicationEntityDao = new EntryPublicationEntityDao(entryPublicationEntityDaoConfig, this);
        entryRentalMonthEntityDao = new EntryRentalMonthEntityDao(entryRentalMonthEntityDaoConfig, this);
        entrySectorEntityDao = new EntrySectorEntityDao(entrySectorEntityDaoConfig, this);
        entryServiceEntityDao = new EntryServiceEntityDao(entryServiceEntityDaoConfig, this);
        entrySleepingEntityDao = new EntrySleepingEntityDao(entrySleepingEntityDaoConfig, this);
        entrySpaceEntityDao = new EntrySpaceEntityDao(entrySpaceEntityDaoConfig, this);
        entryStandingLevelEntityDao = new EntryStandingLevelEntityDao(entryStandingLevelEntityDaoConfig, this);
        entryStationEntityDao = new EntryStationEntityDao(entryStationEntityDaoConfig, this);
        entryTariffEntityDao = new EntryTariffEntityDao(entryTariffEntityDaoConfig, this);
        entryEntityDao = new EntryEntityDao(entryEntityDaoConfig, this);
        joinEntryEntityWithEntryActivityEntityDao = new JoinEntryEntityWithEntryActivityEntityDao(joinEntryEntityWithEntryActivityEntityDaoConfig, this);
        joinEntryEntityWithEntryAffiliationEntityDao = new JoinEntryEntityWithEntryAffiliationEntityDao(joinEntryEntityWithEntryAffiliationEntityDaoConfig, this);
        joinEntryEntityWithEntryAllianceOptionEntityDao = new JoinEntryEntityWithEntryAllianceOptionEntityDao(joinEntryEntityWithEntryAllianceOptionEntityDaoConfig, this);
        joinEntryEntityWithEntryAmenityEntityDao = new JoinEntryEntityWithEntryAmenityEntityDao(joinEntryEntityWithEntryAmenityEntityDaoConfig, this);
        joinEntryEntityWithEntryAnimationEntityDao = new JoinEntryEntityWithEntryAnimationEntityDao(joinEntryEntityWithEntryAnimationEntityDaoConfig, this);
        joinEntryEntityWithEntryAtmospherEntityDao = new JoinEntryEntityWithEntryAtmospherEntityDao(joinEntryEntityWithEntryAtmospherEntityDaoConfig, this);
        joinEntryEntityWithEntryCategoryEntityDao = new JoinEntryEntityWithEntryCategoryEntityDao(joinEntryEntityWithEntryCategoryEntityDaoConfig, this);
        joinEntryEntityWithEntryChainEntityDao = new JoinEntryEntityWithEntryChainEntityDao(joinEntryEntityWithEntryChainEntityDaoConfig, this);
        joinEntryEntityWithEntryClosingEntityDao = new JoinEntryEntityWithEntryClosingEntityDao(joinEntryEntityWithEntryClosingEntityDaoConfig, this);
        joinEntryEntityWithEntryClosureEntityDao = new JoinEntryEntityWithEntryClosureEntityDao(joinEntryEntityWithEntryClosureEntityDaoConfig, this);
        joinEntryEntityWithEntryCommerciaEntityDao = new JoinEntryEntityWithEntryCommerciaEntityDao(joinEntryEntityWithEntryCommerciaEntityDaoConfig, this);
        joinEntryEntityWithEntryCommonTagEntityDao = new JoinEntryEntityWithEntryCommonTagEntityDao(joinEntryEntityWithEntryCommonTagEntityDaoConfig, this);
        joinEntryEntityWithEntryContactEntityDao = new JoinEntryEntityWithEntryContactEntityDao(joinEntryEntityWithEntryContactEntityDaoConfig, this);
        joinEntryEntityWithEntryDescriptionEntityDao = new JoinEntryEntityWithEntryDescriptionEntityDao(joinEntryEntityWithEntryDescriptionEntityDaoConfig, this);
        joinEntryEntityWithEntryDisabledOptionEntityDao = new JoinEntryEntityWithEntryDisabledOptionEntityDao(joinEntryEntityWithEntryDisabledOptionEntityDaoConfig, this);
        joinEntryEntityWithEntryFamilyOptionEntityDao = new JoinEntryEntityWithEntryFamilyOptionEntityDao(joinEntryEntityWithEntryFamilyOptionEntityDaoConfig, this);
        joinEntryEntityWithEntryFrpOptionEntityDao = new JoinEntryEntityWithEntryFrpOptionEntityDao(joinEntryEntityWithEntryFrpOptionEntityDaoConfig, this);
        joinEntryEntityWithEntryFurnishedRentalEntityDao = new JoinEntryEntityWithEntryFurnishedRentalEntityDao(joinEntryEntityWithEntryFurnishedRentalEntityDaoConfig, this);
        joinEntryEntityWithEntryGroupOptionEntityDao = new JoinEntryEntityWithEntryGroupOptionEntityDao(joinEntryEntityWithEntryGroupOptionEntityDaoConfig, this);
        joinEntryEntityWithEntryImageEntityDao = new JoinEntryEntityWithEntryImageEntityDao(joinEntryEntityWithEntryImageEntityDaoConfig, this);
        joinEntryEntityWithEntryLabelEntityDao = new JoinEntryEntityWithEntryLabelEntityDao(joinEntryEntityWithEntryLabelEntityDaoConfig, this);
        joinEntryEntityWithEntryLanguageEntityDao = new JoinEntryEntityWithEntryLanguageEntityDao(joinEntryEntityWithEntryLanguageEntityDaoConfig, this);
        joinEntryEntityWithEntryLocationEntityDao = new JoinEntryEntityWithEntryLocationEntityDao(joinEntryEntityWithEntryLocationEntityDaoConfig, this);
        joinEntryEntityWithEntryOpeningEntityDao = new JoinEntryEntityWithEntryOpeningEntityDao(joinEntryEntityWithEntryOpeningEntityDaoConfig, this);
        joinEntryEntityWithEntryOptionEntityDao = new JoinEntryEntityWithEntryOptionEntityDao(joinEntryEntityWithEntryOptionEntityDaoConfig, this);
        joinEntryEntityWithEntryPaymentEntityDao = new JoinEntryEntityWithEntryPaymentEntityDao(joinEntryEntityWithEntryPaymentEntityDaoConfig, this);
        joinEntryEntityWithEntryPoiOptionEntityDao = new JoinEntryEntityWithEntryPoiOptionEntityDao(joinEntryEntityWithEntryPoiOptionEntityDaoConfig, this);
        joinEntryEntityWithEntryProfileEntityDao = new JoinEntryEntityWithEntryProfileEntityDao(joinEntryEntityWithEntryProfileEntityDaoConfig, this);
        joinEntryEntityWithEntryPublicationEntityDao = new JoinEntryEntityWithEntryPublicationEntityDao(joinEntryEntityWithEntryPublicationEntityDaoConfig, this);
        joinEntryEntityWithEntryRentalMonthEntityDao = new JoinEntryEntityWithEntryRentalMonthEntityDao(joinEntryEntityWithEntryRentalMonthEntityDaoConfig, this);
        joinEntryEntityWithEntrySectorEntityDao = new JoinEntryEntityWithEntrySectorEntityDao(joinEntryEntityWithEntrySectorEntityDaoConfig, this);
        joinEntryEntityWithEntryServiceEntityDao = new JoinEntryEntityWithEntryServiceEntityDao(joinEntryEntityWithEntryServiceEntityDaoConfig, this);
        joinEntryEntityWithEntrySleepingEntityDao = new JoinEntryEntityWithEntrySleepingEntityDao(joinEntryEntityWithEntrySleepingEntityDaoConfig, this);
        joinEntryEntityWithEntrySpaceEntityDao = new JoinEntryEntityWithEntrySpaceEntityDao(joinEntryEntityWithEntrySpaceEntityDaoConfig, this);
        joinEntryEntityWithEntryStandingLevelEntityDao = new JoinEntryEntityWithEntryStandingLevelEntityDao(joinEntryEntityWithEntryStandingLevelEntityDaoConfig, this);
        joinEntryEntityWithEntryStationEntityDao = new JoinEntryEntityWithEntryStationEntityDao(joinEntryEntityWithEntryStationEntityDaoConfig, this);
        joinEntryEntityWithEntryTariffEntityDao = new JoinEntryEntityWithEntryTariffEntityDao(joinEntryEntityWithEntryTariffEntityDaoConfig, this);
        joinEntryOpeningEntityWithEntryGridEntityDao = new JoinEntryOpeningEntityWithEntryGridEntityDao(joinEntryOpeningEntityWithEntryGridEntityDaoConfig, this);
        eventEntityDao = new EventEntityDao(eventEntityDaoConfig, this);

        registerDao(EntryActivityEntity.class, entryActivityEntityDao);
        registerDao(EntryAddressEntity.class, entryAddressEntityDao);
        registerDao(EntryAffiliationEntity.class, entryAffiliationEntityDao);
        registerDao(EntryAllianceOptionEntity.class, entryAllianceOptionEntityDao);
        registerDao(EntryAmenityEntity.class, entryAmenityEntityDao);
        registerDao(EntryAnimationEntity.class, entryAnimationEntityDao);
        registerDao(EntryAtmospherEntity.class, entryAtmospherEntityDao);
        registerDao(EntryCapacityEntity.class, entryCapacityEntityDao);
        registerDao(EntryCategoryEntity.class, entryCategoryEntityDao);
        registerDao(EntryChainEntity.class, entryChainEntityDao);
        registerDao(EntryClosingEntity.class, entryClosingEntityDao);
        registerDao(EntryClosureEntity.class, entryClosureEntityDao);
        registerDao(EntryCommerciaEntity.class, entryCommerciaEntityDao);
        registerDao(EntryCommonTagEntity.class, entryCommonTagEntityDao);
        registerDao(EntryContactEntity.class, entryContactEntityDao);
        registerDao(EntryDescriptionEntity.class, entryDescriptionEntityDao);
        registerDao(EntryDisabledOptionEntity.class, entryDisabledOptionEntityDao);
        registerDao(EntryFamilyOptionEntity.class, entryFamilyOptionEntityDao);
        registerDao(EntryFrpOptionEntity.class, entryFrpOptionEntityDao);
        registerDao(EntryFurnishedRentalEntity.class, entryFurnishedRentalEntityDao);
        registerDao(EntryGridEntity.class, entryGridEntityDao);
        registerDao(EntryGroupOptionEntity.class, entryGroupOptionEntityDao);
        registerDao(EntryImageEntity.class, entryImageEntityDao);
        registerDao(EntryLabelEntity.class, entryLabelEntityDao);
        registerDao(EntryLanguageEntity.class, entryLanguageEntityDao);
        registerDao(EntryLivingEntity.class, entryLivingEntityDao);
        registerDao(EntryLocationEntity.class, entryLocationEntityDao);
        registerDao(EntryOpeningEntity.class, entryOpeningEntityDao);
        registerDao(EntryOptionEntity.class, entryOptionEntityDao);
        registerDao(EntryPaymentEntity.class, entryPaymentEntityDao);
        registerDao(EntryPoiOptionEntity.class, entryPoiOptionEntityDao);
        registerDao(EntryProfileEntity.class, entryProfileEntityDao);
        registerDao(EntryPublicationEntity.class, entryPublicationEntityDao);
        registerDao(EntryRentalMonthEntity.class, entryRentalMonthEntityDao);
        registerDao(EntrySectorEntity.class, entrySectorEntityDao);
        registerDao(EntryServiceEntity.class, entryServiceEntityDao);
        registerDao(EntrySleepingEntity.class, entrySleepingEntityDao);
        registerDao(EntrySpaceEntity.class, entrySpaceEntityDao);
        registerDao(EntryStandingLevelEntity.class, entryStandingLevelEntityDao);
        registerDao(EntryStationEntity.class, entryStationEntityDao);
        registerDao(EntryTariffEntity.class, entryTariffEntityDao);
        registerDao(EntryEntity.class, entryEntityDao);
        registerDao(JoinEntryEntityWithEntryActivityEntity.class, joinEntryEntityWithEntryActivityEntityDao);
        registerDao(JoinEntryEntityWithEntryAffiliationEntity.class, joinEntryEntityWithEntryAffiliationEntityDao);
        registerDao(JoinEntryEntityWithEntryAllianceOptionEntity.class, joinEntryEntityWithEntryAllianceOptionEntityDao);
        registerDao(JoinEntryEntityWithEntryAmenityEntity.class, joinEntryEntityWithEntryAmenityEntityDao);
        registerDao(JoinEntryEntityWithEntryAnimationEntity.class, joinEntryEntityWithEntryAnimationEntityDao);
        registerDao(JoinEntryEntityWithEntryAtmospherEntity.class, joinEntryEntityWithEntryAtmospherEntityDao);
        registerDao(JoinEntryEntityWithEntryCategoryEntity.class, joinEntryEntityWithEntryCategoryEntityDao);
        registerDao(JoinEntryEntityWithEntryChainEntity.class, joinEntryEntityWithEntryChainEntityDao);
        registerDao(JoinEntryEntityWithEntryClosingEntity.class, joinEntryEntityWithEntryClosingEntityDao);
        registerDao(JoinEntryEntityWithEntryClosureEntity.class, joinEntryEntityWithEntryClosureEntityDao);
        registerDao(JoinEntryEntityWithEntryCommerciaEntity.class, joinEntryEntityWithEntryCommerciaEntityDao);
        registerDao(JoinEntryEntityWithEntryCommonTagEntity.class, joinEntryEntityWithEntryCommonTagEntityDao);
        registerDao(JoinEntryEntityWithEntryContactEntity.class, joinEntryEntityWithEntryContactEntityDao);
        registerDao(JoinEntryEntityWithEntryDescriptionEntity.class, joinEntryEntityWithEntryDescriptionEntityDao);
        registerDao(JoinEntryEntityWithEntryDisabledOptionEntity.class, joinEntryEntityWithEntryDisabledOptionEntityDao);
        registerDao(JoinEntryEntityWithEntryFamilyOptionEntity.class, joinEntryEntityWithEntryFamilyOptionEntityDao);
        registerDao(JoinEntryEntityWithEntryFrpOptionEntity.class, joinEntryEntityWithEntryFrpOptionEntityDao);
        registerDao(JoinEntryEntityWithEntryFurnishedRentalEntity.class, joinEntryEntityWithEntryFurnishedRentalEntityDao);
        registerDao(JoinEntryEntityWithEntryGroupOptionEntity.class, joinEntryEntityWithEntryGroupOptionEntityDao);
        registerDao(JoinEntryEntityWithEntryImageEntity.class, joinEntryEntityWithEntryImageEntityDao);
        registerDao(JoinEntryEntityWithEntryLabelEntity.class, joinEntryEntityWithEntryLabelEntityDao);
        registerDao(JoinEntryEntityWithEntryLanguageEntity.class, joinEntryEntityWithEntryLanguageEntityDao);
        registerDao(JoinEntryEntityWithEntryLocationEntity.class, joinEntryEntityWithEntryLocationEntityDao);
        registerDao(JoinEntryEntityWithEntryOpeningEntity.class, joinEntryEntityWithEntryOpeningEntityDao);
        registerDao(JoinEntryEntityWithEntryOptionEntity.class, joinEntryEntityWithEntryOptionEntityDao);
        registerDao(JoinEntryEntityWithEntryPaymentEntity.class, joinEntryEntityWithEntryPaymentEntityDao);
        registerDao(JoinEntryEntityWithEntryPoiOptionEntity.class, joinEntryEntityWithEntryPoiOptionEntityDao);
        registerDao(JoinEntryEntityWithEntryProfileEntity.class, joinEntryEntityWithEntryProfileEntityDao);
        registerDao(JoinEntryEntityWithEntryPublicationEntity.class, joinEntryEntityWithEntryPublicationEntityDao);
        registerDao(JoinEntryEntityWithEntryRentalMonthEntity.class, joinEntryEntityWithEntryRentalMonthEntityDao);
        registerDao(JoinEntryEntityWithEntrySectorEntity.class, joinEntryEntityWithEntrySectorEntityDao);
        registerDao(JoinEntryEntityWithEntryServiceEntity.class, joinEntryEntityWithEntryServiceEntityDao);
        registerDao(JoinEntryEntityWithEntrySleepingEntity.class, joinEntryEntityWithEntrySleepingEntityDao);
        registerDao(JoinEntryEntityWithEntrySpaceEntity.class, joinEntryEntityWithEntrySpaceEntityDao);
        registerDao(JoinEntryEntityWithEntryStandingLevelEntity.class, joinEntryEntityWithEntryStandingLevelEntityDao);
        registerDao(JoinEntryEntityWithEntryStationEntity.class, joinEntryEntityWithEntryStationEntityDao);
        registerDao(JoinEntryEntityWithEntryTariffEntity.class, joinEntryEntityWithEntryTariffEntityDao);
        registerDao(JoinEntryOpeningEntityWithEntryGridEntity.class, joinEntryOpeningEntityWithEntryGridEntityDao);
        registerDao(EventEntity.class, eventEntityDao);
    }
    
    public void clear() {
        entryActivityEntityDaoConfig.clearIdentityScope();
        entryAddressEntityDaoConfig.clearIdentityScope();
        entryAffiliationEntityDaoConfig.clearIdentityScope();
        entryAllianceOptionEntityDaoConfig.clearIdentityScope();
        entryAmenityEntityDaoConfig.clearIdentityScope();
        entryAnimationEntityDaoConfig.clearIdentityScope();
        entryAtmospherEntityDaoConfig.clearIdentityScope();
        entryCapacityEntityDaoConfig.clearIdentityScope();
        entryCategoryEntityDaoConfig.clearIdentityScope();
        entryChainEntityDaoConfig.clearIdentityScope();
        entryClosingEntityDaoConfig.clearIdentityScope();
        entryClosureEntityDaoConfig.clearIdentityScope();
        entryCommerciaEntityDaoConfig.clearIdentityScope();
        entryCommonTagEntityDaoConfig.clearIdentityScope();
        entryContactEntityDaoConfig.clearIdentityScope();
        entryDescriptionEntityDaoConfig.clearIdentityScope();
        entryDisabledOptionEntityDaoConfig.clearIdentityScope();
        entryFamilyOptionEntityDaoConfig.clearIdentityScope();
        entryFrpOptionEntityDaoConfig.clearIdentityScope();
        entryFurnishedRentalEntityDaoConfig.clearIdentityScope();
        entryGridEntityDaoConfig.clearIdentityScope();
        entryGroupOptionEntityDaoConfig.clearIdentityScope();
        entryImageEntityDaoConfig.clearIdentityScope();
        entryLabelEntityDaoConfig.clearIdentityScope();
        entryLanguageEntityDaoConfig.clearIdentityScope();
        entryLivingEntityDaoConfig.clearIdentityScope();
        entryLocationEntityDaoConfig.clearIdentityScope();
        entryOpeningEntityDaoConfig.clearIdentityScope();
        entryOptionEntityDaoConfig.clearIdentityScope();
        entryPaymentEntityDaoConfig.clearIdentityScope();
        entryPoiOptionEntityDaoConfig.clearIdentityScope();
        entryProfileEntityDaoConfig.clearIdentityScope();
        entryPublicationEntityDaoConfig.clearIdentityScope();
        entryRentalMonthEntityDaoConfig.clearIdentityScope();
        entrySectorEntityDaoConfig.clearIdentityScope();
        entryServiceEntityDaoConfig.clearIdentityScope();
        entrySleepingEntityDaoConfig.clearIdentityScope();
        entrySpaceEntityDaoConfig.clearIdentityScope();
        entryStandingLevelEntityDaoConfig.clearIdentityScope();
        entryStationEntityDaoConfig.clearIdentityScope();
        entryTariffEntityDaoConfig.clearIdentityScope();
        entryEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryActivityEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryAffiliationEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryAllianceOptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryAmenityEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryAnimationEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryAtmospherEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryCategoryEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryChainEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryClosingEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryClosureEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryCommerciaEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryCommonTagEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryContactEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryDescriptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryDisabledOptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryFamilyOptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryFrpOptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryFurnishedRentalEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryGroupOptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryImageEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryLabelEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryLanguageEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryLocationEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryOpeningEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryOptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryPaymentEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryPoiOptionEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryProfileEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryPublicationEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryRentalMonthEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntrySectorEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryServiceEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntrySleepingEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntrySpaceEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryStandingLevelEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryStationEntityDaoConfig.clearIdentityScope();
        joinEntryEntityWithEntryTariffEntityDaoConfig.clearIdentityScope();
        joinEntryOpeningEntityWithEntryGridEntityDaoConfig.clearIdentityScope();
        eventEntityDaoConfig.clearIdentityScope();
    }

    public EntryActivityEntityDao getEntryActivityEntityDao() {
        return entryActivityEntityDao;
    }

    public EntryAddressEntityDao getEntryAddressEntityDao() {
        return entryAddressEntityDao;
    }

    public EntryAffiliationEntityDao getEntryAffiliationEntityDao() {
        return entryAffiliationEntityDao;
    }

    public EntryAllianceOptionEntityDao getEntryAllianceOptionEntityDao() {
        return entryAllianceOptionEntityDao;
    }

    public EntryAmenityEntityDao getEntryAmenityEntityDao() {
        return entryAmenityEntityDao;
    }

    public EntryAnimationEntityDao getEntryAnimationEntityDao() {
        return entryAnimationEntityDao;
    }

    public EntryAtmospherEntityDao getEntryAtmospherEntityDao() {
        return entryAtmospherEntityDao;
    }

    public EntryCapacityEntityDao getEntryCapacityEntityDao() {
        return entryCapacityEntityDao;
    }

    public EntryCategoryEntityDao getEntryCategoryEntityDao() {
        return entryCategoryEntityDao;
    }

    public EntryChainEntityDao getEntryChainEntityDao() {
        return entryChainEntityDao;
    }

    public EntryClosingEntityDao getEntryClosingEntityDao() {
        return entryClosingEntityDao;
    }

    public EntryClosureEntityDao getEntryClosureEntityDao() {
        return entryClosureEntityDao;
    }

    public EntryCommerciaEntityDao getEntryCommerciaEntityDao() {
        return entryCommerciaEntityDao;
    }

    public EntryCommonTagEntityDao getEntryCommonTagEntityDao() {
        return entryCommonTagEntityDao;
    }

    public EntryContactEntityDao getEntryContactEntityDao() {
        return entryContactEntityDao;
    }

    public EntryDescriptionEntityDao getEntryDescriptionEntityDao() {
        return entryDescriptionEntityDao;
    }

    public EntryDisabledOptionEntityDao getEntryDisabledOptionEntityDao() {
        return entryDisabledOptionEntityDao;
    }

    public EntryFamilyOptionEntityDao getEntryFamilyOptionEntityDao() {
        return entryFamilyOptionEntityDao;
    }

    public EntryFrpOptionEntityDao getEntryFrpOptionEntityDao() {
        return entryFrpOptionEntityDao;
    }

    public EntryFurnishedRentalEntityDao getEntryFurnishedRentalEntityDao() {
        return entryFurnishedRentalEntityDao;
    }

    public EntryGridEntityDao getEntryGridEntityDao() {
        return entryGridEntityDao;
    }

    public EntryGroupOptionEntityDao getEntryGroupOptionEntityDao() {
        return entryGroupOptionEntityDao;
    }

    public EntryImageEntityDao getEntryImageEntityDao() {
        return entryImageEntityDao;
    }

    public EntryLabelEntityDao getEntryLabelEntityDao() {
        return entryLabelEntityDao;
    }

    public EntryLanguageEntityDao getEntryLanguageEntityDao() {
        return entryLanguageEntityDao;
    }

    public EntryLivingEntityDao getEntryLivingEntityDao() {
        return entryLivingEntityDao;
    }

    public EntryLocationEntityDao getEntryLocationEntityDao() {
        return entryLocationEntityDao;
    }

    public EntryOpeningEntityDao getEntryOpeningEntityDao() {
        return entryOpeningEntityDao;
    }

    public EntryOptionEntityDao getEntryOptionEntityDao() {
        return entryOptionEntityDao;
    }

    public EntryPaymentEntityDao getEntryPaymentEntityDao() {
        return entryPaymentEntityDao;
    }

    public EntryPoiOptionEntityDao getEntryPoiOptionEntityDao() {
        return entryPoiOptionEntityDao;
    }

    public EntryProfileEntityDao getEntryProfileEntityDao() {
        return entryProfileEntityDao;
    }

    public EntryPublicationEntityDao getEntryPublicationEntityDao() {
        return entryPublicationEntityDao;
    }

    public EntryRentalMonthEntityDao getEntryRentalMonthEntityDao() {
        return entryRentalMonthEntityDao;
    }

    public EntrySectorEntityDao getEntrySectorEntityDao() {
        return entrySectorEntityDao;
    }

    public EntryServiceEntityDao getEntryServiceEntityDao() {
        return entryServiceEntityDao;
    }

    public EntrySleepingEntityDao getEntrySleepingEntityDao() {
        return entrySleepingEntityDao;
    }

    public EntrySpaceEntityDao getEntrySpaceEntityDao() {
        return entrySpaceEntityDao;
    }

    public EntryStandingLevelEntityDao getEntryStandingLevelEntityDao() {
        return entryStandingLevelEntityDao;
    }

    public EntryStationEntityDao getEntryStationEntityDao() {
        return entryStationEntityDao;
    }

    public EntryTariffEntityDao getEntryTariffEntityDao() {
        return entryTariffEntityDao;
    }

    public EntryEntityDao getEntryEntityDao() {
        return entryEntityDao;
    }

    public JoinEntryEntityWithEntryActivityEntityDao getJoinEntryEntityWithEntryActivityEntityDao() {
        return joinEntryEntityWithEntryActivityEntityDao;
    }

    public JoinEntryEntityWithEntryAffiliationEntityDao getJoinEntryEntityWithEntryAffiliationEntityDao() {
        return joinEntryEntityWithEntryAffiliationEntityDao;
    }

    public JoinEntryEntityWithEntryAllianceOptionEntityDao getJoinEntryEntityWithEntryAllianceOptionEntityDao() {
        return joinEntryEntityWithEntryAllianceOptionEntityDao;
    }

    public JoinEntryEntityWithEntryAmenityEntityDao getJoinEntryEntityWithEntryAmenityEntityDao() {
        return joinEntryEntityWithEntryAmenityEntityDao;
    }

    public JoinEntryEntityWithEntryAnimationEntityDao getJoinEntryEntityWithEntryAnimationEntityDao() {
        return joinEntryEntityWithEntryAnimationEntityDao;
    }

    public JoinEntryEntityWithEntryAtmospherEntityDao getJoinEntryEntityWithEntryAtmospherEntityDao() {
        return joinEntryEntityWithEntryAtmospherEntityDao;
    }

    public JoinEntryEntityWithEntryCategoryEntityDao getJoinEntryEntityWithEntryCategoryEntityDao() {
        return joinEntryEntityWithEntryCategoryEntityDao;
    }

    public JoinEntryEntityWithEntryChainEntityDao getJoinEntryEntityWithEntryChainEntityDao() {
        return joinEntryEntityWithEntryChainEntityDao;
    }

    public JoinEntryEntityWithEntryClosingEntityDao getJoinEntryEntityWithEntryClosingEntityDao() {
        return joinEntryEntityWithEntryClosingEntityDao;
    }

    public JoinEntryEntityWithEntryClosureEntityDao getJoinEntryEntityWithEntryClosureEntityDao() {
        return joinEntryEntityWithEntryClosureEntityDao;
    }

    public JoinEntryEntityWithEntryCommerciaEntityDao getJoinEntryEntityWithEntryCommerciaEntityDao() {
        return joinEntryEntityWithEntryCommerciaEntityDao;
    }

    public JoinEntryEntityWithEntryCommonTagEntityDao getJoinEntryEntityWithEntryCommonTagEntityDao() {
        return joinEntryEntityWithEntryCommonTagEntityDao;
    }

    public JoinEntryEntityWithEntryContactEntityDao getJoinEntryEntityWithEntryContactEntityDao() {
        return joinEntryEntityWithEntryContactEntityDao;
    }

    public JoinEntryEntityWithEntryDescriptionEntityDao getJoinEntryEntityWithEntryDescriptionEntityDao() {
        return joinEntryEntityWithEntryDescriptionEntityDao;
    }

    public JoinEntryEntityWithEntryDisabledOptionEntityDao getJoinEntryEntityWithEntryDisabledOptionEntityDao() {
        return joinEntryEntityWithEntryDisabledOptionEntityDao;
    }

    public JoinEntryEntityWithEntryFamilyOptionEntityDao getJoinEntryEntityWithEntryFamilyOptionEntityDao() {
        return joinEntryEntityWithEntryFamilyOptionEntityDao;
    }

    public JoinEntryEntityWithEntryFrpOptionEntityDao getJoinEntryEntityWithEntryFrpOptionEntityDao() {
        return joinEntryEntityWithEntryFrpOptionEntityDao;
    }

    public JoinEntryEntityWithEntryFurnishedRentalEntityDao getJoinEntryEntityWithEntryFurnishedRentalEntityDao() {
        return joinEntryEntityWithEntryFurnishedRentalEntityDao;
    }

    public JoinEntryEntityWithEntryGroupOptionEntityDao getJoinEntryEntityWithEntryGroupOptionEntityDao() {
        return joinEntryEntityWithEntryGroupOptionEntityDao;
    }

    public JoinEntryEntityWithEntryImageEntityDao getJoinEntryEntityWithEntryImageEntityDao() {
        return joinEntryEntityWithEntryImageEntityDao;
    }

    public JoinEntryEntityWithEntryLabelEntityDao getJoinEntryEntityWithEntryLabelEntityDao() {
        return joinEntryEntityWithEntryLabelEntityDao;
    }

    public JoinEntryEntityWithEntryLanguageEntityDao getJoinEntryEntityWithEntryLanguageEntityDao() {
        return joinEntryEntityWithEntryLanguageEntityDao;
    }

    public JoinEntryEntityWithEntryLocationEntityDao getJoinEntryEntityWithEntryLocationEntityDao() {
        return joinEntryEntityWithEntryLocationEntityDao;
    }

    public JoinEntryEntityWithEntryOpeningEntityDao getJoinEntryEntityWithEntryOpeningEntityDao() {
        return joinEntryEntityWithEntryOpeningEntityDao;
    }

    public JoinEntryEntityWithEntryOptionEntityDao getJoinEntryEntityWithEntryOptionEntityDao() {
        return joinEntryEntityWithEntryOptionEntityDao;
    }

    public JoinEntryEntityWithEntryPaymentEntityDao getJoinEntryEntityWithEntryPaymentEntityDao() {
        return joinEntryEntityWithEntryPaymentEntityDao;
    }

    public JoinEntryEntityWithEntryPoiOptionEntityDao getJoinEntryEntityWithEntryPoiOptionEntityDao() {
        return joinEntryEntityWithEntryPoiOptionEntityDao;
    }

    public JoinEntryEntityWithEntryProfileEntityDao getJoinEntryEntityWithEntryProfileEntityDao() {
        return joinEntryEntityWithEntryProfileEntityDao;
    }

    public JoinEntryEntityWithEntryPublicationEntityDao getJoinEntryEntityWithEntryPublicationEntityDao() {
        return joinEntryEntityWithEntryPublicationEntityDao;
    }

    public JoinEntryEntityWithEntryRentalMonthEntityDao getJoinEntryEntityWithEntryRentalMonthEntityDao() {
        return joinEntryEntityWithEntryRentalMonthEntityDao;
    }

    public JoinEntryEntityWithEntrySectorEntityDao getJoinEntryEntityWithEntrySectorEntityDao() {
        return joinEntryEntityWithEntrySectorEntityDao;
    }

    public JoinEntryEntityWithEntryServiceEntityDao getJoinEntryEntityWithEntryServiceEntityDao() {
        return joinEntryEntityWithEntryServiceEntityDao;
    }

    public JoinEntryEntityWithEntrySleepingEntityDao getJoinEntryEntityWithEntrySleepingEntityDao() {
        return joinEntryEntityWithEntrySleepingEntityDao;
    }

    public JoinEntryEntityWithEntrySpaceEntityDao getJoinEntryEntityWithEntrySpaceEntityDao() {
        return joinEntryEntityWithEntrySpaceEntityDao;
    }

    public JoinEntryEntityWithEntryStandingLevelEntityDao getJoinEntryEntityWithEntryStandingLevelEntityDao() {
        return joinEntryEntityWithEntryStandingLevelEntityDao;
    }

    public JoinEntryEntityWithEntryStationEntityDao getJoinEntryEntityWithEntryStationEntityDao() {
        return joinEntryEntityWithEntryStationEntityDao;
    }

    public JoinEntryEntityWithEntryTariffEntityDao getJoinEntryEntityWithEntryTariffEntityDao() {
        return joinEntryEntityWithEntryTariffEntityDao;
    }

    public JoinEntryOpeningEntityWithEntryGridEntityDao getJoinEntryOpeningEntityWithEntryGridEntityDao() {
        return joinEntryOpeningEntityWithEntryGridEntityDao;
    }

    public EventEntityDao getEventEntityDao() {
        return eventEntityDao;
    }

}
