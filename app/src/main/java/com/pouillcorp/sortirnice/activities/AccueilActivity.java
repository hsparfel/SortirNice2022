package com.pouillcorp.sortirnice.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.pouillcorp.sortirnice.R;
import com.pouillcorp.sortirnice.entities.DateMaj;
import com.pouillcorp.sortirnice.entities.entry.EntryEntity;
import com.pouillcorp.sortirnice.entities.entry.detail.EntryProfileEntity;
import com.pouillcorp.sortirnice.entities.event.EvenementEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementProfileEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementProfileEntity;

import java.util.List;

import butterknife.ButterKnife;
import icepick.Icepick;

public class AccueilActivity extends NavDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Stetho.initializeWithDefaults(this);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        setTitle("Accueil");
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

    public void afficherEvenements(View view) {
        ouvrirActiviteSuivante(this, AfficherEvenementsActivity.class,false);
    }

    public void afficherEntriesDivers(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesDiversActivity.class,false);
    }

    public void afficherMesFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherFavorisActivity.class,false);
    }

    public void forcerDateEntry(View view) {
        DateMaj date = dateMajDao.load(1l);
        date.setDateMajEntry("01/01/2022");
        dateMajDao.update(date);
    }

    public void majDb(View view) {
        /*evenementEntityDao.deleteByKey(114l);
        List<JoinEvenementEntityWithEvenementProfileEntity> list = joinEvenementEntityWithEvenementProfileEntityDao.queryRaw("where evenement_entity_id = 114");
        for (JoinEvenementEntityWithEvenementProfileEntity current : list) {
            joinEvenementEntityWithEvenementProfileEntityDao.delete(current);
        }*/
        List<EvenementEntity> listEvent = evenementEntityDao.queryRaw("where favori = 1");
        List<EntryEntity> listEntry = entryEntityDao.queryRaw("where favori = 1");
        for (EvenementEntity event : listEvent) {
            event.setFavori(false);
            evenementEntityDao.update(event);
        }
        for (EntryEntity entry : listEntry) {
            entry.setFavori(false);
            entryEntityDao.update(entry);
        }
    }
}
