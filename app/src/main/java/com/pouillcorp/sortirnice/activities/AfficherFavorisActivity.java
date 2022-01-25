package com.pouillcorp.sortirnice.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.pouillcorp.sortirnice.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public class AfficherFavorisActivity extends NavDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_favoris);
        Stetho.initializeWithDefaults(this);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);
        setTitle("Choix Favoris");
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

    public void afficherEvenementsFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherEvenementsFavorisActivity.class,false);
    }

    public void afficherEntriesFavoris(View view) {
        ouvrirActiviteSuivante(this, AfficherEntriesFavorisActivity.class,false);
    }
}
