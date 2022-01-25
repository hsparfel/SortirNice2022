package com.pouillcorp.sortirnice.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.pouillcorp.sortirnice.R;

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
}
